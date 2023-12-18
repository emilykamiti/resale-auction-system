package com.resale.app.api.rest;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.resale.app.bean.BidBeanI;
import com.resale.app.model.entity.Bid;
import com.resale.app.model.entity.Item;

@Path("/bids")
public class BidRestApi extends BaseRestApi {

    @EJB
    private BidBeanI bidBean;

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(bidBean.list(new Bid()));
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Bid bid) {
        bidBean.addOrUpdate(bid);
        return respond();
    }

    @RolesAllowed("LOGGED_IN")
    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        bidBean.delete(Bid.class, id);
        return respond();
    }
}
