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
    @JoinColumn(name = "user_id")
    private Long userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    @Formula("item_id")
    @HtmlTableColHeader(header = "Item ID")
    private Long itemId;

    @Override
    public String toString() {
        return "Bid [bidNumber=" + bidNumber + ", bidTime=" + bidTime + ", bidAmount=" + bidAmount + ", user=" + user
                + ", userId=" + userId + ", item=" + item + ", itemId=" + itemId + "]";
    }

    public Bid(String bidNumber, LocalDateTime bidTime, BigDecimal bidAmount, User user, Long userId, Item item,
            Long itemId) {
        this.bidNumber = bidNumber;
        this.bidTime = bidTime;
        this.bidAmount = bidAmount;
        this.user = user;
        this.userId = userId;
        this.item = item;
        this.itemId = itemId;
    }

    public Bid() {
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

}
