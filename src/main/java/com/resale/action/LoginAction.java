package com.resale.action;

import org.apache.commons.lang3.StringUtils;
import com.resale.app.bean.AuthBeanI;
import com.resale.app.model.entity.User;
import com.resale.app.model.entity.UserType;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends BaseAction {

    @EJB
    AuthBeanI authBean;

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

            if (userDetails != null && StringUtils.isNotBlank(userDetails.getUsername())) {
                HttpSession httpSession = req.getSession(true);

                httpSession.setAttribute("loggedInId", new Date().getTime() + "");
                httpSession.setAttribute("username", userDetails.getUsername());
                httpSession.setAttribute("userType", userDetails.getUserType());
                httpSession.setAttribute("userId", userDetails.getId());
                httpSession.setAttribute("email", userDetails.getEmail());

                if (userDetails.getUserType() == UserType.ADMIN) {
                    resp.sendRedirect("./admin");
                } else {
                    resp.sendRedirect("./home");
                }
            } else {
                resp.sendRedirect("./login.jsp");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendRedirect("./login.jsp");
        }
    }
}
