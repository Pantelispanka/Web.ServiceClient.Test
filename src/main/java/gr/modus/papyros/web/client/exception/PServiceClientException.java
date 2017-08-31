/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.exception;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public class PServiceClientException extends RuntimeException {

    private int status;

    public PServiceClientException() {
    }

    public PServiceClientException(String message) {
        super(message);
    }

    public PServiceClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public PServiceClientException(Throwable cause) {
        super(cause);
    }

    public PServiceClientException(int status, String message) {
        super(message);
        this.status = status;
    }

    public PServiceClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
