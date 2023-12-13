package com.resale.action;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.AuthBeanI;

import java.io.IOException;

@WebServlet("/admin")
public class AdminAction extends BaseAction {
    @EJB
    private AuthBeanI authBean;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.getRequestDispatcher("./admin.jsp").forward(req, res);
    }

}