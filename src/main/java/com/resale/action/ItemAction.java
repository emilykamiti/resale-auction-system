package com.resale.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.ItemBean;
import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;

@WebServlet("/item")
public class ItemAction extends BaseAction {
    ItemBeanI itemBean = new ItemBean();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./add-item.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Item itemsUpdate = serializeForm(Item.class, req.getParameterMap());
        try {
            itemBean.addItems(itemsUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("./home");
    }
}