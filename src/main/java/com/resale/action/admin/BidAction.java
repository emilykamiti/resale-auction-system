package com.resale.action.admin;

import com.resale.app.model.entity.Bid;
import com.resale.action.BaseAction;
import com.resale.app.bean.BidBeanI;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bids")
public class BidAction extends BaseAction {

    @EJB
    private BidBeanI bidBean;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
    
        String searchId = req.getParameter("itemId");
    
        if (searchId != null && !searchId.isEmpty()) {
            Long id = Long.parseLong(searchId);
            List<Bid> bids = bidBean.getBidByItemId(id);
    
            if (bids != null && !bids.isEmpty()) {
                req.setAttribute("bids", bids);
            } else {
                req.setAttribute("errorMessage", "No bids found for item with id " + searchId);
            }
        }
    
        setSearchForm(req);
        renderPage(req, resp, 4, Bid.class, bidBean.list(new Bid()));
    }
    

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        Long itemId = Long.parseLong(req.getParameter("itemId"));

        Bid bid = serializeForm(Bid.class, req.getParameterMap());

        bid = bidBean.addOrUpdateBid(bid, username, itemId);

        res.sendRedirect("./biditem.jsp?id=" + itemId);
    }
}