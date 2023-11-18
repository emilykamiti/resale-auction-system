package com.resale.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.ItemBean;
import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;

@WebServlet("/items")
public class ItemAction extends BaseAction {

    private ItemBeanI itemBean = new ItemBean();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        itemBean.addOrUpdateAccount(serializeForm(Item.class, req.getParameterMap()));

        resp.sendRedirect("./items");
    }
}
