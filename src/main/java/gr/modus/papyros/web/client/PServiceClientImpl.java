/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client;

import gr.modus.papyros.web.client.consumer.AAConsumer;
import gr.modus.papyros.web.client.consumer.DataConsumer;
import gr.modus.papyros.web.client.consumer.DocumentsConsumer;
import gr.modus.papyros.web.client.consumer.FormsConsumer;
import gr.modus.papyros.web.client.exception.PServiceClientException;
import gr.modus.papyros.web.client.model.ArchiveForm;
import gr.modus.papyros.web.client.model.Credentials;
import gr.modus.papyros.web.client.model.DocumentInfo;
import gr.modus.papyros.web.client.model.FormData;
import gr.modus.papyros.web.client.serialize.Serializer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.asynchttpclient.AsyncHttpClient;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public class PServiceClientImpl implements PapyrosClient {

    private final Serializer serializer;
    private final AsyncHttpClient client;

    private final AAConsumer aaConsumer;
    private final DocumentsConsumer documentsConsumer;
    private final FormsConsumer formsConsumer;
    private final DataConsumer dataConsumer;

    private Credentials credentials;
    private String username;
    private String password;

    public PServiceClientImpl(
            AsyncHttpClient client,
            Serializer serializer,
            AAConsumer aaConsumer,
            DocumentsConsumer documentsConsumer,
            FormsConsumer formsConsumer,
            DataConsumer dataConsumer) {
        this.client = client;
        this.serializer = serializer;
        this.aaConsumer = aaConsumer;
        this.documentsConsumer = documentsConsumer;
        this.formsConsumer = formsConsumer;
        this.dataConsumer = dataConsumer;
    }

    @Override
    public CompletableFuture<Credentials> login(String username, String password) {
        return aaConsumer.login(username, password)
                .thenApply(creds -> {
                    this.credentials = creds;
                    this.username = username;
                    this.password = password;
                    return creds;
                });
    }

    @Override
    public CompletableFuture logout() {
        return aaConsumer.logout(credentials.getHandle());
    }

    @Override
    public CompletableFuture<DocumentInfo> getDocumentInfo(int docId) {
        return checkConnection()
                .thenCompose((creds) -> documentsConsumer.getDocumentInfo(docId, creds.getHandle()));
    }

    @Override
    public CompletableFuture<DocumentInfo> getDocumentInfoEx(int docId) {
        return checkConnection()
                .thenCompose((creds) -> documentsConsumer.getDocumentInfoEntended(docId, creds.getHandle()));
    }

    @Override
    public CompletableFuture<Collection<ArchiveForm>> getArchiveForms(int docId) {
        return checkConnection()
                .thenCompose((creds) -> formsConsumer.getArchiveListForDocument(docId, creds.getHandle()));
    }

    @Override
    public CompletableFuture<Map<Integer,Collection<ArchiveForm>>> getArchiveForms(Collection<Integer> docIds) {
        return checkConnection()
                .thenCompose((creds) -> formsConsumer.getArchiveListForDocuments(docIds, creds.getHandle()));
    }

    @Override
    public CompletableFuture<FormData> getFormData(int caseId, int docId) {
        return checkConnection()
                .thenCompose((creds) -> dataConsumer.getFormData(docId, caseId, creds.getHandle()));
    }

    private CompletableFuture<Boolean> checkSession() {
        return aaConsumer.checkSession(credentials.getHandle());
    }

    private CompletableFuture<Credentials> checkConnection() {
        if (credentials != null) {
            return checkSession()
                    .thenCompose((valid) -> {
                        if (!valid) {
                            return login(username, password);
                        }
                        return CompletableFuture.supplyAsync(() -> {
                            return credentials;
                        });
                    });
        } else if (username != null && password != null) {
            return login(username, password);
        } else {
            throw new PServiceClientException(401, "Please login first");
        }
    }

}
