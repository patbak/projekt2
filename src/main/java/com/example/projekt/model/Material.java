package com.example.projekt.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private int materialId;

    @Column(name = "name")
    private String materialName;

    @Column(name = "unit")
    private String materialUnit;

    @Column(name = "average_cost")
    private float avgCost;

    @OneToMany(
            mappedBy = "material",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<UsedMaterial> usedMaterials;

    public List<UsedMaterial> getUsedMaterials() {
        return usedMaterials;
    }

    public void setUsedMaterials(List<UsedMaterial> usedMaterials) {
        this.usedMaterials = usedMaterials;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public float getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(float avgCost) {
        this.avgCost = avgCost;
    }
}
