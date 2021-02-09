package com.example.projekt.entity;

public class QualityEvaluationDto {

    private int id;

    private int value;

    private  String name;


    public QualityEvaluationDto(int id, int value, String name) {
        this.id = id;
        this.value = value;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
