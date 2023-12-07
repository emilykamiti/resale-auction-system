package com.resale.app.model.entity;

import com.resale.app.view.helper.HtmlForm;
import com.resale.app.view.helper.HtmlFormField;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.resale.app.view.helper.HtmlCrdRender;
import com.resale.app.view.helper.HtmlTableColHeader;
import com.resale.database.helper.DbTableColumn;

@Entity
@Table(name = "items")
@HtmlForm(label = "Item", url = "./item")
public class Item extends BaseEntity {

    @DbTableColumn(name = "name")
    @HtmlTableColHeader(header = " Item Name")
    private String itemName;

    @DbTableColumn(name = "description")
    @HtmlFormField(label = "Description")
    @HtmlTableColHeader(header = "Description")
    private String description;

    @Column(name = "price")
    @HtmlCrdRender(label = "price")
    @HtmlFormField(label = "price")
    @HtmlTableColHeader(header = "Item Price")
    private BigDecimal price;

    @Column(name = "image")
    @HtmlCrdRender(label = "image")
    @HtmlFormField(label = "image")
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
