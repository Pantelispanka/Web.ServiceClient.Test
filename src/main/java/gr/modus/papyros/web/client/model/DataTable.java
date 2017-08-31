/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author Charalampos Chomenidis
 */
public class DataTable {

    private DocumentInfo documentInfo;
    private ArchiveForm archiveForm;
    private Map<Integer, Object> fieldsData;
    private Date dateIn;
    private Date dateEdit;

    public DocumentInfo getDocumentInfo() {
        return documentInfo;
    }

    public void setDocumentInfo(DocumentInfo documentInfo) {
        this.documentInfo = documentInfo;
    }

    public ArchiveForm getArchiveForm() {
        return archiveForm;
    }

    public void setArchiveForm(ArchiveForm archiveForm) {
        this.archiveForm = archiveForm;
    }

    public Map<Integer, Object> getFieldsData() {
        return fieldsData;
    }

    public void setFieldsData(Map<Integer, Object> fieldsData) {
        this.fieldsData = fieldsData;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }

}
