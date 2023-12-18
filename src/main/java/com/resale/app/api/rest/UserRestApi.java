package com.resale.app.api.rest;

import com.resale.app.bean.UserBeanI;
import com.resale.app.model.entity.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class UserRestApi extends BaseRestApi {

    @EJB
    private UserBeanI userBean;

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(userBean.list(new User()));
    }
}
