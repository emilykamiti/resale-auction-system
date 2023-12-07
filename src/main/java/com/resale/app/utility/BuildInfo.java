package com.resale.app.utility;



import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class BuildInfo {

    @Produces
    double buildNumber = 4.7;

}
