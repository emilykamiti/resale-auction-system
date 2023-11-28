package com.resale.action;

import com.resale.app.model.entity.Item;
import com.resale.app.view.helper.Type;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.ItemBean;
import com.resale.app.bean.ItemBeanI;

@WebServlet("/type")
public class TypeAction extends BaseAction {
    ItemBeanI itemBean = new ItemBean();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = itemBean.list(Item.class);
        String productItems = Type.showType(items); 
        renderPage(req, resp, 3, productItems);
    }

    private void renderPage(HttpServletRequest req, HttpServletResponse resp, int i, String productItems) {
    }
}
