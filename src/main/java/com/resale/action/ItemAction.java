package com.resale.action;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;

@WebServlet("/item")
public class ItemAction extends BaseAction {
    
    @EJB
    private ItemBeanI itemBean;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           System.out.print("add item.................form");
        req.getRequestDispatcher("./add-item.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    itemBean.addOrUpdate(serializeForm(Item.class, req.getParameterMap()));

        resp.sendRedirect("./home");
    }
}