package com.resale.app.utility;

import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
@BidNo
public class BidNoGenerator {

    @Produces
    public String generateBidNumber() {
        return "BID-" + ThreadLocalRandom.current().nextInt(10000, 20000);
    }
}
