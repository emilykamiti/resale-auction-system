package com.resale.app.model.entity;

import java.io.Serializable;
import com.resale.app.view.html.ResaleHtmlForm;
import com.resale.app.view.html.ResaleHtmlFormField;
import com.resale.app.view.html.ResaleTableColHeader;

@ResaleHtmlForm(label = "Item", url = "./item")
public class Item implements Serializable {

    @ResaleTableColHeader(header = "Name")
    @ResaleHtmlFormField(label = "item-name")
    private String name;

    @ResaleTableColHeader(header = "Type")
    @ResaleHtmlFormField(label = "item-type")
    private String type;

    @ResaleTableColHeader(header = "Price")
    @ResaleHtmlFormField(label = "item-price")
    private double price;

    @ResaleTableColHeader(header = "Image")
    @ResaleHtmlFormField(label = "item-image")
    private String imageURL;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Item(String name, String type, double price, String imageURL) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.imageURL = imageURL;
    }

}
