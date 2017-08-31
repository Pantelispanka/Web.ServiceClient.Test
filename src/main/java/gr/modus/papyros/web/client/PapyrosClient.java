/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client;

import gr.modus.papyros.web.client.model.ArchiveForm;
import gr.modus.papyros.web.client.model.Credentials;
import gr.modus.papyros.web.client.model.DocumentInfo;
import gr.modus.papyros.web.client.model.FormData;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public interface PapyrosClient {

    public CompletableFuture<Credentials> login(String username, String password);

    public CompletableFuture logout();

    public CompletableFuture<DocumentInfo> getDocumentInfo(int docId);

    public CompletableFuture<DocumentInfo> getDocumentInfoEx(int docId);

    public CompletableFuture<Collection<ArchiveForm>> getArchiveForms(int docId);

    public CompletableFuture<Map<Integer,Collection<ArchiveForm>>> getArchiveForms(Collection<Integer> docIds);

    public CompletableFuture<FormData> getFormData(int caseId, int docId);
}
