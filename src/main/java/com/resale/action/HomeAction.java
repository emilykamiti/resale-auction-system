package com.resale.action;

import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;
import com.resale.app.view.helper.HtmlCardRender;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeAction extends BaseAction {

    @EJB
    ItemBeanI itemBean;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        renderCard(req, resp, 2, HtmlCardRender.generateCards( itemBean.list(new Item())));
    }
}