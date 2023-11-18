<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Landing Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-image: url('https://images.pexels.com/photos/5632402/pexels-photo-5632402.jpeg?auto=compress&cs=tinysrgb&w=1200');
            background-size: 100% 100%;
            background-repeat: no-repeat;
            background-position: center;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            text-align: center;
            margin-left: 33%;
        }

        .heading {
            font-size: 4em;
            margin-bottom: 20px;
            color: #FFA500;
        }

        .paragraph {
            font-size: 1em;
            color: rgb(163, 163, 221);
        }

        .button {
            margin-top: 10%;
            display: inline-block;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            background-color: #007bff;
            color: white;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="heading">eSales Auctioning</h1>
        <p class="paragraph">Own Your Price!</p>
        <p class="paragraph">You're just one bid away!</p>
        <a href="./home" class="button">Click to proceed</a>
    </div>
</body>
</html>
