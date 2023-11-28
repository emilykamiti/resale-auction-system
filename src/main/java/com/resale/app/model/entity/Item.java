package com.resale.app.model.entity;

import com.resale.app.view.helper.HtmlForm;
import com.resale.app.view.helper.HtmlFormField;

import com.resale.app.view.helper.HtmlCrdRender;
import com.resale.app.view.helper.HtmlTableColHeader;
import com.resale.database.helper.DbTable;
import com.resale.database.helper.DbTableColumn;

@DbTable(name = "items")
@HtmlForm(label = "Item", url = "./item")
public class Item extends BaseEntity {

    @DbTableColumn(name = "name")
    @HtmlTableColHeader(header = "Name")
    private String name;

    @DbTableColumn(name = "type")
    @HtmlCrdRender(label = "type")
    @HtmlFormField(label = "type")
    @HtmlTableColHeader(header = "Item Type")
    private ItemType type;

    @DbTableColumn(name = "price")
    @HtmlCrdRender(label = "price")
    @HtmlFormField(label = "price")
    @HtmlTableColHeader(header = "Item Price")
    private double price;

    @DbTableColumn(name = "image")
    @HtmlCrdRender(label = "image")
    @HtmlFormField(label = "image")
    private String image; 
    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Item(String name, ItemType type, double price, String image) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", type=" + type + ", price=" + price + ", image=" + image + "]";
    }
}
