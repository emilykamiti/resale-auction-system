package com.resale.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.view.helper.AppPage;

@WebServlet("/payment")
public class PaymentAction extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new AppPage().renderHtml(req, resp, 1,
                "<h2>payments </h2> pay for product here /register will go here");

    }
}