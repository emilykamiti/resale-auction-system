package com.resale.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.StringUtils;

import com.resale.app.utility.EnumConverter;

import com.resale.app.view.helper.HtmlCmpRender;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BaseAction extends HttpServlet {

    @SuppressWarnings("unchecked")
    public <T> T serializeFormBk(Class<?> clazz, Map<String, String[]> requestMap) {

        T clazzInstance;

        try {
            clazzInstance = (T) clazz.getDeclaredConstructor().newInstance();

            DateConverter converter = new DateConverter(null);
            converter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(converter, Date.class);
            ConvertUtils.register(new EnumConverter(), Date.class);

            BeanUtils.populate(clazzInstance, requestMap);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException
                | InstantiationException e) {
            throw new RuntimeException(e);
        }

        return clazzInstance;
    }

    @SuppressWarnings("unchecked")
    public <T> T serializeForm(Class<?> clazz, Map<String, String[]> requestMap) {

        T clazzInstance;

        try {
            clazzInstance = (T) clazz.getDeclaredConstructor().newInstance();

            BeanUtilsBean beanUtilsBean = new BeanUtilsBean(new ConvertUtilsBean() {
                @Override
                public Object convert(String value, Class clazz) {
                    if (clazz.isEnum()) {
                        return Enum.valueOf(clazz, value);
                    } else {
                        return super.convert(value, clazz);
                    }
                }
            });

            ConvertUtils.register(new BigDecimalConverter(), BigDecimal.class);

            DateConverter converter = new DateConverter(null);
            converter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(converter, Date.class);

            beanUtilsBean.populate(clazzInstance, requestMap);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException
                | InstantiationException e) {
            throw new RuntimeException(e);
        }

        return clazzInstance;
    }

    public void renderPage(HttpServletRequest request, HttpServletResponse response, int activeMenu, Class<?> entity,
    List<?> entityList)
    throws ServletException, IOException {

request.setAttribute("activeMenu", activeMenu);

if (StringUtils.trimToEmpty(request.getParameter("action")).equals("add"))
    request.setAttribute("content", HtmlCmpRender.form(entity));
else {
    // Check if there's a sorted list in the request attributes
    List<?> sortedList = (List<?>) request.getAttribute("bids");

    if (sortedList != null && !sortedList.isEmpty()) {
        // Render the sorted bid table
        request.setAttribute("content", HtmlCmpRender.table(sortedList, entity));
    } else {
        // Render the regular table if no sorted list is present
        request.setAttribute("content", HtmlCmpRender.table(entityList, entity));
    }
}

RequestDispatcher dispatcher = request.getRequestDispatcher("./app/index.jsp");
dispatcher.forward(request, response);
}


    public void renderAdmin(HttpServletRequest req, HttpServletResponse res, int activeMenu, Class<?> entity,
            List<?> entityList) throws ServletException, IOException {
        if (StringUtils.trimToEmpty(req.getParameter("action")).equals("add"))
            req.setAttribute("content", HtmlCmpRender.form(entity));
        else
            req.setAttribute("content", HtmlCmpRender.table(entityList, entity));

        RequestDispatcher dispatcher = req.getRequestDispatcher("./app/adminPage.jsp");
        dispatcher.forward(req, res);

    }

    public void renderCard(HttpServletRequest request, HttpServletResponse response, int activeMenu, String content)
            throws ServletException, IOException {

        request.setAttribute("activeMenu", activeMenu);
        request.setAttribute("content", content);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./app/index.jsp");
        dispatcher.forward(request, response);
    }

    public void setSearchForm(HttpServletRequest request) {
        String searchForm = "<form action=\"/search\" method=\"get\">" +
                "<input type=\"text\" name=\"itemId\" placeholder=\"Enter item id\">" +
                "<input type=\"submit\" value=\"Search\">" +
                "</form>";
        request.setAttribute("searchForm", searchForm);
    }

}
