/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

/**
 *
 * @author Charalampos Chomenidis
 */
public class Version {

    private DocumentInfo mainDoc;
    private DocumentInfo versionDoc;
    private int versionId;
    private String versionDescription;
    private int defaultFlag;
    private int defaultAsk;

    public DocumentInfo getMainDoc() {
        return mainDoc;
    }

    public void setMainDoc(DocumentInfo mainDoc) {
        this.mainDoc = mainDoc;
    }

    public DocumentInfo getVersionDoc() {
        return versionDoc;
    }

    public void setVersionDoc(DocumentInfo versionDoc) {
        this.versionDoc = versionDoc;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public String getVersionDescription() {
        return versionDescription;
    }

    public void setVersionDescription(String versionDescription) {
        this.versionDescription = versionDescription;
    }

    public int getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(int defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public int getDefaultAsk() {
        return defaultAsk;
    }

    public void setDefaultAsk(int defaultAsk) {
        this.defaultAsk = defaultAsk;
    }

}
