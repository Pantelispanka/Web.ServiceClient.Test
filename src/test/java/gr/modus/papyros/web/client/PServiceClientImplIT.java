/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.modus.papyros.web.client.consumer.AAConsumer;
import gr.modus.papyros.web.client.consumer.DataConsumer;
import gr.modus.papyros.web.client.consumer.DocumentsConsumer;
import gr.modus.papyros.web.client.consumer.FormsConsumer;
import gr.modus.papyros.web.client.model.ArchiveForm;
import gr.modus.papyros.web.client.model.Credentials;
import gr.modus.papyros.web.client.model.DocumentInfo;
import gr.modus.papyros.web.client.model.FormData;
import gr.modus.papyros.web.client.serialize.JacksonSerializer;
import gr.modus.papyros.web.client.serialize.Serializer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public class PServiceClientImplIT {

    private static PapyrosClient client;

    private final String username = "supervisor";
    private final String password = "modus";

    public PServiceClientImplIT() {
    }

    @BeforeClass
    public static void setUpClass() {
        Serializer serializer = new JacksonSerializer(new ObjectMapper());
        AsyncHttpClient httpClient = new DefaultAsyncHttpClient();
        String basePath = "http://testsrv:9080/7_3";
        client = new PServiceClientImpl(httpClient,
                serializer,
                new AAConsumer(httpClient, serializer, basePath),
                new DocumentsConsumer(httpClient, serializer, basePath),
                new FormsConsumer(httpClient, serializer, basePath),
                new DataConsumer(httpClient, serializer, basePath)
        );
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class ServiceClientImpl.
     */
    @Test
    public void testLogin() throws InterruptedException, ExecutionException {
        System.out.println("testing login");
        CompletableFuture<Credentials> result = client.login(username, password);
        assertNotNull(result.get());
    }

    /**
     * Test of logout method, of class ServiceClientImpl.
     */
    @Test
    public void testLogout() throws InterruptedException, ExecutionException {
        System.out.println("testing logout");
        CompletableFuture result = client.login(username, password).thenCompose((o) -> client.logout());
        result.join();
        assertTrue(!result.isCompletedExceptionally());
    }

    /**
     * Test of getDocumentInfo method, of class ServiceClientImpl.
     */
    @Test
    public void testGetDocumentInfo() throws InterruptedException, ExecutionException {
        System.out.println("testing getDocumentInfo");
        CompletableFuture<DocumentInfo> result = client.login(username, password)
                .thenCompose((creds) -> client.getDocumentInfo(91));

        result.join();
        assertNotNull(result.get());
    }

    /**
     * Test of getDocumentInfoEx method, of class ServiceClientImpl.
     */
    @Test
    public void testGetDocumentInfoEx() throws InterruptedException, ExecutionException {
        System.out.println("testing getDocumentInfoEx");
        CompletableFuture<DocumentInfo> result = client.login(username, password)
                .thenCompose((creds) -> client.getDocumentInfoEx(91));

        assertNotNull(result.get());
    }

    /**
     * Test of getArchiveForms method, of class ServiceClientImpl.
     */
    @Test
    public void testGetArchiveForms() throws InterruptedException, ExecutionException, TimeoutException {
        System.out.println("testing GetArchiveListForDocuments");
        CompletableFuture<Collection<ArchiveForm>> result = client.login(username, password)
                .thenCompose((o) -> client.getArchiveForms(91));
        assertTrue(!result.get().isEmpty());
    }

    /**
     * Test of getArchiveForms method, of class ServiceClientImpl.
     */
    @Test
    public void testGetArchiveFormsMultipleIds() throws InterruptedException, ExecutionException, TimeoutException {
        System.out.println("testing GetArchiveListForDocuments");
        CompletableFuture<Map<Integer, Collection<ArchiveForm>>> result = client.login(username, password)
                .thenCompose((o) -> client.getArchiveForms((Collection) Arrays.asList(91, 92)));
        Map<Integer, Collection<ArchiveForm>> forms = result.get();        

        assertTrue(!forms.isEmpty());
    }

    /**
     * Test of fetchFormData method, of class ServiceClientImpl.
     */
    @Test
    public void testGetFormData() throws InterruptedException, ExecutionException {
        System.out.println("testing GetFormData");
        CompletableFuture<FormData> result = client.login(username, password)
                .thenCompose((creds) -> client.getArchiveForms(91))
                .thenCompose((archiveForms) -> client.getFormData(archiveForms.stream().findFirst().get().getForm().getCaseId(), 91));
        assertTrue(result.get().getColumns().size() > 0);
    }

}
