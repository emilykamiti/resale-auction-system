package com.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession httpSession = httpRequest.getSession();

        String servletPath = httpRequest.getServletPath();
        System.out.println("servlet path: " + servletPath);
        System.out.println("context path: " + httpRequest.getContextPath());
        System.out.println("context URI: " + httpRequest.getRequestURI());

        if (httpSession.isNew()) {
            System.out.println("1.New Session");
            httpSession.invalidate();

            if (servletPath.equals("/login") || servletPath.equals("/login.html")) {
                System.out.println("2. Proceed to login...or index.html");
                filterChain.doFilter(servletRequest, servletResponse);

            } else {
                System.out.println("3. Proceed to login...or index.html");
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
                servletResponse.getWriter().flush();

            }

        } else {
           
            if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId"))) {
                 System.out.println("4. Proceed to login...or index.html");
                httpResponse.addHeader("AuthTime", DateFormat.getDateTimeInstance().format(new Date()));
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                System.out.println("5. Proceed to login...or index.html");
                httpResponse.sendRedirect(httpRequest.getContextPath() + "./login");
                servletResponse.getWriter().flush();

            }
        }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
