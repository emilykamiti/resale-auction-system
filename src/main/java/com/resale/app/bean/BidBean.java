package com.resale.app.bean;

import com.google.gson.Gson;

import com.google.gson.Gson;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;

import com.resale.app.model.entity.Bid;
<<<<<<< HEAD
import com.resale.app.model.entity.Item;
=======
import com.resale.app.model.entity.Email;
>>>>>>> 4131598ecc32c5e798f4153911e775fef3d6e20e
import com.resale.app.model.entity.User;
import com.resale.app.utility.BidNo;
import com.resale.app.utility.BidNoGenerator;

@Remote
@Stateless
public class BidBean extends GenericBean<Bid> implements BidBeanI {

    @Inject
    @BidNo
    private BidNoGenerator bidNoGenerator;

    @Inject
    private EmailBean emailBean;

    @PersistenceContext
    private EntityManager em;

    public Bid addOrUpdateBid(Bid bid, String username, Long itemId) {

        User user;
        Item item;

        TypedQuery<User> query = em.createNamedQuery("findUserByUsername", User.class);
        query.setParameter("username", username);
        user = query.getSingleResult();

        TypedQuery<Item> queryitem = em.createNamedQuery("findItemByItemId", Item.class);
        queryitem.setParameter("itemId", itemId);
        try {
            item = queryitem.getSingleResult();
        } catch (NoResultException e) {
            // Handle the exception. For example, return null or throw a custom exception.
            return null;
        }
        bid.setUser(user);
        bid.setItem(item);
        bid.setBidNumber(bidNoGenerator.generateBidNumber());
        bid.setBidTime(LocalDateTime.now());

        getDao().addOrUpdate(bid);

        Email email = new Email();
        email.senderEmail = "emilykamiti@gmail.com";
        email.recipientEmail = bid.getUser().getEmail();
        email.subject = "Bid Confirmation";
        email.body = "You have successully made a bid of " + bid.getBidAmount();

        String jsonEmail = new Gson().toJson(email);
        try {
            emailBean.sendEmail(email, jsonEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return bid;
    }

    public List<Bid> getBidByUserId(Long userId) {
        return em.createQuery("SELECT b FROM Bid b WHERE b.user.id = :userId", Bid.class)
                .setParameter("userId", userId)
                .getResultList();

    }

    public List<Bid> getBidByItemId(Long itemId) {
        return em.createQuery("SELECT b FROM Bid b WHERE b.item.id = :itemId", Bid.class)
                .setParameter("itemId", itemId)
                .getResultList();
    }

}
