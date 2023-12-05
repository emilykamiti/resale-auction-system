package com.resale.app.model.entity;

import java.io.Serializable;

import com.resale.app.view.helper.HtmlForm;
import com.resale.app.view.helper.HtmlFormField;
import com.resale.app.view.helper.HtmlTableColHeader;
import com.resale.database.helper.DbTable;
import com.resale.database.helper.DbTableColumn;
@DbTable(name = "bids") 
@HtmlForm(label = "Bid", url = "./bid")
public class Bid implements Serializable {

    @DbTableColumn(name = "id") // Annotate id field with DbTableColumn specifying column name
    private long id;

    @DbTableColumn(name = "item_id") // Annotate itemId field with DbTableColumn specifying column name
    private long itemId; // Assuming itemId is used to link bid to the item

    @DbTableColumn(name = "user_id") // Annotate userId field with DbTableColumn specifying column name
    private long userId; // Assuming userId is used to link bid to the user

    @HtmlTableColHeader(header = "Bid Amount")
    @HtmlFormField(label = "bid-amount")
    @DbTableColumn(name = "bid_amount") // Annotate bidAmount field with DbTableColumn specifying column name
    private double bidAmount;

    @DbTableColumn(name = "track_id") // Annotate trackID field with DbTableColumn specifying column name
    private String trackID;

    public Bid() {
        // Default constructor
    }

    public Bid(long id, long itemId, long userId, double bidAmount, String trackID) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
        this.bidAmount = bidAmount;
        this.trackID = trackID;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getTrackID() {
        return trackID;
    }

    public void setTrackID(String trackID) {
        this.trackID = trackID;
    }
}