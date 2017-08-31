/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

import java.util.List;

/**
 *
 * @author Charalampos Chomenidis
 */
public class MetaDataModel {

    private String sessionId;
    private float responseTime;
    private String message;
    private long count; //records displayed in grid
    private int totalCount;
    private List<GridMetaDataModel> columns;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public float getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(float responseTime) {
        this.responseTime = responseTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<GridMetaDataModel> getColumns() {
        return columns;
    }

    public void setColumns(List<GridMetaDataModel> columns) {
        this.columns = columns;
    }

}
