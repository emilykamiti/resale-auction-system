package com.resale.action;

import com.resale.app.bean.ItemBean;
import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;
import com.resale.app.view.helper.AppPage;
import com.resale.app.view.helper.HtmlCmpRender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/home")
public class HomeAction extends BaseAction {

    private ItemBeanI itemBean = new ItemBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addItemLink = "<br/><a href=\"" + req.getContextPath() + "/add-item.jsp\">Add Item</a>";

        renderPage(req, resp, 0, Item.class, new ArrayList<Item>());
    
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item newItem = new Item();

        String itemImage = req.getParameter("imageURL");
        newItem.setImageURL(itemImage);
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}