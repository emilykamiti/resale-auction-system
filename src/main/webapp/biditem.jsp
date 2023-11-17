<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.resale.app.model.entity.Bid" %>

<%
    String confirmationMessage = (String) request.getAttribute("confirmationMessage");
    List<Bid> bids = (List<Bid>) request.getAttribute("bids"); // Retrieve 'bids' attribute from request
%>

<!DOCTYPE html>
<html>
<head>
    <title>Bid Page</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 40%;
        }

        .form-title {
            font-family: 'Times New Roman', serif;
            font-size: 24px;
            font-weight: bold;
            color: #000000;
            text-transform: uppercase;
            text-align: center;
            margin: 20px 0;
        }

        form {
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            font-weight: bold;
            color: #000000;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            box-sizing: border-box;
        }

        button {
            background-color: #1E90FF; /* Blue color for the button */
            color: white;
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0066CC; /* Darker blue on hover */
        }

        .confirmation-message-container {
            background-color: #4c82af;
            color: #ffffff;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        .confirmation-message {
            font-size: 16px;
            font-weight: bold;
        }

        .track-id {
            margin-bottom: 5px;
            border-bottom: 1px solid #ccc;
            padding-bottom: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="form-title">MAKE BID</h2>

        <form action="./bidaction" method="post">
            <label for="name">Username:</label>
            <input type="text" id="name" name="name" required><br>
    
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required><br>
    
            <label for="bid_amount">Amount to bid:</label>
            <input type="number" id="bid_amount" name="bid_amount" required><br>
    
            <label for="itemName">Item Name:</label>
            <input type="text" id="itemName" name="itemName" required><br>
    
            <input type="hidden" name="product" value="123">
            <input type="hidden" name="price" value="50.0">
    
            <button type="submit" name="bid">Make a bid</button>
        </form>

        <% if (confirmationMessage != null && !confirmationMessage.isEmpty()) { %>
            <div class="confirmation-message-container">
                <div class="confirmation-message">
                    <%= confirmationMessage %>
                </div>
            </div>
        <% } %>

        <% if (bids != null && !bids.isEmpty()) { %>
            <div class="track-ids">
                <% for (Bid bid : bids) { %>
                    <div class="track-id">
                        Track ID: <%= bid.getTrackID() %>
                    </div>
                <% } %>
            </div>
        <% } %>
    </div>
</body>
</html>
