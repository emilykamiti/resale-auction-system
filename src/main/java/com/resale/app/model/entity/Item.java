package com.resale.app.model.entity;

import java.io.Serializable;

import com.resale.app.view.helper.HtmlForm;
import com.resale.app.view.helper.HtmlTable;
import com.resale.app.view.helper.HtmlTableColHeader;
import com.resale.database.helper.DbColumn;



@HtmlTable(addUrl = "./items?action=add")
@HtmlForm(label = "Item", url = "./item")
public class Item implements Serializable {

 @DbColumn(columnName = "name")
    @HtmlTableColHeader(header = "Name")
    private String name;

    @DbColumn(columnName = "type")
    @HtmlTableColHeader(header = "Type")
    private String type;

    @DbColumn(columnName = "price")
    @HtmlTableColHeader(header = "Price")
    private double price;

    @DbColumn(columnName = "image")
    @HtmlTableColHeader(header = "Image")
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
