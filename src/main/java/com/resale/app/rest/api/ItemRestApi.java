package com.resale.app.rest.api;


import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers")
public class ItemRestApi  extends BaseRestApi{

    @EJB
    private ItemBeanI itemBean;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Item item){
        itemBean.addOrUpdate(item);
        return respond();
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(itemBean.list(new Item()));
    }
}
