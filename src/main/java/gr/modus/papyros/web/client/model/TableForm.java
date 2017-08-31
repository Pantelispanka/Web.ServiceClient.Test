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
public class TableForm {

    private int id;             // Μοναδικό ID που είναι και το primary key του πίνακα (id υποφορμας)
    private int pType;
    private int pDefault;
    private Form form;          //Η φόρμα στην οποία ανοίκει η υποφόρμα
    private String formName;    // Το όνομα της φόρμας εμφάνισης. Αυτό το όνομα εμφανίζετε στα μενού
    private String tableFormName;   // Το όνομα του πίνακα της φόρμας
    private int rightExecuteId; // ID Δικαιώματος για την δυνατότητα να χρησιμοποιήσει την συγκεκριμένη φόρμα εμφάνισης
    private int rightViewId;    // ID Δικαιώματος για το αν θα εμφανίζετε η φόρμα στο μενού
    private int docId;          // The id of the currently selected document - used in edit form
    private int parentDocID;    // Το id του εγγράφου από το οποίο άνοιξε νέα φόρμα (π.χ. detail data)
    private List<TableItem> items;
    private int userId;
    private int detailedHidden; //1 is detail data form and is hidden, 0 otherwise

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpType() {
        return pType;
    }

    public void setpType(int pType) {
        this.pType = pType;
    }

    public int getpDefault() {
        return pDefault;
    }

    public void setpDefault(int pDefault) {
        this.pDefault = pDefault;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getTableFormName() {
        return tableFormName;
    }

    public void setTableFormName(String tableFormName) {
        this.tableFormName = tableFormName;
    }

    public int getRightExecuteId() {
        return rightExecuteId;
    }

    public void setRightExecuteId(int rightExecuteId) {
        this.rightExecuteId = rightExecuteId;
    }

    public int getRightViewId() {
        return rightViewId;
    }

    public void setRightViewId(int rightViewId) {
        this.rightViewId = rightViewId;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getParentDocID() {
        return parentDocID;
    }

    public void setParentDocID(int parentDocID) {
        this.parentDocID = parentDocID;
    }

    public List<TableItem> getItems() {
        return items;
    }

    public void setItems(List<TableItem> items) {
        this.items = items;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDetailedHidden() {
        return detailedHidden;
    }

    public void setDetailedHidden(int detailedHidden) {
        this.detailedHidden = detailedHidden;
    }

}
