package com.resale.app.bean;

import java.util.ArrayList;
import java.util.List;
import com.resale.app.model.entity.Bid;

public class BidBean implements BidBeanI {
    private List<Bid> allBids = new ArrayList<>();

    @Override
    public boolean submitBid(Bid bid) {
        return allBids.add(bid);
    }

    @Override
    public List<Bid> getAllBids() {
        return allBids;
    }
}
