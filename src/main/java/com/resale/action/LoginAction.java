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
            resp.sendRedirect("./login.html");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginUser = new User();
        serializeForm(loginUser, req.getParameterMap());

        User userDetails = authBean.authenticate(loginUser);

        if (userDetails != null) {
            HttpSession httpSession = req.getSession(true);

            httpSession.setAttribute("loggedInId", String.valueOf(new Date().getTime()));
            httpSession.setAttribute("username", loginUser.getUsername());

            resp.sendRedirect("./home");
            return;
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html><body>Invalid login details <a href=\".\"> Login again </a></body></html>");
    }
}
