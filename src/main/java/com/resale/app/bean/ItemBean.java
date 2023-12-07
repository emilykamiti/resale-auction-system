package com.resale.app.bean;


import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.resale.app.model.entity.Item;

@Remote
@Stateless
public class ItemBean extends GenericBean<Item> implements ItemBeanI {

   
}