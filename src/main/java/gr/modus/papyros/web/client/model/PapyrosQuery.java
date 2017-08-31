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
public class PapyrosQuery {

    public enum QueryOwner {

        ROUTINGS(3),
        FORM(2);

        private final int id;

        QueryOwner(int id) {
            this.id = id;
        }

        private static final Map<Integer, QueryOwner> lookup = new HashMap<>();

        static {
            for (QueryOwner owner : QueryOwner.values()) {
                lookup.put(owner.getId(), owner);
            }
        }

        public static QueryOwner get(int id) {
            return lookup.get(id);
        }

        public int getId() {
            return this.id;
        }

        @Override
        public String toString() {
            return String.valueOf(this.id);
        }

    }
    private int id;
    private String description;
    private int displaySetId;
    private int orderSetId;
    private QueryOwner queryOwner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDisplaySetId() {
        return displaySetId;
    }

    public void setDisplaySetId(int displaySetId) {
        this.displaySetId = displaySetId;
    }

    public int getOrderSetId() {
        return orderSetId;
    }

    public void setOrderSetId(int orderSetId) {
        this.orderSetId = orderSetId;
    }

    public QueryOwner getQueryOwner() {
        return queryOwner;
    }

    public void setQueryOwner(QueryOwner queryOwner) {
        this.queryOwner = queryOwner;
    }

}
