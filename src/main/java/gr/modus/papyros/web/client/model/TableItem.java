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
public class TableItem {

    public enum DataType {
        Date(1),
        AlphaNumeric(2),
        Numeric(3),
        Mul(4),
        Decimal(5);

        private final int value;

        DataType(int value) {
            this.value = value;
        }

        public static DataType getByValue(int value) {
            return Arrays.stream(DataType.values()).filter(v -> v.value == value).findFirst().orElse(null);
        }

        public int getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    private int id;             // Μοναδικό ID που είναι και το primary key του πίνακα
    private int orderId;        // Ορίζει την σειρά των πεδίων
    private String fieldName;   // Το όνομα του πεδίου όπως το έχει ορίσει ο χρήστης
    private String dbField;     //Το όνομα του column στον πίνακα Wxxx_DATA για το συγκεκριμένο πεδίο.
    private DataType dataType;  // Καθορίζει το database τύπο του πεδίου. Οι τύποι που χρησιμοποιούνται είναι:
    // 4.	Πολλαπλών επιλογών
    // 5.	Αριθμητικό με δεκαδικά
    private int par1L;          // Καθορίζει το μήκος των Αλφαριθμητικών πεδίων (για DATATYPE = 2)
    // 1.	Ημερομηνία
    // 2.	Αλφαριθμητικό

    // 3.	Αριθμητικό
    private String par1;
    private int par2L;
    private String par2;
    private int par3L;
    private String par3;
    private int rightId1;
    private int rightId2;
    private int rightId3;
    private boolean fieldIsStatic;
    private String dataValue;
    private String dataTypeStr;
    private int length;         // display_sets_fields.DSETFLD_FLD_LENGTH
    private int align;          // display_sets_fields.DSETFLD_FLD_ALIGN
    private String columnDesc;  //display_sets_fields.DSETFLD_DESCRIPTION
    private TableView tableView;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDbField() {
        return dbField;
    }

    public void setDbField(String dbField) {
        this.dbField = dbField;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public int getPar1L() {
        return par1L;
    }

    public void setPar1L(int par1L) {
        this.par1L = par1L;
    }

    public String getPar1() {
        return par1;
    }

    public void setPar1(String par1) {
        this.par1 = par1;
    }

    public int getPar2L() {
        return par2L;
    }

    public void setPar2L(int par2L) {
        this.par2L = par2L;
    }

    public String getPar2() {
        return par2;
    }

    public void setPar2(String par2) {
        this.par2 = par2;
    }

    public int getPar3L() {
        return par3L;
    }

    public void setPar3L(int par3L) {
        this.par3L = par3L;
    }

    public String getPar3() {
        return par3;
    }

    public void setPar3(String par3) {
        this.par3 = par3;
    }

    public int getRightId1() {
        return rightId1;
    }

    public void setRightId1(int rightId1) {
        this.rightId1 = rightId1;
    }

    public int getRightId2() {
        return rightId2;
    }

    public void setRightId2(int rightId2) {
        this.rightId2 = rightId2;
    }

    public int getRightId3() {
        return rightId3;
    }

    public void setRightId3(int rightId3) {
        this.rightId3 = rightId3;
    }

    public boolean isFieldIsStatic() {
        return fieldIsStatic;
    }

    public void setFieldIsStatic(boolean fieldIsStatic) {
        this.fieldIsStatic = fieldIsStatic;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataTypeStr() {
        return dataTypeStr;
    }

    public void setDataTypeStr(String dataTypeStr) {
        this.dataTypeStr = dataTypeStr;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAlign() {
        return align;
    }

    public void setAlign(int align) {
        this.align = align;
    }

    public String getColumnDesc() {
        return columnDesc;
    }

    public void setColumnDesc(String columnDesc) {
        this.columnDesc = columnDesc;
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }

}
