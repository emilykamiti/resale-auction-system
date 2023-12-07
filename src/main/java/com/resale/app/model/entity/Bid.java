package com.resale.app.model.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.resale.app.view.helper.HtmlForm;

@Entity
@Table(name = "bids")
@HtmlForm(label = "Bid", url = "./bids")
public class Bid extends BaseEntity {

    @Column(name = "bid_amount")
    private double bidAmount;

    public Bid() {

    }

    public Bid( double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

}