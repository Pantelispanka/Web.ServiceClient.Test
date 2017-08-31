/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

import java.util.Date;

/**
 *
 * @author Charalampos Chomenidis
 */
public class PDeletedDetails {

    private int deletedId;
    private int docId; //DOC_ID = IMAGE.ID
    private Date dateDeleted;
    private int userDeleted;
    private int formId; //REPRESENTS CASE_ID!!! NOT THE ID FROM FORMS TABLE
    private int folderId;
    private int caseDocId;
    private int caseFldId;
    private int isDeleted;
    private DocumentInfo docInfo; //reference στο αντικειμενο που διαγραφηκε

    public int getDeletedId() {
        return deletedId;
    }

    public void setDeletedId(int deletedId) {
        this.deletedId = deletedId;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public Date getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    public int getUserDeleted() {
        return userDeleted;
    }

    public void setUserDeleted(int userDeleted) {
        this.userDeleted = userDeleted;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public int getCaseDocId() {
        return caseDocId;
    }

    public void setCaseDocId(int caseDocId) {
        this.caseDocId = caseDocId;
    }

    public int getCaseFldId() {
        return caseFldId;
    }

    public void setCaseFldId(int caseFldId) {
        this.caseFldId = caseFldId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public DocumentInfo getDocInfo() {
        return docInfo;
    }

    public void setDocInfo(DocumentInfo docInfo) {
        this.docInfo = docInfo;
    }

}
