/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.consumer;

import gr.modus.papyros.web.client.exception.PServiceClientException;
import gr.modus.papyros.web.client.model.DocumentInfo;
import gr.modus.papyros.web.client.model.ResponseModel;
import gr.modus.papyros.web.client.serialize.Serializer;
import gr.modus.papyros.web.client.serialize.TypeReference;
import java.util.concurrent.CompletableFuture;
import org.asynchttpclient.AsyncHttpClient;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public class DocumentsConsumer extends BaseConsumer {

    private static final String DOC_INFO = "DocumentServices/getDocImageInfo/%s";
    private static final String DOC_INFO_EXTENDED = "DocumentServices/getDocImageInfoExtended/%s";

    private final String basePath;
    private final String getDocInfoPath;
    private final String getDocInfoExtendedPath;

    public DocumentsConsumer(AsyncHttpClient httpClient, Serializer serializer, String basePath) {
        super(httpClient, serializer);
        this.basePath = basePath;
        this.getDocInfoPath = createPath(this.basePath, SERVICES_ENDPOINT, DOC_INFO);
        this.getDocInfoExtendedPath = createPath(this.basePath, SERVICES_ENDPOINT, DOC_INFO_EXTENDED);
    }

    public CompletableFuture<DocumentInfo> getDocumentInfo(int docId, String handle) {
        String path = String.format(getDocInfoPath, docId);
        return get(path, new TypeReference<ResponseModel<DocumentInfo>>() {}, handle)
                .thenApply((response) -> {
                    if (!response.isSuccess()) {
                        throw new PServiceClientException(response.getProcessMessage());
                    }
                    return response.getData().stream().findFirst().orElse(null);
                });
    }

    public CompletableFuture<DocumentInfo> getDocumentInfoEntended(int docId, String handle) {
        String path = String.format(getDocInfoExtendedPath, docId);
        return get(path, new TypeReference<ResponseModel<DocumentInfo>>() {}, handle)
                .thenApply((response) -> {
                    if (!response.isSuccess()) {
                        throw new PServiceClientException(response.getProcessMessage());
                    }
                    return response.getData().stream().findFirst().orElse(null);
                });
    }

}
