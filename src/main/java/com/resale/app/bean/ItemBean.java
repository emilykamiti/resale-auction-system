package com.resale.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.resale.app.model.entity.Item;

@Remote
@Stateless
public class ItemBean extends GenericBean<Item> implements ItemBeanI {

    @PersistenceContext
    private EntityManager em;

    public Item findById(Long userId) {
        return em.find(Item.class, userId);
    }

}


   