package com.resale.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.resale.app.bean.BidBean;
import com.resale.app.model.entity.Bid;

@WebServlet("/bidaction")
public class BidAction extends BaseAction {
    private BidBean bidBean = new BidBean();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/biditem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Bid newBid = new Bid(0, null, null, null, 0);
        serializeForm(newBid, request.getParameterMap());

        try {
            boolean isBidSubmitted = bidBean.submitBid(newBid);

            if (isBidSubmitted) {
                HttpSession session = request.getSession();
                session.setAttribute("bidBean", bidBean);

                request.setAttribute("confirmationMessage", "Bid made successfully!");
            } else {
                request.setAttribute("errorMessage", "Bid submission failed. Please try again.");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Invalid bid amount. Please enter a valid number.");
        }

        request.getRequestDispatcher("/biditem.jsp").forward(request, response);
    }
}