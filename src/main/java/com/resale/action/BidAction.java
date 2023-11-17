package com.resale.action;

import com.resale.action.BaseAction;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.BidBean;
import com.resale.app.model.entity.Bid;

@WebServlet("/bidaction")
public class BidAction extends BaseAction {
    private BidBean bidBean = new BidBean();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    List<Bid> bids = bidBean.getAllBids(); 
    request.setAttribute("bids", bids);
    request.getRequestDispatcher("/biditem.jsp").forward(request, response);
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Bid newBid = new Bid(0, null, null, null, 0);

        serializeForm(newBid, request.getParameterMap());

        try {

            String trackID = UUID.randomUUID().toString();
            newBid.setTrackID(trackID);

            boolean isBidSubmitted = bidBean.submitBid(newBid);

            if (isBidSubmitted) {
                List<Bid> bids = bidBean.getAllBids();
                request.setAttribute("bids", bids);
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
