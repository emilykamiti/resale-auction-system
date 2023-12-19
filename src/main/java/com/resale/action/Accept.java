package com.resale.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/email/accept")
public class Accept extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        // Code to send the acceptance email goes here
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Acceptance email sent");
    }
}
