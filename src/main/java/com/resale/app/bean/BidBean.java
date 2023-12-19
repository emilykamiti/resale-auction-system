package com.resale.app.bean;

import com.google.gson.Gson;

import com.google.gson.Gson;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;

import com.resale.app.model.entity.Bid;
import com.resale.app.model.entity.Email;
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

    public Bid addOrUpdateBid(Bid bid, String username) {

        User user;

        TypedQuery<User> query = em.createNamedQuery("findUserByUsername", User.class);
        query.setParameter("username", username);
        user = query.getSingleResult();

        bid.setUser(user);

        bid.setBidNumber(bidNoGenerator.generateBidNumber());
        bid.setBidTime(LocalDateTime.now());

        getDao().addOrUpdate(bid);

        Email email = new Email();
        email.senderEmail = "emilykamiti@gmail.com";
        email.recipientEmail = "kenmutesh901@gmail.com";
        email.subject = "Testing";
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

}
