
<%@ page isELIgnored="false" %>
    <jsp:useBean id="navbar" class="com.resale.app.model.entity.view.NavBar" scope="request" />
    <jsp:useBean id="contentBean" class="com.resale.app.userbean.ContentBean" scope="request" />
    <!DOCTYPE html>
    <html>

    <head>

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/1211563ad5.js" crossorigin="anonymous"></script>


        <jsp:include page="./css/landingCss.jsp" />
    </head>

    <body>
        <div class="NavbarContent">
            <jsp:setProperty name="navbar" property="activeLink" value='${requestScope.activeMenu}' />
            <jsp:setProperty name="navbar" property="userType" value='${sessionScope.userType}' />
            <jsp:getProperty name="navbar" property="menu" />

        </div>
        <div class="Content">
            <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />
            <jsp:getProperty name="contentBean" property="content" />
        </div>

        <div class="container">
            <h1 class="heading">Sales Auctioneers</h1>
            <p class="paragraph">Own Your Price!</p>
            <p class="paragraph">You're just one bid away!</p>
            <a href="./home" class="button">Click to proceed</a>
        </div>

    </body>

    </html>