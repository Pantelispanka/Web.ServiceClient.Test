/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client;

import gr.modus.papyros.web.client.consumer.AAConsumer;
import gr.modus.papyros.web.client.consumer.DataConsumer;
import gr.modus.papyros.web.client.consumer.DocumentsConsumer;
import gr.modus.papyros.web.client.consumer.FormsConsumer;
import gr.modus.papyros.web.client.serialize.Serializer;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public class PapyrosClientFactory {

    public PapyrosClient create(String basePath, Serializer serializer) {

        AsyncHttpClient httpClient = new DefaultAsyncHttpClient();
        return new PServiceClientImpl(
                httpClient,
                serializer,
                new AAConsumer(httpClient, serializer, basePath),
                new DocumentsConsumer(httpClient, serializer, basePath),
                new FormsConsumer(httpClient, serializer, basePath),
                new DataConsumer(httpClient, serializer, basePath));
    }
}
