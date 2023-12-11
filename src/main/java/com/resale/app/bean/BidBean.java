package com.resale.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;

import com.resale.app.model.entity.Bid;
import com.resale.app.utility.BidNo;
import com.resale.app.utility.BidNoGenerator;

@Remote
@Stateless
public class BidBean extends GenericBean<Bid> implements BidBeanI {

    @Inject
    @BidNo
    private BidNoGenerator bidNoGenerator;

    public Bid addOrUpdate(Bid bid) {
        Bid managedBid;

        if (bid.getId() != null) {
            managedBid = getDao().getEm().find(Bid.class, bid.getId());
        } else {
            managedBid = new Bid();
            managedBid.setBidNumber(bidNoGenerator.generateBidNumber());
        }

        managedBid.setBidAmount(bid.getBidAmount());
        managedBid.setBidTime(LocalDateTime.now());

        return getDao().addOrUpdate(managedBid);
    }
}