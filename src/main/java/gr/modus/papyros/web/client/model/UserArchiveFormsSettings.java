/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Charalampos Chomenidis
 */
public class UserArchiveFormsSettings {

    public enum DocType {
        BLANK(1, "Κενό Έγγραφο", ""),
        DOCUMENT(3, "Έγγραφο", "");

        private final int docType;
        private final String docTypeName;
        private final String docTypeIcon;

        DocType(int docType, String docTypeName, String docTypeIcon) {
            this.docType = docType;
            this.docTypeName = docTypeName;
            this.docTypeIcon = docTypeIcon;
        }

        public int getType() {
            return this.docType;
        }

        public String getName() {
            return this.docTypeName;
        }

        public String getIcon() {
            return this.docTypeIcon;
        }

        private static final Map<Integer, DocType> lookup = new HashMap<>();

        static {
            for (DocType docType : UserArchiveFormsSettings.DocType.values()) {
                DocType put = lookup.put(docType.getType(), docType);
            }
        }

        public static DocType get(int id) {
            return lookup.get(id);
        }

    }

    private int userId;
    private DocType docType;
    private TableForm tableForm;

    private boolean cleanImage;
    private boolean deskew;
    private boolean unindexed;
    private boolean extractText;
    private boolean checkAnalysis;
    private boolean ocrDoc;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public TableForm getTableForm() {
        return tableForm;
    }

    public void setTableForm(TableForm tableForm) {
        this.tableForm = tableForm;
    }

    public boolean isCleanImage() {
        return cleanImage;
    }

    public void setCleanImage(boolean cleanImage) {
        this.cleanImage = cleanImage;
    }

    public boolean isDeskew() {
        return deskew;
    }

    public void setDeskew(boolean deskew) {
        this.deskew = deskew;
    }

    public boolean isUnindexed() {
        return unindexed;
    }

    public void setUnindexed(boolean unindexed) {
        this.unindexed = unindexed;
    }

    public boolean isExtractText() {
        return extractText;
    }

    public void setExtractText(boolean extractText) {
        this.extractText = extractText;
    }

    public boolean isCheckAnalysis() {
        return checkAnalysis;
    }

    public void setCheckAnalysis(boolean checkAnalysis) {
        this.checkAnalysis = checkAnalysis;
    }

    public boolean isOcrDoc() {
        return ocrDoc;
    }

    public void setOcrDoc(boolean ocrDoc) {
        this.ocrDoc = ocrDoc;
    }

}
