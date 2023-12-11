package com.resale.app.utility;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
 @CustomerTrackId
public class TrackNoGenerator {

    @Produces
   
    public String generateCustomerTrackId() {
        return "CTID-" + ThreadLocalRandom.current().nextInt(1000, 10000);
    }
}
