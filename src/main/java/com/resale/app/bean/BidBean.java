package com.resale.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;

import com.resale.app.model.entity.Bid;
import com.resale.app.model.entity.User;
import com.resale.app.utility.BidNo;
import com.resale.app.utility.BidNoGenerator;

@Remote
@Stateless
public class BidBean extends GenericBean<Bid> implements BidBeanI {

    @Inject
    @BidNo
    private BidNoGenerator bidNoGenerator;

    @PersistenceContext
    private EntityManager em;

    public Bid addOrUpdateBid(Bid bid, String username) {

        User user;

        TypedQuery<User> query = em.createNamedQuery("findUserByUsername", User.class);
        query.setParameter("username", username);
        user = query.getSingleResult();

        bid.setUser(user);

        bid.setBidNumber(bidNoGenerator.generateBidNumber());
        bid.setBidTime(LocalDateTime.now());

        getDao().addOrUpdate(bid);

        return bid;
    }

    public List<Bid> getBidByUserId(Long userId) {
        return em.createQuery("SELECT b FROM Bid b WHERE b.user.id = :userId", Bid.class)
                .setParameter("userId", userId)
                .getResultList();

    }

}
