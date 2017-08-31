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
public class User {

    private String username;
    private String password;
    private String cityname;
    private String streetname;
    private String streetnumber;
    private String arealcode;
    private String telephone;
    private String mobile;
    private String fax;
    private String email;
    private String customField1;
    private String customField2;
    private String customField3;
    private String customField4;
    private String description;
    private String lastpasswordupdate;
    private String accountexpirationdate;
    private boolean passwordneverexpires;
    private boolean usercanchangepassword;
    private boolean accountneverexpires;
    private int unindexedFolderId; //φάκελος μη αρχειοθετημενων του χρήστη
    private Group primaryGroup;
    private List<Group> activeGroups;
    private List<Group> allGroups;
    private String activeGroupsStr; //comma separated list of all the user's groups    Τα οποία είναι active.
    private String allGroupsStr; //comma separated list of all the user's groups    Τα οποία είναι active.
    private User myDelegator;//αντικαταστατης του χρηστη
    private List<Integer> delegateOf; //χρηστες που ο χρηστης αντικαθιστά
    private List<UserArchiveFormsSettings> userArchiveFormsSettings;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getArealcode() {
        return arealcode;
    }

    public void setArealcode(String arealcode) {
        this.arealcode = arealcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField2() {
        return customField2;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    public String getCustomField3() {
        return customField3;
    }

    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    public String getCustomField4() {
        return customField4;
    }

    public void setCustomField4(String customField4) {
        this.customField4 = customField4;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastpasswordupdate() {
        return lastpasswordupdate;
    }

    public void setLastpasswordupdate(String lastpasswordupdate) {
        this.lastpasswordupdate = lastpasswordupdate;
    }

    public String getAccountexpirationdate() {
        return accountexpirationdate;
    }

    public void setAccountexpirationdate(String accountexpirationdate) {
        this.accountexpirationdate = accountexpirationdate;
    }

    public boolean isPasswordneverexpires() {
        return passwordneverexpires;
    }

    public void setPasswordneverexpires(boolean passwordneverexpires) {
        this.passwordneverexpires = passwordneverexpires;
    }

    public boolean isUsercanchangepassword() {
        return usercanchangepassword;
    }

    public void setUsercanchangepassword(boolean usercanchangepassword) {
        this.usercanchangepassword = usercanchangepassword;
    }

    public boolean isAccountneverexpires() {
        return accountneverexpires;
    }

    public void setAccountneverexpires(boolean accountneverexpires) {
        this.accountneverexpires = accountneverexpires;
    }

    public int getUnindexedFolderId() {
        return unindexedFolderId;
    }

    public void setUnindexedFolderId(int unindexedFolderId) {
        this.unindexedFolderId = unindexedFolderId;
    }

    public Group getPrimaryGroup() {
        return primaryGroup;
    }

    public void setPrimaryGroup(Group primaryGroup) {
        this.primaryGroup = primaryGroup;
    }

    public List<Group> getActiveGroups() {
        return activeGroups;
    }

    public void setActiveGroups(List<Group> activeGroups) {
        this.activeGroups = activeGroups;
    }

    public List<Group> getAllGroups() {
        return allGroups;
    }

    public void setAllGroups(List<Group> allGroups) {
        this.allGroups = allGroups;
    }

    public String getActiveGroupsStr() {
        return activeGroupsStr;
    }

    public void setActiveGroupsStr(String activeGroupsStr) {
        this.activeGroupsStr = activeGroupsStr;
    }

    public String getAllGroupsStr() {
        return allGroupsStr;
    }

    public void setAllGroupsStr(String allGroupsStr) {
        this.allGroupsStr = allGroupsStr;
    }

    public User getMyDelegator() {
        return myDelegator;
    }

    public void setMyDelegator(User myDelegator) {
        this.myDelegator = myDelegator;
    }

    public List<Integer> getDelegateOf() {
        return delegateOf;
    }

    public void setDelegateOf(List<Integer> delegateOf) {
        this.delegateOf = delegateOf;
    }

    public List<UserArchiveFormsSettings> getUserArchiveFormsSettings() {
        return userArchiveFormsSettings;
    }

    public void setUserArchiveFormsSettings(List<UserArchiveFormsSettings> userArchiveFormsSettings) {
        this.userArchiveFormsSettings = userArchiveFormsSettings;
    }

}
