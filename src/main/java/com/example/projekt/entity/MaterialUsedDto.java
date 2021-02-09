package com.example.projekt.entity;

import com.example.projekt.entity.BrigadeDailyReportDto;
import com.example.projekt.entity.MaterialDto;

public class MaterialUsedDto {

    private int id;

    private float quantity;

    private BrigadeDailyReportDto brigadeDailyReport;

    private MaterialDto material;

    public MaterialUsedDto(int id, float quantity, BrigadeDailyReportDto brigadeDailyReport, MaterialDto material) {
        this.id = id;
        this.quantity = quantity;
        this.brigadeDailyReport = brigadeDailyReport;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public BrigadeDailyReportDto getBrigadeDailyReport() {
        return brigadeDailyReport;
    }

    public void setBrigadeDailyReport(BrigadeDailyReportDto brigadeDailyReport) {
        this.brigadeDailyReport = brigadeDailyReport;
    }

    public MaterialDto getMaterial() {
        return material;
    }

    public void setMaterial(MaterialDto material) {
        this.material = material;
    }
}
