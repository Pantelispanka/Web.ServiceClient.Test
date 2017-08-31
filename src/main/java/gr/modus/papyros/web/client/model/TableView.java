/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.model;

import java.util.Arrays;

/**
 *
 * @author Charalampos Chomenidis
 */
public class TableView {

    public enum ViewType {
        TextBox(1),
        ComboListBox(2),
        ComboEditListBox(3),
        ListBox(4),
        DateControl(5),
        CheckBoxButton(6),
        RadioButton(7),
        MultipleDictionary(10),
        SingleFolders(11),
        SingleDictionary(12),
        DateEditControl(13),
        MultipleFolders(14),
        SingleCodeDictionary(15),
        MultipleCodeDictionary(16),
        Thesaurus(17),
        StaticTextCaption(30),
        StaticFrame(31),
        StaticLine(32),
        StaticText(33);

        private final int value;

        ViewType(int value) {
            this.value = value;
        }

        public static ViewType getByValue(int value) {
            return Arrays.stream(ViewType.values()).filter(v -> v.value == value).findFirst().orElse(null);
        }

        public int getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    private int displayId;  // Το ID της φόρμας εμφάνισης (σύνδεση με Wxxx_FORMS.ID)
    private int fieldId;    // Το ID του πεδίου (σύνδεση με Wxxx_ITEMS.ID).
    // Για τα στατικά πεδία που τοποθετούνται το ID είναι για το
    // caption ενός πεδίου ίσο με το ID του πεδίου + 1000
    // και για τα υπόλοιπα static έχουν τιμές πάνω από 5000
    private int positionX;  // Καθορίζει την οριζόντια θέση του πεδίου στην φόρμα (είναι σε pixels)
    private int positionY;  // Καθορίζει το πλάτος του πεδίου στην φόρμα (είναι σε pixels)
    private int width;      // Καθορίζει το πλάτος του πεδίου στην φόρμα (είναι σε pixels)
    private int height;     // Καθορίζει το ύψος του πεδίου στην φόρμα (είναι σε pixels)
    private ViewType viewType;   // Καθορίζει τον τύπο του control που θα χρησιμοποιηθεί για το συγκεκριμένο πεδίο
    private String viewTypeStr;
    private int viewSubType;// Καθορίζει τον τύπο του control που θα χρησιμοποιηθεί για το συγκεκριμένο πεδίο
    private int align;      // Καθορίζει το align για τα πεδία που το control που χρησιμοποιείται είναι EDITBOX και έχει τιμές
    // 0,1 για left align
    // 2 για center
    // 3 για right align
    private String par1;    // Σχετίζεται με το viewtype – viewsubtype
    private int par1L;      // Σχετίζεται με το viewtype – viewsubtype
    private String par2;    // Σχετίζεται με το viewtype – viewsubtype
    private int par2L;      // Σχετίζεται με το viewtype – viewsubtype
    private String par3;    // Σχετίζεται με το viewtype – viewsubtype
    private int par3L;      // Σχετίζεται με το viewtype – viewsubtype
    private String par4;    // Σχετίζεται με το viewtype – viewsubtype
    private int tabOrder;   // Καθορίζει το Tab order

    public int getDisplayId() {
        return displayId;
    }

    public void setDisplayId(int displayId) {
        this.displayId = displayId;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ViewType getViewType() {
        return viewType;
    }

    public void setViewType(ViewType viewType) {
        this.viewType = viewType;
    }

    public String getViewTypeStr() {
        return viewTypeStr;
    }

    public void setViewTypeStr(String viewTypeStr) {
        this.viewTypeStr = viewTypeStr;
    }

    public int getViewSubType() {
        return viewSubType;
    }

    public void setViewSubType(int viewSubType) {
        this.viewSubType = viewSubType;
    }

    public int getAlign() {
        return align;
    }

    public void setAlign(int align) {
        this.align = align;
    }

    public String getPar1() {
        return par1;
    }

    public void setPar1(String par1) {
        this.par1 = par1;
    }

    public int getPar1L() {
        return par1L;
    }

    public void setPar1L(int par1L) {
        this.par1L = par1L;
    }

    public String getPar2() {
        return par2;
    }

    public void setPar2(String par2) {
        this.par2 = par2;
    }

    public int getPar2L() {
        return par2L;
    }

    public void setPar2L(int par2L) {
        this.par2L = par2L;
    }

    public String getPar3() {
        return par3;
    }

    public void setPar3(String par3) {
        this.par3 = par3;
    }

    public int getPar3L() {
        return par3L;
    }

    public void setPar3L(int par3L) {
        this.par3L = par3L;
    }

    public String getPar4() {
        return par4;
    }

    public void setPar4(String par4) {
        this.par4 = par4;
    }

    public int getTabOrder() {
        return tabOrder;
    }

    public void setTabOrder(int tabOrder) {
        this.tabOrder = tabOrder;
    }

}
