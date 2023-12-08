package com.resale.app.bean;

import java.time.LocalDateTime;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.resale.app.model.entity.Bid;

@Remote
@Stateless
public class BidBean extends GenericBean<Bid> implements BidBeanI {

}