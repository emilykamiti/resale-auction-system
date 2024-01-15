package com.resale.action.admin;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.action.BaseAction;
import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;

@WebServlet("/item")
public class ItemAction extends BaseAction {

    @EJB
    private ItemBeanI itemBean;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        renderPage(req, resp, 4, Item.class, itemBean.list(new Item()));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        itemBean.addOrUpdate(serializeForm(Item.class, req.getParameterMap()));

        resp.sendRedirect("./home");
    }
}