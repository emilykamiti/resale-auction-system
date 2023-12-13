package com.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession httpSession = httpRequest.getSession();

        String servletPath = httpRequest.getServletPath();

        if (servletPath.equals("/login") || servletPath.equals("/login.jsp")) {
            if (StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId")))) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
                servletResponse.getWriter().flush();
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            if (servletPath.equals("/landing") || servletPath.equals("/") || servletPath.equals("/home")
                    || servletPath.equals("/register") || servletPath.equals("/register.jsp")) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else if (httpSession.isNew()) {
                httpSession.invalidate();
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            } else if (StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId")))) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
                servletResponse.getWriter().flush();
            }

        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}