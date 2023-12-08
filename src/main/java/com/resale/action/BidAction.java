package com.resale.action;

import com.resale.app.model.entity.Bid;
import com.resale.app.model.entity.Item;
import com.resale.app.bean.BidBeanI;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bids")
public class BidAction extends BaseAction {

    @EJB
    private BidBeanI bidBean;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           renderPage(req, resp, 4, Bid.class, bidBean.list(new Bid()));

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Bid newBid = serializeForm(Bid.class, req.getParameterMap());
        newBid.setBidTime(LocalDateTime.now());
        bidBean.addOrUpdate(newBid);
        resp.sendRedirect("./biditem.jsp");

    }
}
