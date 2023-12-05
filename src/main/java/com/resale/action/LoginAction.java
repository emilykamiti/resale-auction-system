package com.resale.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import com.resale.app.bean.AuthBean;
import com.resale.app.bean.AuthBeanI;
import com.resale.app.model.entity.User;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends BaseAction {

    AuthBeanI authBean = new AuthBean();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId"))) {
            resp.sendRedirect("./home");
        } else {
            resp.sendRedirect("./login.jsp");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User loginUser = serializeForm(User.class, req.getParameterMap());

        try {
            User userDetails = authBean.authenticate(loginUser);

            if (userDetails != null) {
            HttpSession httpSession = req.getSession(true);

            httpSession.setAttribute("loggedInId", new Date().getTime() + "");
            httpSession.setAttribute("username", loginUser.getUsername());

            resp.sendRedirect("./home");

            }

            PrintWriter print = resp.getWriter();
            print.write("<html><body>Invalid login details <a href=\".\"> Login again </a></body></html>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
