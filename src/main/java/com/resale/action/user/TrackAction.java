package com.resale.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/track")
public class TrackAction extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId = req.getParameter("trackId");

        if (trackId != null && !trackId.isEmpty()) {
            String message = "Tracking for product with ID: " + trackId;
            req.setAttribute("trackingMessage", message);
        } else {
            req.setAttribute("errorMessage", "Track ID is required.");
        }

        req.getRequestDispatcher("/track.jsp").forward(req, resp);
    }
}
