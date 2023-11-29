package com.resale.action;

import com.resale.app.bean.ItemBean;
import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;
import com.resale.app.view.helper.HtmlCards;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeAction extends BaseAction {

    @EJB
    ItemBeanI itemBean;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        List<Item> items = itemBean.list(Item.class);
        for (Item item : items) {
            System.out.println(item.getId());
            System.out.println(item.getitemName());
        }
                String commodity = HtmlCards.generateCards(items);
        
                renderPage(req, resp, 3, commodity);
        
            }
        }