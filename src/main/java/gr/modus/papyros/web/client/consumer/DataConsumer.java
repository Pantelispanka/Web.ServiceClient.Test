/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.consumer;

import gr.modus.papyros.web.client.model.FormData;
import gr.modus.papyros.web.client.model.ResponseModel;
import gr.modus.papyros.web.client.serialize.Serializer;
import gr.modus.papyros.web.client.serialize.TypeReference;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.asynchttpclient.AsyncHttpClient;

/**
 * @author George Anagnostopoulos
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public class DataConsumer extends BaseConsumer {

    private static final String DATA_TABLE_RECORD = "DataServices/fetchDataTableRecord/%s/%s";

    private final String basePath;
    private final String getDataRecordPath;

    public DataConsumer(AsyncHttpClient httpClient, Serializer serializer, String basePath) {
        super(httpClient, serializer);
        this.basePath = basePath;
        this.getDataRecordPath = createPath(basePath, SERVICES_ENDPOINT, DATA_TABLE_RECORD);
    }

    public CompletableFuture<FormData> getFormData(int docId, int caseId, String handle) {
        String path = String.format(getDataRecordPath, caseId, docId);
        return get(path, new TypeReference<ResponseModel<Map<String, Object>>>() {}, handle)
                .thenApply((response) -> {
                    FormData formData = new FormData();
                    if (response.getData() != null && !response.getData().isEmpty()) {
                        formData.setFieldValues(response.getData().stream().findFirst().orElse(null));
                    }
                    formData.setColumns(response.getMetaData().getColumns());
                    formData.setDocumentId(docId);
                    return formData;
                });
    }

}
