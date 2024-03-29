package com.resale.app.model.entity;

import com.resale.app.view.helper.HtmlForm;
import com.resale.app.view.helper.HtmlFormField;
import com.resale.app.view.helper.HtmlTable;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.resale.app.view.helper.HtmlCards;
import com.resale.app.view.helper.HtmlTableColHeader;

@Entity
@Table(name = "items")
@HtmlTable(addUrl = "./item?action=add")
@HtmlForm(label = "Item", url = "./item")
@NamedQueries({
        @NamedQuery(name = "findItemByItemId", query = "SELECT i FROM Item i WHERE i.id = :itemId"),
})

public class Item extends BaseEntity {

    @Column(name = "ItemName")
    @HtmlCards(label = "Item Name")
    @HtmlTableColHeader(header = " Item Name")
    @HtmlFormField(label = "Item Name", required = true)
    private String itemName;

    @Column(name = "Description")
    @HtmlFormField(label = "Description", required = true)
    @HtmlTableColHeader(header = "Description")
    private String description;

    @Column(name = "ItemCategory")
    @HtmlFormField(label = "ItemCategory", required = true)
    @Enumerated(EnumType.STRING)
    private ItemCategory category;

    @Column(name = "EstimateAmount")
    @HtmlCards(label = "Estimate Amount")
    @HtmlFormField(label = "Estimate", required = true)
    @HtmlTableColHeader(header = "Estimate Amount")
    private BigDecimal estimateAmount;

    @Column(name = "image")
    @HtmlCards(label = "image")
    @HtmlTableColHeader(header = "image")
    @HtmlFormField(label = "image", required = true)
    private String image;

    @Column(name = "BidDuration")
    @HtmlCards(label = "BidDuration: ")
    @HtmlTableColHeader(header = "Duration")
    @HtmlFormField(label = "Duration", required = true)
    private String bidDuration;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Bid> bids;

    @Override
    public String toString() {
        return "Item [itemName=" + itemName + ", description=" + description + ", category=" + category
                + ", estimateAmount=" + estimateAmount + ", image=" + image + ", bidDuration=" + bidDuration + "]";
    }

    public Item() {
    }

    public Item(String itemName, String description, ItemCategory category, BigDecimal estimateAmount, String image,
            String bidDuration) {
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.estimateAmount = estimateAmount;
        this.image = image;
        this.bidDuration = bidDuration;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return estimateAmount;
    }

    public void setPrice(BigDecimal price) {
        this.estimateAmount = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBidDuration() {
        return bidDuration;
    }

    public void setBidDuration(String bidDuration) {
        this.bidDuration = bidDuration;
    }

    @JsonIgnore
    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}