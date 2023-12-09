package com.resale.app.model.entity;

import com.resale.app.view.helper.HtmlTable;
import com.resale.app.view.helper.HtmlTableColHeader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "bids")
@HtmlTable(addUrl = "./bids?action=add")
public class Bid extends BaseEntity {

    @Column(name = "BidNo", nullable = false, unique = true)
    @HtmlTableColHeader(header = "Bid Number")
    private String bidNumber;

    @Column(name = "BidderName")
    @HtmlTableColHeader(header = "Bidder Name")
    private String bidderName;

    @Column(name = "BidTime")
    @HtmlTableColHeader(header = "BId Time")
    private LocalDateTime bidTime;
 
    @Column(name = "BidAmount")
    @HtmlTableColHeader(header = "Bid Amount")
    private BigDecimal bidAmount;

    
    public Bid() {
    }

    public Bid(String bidNumber, String bidderName, BigDecimal bidAmount, LocalDateTime bidTime) {
        this.bidderName = bidderName;
        this.bidTime = LocalDateTime.now(); 
        this.bidAmount = bidAmount;
        this .bidNumber = bidNumber;
    }

     public String getBidNumber() {
        return bidNumber;
    }

    public void setBidNumber(String bidNumber) {
        this.bidNumber = bidNumber;
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
        return "Bid [bidNumber=" + bidNumber + ", bidderName=" + bidderName + ", bidTime=" + bidTime + ", bidAmount="
                + bidAmount + "]";
    }

}
