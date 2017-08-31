/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.consumer;

import gr.modus.papyros.web.client.serialize.TypeReference;
import gr.modus.papyros.web.client.exception.PServiceClientException;
import gr.modus.papyros.web.client.model.ArchiveForm;
import gr.modus.papyros.web.client.model.ResponseModel;
import gr.modus.papyros.web.client.serialize.Serializer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.asynchttpclient.AsyncHttpClient;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public class FormsConsumer extends BaseConsumer {

    private final static String ARCHIVE_LIST_ID = "FormServices/getArchiveList";
    private final static String ARCHIVE_LIST_IDS = "FormServices/getArchiveListForListDocIds";

    private final String basePath;
    private final String archiveListIdPath;
    private final String archiveListIdsPath;

    public FormsConsumer(AsyncHttpClient httpClient, Serializer serializer, String basePath) {
        super(httpClient, serializer);
        this.basePath = basePath;
        this.archiveListIdPath = createPath(this.basePath, SERVICES_ENDPOINT, ARCHIVE_LIST_ID);
        this.archiveListIdsPath = createPath(this.basePath, SERVICES_ENDPOINT, ARCHIVE_LIST_IDS);
    }

    public CompletableFuture<Collection<ArchiveForm>> getArchiveListForDocument(Integer docId, String handle) {
        String path = addUrlParameter(this.archiveListIdPath, "docId", docId.toString());
        return get(
                path,
                new TypeReference<ResponseModel<ArchiveForm>>() {},
                handle)
                .thenApply((response) -> {
                    if (!response.isSuccess()) {
                        throw new PServiceClientException(response.getProcessMessage());
                    }
                    return response;
                })
                .thenApply((response) -> response.getData());
    }

    public CompletableFuture<Map<Integer,Collection<ArchiveForm>>> getArchiveListForDocuments(Collection<Integer> docIds, String handle) {
        Map<String, List<String>> parameters = new HashMap<>();
        parameters.put(
                "docIds",
                Arrays.asList(docIds.stream().map(i -> i.toString()).collect(Collectors.joining(",")))
        );
        return postForm(
                archiveListIdsPath,
                parameters,
                new TypeReference<ResponseModel<Map<Integer,Collection<ArchiveForm>>>>() {},
                handle)
                .thenApply((response) -> response.getData().stream().findFirst().orElse(null));
    }

}
