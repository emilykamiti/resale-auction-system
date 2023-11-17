package com.resale.app.model.entity;

import java.io.Serializable;
import com.resale.app.view.html.ResaleHtmlForm;
import com.resale.app.view.html.ResaleHtmlFormField;
import com.resale.app.view.html.ResaleTableColHeader;

@ResaleHtmlForm(label = "Bid", url = "./bid")
public class Bid implements Serializable {
    private long id;

    @ResaleTableColHeader(header = "Item Name")
    @ResaleHtmlFormField(label = "bid-item-name")
    private String itemName;

    @ResaleTableColHeader(header = "User Name")
    @ResaleHtmlFormField(label = "bid-user-name")
    private String userName;

    @ResaleTableColHeader(header = "PhoneNumber")
    @ResaleHtmlFormField(label = "phone-number")
    private String phone;

    @ResaleTableColHeader(header = "Bid Amount")
    @ResaleHtmlFormField(label = "bid-amount")
    private double bidAmount;

    private String trackID;

    public Bid(long id, String itemName, String userName, String phone, double bidAmount) {
        this.id = id;
        this.itemName = itemName;
        this.userName = userName;
        this.phone = phone;
        this.bidAmount = bidAmount;
    }

    // Getters and setters for trackID
    public String getTrackID() {
        return trackID;
    }

    public void setTrackID(String trackID) {
        this.trackID = trackID;
    }

    // Getters and setters for other fields
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }
}
