x<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.resale.app.model.entity.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="com.resale.app.model.entity.Bid" %>

<!DOCTYPE html>
<html>
<head>
    <title>Bid Page</title>
    <style>body {
        font-family: Arial, Helvetica, sans-serif;
        background-size: cover;
        background-color: coral;
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
    </style>
</head>
<body>
<div class="container">

    <h2 class="form-title">MAKE BID</h2>
   
    <form action="./bids" method="post">
    
    <label for="bidAmount">Amount to bid</label>
    
    <input type="number" id="bidAmount" name="bidAmount" required><br>
    
    <button type="submit" name="bid">Make a bid</button>
    <a href="./home" class="homepage-link">Go to homepage</a>
</form>
        </div>
    </div>
</body>
</head>
</html>