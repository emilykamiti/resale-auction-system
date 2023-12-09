package com.resale.app.utility;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class TrackNoGenerator {

    @Produces
    @CustomerTrackId
    String generateCustomerTrackId() {
        // Generate a unique track ID for customers
        // You can use any logic here to generate a unique ID
        return "CTID-" + ThreadLocalRandom.current().nextInt(1000, 10000);
    }
}
