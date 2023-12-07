package com.resale.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.resale.app.model.entity.Bid;

@Remote
@Stateless
public class  BidBean extends GenericBean<Bid> implements BidBeanI {
    
}
