<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Display Bids</title>
</head>
<body>
    <h1>List of Bids</h1>
    <c:if test="${not empty bids}">
        <table border="1">
            <tr>
                <th>Bid ID</th>
                <th>Item ID</th>
                <th>User ID</th>
                <th>Bid Amount</th>
                <!-- Add other necessary headers -->
            </tr>
            <c:forEach items="${bids}" var="bid">
                <tr>
                    <td>${bid.id}</td>
                    <td>${bid.itemId}</td>
                    <td>${bid.userId}</td>
                    <td>${bid.bidAmount}</td>
                    <!-- Add other necessary fields -->
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty bids}">
        <p>No bids available.</p>
    </c:if>
</body>
</html>
