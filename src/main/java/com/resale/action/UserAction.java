package com.resale.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.UserBean;
import com.resale.app.bean.UserBeanI;
import com.resale.app.model.entity.User;

@WebServlet("/useraction")
public class UserAction extends BaseAction {
    UserBeanI userBean = new UserBean();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User registerUser = new User();
        userBean.register(registerUser);

        resp.sendRedirect("./login");
    }
}
