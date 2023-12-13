package com.resale.action;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.resale.app.bean.AuthBeanI;
import com.resale.app.model.entity.User;
import com.resale.app.model.entity.UserType;

import java.io.IOException;
import java.util.Date;

@WebServlet("/admin")
public class AdminAction extends BaseAction {

    @EJB

    private AuthBeanI authBean;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
                    req.getRequestDispatcher("./admin.jsp").forward(req, res);
                }
     
}