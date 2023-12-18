package com.resale.app.api.rest;

import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Bid;
import com.resale.app.model.entity.Item;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/item")
public class ItemRestApi extends BaseRestApi {

    @EJB
    private ItemBeanI itemBean;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Item item) {
        itemBean.addOrUpdate(item);
        return respond();
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(itemBean.list(new Item()));
    }

    @RolesAllowed("LOGGED_IN")
    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        itemBean.delete(Item.class, id);
        return respond();
    }

}
