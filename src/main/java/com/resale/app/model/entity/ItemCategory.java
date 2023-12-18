package com.resale.app.model.entity;

public enum ItemCategory {

    ACCESORY("Accesory"),
    LUXURY("Luxury"),
    HOMEURNITURE("Luxury"),
    CARS("Cars");

    private String name;

    ItemCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
