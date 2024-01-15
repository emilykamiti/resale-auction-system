package com.resale.action.admin;

import com.resale.app.model.entity.Bid;
import com.resale.action.BaseAction;
import com.resale.app.bean.BidBeanI;

import java.io.IOException;

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