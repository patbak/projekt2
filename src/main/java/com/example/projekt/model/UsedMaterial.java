package com.example.projekt.model;


import javax.persistence.*;

@Entity
@Table(name = "materials_used")
public class UsedMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material_used")
    private int usedMaterialId;

    @Column(name = "quantity")
    private float quantity;

    @ManyToOne
    @JoinColumn(name = "materials_id_material")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "brigade_daily_reports_id_brigade_daily_report")
    private DailyWorkReport dailyWorkReport;

    public int getUsedMaterialId() {
        return usedMaterialId;
    }

    public void setUsedMaterialId(int usedMaterialId) {
        this.usedMaterialId = usedMaterialId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public DailyWorkReport getDailyWorkReport() {
        return dailyWorkReport;
    }

    public void setDailyWorkReport(DailyWorkReport dailyWorkReport) {
        this.dailyWorkReport = dailyWorkReport;
    }
}
