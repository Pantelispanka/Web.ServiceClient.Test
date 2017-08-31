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
public class POCR {

    public enum POCRSTatus {
        NEW(0),
        PEDDING(1),
        FINISHED(2),
        FAILED(3);

        private final int value;

        POCRSTatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static POCRSTatus getByValue(int value) {
            switch (value) {
                case 0:
                    return POCRSTatus.NEW;
                case 1:
                    return POCRSTatus.PEDDING;
                case 2:
                    return POCRSTatus.FINISHED;
                case 3:
                    return POCRSTatus.FAILED;
                default:
                    return POCRSTatus.NEW;
            }
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    private int id;
    private POCRSTatus pOCRSTatus;
    private Date dateIn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public POCRSTatus getpOCRSTatus() {
        return pOCRSTatus;
    }

    public void setpOCRSTatus(POCRSTatus pOCRSTatus) {
        this.pOCRSTatus = pOCRSTatus;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

}
