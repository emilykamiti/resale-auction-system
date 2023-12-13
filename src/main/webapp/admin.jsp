<%@ page isELIgnored="false" %>
    <jsp:useBean id="contentBean" class="com.resale.app.userbean.ContentBean" scope="request" />
    <jsp:useBean id="activeMenuBean" class="com.resale.app.userbean.ActiveMenuBean" scope="request" />

    <!DOCTYPE html>
    <html>

    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/1211563ad5.js" crossorigin="anonymous"></script>

        <jsp:include page="./css/adminCss.jsp" />
    </head>

    <body>

        <div class="Content">
            <div class="ContentLinks">
                <span>Resale auction</span>

                <jsp:setProperty name="activeMenuBean" property="activeMenu" value="${requestScope.activeMenu}" />
                   


                <jsp:setProperty name="activeMenuBean" property="activeMenu"
                value="${requestScope.activeMenu}" />


              
                    <a class="${ (activeMenuBean.getActiveMenu() == 1) ? " active" : "" }" href="./home">Home</a>
                    <a class="${ (activeMenuBean.getActiveMenu() == 1) ? " active" : "" }" href="./bids">Bids</a>
                    <a class="${ (activeMenuBean.getActiveMenu() == 2) ? " active" : "" }" href="./item">Add Items</a>
                    <a class="${ (activeMenuBean.getActiveMenu() == 3) ? " active" : "" }"
                    <a href="./logout">Logout</a>

            </div>
            <div class="ContentLinkContent">

                ${requestScope.statContent}

                <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />
                <jsp:getProperty name="contentBean" property="content" />
            </div>
    </body>

    </html>