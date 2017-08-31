/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

/**
 *
 * @author Charalampos Chomenidis
 */
public class ArchiveForm extends TableForm {

    private boolean archived; //true αν ένα έγγραφο έχει αρχειοθετηθεί
    private boolean rightSubForm; //true αν ένα έγγραφο έχει αρχειοθετηθεί με αυτήν και είναι επιλεγμένη σαν rightForm

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isRightSubForm() {
        return rightSubForm;
    }

    public void setRightSubForm(boolean rightSubForm) {
        this.rightSubForm = rightSubForm;
    }

}
