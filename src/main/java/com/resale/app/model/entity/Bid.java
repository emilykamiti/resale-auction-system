package com.resale.app.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.resale.app.view.helper.HtmlTable;
import com.resale.app.view.helper.HtmlTableColHeader;

@Entity
@Table(name = "bids")
@HtmlTable(addUrl = "./bids?action=add")
public class Bid extends BaseEntity {

    @Column(name = "BidderName")
    @HtmlTableColHeader(header = "BidderName")
    private String bidderName;

    @Column(name = "BidTime")
    @HtmlTableColHeader(header = "Bid Time")
    private LocalDateTime bidTime;

    @Column(name = "bidamount")
    @HtmlTableColHeader(header = "bidamount")
    private BigDecimal bidAmount;

    public Bid() {
    }

    @Override
    public String toString() {
        return "Bid [bidderName=" + bidderName + ", bidTime=" + bidTime + ", bidAmount=" + bidAmount + "]";
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

    public Bid(String bidderName, LocalDateTime bidTime, BigDecimal bidAmount) {
        this.bidderName = bidderName;
        this.bidTime = bidTime;
        this.bidAmount = bidAmount;
    }

}