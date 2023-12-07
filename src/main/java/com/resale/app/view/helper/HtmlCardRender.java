package com.resale.app.view.helper;

import java.lang.reflect.Field;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class HtmlCardRender {
    public static String generateCards(List<?> models) {
        if (models == null || models.isEmpty()) {
            return StringUtils.EMPTY;
        }

        StringBuilder cardBuilder = new StringBuilder();

        cardBuilder.append("<div class=\"card-container\">");

        cardBuilder.append("<script>");
        cardBuilder.append("function redirectToBidForm(itemId) {");
        cardBuilder.append("  window.location.href = 'biditem.jsp?id=' + itemId;");
        cardBuilder.append("}");
        cardBuilder.append("</script>");

        for (Object model : models) {
            Field[] fields = model.getClass().getDeclaredFields();

            cardBuilder.append("<div class=\"card\">");

            for (Field field : fields) {
                if (!field.isAnnotationPresent(HtmlCards.class)) {
                    continue;
                }

                HtmlCards annotation = field.getAnnotation(HtmlCards.class);
                try {
                    field.setAccessible(true);
                    if (annotation.label().equals("image")) {
                        cardBuilder.append("<img class=\"card-image\" src='" + field.get(model) + "' alt='item image'>");
                    } else {
                        cardBuilder.append("<h3 class=\"card-title\">").append(annotation.label())
                                .append(field.get(model)).append("</h3>");
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            cardBuilder.append("<div class=\"card-buttons\">");
            cardBuilder.append("<button class=\"bid-button\" onclick=\"redirectToBidForm('")
                    .append(getFieldValue("id", model)).append("')\">Bid</button>");
            cardBuilder.append("</div>");

            cardBuilder.append("</div>");
        }

        cardBuilder.append("</div>");

        cardBuilder.append("<style>");
        cardBuilder.append(".card-container { display: flex; flex-wrap: wrap; justify-content: space-around; }");
        cardBuilder.append(
                ".card { border-radius: 5px; margin-top: 20px; text-align: center; background: #C2D7EB; box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5); transition: all 0.3s; display: inline-block; transform-origin: center; width: 250px; padding: 15px; }");
        cardBuilder.append(".card:hover { box-shadow: 8px 8px 12px rgba(0, 0, 0, 0.7); transform: scale(1.1); }");
        cardBuilder.append(".card-image { height: 250px; width: 250px; }");
        cardBuilder.append(".card-buttons { margin-top: 10px; }");
        cardBuilder.append(
                ".bid-button { padding: 5px 10px; background-color: #4CAF50; color: white; border: none; border-radius: 3px; cursor: pointer; }");
        cardBuilder.append("</style>");

        return cardBuilder.toString();
    }

    private static String getFieldValue(String fieldName, Object model) {
        Class<?> currentClass = model.getClass();

        while (currentClass != null) {
            try {
                java.lang.reflect.Method method = currentClass.getDeclaredMethod("get" + StringUtils.capitalize(fieldName));
                Object value = method.invoke(model);
                return value != null ? value.toString() : "";
            } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
                currentClass = currentClass.getSuperclass();
            }
        }
        return "";
    }
}
