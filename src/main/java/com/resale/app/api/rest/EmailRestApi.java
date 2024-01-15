package com.resale.app.api.rest;

import javax.mail.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.resale.app.bean.EmailBean;
import com.resale.app.model.entity.Email;

import javax.ejb.EJB;

@Path("/emails")
public class EmailRestApi {

    @EJB
    private EmailBean emailBean;

    @POST
    @Path("/send")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendEmail(Email email) {
        try {
            emailBean.sendEmail(email, null);
            return Response.ok("Email sent successfully").build();
        } catch (MessagingException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to send email: " + e.getMessage()).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Unexpected error: " + ex.getMessage()).build();
        }
    }
}
