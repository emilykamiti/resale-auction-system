package com.resale.app.model.entity;

public enum UserType {


    ADMIN("Admin"),
    BIDDER("Bidder");

    private String name;
   
    UserType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}