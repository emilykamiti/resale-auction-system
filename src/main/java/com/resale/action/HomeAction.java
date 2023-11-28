package com.resale.action;

import com.resale.app.bean.ItemBean;
import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;
import com.resale.app.view.helper.HtmlCards;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeAction extends BaseAction {

    private ItemBeanI itemBean = new ItemBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> itemList = itemBean.list(Item.class);
    
        String itemCards = HtmlCards.generateCards(itemList);
    
        String pageContent = itemCards;

        req.setAttribute("pageContent", pageContent);
        req.getRequestDispatcher("./app/index.jsp").forward(req, resp);
    }
    
  

}