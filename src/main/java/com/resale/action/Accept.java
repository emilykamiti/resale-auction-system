package com.resale.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.resale.app.model.entity.Bid;
import com.resale.app.model.entity.Email;
import com.resale.app.bean.EmailBean;

@WebServlet("/email/accept")
public class Accept extends HttpServlet {

    private EmailBean emailBean;

    private Bid bid;

    public void setEmailBean(EmailBean emailBean) {
        this.emailBean = emailBean;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String recipientEmail = request.getParameter("email");

        Email email = new Email();
        email.setSenderEmail("emilykamiti@gmail.com");
        email.recipientEmail = bid.getUser().getEmail();
        email.setSubject("Bid Acceptance");
        email.setBody("Congratulations! Your bid has been accepted.");

        String jsonEmail = new Gson().toJson(email);

        response.setContentType("application/json");

        try {
            emailBean.sendEmail(email, jsonEmail);
            System.out.println("{\"status\":\"success\", \"message\":\"Acceptance email sent\"}");
        } catch (MessagingException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.out.println("{\"status\":\"error\", \"message\":\"Failed to send acceptance email\"}");
        }
    }
}
