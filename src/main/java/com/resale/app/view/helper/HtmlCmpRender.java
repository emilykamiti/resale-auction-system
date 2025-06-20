package com.resale.app.view.helper;

import org.apache.commons.lang3.StringUtils;

import com.resale.app.model.entity.Bid;
import com.resale.app.model.entity.Item;
import com.resale.app.model.entity.User;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class HtmlCmpRender implements Serializable {

    public static String searchForm() {
        return "<style>" +
                ".search-form {" +
                "  margin-bottom: 20px;" +
                "}" +
                ".search-form input[type='text'] {" +
                "  padding: 5px;" +
                "  margin-right: 10px;" +
                "}" +
                ".search-form input[type='submit'] {" +
                "  padding: 5px 10px;" +
                "  background-color: #4CAF50;" +
                "  border: none;" +
                "  color: white;" +
                "  cursor: pointer;" +
                "}" +
                "</style>" +
                "<form class=\"search-form\" action=\"./bids\" method=\"get\">" +
                "<input type=\"text\" name=\"itemId\" placeholder=\"Enter item id\">" +
                "<input type=\"submit\" value=\"Search\">" +
                "</form>";
    }

    public static String table(List<?> dataList, Class<?> dataClass) {

        if (!dataClass.isAnnotationPresent(HtmlTable.class))
            return StringUtils.EMPTY;

        HtmlTable htmlTable = dataClass.getAnnotation(HtmlTable.class);

        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append(searchForm());

        if (dataClass.equals(Item.class)) {
            trBuilder.append("<a class=\"link-btn-add\" href=\"")
                    .append(htmlTable.addUrl()).append("\">Add</a><br/>");
        }

        trBuilder.append("<table><tr>");

        Field[] fields = dataClass.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(HtmlTableColHeader.class))
                continue;

            trBuilder.append("<th>")
                    .append(field.getAnnotation(HtmlTableColHeader.class).header())
                    .append("</th>");
        }
        if (dataClass.equals(Bid.class)) {
            trBuilder.append("<th>Action</th>");

        }

        trBuilder.append("</tr>");

        if (dataList != null && !dataList.isEmpty()) {

            for (Object data : dataList) {

                trBuilder.append("<tr>");
                for (Field field : fields) {
                    if (!field.isAnnotationPresent(HtmlTableColHeader.class))
                        continue;

                    try {
                        field.setAccessible(true);
                        HtmlTableColHeader colHeader = field.getAnnotation(HtmlTableColHeader.class);

                        Object colData;
                        if (StringUtils.isNotBlank(colHeader.dateFormat()))
                            colData = new SimpleDateFormat(colHeader.dateFormat())
                                    .format(Optional.ofNullable((Date) field.get(data)).orElse(new Date()));
                        else if (StringUtils.isNotBlank(colHeader.numberFormat()))
                            colData = new DecimalFormat(colHeader.numberFormat())
                                    .format(Optional.ofNullable(field.get(data)).orElse(BigDecimal.ZERO));
                        else
                            colData = field.get(data);

                        trBuilder.append("<td>")
                                .append(Optional.ofNullable(colData).orElse(""))
                                .append("</td>");

                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);

                    }
                }

                if (data instanceof Bid) {
                    Bid bid = (Bid) data;
                    User bidUser = bid.getUser();
                    if (bidUser != null) {
                        trBuilder.append("<td>")
                                .append("<button class=\"btn-accept\" onclick=\"sendAcceptEmail('"
                                        + bidUser.getEmail() + "')\">Accept</button>")
                                .append("</td>");
                    } else {
                        trBuilder.append("");
                    }
                }
                trBuilder.append("</tr>");
            }
        }

        trBuilder.append("</table>");
        trBuilder.append("<script>");
        trBuilder.append("function sendAcceptEmail(email) {");
        trBuilder.append("console.log('sendAcceptEmail called with email:', email);");
        trBuilder.append("fetch('./email/accept', {");
        trBuilder.append("method: 'POST',");
        trBuilder.append("headers: { 'Content-Type': 'application/json' },");
        trBuilder.append("body: JSON.stringify({ email: email })");
        trBuilder.append("})");
        trBuilder.append(".then(response => response.json())");
        trBuilder.append(".then(data => console.log(data))");
        trBuilder.append(".catch((error) => console.error('Error:', error));");
        trBuilder.append("}");

        trBuilder.append("function sendRejectEmail(email) {");
        trBuilder.append("console.log('sendRejectEmail called with email:', email);");
        trBuilder.append("fetch('./email/reject', {");
        trBuilder.append("method: 'POST',");
        trBuilder.append("headers: { 'Content-Type': 'application/json' },");
        trBuilder.append("body: JSON.stringify({ email: email })");
        trBuilder.append("})");
        trBuilder.append(".then(response => response.json())");
        trBuilder.append(".then(data => console.log(data))");
        trBuilder.append(".catch((error) => console.error('Error:', error));");
        trBuilder.append("}");
        trBuilder.append("</script>");

        return trBuilder.toString();
    }

    public static String form(Class<?> model) {

        HtmlForm htmlFormMarker = null;
        if (model.isAnnotationPresent(HtmlForm.class))
            htmlFormMarker = model.getAnnotation(HtmlForm.class);

        if (htmlFormMarker == null)
            return StringUtils.EMPTY;

        StringBuilder htmlForm = new StringBuilder("<br/><h3>Add " + htmlFormMarker.label() + "</h3><br/>" +
                "<form action=\"" + htmlFormMarker.url() + "\" method=\"" + htmlFormMarker.httpMethod() + "\">" +
                "<div class=\"container\">");

        Field[] fields = model.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(HtmlFormField.class))
                continue;

            HtmlFormField formField = field.getAnnotation(HtmlFormField.class);

            String fieldName = field.getName();

            htmlForm
                    .append("<label for=\"").append(ifBlank(formField.labelFor(), fieldName)).append("\">")
                    .append(ifBlank(formField.label(), fieldName))
                    .append(formField.required() ? "<span style=\"color:red;\">*</span> " : "")
                    .append(":</label><br>");

            if (field.getType().isEnum()) {
                htmlForm.append("<select")
                        .append(" id=\"").append(ifBlank(formField.id(), fieldName))
                        .append("\" name=\"").append(ifBlank(formField.name(), fieldName)).append("\" ")
                        .append(formField.required() ? "required" : "")
                        .append(">");

                for (Object enumValue : field.getType().getEnumConstants()) {

                    try {
                        Method method = field.getType().getMethod("getName");
                        htmlForm.append("htmlForm.append(<option value=\"")
                                .append(enumValue).append("\">")
                                .append(method.invoke(enumValue)).append("</option>)");
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }

                htmlForm.append("</select>");

            } else {
                htmlForm.append("<input type=\"")
                        .append(formField.type())
                        .append("\" id=\"").append(ifBlank(formField.id(), fieldName))
                        .append("\" name=\"").append(ifBlank(formField.name(), fieldName)).append("\" ")
                        .append(formField.required() ? "required" : "")
                        .append("><br>");
            }

        }

        htmlForm.append("<button type=\"submit\">Submit</button>");
        htmlForm.append("</div>" + "</form>" + "<br/>");

        return htmlForm.toString();

    }

    private static String ifBlank(String target, String alternative) {
        return StringUtils.isBlank(target) ? alternative : StringUtils.trimToEmpty(target);
    }

}
