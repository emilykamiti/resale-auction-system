
package com.resale.app.view.html;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.resale.app.view.css.AppCss;
import com.resale.app.view.navigationbar.TopNavigationBar;


public class AppPage implements Serializable {

    public void renderHtml(HttpServletRequest req, HttpServletResponse resp,
       int activeMenu, String content) throws IOException {

        HttpSession session = req.getSession();

        ServletContext ctx = req.getServletContext();

        PrintWriter print = resp.getWriter();

        print.write("<!DOCTYPE html>" +
            "<html>" +

            "<head>" +
            " <meta charset='UTF-8'>\n" +
            "    <title>Items Page</title>\n" +
            "    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>\n" +
            "    <script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>\n" +
            "    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css'>\n" +
                new AppCss().getStyle() +
            "</head>" +

            "<body>" +
            

            new TopNavigationBar().menu(activeMenu) + "<h3>" +
            "</h3><br/>");

        print.write(content);
        print.write("<a href=\"./logout\">Logout</a> | <a href=\"./useraction\">Register</a>"+

            "</body>" +
            "</html>");


    }

    public void renderHtml(HttpServletRequest req, HttpServletResponse resp, int i, String string, String string2) {
    }
}