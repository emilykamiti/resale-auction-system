// package com.resale.action;

// import com.resale.app.model.entity.Item;

// import java.io.IOException;
// import java.util.List;

// import javax.ejb.EJB;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import com.resale.app.bean.ItemBeanI;

// @WebServlet("/type")
// public class TypeAction extends BaseAction {
// @EJB
// ItemBeanI itemBean;

// protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
// ServletException, IOException {
// List<Item> items = itemBean.list(Item.class);
// String itemCards = Type.showType(items);
// renderPage(req, resp, 3, itemCards);
// }

// }
