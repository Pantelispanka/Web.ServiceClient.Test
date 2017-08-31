/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Charalampos Chomenidis
 */
public class UserGroup {

    protected int id;
    protected String fullname;
    protected String imgPath = "";
    protected String imageFullname;
    protected String accessHours;
    protected boolean isFavorite;
    protected Type type;
    protected FolderInfo unindexed; //Usergroup's selected folder for non archived documents.
    protected List<FolderInfo> indexed; //Usergroup's selected folders for archived documents.
    protected Status status;
    protected List<POrgChart> orgNodes; //συνδεση μέσω P_OC_USERS - οι θέσεις του χρήστη/ της ομάδας πάνω στο οργανόγραμμα

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImageFullname() {
        return imageFullname;
    }

    public void setImageFullname(String imageFullname) {
        this.imageFullname = imageFullname;
    }

    public String getAccessHours() {
        return accessHours;
    }

    public void setAccessHours(String accessHours) {
        this.accessHours = accessHours;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public FolderInfo getUnindexed() {
        return unindexed;
    }

    public void setUnindexed(FolderInfo unindexed) {
        this.unindexed = unindexed;
    }

    public List<FolderInfo> getIndexed() {
        return indexed;
    }

    public void setIndexed(List<FolderInfo> indexed) {
        this.indexed = indexed;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<POrgChart> getOrgNodes() {
        return orgNodes;
    }

    public void setOrgNodes(List<POrgChart> orgNodes) {
        this.orgNodes = orgNodes;
    }

    public enum Type {
        USER(1),
        GROUP(2);

        private static final Map<Integer, Type> lookup = new HashMap<>();

        static {
            for (Type type : UserGroup.Type.values()) {
                lookup.put(type.getId(), type);
            }
        }

        private final int id;

        Type(int id) {
            this.id = id;
        }

        public static Type get(int id) {
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

    public enum Status {
        INACTIVE(2),
        ACTIVE(1),
        DELETED(0);

        private static final Map<Integer, Status> lookup = new HashMap<>();

        static {
            for (Status status : Status.values()) {
                lookup.put(status.getId(), status);
            }
        }

        private final int id;

        Status(int id) {
            this.id = id;
        }

        public static Status get(int id) {
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

    public enum Base {
        ADMINISTRATOR(1000000),
        EVERYONE(100000),
        ADMINISTRATORS(100001);

        private static final Map<Integer, Base> lookup = new HashMap<>();

        static {
            for (Base base : UserGroup.Base.values()) {
                lookup.put(base.getId(), base);
            }
        }

        private final int id;

        Base(int id) {
            this.id = id;
        }

        public static Base get(int id) {
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
}
