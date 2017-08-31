/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author George Anagnostopoulos
 */
public class FormData {

    private Integer documentId;
    private Map<String, Object> fieldValues;
    private List<GridMetaDataModel> columns;
    private String formDescription;

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Map<String, Object> getFieldValues() {
        return fieldValues;
    }

    public void setFieldValues(Map<String, Object> fieldValues) {
        this.fieldValues = fieldValues;
    }

    public List<GridMetaDataModel> getColumns() {
        return columns;
    }

    public void setColumns(List<GridMetaDataModel> columns) {
        this.columns = columns;
    }

    public String getFormDescription() {
        return formDescription;
    }

    public void setFormDescription(String formDescription) {
        this.formDescription = formDescription;
    }

}
