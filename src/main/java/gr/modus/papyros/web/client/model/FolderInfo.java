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
public class FolderInfo {

    private String folderTreeName;
    private int dbId; //περιέχει το πραγματικό id. Στην περίπτωση του shortcut περιέχει το πραγματικό id.
    private int shortcutId;
    private FolderInfo shortcutFolder;
    private int querySetId;
    private int querySetOwner; //TODO to be deprecated because type of query can be found by the query subclass
    private PapyrosQuery query;
    private String shortName;
    private String parent;
    private User creator;
    private int owner;
    private String typeLabel;
    private int folderType;
    private int flag;
    private int order;
    private int displayId;
    private List<FolderInfo> folderPath;
    private boolean library;
    private boolean indexed;
    private List<ArchiveForm> indexedForms;
    private boolean unindexed;

    public String getFolderTreeName() {
        return folderTreeName;
    }

    public void setFolderTreeName(String folderTreeName) {
        this.folderTreeName = folderTreeName;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    public int getShortcutId() {
        return shortcutId;
    }

    public void setShortcutId(int shortcutId) {
        this.shortcutId = shortcutId;
    }

    public FolderInfo getShortcutFolder() {
        return shortcutFolder;
    }

    public void setShortcutFolder(FolderInfo shortcutFolder) {
        this.shortcutFolder = shortcutFolder;
    }

    public int getQuerySetId() {
        return querySetId;
    }

    public void setQuerySetId(int querySetId) {
        this.querySetId = querySetId;
    }

    public int getQuerySetOwner() {
        return querySetOwner;
    }

    public void setQuerySetOwner(int querySetOwner) {
        this.querySetOwner = querySetOwner;
    }

    public PapyrosQuery getQuery() {
        return query;
    }

    public void setQuery(PapyrosQuery query) {
        this.query = query;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    public int getFolderType() {
        return folderType;
    }

    public void setFolderType(int folderType) {
        this.folderType = folderType;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getDisplayId() {
        return displayId;
    }

    public void setDisplayId(int displayId) {
        this.displayId = displayId;
    }

    public List<FolderInfo> getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(List<FolderInfo> folderPath) {
        this.folderPath = folderPath;
    }

    public boolean isLibrary() {
        return library;
    }

    public void setLibrary(boolean library) {
        this.library = library;
    }

    public boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    public List<ArchiveForm> getIndexedForms() {
        return indexedForms;
    }

    public void setIndexedForms(List<ArchiveForm> indexedForms) {
        this.indexedForms = indexedForms;
    }

    public boolean isUnindexed() {
        return unindexed;
    }

    public void setUnindexed(boolean unindexed) {
        this.unindexed = unindexed;
    }

}
