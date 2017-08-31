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
public class IndexedDocs {

    private int docId;
    private IndexType indexType;
    private IndexStatus indexStatus;
    private String failedReason;
    private Date indexTime;

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public IndexType getIndexType() {
        return indexType;
    }

    public void setIndexType(IndexType indexType) {
        this.indexType = indexType;
    }

    public IndexStatus getIndexStatus() {
        return indexStatus;
    }

    public void setIndexStatus(IndexStatus indexStatus) {
        this.indexStatus = indexStatus;
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

    public Date getIndexTime() {
        return indexTime;
    }

    public void setIndexTime(Date indexTime) {
        this.indexTime = indexTime;
    }

    public enum IndexType {
        Permissions(0),
        Content(1),
        Image(2);

        private final int value;

        IndexType(int value) {
            this.value = value;
        }

        public static IndexType getByValue(int value) {
            switch (value) {
                case 0:
                    return IndexType.Permissions;
                case 1:
                    return IndexType.Content;
                case 2:
                    return IndexType.Image;
                default:
                    return IndexType.Content;
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

    public enum IndexStatus {
        NEW(0),
        PEDDING(1),
        FINISHED(2),
        FAILED(3);

        private final int value;

        IndexStatus(int value) {
            this.value = value;
        }

        public static IndexStatus getByValue(int value) {
            switch (value) {
                case 0:
                    return IndexStatus.NEW;
                case 1:
                    return IndexStatus.PEDDING;
                case 2:
                    return IndexStatus.FINISHED;
                case 3:
                    return IndexStatus.FAILED;
                default:
                    return IndexStatus.NEW;
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
}
