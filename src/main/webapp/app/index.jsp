<%@ page isELIgnored="false" %>
<%@ page import="com.resale.app.view.helper.HtmlMenuToolbar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="../style/style.jsp">
        <jsp:param name="pageColor" value="red" />
    </jsp:include>
</head>

<body>
    <jsp:useBean id="htmlMenuToolBar" class="com.resale.app.view.helper.HtmlMenuToolbar" />
    <jsp:setProperty name="htmlMenuToolBar" property="activeLink" value='${requestScope.activeMenu}' />
    ${htmlMenuToolBar.menu}

    <h3> ${initParam.AppName} | User: ${sessionScope.username} </h3><br/>

    <!-- Display content -->
    ${requestScope.content}
</body>

</html>
