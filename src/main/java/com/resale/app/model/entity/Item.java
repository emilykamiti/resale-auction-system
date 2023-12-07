package com.resale.app.model.entity;

import com.resale.app.view.helper.HtmlForm;
import com.resale.app.view.helper.HtmlFormField;
import com.resale.app.view.helper.HtmlTable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.resale.app.view.helper.HtmlCards;
import com.resale.app.view.helper.HtmlTableColHeader;

@Entity
@Table(name = "items")
@HtmlTable(name = "items", addUrl = "./item/add")
@HtmlForm(label = "Item", url = "./item")
public class Item extends BaseEntity {

    @Column(name = "Item Name")
    @HtmlCards(label = "Item Name")
    @HtmlTableColHeader(header = " Item Name")
     @HtmlFormField(label = "Item Name", required = true)
    private String itemName;

    @Column(name = "Description")
    @HtmlFormField(label = "Description", required = true)
    @HtmlTableColHeader(header = "Description")
    private String description;

    @Column(name = "Item Price")
    @HtmlCards(label = "Item price")
    @HtmlFormField(label = "Price", required = true)
    @HtmlTableColHeader(header = "Item Price")
    private BigDecimal price;

    @Column(name = "image")
    @HtmlCards(label = "image")
    @HtmlTableColHeader(header = "image")
    @HtmlFormField(label = "image", required = true)
    private String image;

    public Item() {
    }

    public String getitemName() {
        return itemName;
    }

    public void setitemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Item(String itemName, ItemType type, BigDecimal price, String image) {
        this.itemName = itemName;
        this.price = price;
        this.image = image;
    }

}
