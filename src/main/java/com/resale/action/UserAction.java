package com.resale.action;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.UserBeanI;
import com.resale.app.model.entity.User;

@WebServlet("/register")
public class UserAction extends BaseAction {
    @EJB
    UserBeanI userBean;

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            userBean.register(serializeForm(User.class, req.getParameterMap()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        resp.sendRedirect("./login");

    }
}