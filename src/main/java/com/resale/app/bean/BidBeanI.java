
package com.resale.app.bean;

import java.util.List;

import com.resale.app.model.entity.Bid;

public interface BidBeanI {

    boolean submitBid(Bid bid);

    List<Bid> getAllBids();

   
}
