package com.example.projekt.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "labour_norms")
public class LabourStandard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_labour_norm")
    private int labourStandardId;

    @Column(name = "directory_number")
    private int catalogNumber;

    @Column(name = "table_number")
    private int tableNumber;

    @Column(name = "column_number")
    private int columnNumber;

    @Column(name = "row_number")
    private int rowNumber;

    @Column(name = "labour_name")
    private String workName;

    @Column(name = "unit_number")
    private float unitOfMeasurementNumber;

    @Column(name = "unit_value")
    private String unitOfMeasurementValue;

    @Column(name = "labour_norm")
    private float labourStandard;


    @OneToMany(
            mappedBy = "labourStandard",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<WorkDone> workDoneList;

    public List<WorkDone> getWorkDoneList() {
        return workDoneList;
    }

    public void setWorkDoneList(List<WorkDone> workDoneList) {
        this.workDoneList = workDoneList;
    }

    public int getLabourStandardId() {
        return labourStandardId;
    }

    public void setLabourStandardId(int labourStandardId) {
        this.labourStandardId = labourStandardId;
    }

    public int getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(int catalogNumber) {
        this.catalogNumber = catalogNumber;
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

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public float getUnitOfMeasurementNumber() {
        return unitOfMeasurementNumber;
    }

    public void setUnitOfMeasurementNumber(float unitOfMeasurementNumber) {
        this.unitOfMeasurementNumber = unitOfMeasurementNumber;
    }

    public String getUnitOfMeasurementValue() {
        return unitOfMeasurementValue;
    }

    public void setUnitOfMeasurementValue(String unitOfMeasurementValue) {
        this.unitOfMeasurementValue = unitOfMeasurementValue;
    }

    public float getLabourStandard() {
        return labourStandard;
    }

    public void setLabourStandard(float labourStandard) {
        this.labourStandard = labourStandard;
    }
}
