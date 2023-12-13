package com.resale.app.rest.api;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.resale.app.bean.BidBeanI;
import com.resale.app.model.entity.Bid;

@Path("/bids")
public class BidRestApi extends BaseRestApi{

    @EJB
    private BidBeanI bidBean;
    
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(bidBean.list(new Bid()));
    }
}
