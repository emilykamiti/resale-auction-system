<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="com.resale.app.view.navigationbar.TopNavigationBar" %>
        <!DOCTYPE html>
        <html>

        <head>

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

                    .topnav {
                        width: 100%;
                        text-decoration-color: #FFA500;
                        position: fixed;
                        top: 0;
                        left: 0;
                        z-index: 999;
                    }

                    .topnav a {
                        color: rgb(255, 136, 0);
                        text-decoration: none;
                        padding: 14px 16px;
                        display: inline-block;
                    }

                    .topnav a:hover {
                        background-color: blue;
                        color: black;
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
            <%-- Insert the TopNavigationBar here --%>
                <%= new TopNavigationBar().menu(0) %>
                    <div class="container">
                        <h1 class="heading">eSales Auctioning</h1>
                        <p class="paragraph">Own Your Price!</p>
                        <p class="paragraph">Your just one Bid away!</p>
                        <a href="./category" class="button">Click to proceed</a>

                    </div>

        </html>