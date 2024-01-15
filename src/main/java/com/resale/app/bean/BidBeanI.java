
package com.resale.app.bean;

import java.util.List;

import com.resale.app.model.entity.Bid;

public interface BidBeanI extends GenericBeanI<Bid> {
    Bid addOrUpdateBid(Bid bid, String userName, Long itemId);

    List<Bid> getBidByItemId(Long itemId);
}
