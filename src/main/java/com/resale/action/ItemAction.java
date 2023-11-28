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

import java.util.logging.Logger;

@WebServlet("/item")
public class ItemAction extends BaseAction {
    ItemBeanI itemBean = new ItemBean();
    private static final Logger LOGGER = Logger.getLogger(ItemAction.class.getName());

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./add-item.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("doPost method called");

        Item itemsUpdate = serializeForm(Item.class, req.getParameterMap());
        LOGGER.info("Form data serialized: " + itemsUpdate);

        try {
            itemBean.addItems(itemsUpdate);
            LOGGER.info("addItems method called");
        } catch (SQLException e) {
            LOGGER.severe("SQLException caught: " + e.getMessage());
            e.printStackTrace();
        }

        resp.sendRedirect("./home");
    }
}