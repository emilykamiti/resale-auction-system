package com.resale.app.model.entity;

import com.resale.app.view.helper.HtmlTable;
import com.resale.app.view.helper.HtmlTableColHeader;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "bids")
@HtmlTable(addUrl = "./bids?action=add")
public class Bid extends BaseEntity {

    @Column(name = "BidNo")
    @HtmlTableColHeader(header = "Bid Number")
    private String bidNumber;

    @Column(name = "BidTime")
    @HtmlTableColHeader(header = "Bid Time")
    private LocalDateTime bidTime;

    @Column(name = "BidAmount")
    @HtmlTableColHeader(header = "Bid Amount")
    private BigDecimal bidAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Formula("user_id")
    private Long userId;

    private long Status; // ! to do later

    public Bid(String bidNumber, LocalDateTime bidTime, BigDecimal bidAmount, User user, Long userId) {
        this.bidNumber = bidNumber;
        this.bidTime = bidTime;
        this.bidAmount = bidAmount;
        this.user = user;
        this.userId = userId;
    }

    public Bid() {
    }

    @Override
    public String toString() {
        return "Bid [bidNumber=" + bidNumber + ", bidTime=" + bidTime + ", bidAmount=" + bidAmount + ", user=" + user
                + "]";
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
