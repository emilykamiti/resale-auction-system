<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.resale.app.model.entity.Bid" %>
<%@ page import="com.resale.app.bean.BidBean" %>
<%@ page import="java.util.List" %>

<html>

<head>
    <title>Bid Table</title>
    <!-- Add your CSS styles if needed -->
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        .confirmation-button, .rejection-button {
            background-color: #4CAF50;
            color: white;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }

        .rejection-button {
            background-color: #f44336;
        }
    </style>
</head>

<body>
    <h2>Bid Table</h2>

    <% BidBean bidBean = (BidBean) session.getAttribute("bidBean"); %>

    <table>
        <tr>
            <th>Username</th>
            <th>Phone</th>
            <th>Bid Amount</th>
            <th>Item Name</th>
            <th>Action</th>
        </tr>
        <% if (bidBean != null) { %>
            <% for (Bid bid : bidBean.getAllBids()) { %>
                <tr>
                    <td><%= bid.getUserName() %></td>
                    <td><%= bid.getPhone() %></td>
                    <td><%= bid.getBidAmount() %></td>
                    <td><%= bid.getItemName() %></td>
                    <td>
                        <a href="./confirmbid?bidId=<%= bid.getId() %>" class="confirmation-button">Confirm</a>
                        <a href="./rejectbid?bidId=<%= bid.getId() %>" class="rejection-button">Reject</a>
                    </td>
                </tr>
            <% } %>
        <% } else { %>
            <tr>
                <td colspan="5">No bids available</td>
            </tr>
        <% } %>
    </table>
</body>

</html>
