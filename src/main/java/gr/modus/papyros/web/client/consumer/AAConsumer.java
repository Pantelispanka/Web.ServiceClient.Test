/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.consumer;

import gr.modus.papyros.web.client.serialize.TypeReference;
import gr.modus.papyros.web.client.exception.PServiceClientException;
import gr.modus.papyros.web.client.model.Credentials;
import gr.modus.papyros.web.client.model.ResponseModel;
import gr.modus.papyros.web.client.serialize.Serializer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.asynchttpclient.AsyncHttpClient;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public class AAConsumer extends BaseConsumer {

    private final static String LOGIN = "LoginServices/loginWeb";
    private final static String LOGIN_DETAILS = "LoginServices/getLoginDetails";
    private final static String LOGOUT = "LoginServices/logoutWeb";
    private final static String CHECK_SESSION = "LoginServices/dummy";

    private final String basePath;
    private final String loginPath;
    private final String loginDetailsPath;
    private final String logoutPath;
    private final String checkSessionPath;

    public AAConsumer(AsyncHttpClient httpClient, Serializer serializer, String basePath) {
        super(httpClient, serializer);
        this.basePath = basePath;
        this.loginPath = createPath(this.basePath, SERVICES_ENDPOINT, LOGIN);
        this.loginDetailsPath = createPath(this.basePath, SERVICES_ENDPOINT, LOGIN_DETAILS);
        this.logoutPath = createPath(this.basePath, SERVICES_ENDPOINT, LOGOUT);
        this.checkSessionPath = createPath(this.basePath, SERVICES_ENDPOINT, CHECK_SESSION);
    }

    public CompletableFuture<Credentials> login(String username, String password) {
        Map<String, List<String>> parameters = new HashMap<>();
        parameters.put("username", Arrays.asList(username));
        parameters.put("password", Arrays.asList(password));

        return httpClient.preparePost(loginPath)
                .setFormParams(parameters)
                .execute()
                .toCompletableFuture()
                .exceptionally(t -> {
                    throw new PServiceClientException(t);
                })
                .thenApply(resp -> {
                    ResponseModel<Map> rm = serializer.parse(resp.getResponseBodyAsStream(), new TypeReference<ResponseModel<Map>>() {
                    });
                    if (resp.getStatusCode() >= 400 || !rm.isSuccess()) {
                        throw new PServiceClientException(resp.getStatusCode(), rm.getProcessMessage());
                    }
                    String handle = resp.getHeader("Set-Cookie").split(";")[0];
                    Credentials credentials = new Credentials();
                    credentials.setHandle(handle);
                    credentials.setId(
                            (int) rm.getData()
                            .stream()
                            .findFirst()
                            .orElseThrow(() -> new PServiceClientException("Bad login response"))
                            .get("id")
                    );
                    return credentials;
                });
    }

    public CompletableFuture<ResponseModel> logout(String handle) {
        return get(this.logoutPath, new TypeReference<ResponseModel>() {
        }, handle);
    }

    public CompletableFuture<Boolean> checkSession(String handle) {
        return httpClient.prepareGet(checkSessionPath)
                .addHeader("Cookie", handle)
                .execute()
                .toCompletableFuture()
                .thenApply((resp) -> {
                    return resp.getStatusCode() == 200;
                });
    }

}
