package com.resale.app.bean;

import com.resale.app.model.entity.Item;

public interface ItemBeanI  {
    String showItems();
    
    Item addOrUpdateItem(Item item);

    void deleteItem(Item item);

}