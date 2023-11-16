package com.resale.app.bean;

import com.resale.app.model.entity.Item;
import com.resale.app.view.html.HtmlTable;
import com.resale.database.Database;

public class ItemBean implements ItemBeanI {

    public String showItems() {

    return HtmlTable.table(Database.getDbInstance().getItems());
    }

    public Item addOrUpdateItem(Item item) {
        Database database = Database.getDbInstance();

        database.getItems().add(item);
        return item;
    }

    public void deleteItem(Item item) {
    }
}