
package com.resale.app.bean;

import com.resale.app.model.entity.Bid;

public interface BidBeanI extends GenericBeanI<Bid> {
    Bid addOrUpdateBid(Bid bid, String userName);

}
