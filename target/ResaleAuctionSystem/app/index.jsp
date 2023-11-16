<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.resale.app.view.css.AppCss" %>
<%@ page import="com.resale.app.view.navigationbar.TopNavigationBar" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset='UTF-8'>
    <title>Items Page</title>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>
    <script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css'>
    <%= new AppCss().getStyle() %>
</head>

<body>
    <%= new TopNavigationBar().menu(activeMenu) %>
    <h3></h3><br/>

    <%= content %>

    <a href="<%= request.getContextPath() %>/logout">Logout</a> | <a href="<%= request.getContextPath() %>/register">Register</a>
</body>

</html>
