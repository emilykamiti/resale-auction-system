package com.resale.app.bean;


import com.resale.app.model.entity.Item;
import com.resale.database.MysqlDatabase;

public class ItemBean extends GenericBean<Item> implements ItemBeanI {

    public Item addItems(Item item) {
        MysqlDatabase.insert(item);
        return item;
    }
}