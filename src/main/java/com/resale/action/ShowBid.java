
package com.resale.action;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.BidBeanI;
import com.resale.app.model.entity.Bid;

@WebServlet("/showbids")

public class ShowBid extends BaseAction {

    @EJB
    private BidBeanI bidBean;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        renderPage(req, resp, 8, Bid.class, bidBean.list(new Bid()));

    }

}
