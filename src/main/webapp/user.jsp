<%@ page isELIgnored="false" %>
<%@ page import="com.resale.app.model.entity.UserType" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="contentBean" class="com.resale.app.userbean.ContentBean" scope="request" />
<jsp:useBean id="activeMenuBean" class="com.resale.app.userbean.ActiveMenuBean" scope="request" />
<jsp:useBean id="user" class="com.resale.app.model.entity.User" scope="session" />


<!DOCTYPE html>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/1211563ad5.js" crossorigin="anonymous"></script>


     <jsp:include page="./css/landingCss.jsp" />
     <jsp:include page="./css/adminCss.jsp" />

</head>
<body>

<div class="Content">
    <div class="ContentLinks">
        <span>Nata Travels</span>

        <h3 class="WelcomeUser">Hi, ${sessionScope.userName}</h3>

        <jsp:setProperty name="activeMenuBean" property="activeMenu" value='<%= request.getAttribute("activeMenu") %>' />

        <c:choose>
        <c:when test="${  sessionScope.userType eq UserType.ADMIN }">
            <a class="${  (activeMenuBean.getActiveMenu() == 0) ? "active" : "" }" href="./home">Home</a>
            <a href="./admin">Admin</a>
            <a href="./">Landing</a>
            <a href="./logout">Logout</a>
        </c:when>
        <c:otherwise>
            <a class="${  (activeMenuBean.getActiveMenu() == 0) ? "active" : "" }" href="./home">Home</a>
            <a class="${  (activeMenuBean.getActiveMenu() == 1) ? "active" : "" }" href="./track">track</a>
            <a class="${  (activeMenuBean.getActiveMenu() == 2) ? "active" : "" }" href="./bids">Bid</a>
            <a href="./">Site</a>
            <a href="./logout">Logout</a>
        </c:otherwise>
        </c:choose>     
        
    </div>
    <div class="ContentLinkContent">
        <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />
        <jsp:getProperty name="contentBean" property="content" />
    </div>
</div>

</body>
</html>