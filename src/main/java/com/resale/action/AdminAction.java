package com.resale.action;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminAction extends BaseAction {

    @EJB
    private ItemBeanI itemBean;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Item> items = itemBean.list(new Item());
        req.setAttribute("items", items);
        req.getRequestDispatcher("./admin.jsp").forward(req, res);
    }

}