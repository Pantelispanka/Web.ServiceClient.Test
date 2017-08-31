/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

/**
 *
 * @author Charalampos Chomenidis
 */
public class POrgChart {

    private int ocId;
    private String ocTree;
    private String ocDescription;
    private int ocDeleted;

    public int getOcId() {
        return ocId;
    }

    public void setOcId(int ocId) {
        this.ocId = ocId;
    }

    public String getOcTree() {
        return ocTree;
    }

    public void setOcTree(String ocTree) {
        this.ocTree = ocTree;
    }

    public String getOcDescription() {
        return ocDescription;
    }

    public void setOcDescription(String ocDescription) {
        this.ocDescription = ocDescription;
    }

    public int getOcDeleted() {
        return ocDeleted;
    }

    public void setOcDeleted(int ocDeleted) {
        this.ocDeleted = ocDeleted;
    }

}
