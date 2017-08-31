/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.consumer;

import gr.modus.papyros.web.client.serialize.TypeReference;
import gr.modus.papyros.web.client.exception.PServiceClientException;
import gr.modus.papyros.web.client.serialize.Serializer;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.HttpResponseHeaders;
import org.asynchttpclient.HttpResponseStatus;
import org.asynchttpclient.request.body.multipart.Part;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public abstract class BaseConsumer implements Closeable {

    protected final static String SERVICES_ENDPOINT = "services";

    protected final AsyncHttpClient httpClient;
    protected final Serializer serializer;

    public BaseConsumer(AsyncHttpClient httpClient, Serializer serializer) {
        this.httpClient = httpClient;
        this.serializer = serializer;
    }

    public <T> CompletableFuture<T> get(BoundRequestBuilder builder, TypeReference<T> c) {
        return builder.execute(new AsyncHandler<T>() {

            private InputStream sis;
            io.netty.handler.codec.http.HttpHeaders headers;

            @Override
            public AsyncHandler.State onStatusReceived(HttpResponseStatus status) throws Exception {
                int statusCode = status.getStatusCode();
//                if (statusCode >= 400) {
//                    return AsyncHandler.State.ABORT;
//                }
                return AsyncHandler.State.CONTINUE;
            }

            @Override
            public AsyncHandler.State onHeadersReceived(HttpResponseHeaders h) throws Exception {
                headers = h.getHeaders();
                return AsyncHandler.State.CONTINUE;
            }

            @Override
            public T onCompleted() throws Exception {
                return serializer.parse(sis, c);
            }

            @Override
            public void onThrowable(Throwable t) {
                throw new PServiceClientException(t);
            }

            @Override
            public AsyncHandler.State onBodyPartReceived(HttpResponseBodyPart httpResponseBodyPart) throws Exception {
                if (sis == null) {
                    sis = new ByteArrayInputStream(httpResponseBodyPart.getBodyPartBytes(), 0, httpResponseBodyPart.length());
                } else {
                    sis = new SequenceInputStream(sis, new ByteArrayInputStream(httpResponseBodyPart.getBodyPartBytes(), 0, httpResponseBodyPart.length()));
                }
                return AsyncHandler.State.CONTINUE;
            }
        }).toCompletableFuture();
    }

    public <T> CompletableFuture<T> get(String path, TypeReference<T> c, String handle) {

        return get(httpClient
                .prepareGet(path)
                .addHeader("Accept", "application/json")
                .addHeader("Cookie", handle),
                c
        );
    }

    public <T> CompletableFuture<T> get(String path, TypeReference<T> c) {

        return get(httpClient
                .prepareGet(path)
                .addHeader("Accept", "application/json"),
                c
        );
    }

    private <T> CompletableFuture<T> post(BoundRequestBuilder builder, TypeReference<T> c) {
        return builder.execute(new AsyncHandler<T>() {

            private InputStream sis;
            io.netty.handler.codec.http.HttpHeaders headers;

            @Override
            public AsyncHandler.State onStatusReceived(HttpResponseStatus status) throws Exception {
                int statusCode = status.getStatusCode();
//                if (statusCode >= 400) {
//                    return AsyncHandler.State.ABORT;
//                }
                return AsyncHandler.State.CONTINUE;
            }

            @Override
            public AsyncHandler.State onHeadersReceived(HttpResponseHeaders h) throws Exception {
                headers = h.getHeaders();
                return AsyncHandler.State.CONTINUE;
            }

            @Override
            public T onCompleted() throws Exception {
                return serializer.parse(sis, c);
            }

            @Override
            public void onThrowable(Throwable t) {
                throw new PServiceClientException(t);
            }

            @Override
            public AsyncHandler.State onBodyPartReceived(HttpResponseBodyPart httpResponseBodyPart) throws Exception {
                if (sis == null) {
                    sis = new ByteArrayInputStream(httpResponseBodyPart.getBodyPartBytes(), 0, httpResponseBodyPart.length());
                } else {
                    sis = new SequenceInputStream(sis, new ByteArrayInputStream(httpResponseBodyPart.getBodyPartBytes(), 0, httpResponseBodyPart.length()));
                }
                return AsyncHandler.State.CONTINUE;
            }
        }).toCompletableFuture();
    }

    public <T> CompletableFuture<T> postForm(String path, Map<String, List<String>> parameters, TypeReference<T> c, String handle) {
        return post(httpClient
                .preparePost(path)
                .setFormParams(parameters)
                .addHeader("Accept", "application/json")
                .addHeader("Cookie", handle),
                c
        );
    }

    public <T> CompletableFuture<T> postForm(String path, Map<String, List<String>> parameters, TypeReference<T> c) {
        return post(httpClient
                .preparePost(path)
                .setFormParams(parameters)
                .addHeader("Accept", "application/json"),
                c
        );
    }

    public <T> CompletableFuture<T> postMultipart(String path, List<Part> bodyParts, TypeReference<T> c, String handle) {
        return post(httpClient
                .preparePost(path)
                .setBodyParts(bodyParts)
                .addHeader("Accept", "application/json")
                .addHeader("Cookie", handle),
                c
        );
    }

    public <T> CompletableFuture<T> postMultipart(String path, List<Part> bodyParts, TypeReference<T> c) {
        return post(httpClient
                .preparePost(path)
                .setBodyParts(bodyParts)
                .addHeader("Accept", "application/json"),
                c
        );
    }

    protected final String createPath(String... paths) {
        StringJoiner joiner = new StringJoiner("/");
        for (String path : paths) {
            joiner.add(path.substring(0 + (path.startsWith("/") ? 1 : 0),
                    path.length() - (path.endsWith("/") ? 1 : 0))
            );
        }
        return joiner.toString();
    }

    protected final String addUrlParameter(String url, String name, String value) {
        return url + (url.contains("?") ? "&" : "?") + name + "=" + value;
    }

    @Override
    public void close() throws IOException {
        if (!this.httpClient.isClosed()) {
            this.httpClient.close();
        }
        if (!this.serializer.isClosed()) {
            this.serializer.close();
        }
    }

}
