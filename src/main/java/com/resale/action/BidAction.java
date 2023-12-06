package com.resale.action;

import com.resale.app.model.entity.Bid;
import com.resale.app.model.entity.Item;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.ItemBeanI;
import com.resale.database.MysqlDatabase;
import java.util.UUID;

@WebServlet("/bidaction")
public class BidAction extends BaseAction {
    @EJB
    ItemBeanI itemBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long itemId = Long.parseLong(request.getParameter("itemId"));

        Item item = itemBean.fetchItem(Item.class, itemId);

        String trackId = UUID.randomUUID().toString();

        Bid newBid = new Bid();
        newBid.setItemId(itemId);
        newBid.setTrackID(trackId);
        newBid.setBidAmount(bidAmount);
        MysqlDatabase.insert(newBid);

        request.setAttribute("confirmationMessage", "Bid made successfully!");
        request.setAttribute("trackId", trackId);

        request.getRequestDispatcher("./home").forward(request, response);
    }
}
