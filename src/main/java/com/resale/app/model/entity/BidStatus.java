package com.resale.app.model.entity;

public enum BidStatus {
    
    REJECT("Reject"),
    ACCEPT("Accept");

    private String name;

    BidStatus(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

