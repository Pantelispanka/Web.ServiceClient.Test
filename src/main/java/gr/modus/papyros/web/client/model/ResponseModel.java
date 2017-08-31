/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

import java.util.Collection;

/**
 *
 * @author Charalampos Chomenidis
 */
public class ResponseModel<E> {

    private boolean success = true; //success param for stores
    private Collection<E> data; //rootproperty
    private MetaDataModel metaData;
    private E simpleData;
    private int messageType = 2; //SUCCESS TODO
    private String messageTitle;
    private String processMessage;
    private int total; //totalproperty

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Collection<E> getData() {
        return data;
    }

    public void setData(Collection<E> data) {
        this.data = data;
    }

    public MetaDataModel getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaDataModel metaData) {
        this.metaData = metaData;
    }

    public E getSimpleData() {
        return simpleData;
    }

    public void setSimpleData(E simpleData) {
        this.simpleData = simpleData;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getProcessMessage() {
        return processMessage;
    }

    public void setProcessMessage(String processMessage) {
        this.processMessage = processMessage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
