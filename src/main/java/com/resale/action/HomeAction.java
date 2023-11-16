package com.resale.action;

import com.resale.app.view.html.AppPage;
import com.resale.app.view.html.HtmlTable;
import com.resale.app.bean.ItemBean;
import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/home")
public class HomeAction extends BaseAction {

    private ItemBeanI itemBean = new ItemBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        new AppPage().renderHtml(req, resp, 0,
                HtmlTable.form(Item.class) + itemBean.showItems());

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item newItem = new Item();
        serializeForm(newItem, req.getParameterMap());

        String itemImage = req.getParameter("imageURL");
        newItem.setImageURL(itemImage);

        itemBean.addOrUpdateItem(newItem);

        resp.sendRedirect(req.getContextPath() + "/home");
    }
}