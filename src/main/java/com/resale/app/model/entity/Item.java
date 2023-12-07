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
@HtmlTable(addUrl = "./item?action=add")
@HtmlForm(label = "Item", url = "./item")
public class Item extends BaseEntity {

    @Column(name = "ItemName")
    @HtmlCards(label = "")
    @HtmlTableColHeader(header = " ItemName")
    @HtmlFormField(label = "Item Name", required = true)
    private String itemName;

    @Column(name = "ItmeDescription")
    @HtmlFormField(label = "Description", required = true)
    @HtmlTableColHeader(header = "ItemDescription")
    private String description;

    @Column(name = "ItemPrice")
    @HtmlCards(label = "Price: ")
    @HtmlFormField(label = "Price", required = true)
    @HtmlTableColHeader(header = "ItemPrice")
    private BigDecimal price;

    @Column(name = "ItemImage")
    @HtmlCards(label = "ItemImage")
    @HtmlTableColHeader(header = "ItemImage")
    @HtmlFormField(label = "ItemImage", required = true)
    private String ItemImage;

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
        return ItemImage;
    }

    public void setImage(String ItemImage) {
        this.ItemImage = ItemImage;
    }

    public Item(String itemName, ItemType type, BigDecimal price, String ItemImage) {
        this.itemName = itemName;
        this.price = price;
        this.ItemImage = ItemImage;
    }

}
