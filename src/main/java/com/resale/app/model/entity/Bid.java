package com.resale.app.model.entity;

import java.io.Serializable;

import com.resale.app.view.helper.HtmlForm;
import com.resale.app.view.helper.HtmlFormField;
import com.resale.app.view.helper.HtmlTableColHeader;

@HtmlForm(label = "Bid", url = "./bid")
public class Bid implements Serializable {
    private long id;

    @HtmlTableColHeader(header = "Item Name")
    @HtmlFormField(label = "bid-item-name")
    private String itemName;

    @HtmlTableColHeader(header = "User Name")
    @HtmlFormField(label = "bid-user-name")
    private String userName;

    @HtmlTableColHeader(header = "PhoneNumber")
    @HtmlFormField(label = "phone-number")
    private String phone;

    @HtmlTableColHeader(header = "Bid Amount")
    @HtmlFormField(label = "bid-amount")
    private double bidAmount;

    private String trackID;

    public Bid(long id, String itemName, String userName, String phone, double bidAmount) {
        this.id = id;
        this.itemName = itemName;
        this.userName = userName;
        this.phone = phone;
        this.bidAmount = bidAmount;
    }

    public String getTrackID() {
        return trackID;
    }

    public void setTrackID(String trackID) {
        this.trackID = trackID;
    }

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
