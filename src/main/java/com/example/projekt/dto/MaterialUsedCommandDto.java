package com.example.projekt.dto;

public class MaterialUsedCommandDto {

    private int materialId;

    private float quantity;

    public MaterialUsedCommandDto(int materialId, float quantity) {
        this.materialId = materialId;
        this.quantity = quantity;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
