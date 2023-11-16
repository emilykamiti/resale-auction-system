// BidBean.java
package com.resale.app.bean;

import java.util.ArrayList;
import java.util.List;

import com.resale.app.model.entity.Bid;

public class BidBean implements BidBeanI {
    private static List<Bid> allBids = new ArrayList<>();

    @Override
    public boolean submitBid(Bid bid) {
        allBids.add(bid);
        return true;
    }

    @Override
    public List<Bid> getAllBids() {
        return allBids;
    }

    public void addOrUpdateBid(Bid newBid) {
      
    }
}
