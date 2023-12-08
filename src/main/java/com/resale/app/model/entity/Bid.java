package com.resale.app.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bids")
public class Bid extends BaseEntity {

    @Column(name = "BidderName")
    private String bidderName;

    @Column(name = "BidTime")
    private LocalDateTime bidTime;

    @Column(name = "bidamount")
    private BigDecimal bidAmount;

    public Bid() {
    }

    public Bid(String bidderName, BigDecimal bidAmount ) {
        this.bidderName = bidderName;
        this.bidTime = LocalDateTime.now(); 
        this.bidAmount = bidAmount;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }

    @Override
    public String toString() {
        return "Bid [bidderName=" + bidderName + ", bidTime=" + bidTime + ", bidAmount=" + bidAmount + "]";
    }
}
