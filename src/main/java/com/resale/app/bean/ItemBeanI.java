package com.resale.app.bean;

import java.sql.SQLException;

import com.resale.app.model.entity.Item;


public interface ItemBeanI extends GenericBeanI<Item> {

    Item  addItems(Item item) throws SQLException;

}
