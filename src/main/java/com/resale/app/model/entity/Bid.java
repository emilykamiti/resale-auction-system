package com.resale.app.model.entity;

import com.resale.app.view.helper.HtmlTable;
import com.resale.app.view.helper.HtmlTableColHeader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bids")
@HtmlTable(addUrl = "./bids?action=add")
public class Bid extends BaseEntity {

    @Column(name = "BidNo", nullable = false, unique = true)
    @HtmlTableColHeader(header = "Bid Number")
    private String bidNumber;

    @Column(name = "BidTime")
    @HtmlTableColHeader(header = "BId Time")
    private LocalDateTime bidTime;

    @Column(name = "EstimateAmount")
    @HtmlTableColHeader(header = "Estimate Amount")
    private BigDecimal estimateAmount;

    @Column(name = "BidAmount")
    @HtmlTableColHeader(header = "Bid Amount")
    private BigDecimal bidAmount;


    @ManyToOne(fetch = FetchType.LAZY)
    private Bidder bidder;

    public Bid() {
    }

    public Bid(String bidNumber, LocalDateTime bidTime, BigDecimal estimateAmount,
            BigDecimal bidAmount) {
        this.bidNumber = bidNumber;
        this.bidTime = bidTime;
        this.estimateAmount = estimateAmount;
        this.bidAmount = bidAmount;
    }

    public String getBidNumber() {
        return bidNumber;
    }

    public void setBidNumber(String bidNumber) {
        this.bidNumber = bidNumber;
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

    public BigDecimal getEstimateAmount() {
        return estimateAmount;
    }

    public void setEstimateAmount(BigDecimal estimateAmount) {
        this.estimateAmount = estimateAmount;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public void setCustomer(Bidder customer) {
        this.bidder = customer;
    }
    @Override
    public String toString() {
        return "Bid [bidNumber=" + bidNumber +  ", bidTime=" + bidTime + ", bidAmount="
                + bidAmount + "]";
    }

}
