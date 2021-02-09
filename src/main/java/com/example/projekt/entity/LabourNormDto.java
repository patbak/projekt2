package com.example.projekt.entity;

public class LabourNormDto {

    private int id;

    private int directoryNumber;

    private int tableNumber;

    private int columnNumber;

    private int rowNumber;

    private String labourName;

    private float unitNumber;

    private String unitValue;

    private float labourNorm;

    public LabourNormDto(int id, int directoryNumber, int tableNumber, int columnNumber, int rowNumber, String labourName, float unitNumber, String unitValue, float labourNorm) {
        this.id = id;
        this.directoryNumber = directoryNumber;
        this.tableNumber = tableNumber;
        this.columnNumber = columnNumber;
        this.rowNumber = rowNumber;
        this.labourName = labourName;
        this.unitNumber = unitNumber;
        this.unitValue = unitValue;
        this.labourNorm = labourNorm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDirectoryNumber() {
        return directoryNumber;
    }

    public void setDirectoryNumber(int directoryNumber) {
        this.directoryNumber = directoryNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getLabourName() {
        return labourName;
    }

    public void setLabourName(String labourName) {
        this.labourName = labourName;
    }

    public float getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(float unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(String unitValue) {
        this.unitValue = unitValue;
    }

    public float getLabourNorm() {
        return labourNorm;
    }

    public void setLabourNorm(float labourNorm) {
        this.labourNorm = labourNorm;
    }
}
