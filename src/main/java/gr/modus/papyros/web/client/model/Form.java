/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

import java.util.Map;

/**
 *
 * @author Charalampos Chomenidis
 */
public class Form {

    private int id;             // Μοναδικό ID που είναι και το primary key του πίνακα
    private String formName;    // Το όνομα της φόρμας (δεν εμφανίζετε στην εφαρμογή)
    private String formInfo;    // Περιγραφή της φόρμας (δεν εμφανίζετε στην εφαρμογή)
    private String tablePrefix; // Το prefix όλων των πινάκων της φόρμας που δημιουργούνται αυτόματα από το σύστημα
    private String tableName;   // Το όνομα του βασικού πίνακα της φόρμας
    private int caseId;         // ID που εισάγετε από τον χρήστη και χρησιμοποιείται όταν γράφουμε custom κώδικα για την φόρμα
    private int orderId;        // Ορίζει την σειρά με την οποία θα εμφανίζονται οι φόρμες στα μενού της εφαρμογής
    private int pAppId;
    private Map<Integer, ArchiveForm> archiveForms; //όλες οι υποφόρμες αρχειοθέτησης μια φόρμας παπύρου
    private Map<Integer, SearchForm> searchForms; //όλες οι υποφόρμες αναζήτησης μια φόρμας παπύρου

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormInfo() {
        return formInfo;
    }

    public void setFormInfo(String formInfo) {
        this.formInfo = formInfo;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getpAppId() {
        return pAppId;
    }

    public void setpAppId(int pAppId) {
        this.pAppId = pAppId;
    }

    public Map<Integer, ArchiveForm> getArchiveForms() {
        return archiveForms;
    }

    public void setArchiveForms(Map<Integer, ArchiveForm> archiveForms) {
        this.archiveForms = archiveForms;
    }

    public Map<Integer, SearchForm> getSearchForms() {
        return searchForms;
    }

    public void setSearchForms(Map<Integer, SearchForm> searchForms) {
        this.searchForms = searchForms;
    }

}
