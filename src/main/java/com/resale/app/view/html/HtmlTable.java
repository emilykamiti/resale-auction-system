package com.resale.app.view.html;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public class HtmlTable implements Serializable {

    public static String table(List<? extends Object> models) {
        if (models == null || models.isEmpty())
            return StringUtils.EMPTY;

        Field[] fields = models.get(0).getClass().getDeclaredFields();

        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<table><tr>");

        for (Field field : fields) {
            if (!field.isAnnotationPresent(ResaleTableColHeader.class))
                continue;

            ResaleTableColHeader colHeader = field.getAnnotation(ResaleTableColHeader.class);
            trBuilder.append("<th>").append(colHeader.header()).append("</th>");
        }
        trBuilder.append("<th>Bid</th>");
        trBuilder.append("</tr>");

        for (Object model : models) {
            trBuilder.append("<tr>");

            for (Field field : fields) {
                if (!field.isAnnotationPresent(ResaleTableColHeader.class))
                    continue;

                try {
                    field.setAccessible(true);
                    if (field.getName().equalsIgnoreCase("imageURL")) {
                        trBuilder.append("<td class='item-image'><img src='").append(field.get(model))
                                .append("' alt='Item Image'></td>");
                    } else {

                        trBuilder.append("<td>").append(field.get(model)).append("</td>");
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            trBuilder.append("<td><a href='./bidaction'>Bid</a></td>");

            trBuilder.append("</tr>");
        }

        trBuilder.append("</table>");
        return trBuilder.toString();
    }

    public static String form(Class<?> model) {
        ResaleHtmlForm resaleHtmlForm = null;
        if (model.isAnnotationPresent(ResaleHtmlForm.class))
            resaleHtmlForm = model.getAnnotation(ResaleHtmlForm.class);

        if (resaleHtmlForm == null)
            return StringUtils.EMPTY;

        String htmlForm = "<h2>" + resaleHtmlForm.label() + "</h2>" +
                "<br/>Add " + resaleHtmlForm.label() + "<br/><form action=\"" + resaleHtmlForm.url()
                + "\" method=\"" + resaleHtmlForm.httpMethod() + "\">";

        Field[] fields = model.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(ResaleHtmlFormField.class))
                continue;

            ResaleHtmlFormField formField = field.getAnnotation(ResaleHtmlFormField.class);

            String fieldName = field.getName();

            htmlForm += "<label for=\""
                    + (StringUtils.isBlank(formField.labelFor()) ? fieldName : formField.labelFor())
                    + "\">"
                    + (StringUtils.isBlank(formField.label()) ? fieldName : formField.label()) + ":</label><br>";
            htmlForm += "<input type=\"text\" id=\""
                    + (StringUtils.isBlank(formField.id()) ? fieldName : formField.id()) + "\" name=\""
                    + (StringUtils.isBlank(formField.name()) ? fieldName : formField.name()) + "\" ><br>";
        }

        htmlForm += "<input type=\"submit\" value=\"Submit\">";
        htmlForm += "</form><br/>";

        return htmlForm;
    }
}
