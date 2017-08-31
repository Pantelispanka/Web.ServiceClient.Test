/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Charalampos Chomenidis
 */
public class DocumentInfo {

    public enum DocumentType {
        REAL(1),
        CASE(2),
        EMPTY(3),
        EVENT(4),
        TASK(5),
        ANNOUNCEMENT(6);

        private final int value;

        DocumentType(int value) {
            this.value = value;
        }

        public static DocumentType getByValue(int value) {
            switch (value) {
                case 1:
                    return DocumentType.REAL;
                case 2:
                    return DocumentType.CASE;
                case 3:
                    return DocumentType.EMPTY;
                case 4:
                    return DocumentType.EVENT;
                case 5:
                    return DocumentType.TASK;
                case 6:
                    return DocumentType.ANNOUNCEMENT;
                default:
                    return DocumentType.EMPTY;
            }
        }

        public int getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    private int id;
    private DocumentType type;
    private String description;
    private Date dateInserted;
    private int revision;
    private PDevice device;
    private int pages;
    private int typeId; //TODO change to enum
    private int subTypeId;
    private String extension;
    private int checkOut;
    private User checkOutBy;
    private String filename;
    private String fileDescription;
    private long param1;
    private int param2;
    private PServer pserver;
    private int pFilter;
    private String pFilterDescription;
    private User owner;
    private Version version; //τα στοιχεία της έκδοσης που ανοίκει το έγγραφο
    private List<DataTable> documentDatasInfo; //στοιχεια Αρχειοθέτησης - πιθανόν > 1 φόρμες
    private List<PDeletedDetails> pdeletedDetails;//στοιχεία Διαγραφής - πιθανόν το έγγραφο να διαγράφηκε από > 1 τοποθεσίες (φακέλους/φόρμες)
    private POCR pOCR; //το OCR status του εγγράφου
    private List<IndexedDocs> index; //οι εγγραφές του εγγράφου στον LUC_INDEXED_DOCS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateInserted() {
        return dateInserted;
    }

    public void setDateInserted(Date dateInserted) {
        this.dateInserted = dateInserted;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public PDevice getDevice() {
        return device;
    }

    public void setDevice(PDevice device) {
        this.device = device;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(int subTypeId) {
        this.subTypeId = subTypeId;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public User getCheckOutBy() {
        return checkOutBy;
    }

    public void setCheckOutBy(User checkOutBy) {
        this.checkOutBy = checkOutBy;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public long getParam1() {
        return param1;
    }

    public void setParam1(long param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }

    public PServer getPserver() {
        return pserver;
    }

    public void setPserver(PServer pserver) {
        this.pserver = pserver;
    }

    public int getpFilter() {
        return pFilter;
    }

    public void setpFilter(int pFilter) {
        this.pFilter = pFilter;
    }

    public String getpFilterDescription() {
        return pFilterDescription;
    }

    public void setpFilterDescription(String pFilterDescription) {
        this.pFilterDescription = pFilterDescription;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public List<DataTable> getDocumentDatasInfo() {
        return documentDatasInfo;
    }

    public void setDocumentDatasInfo(List<DataTable> documentDatasInfo) {
        this.documentDatasInfo = documentDatasInfo;
    }

    public List<PDeletedDetails> getPdeletedDetails() {
        return pdeletedDetails;
    }

    public void setPdeletedDetails(List<PDeletedDetails> pdeletedDetails) {
        this.pdeletedDetails = pdeletedDetails;
    }

    public POCR getpOCR() {
        return pOCR;
    }

    public void setpOCR(POCR pOCR) {
        this.pOCR = pOCR;
    }

    public List<IndexedDocs> getIndex() {
        return index;
    }

    public void setIndex(List<IndexedDocs> index) {
        this.index = index;
    }

}
