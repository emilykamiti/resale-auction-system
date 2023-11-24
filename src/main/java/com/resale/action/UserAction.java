package com.resale.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.UserBean;
import com.resale.app.bean.UserBeanI;
import com.resale.app.model.entity.User;


    @WebServlet("/user")
public class UserAction extends BaseAction {
    UserBeanI userBean = new UserBean();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User registerUser = serializeForm(User.class, req.getParameterMap());
        try {
            userBean.register(registerUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("./login");
    }
}
