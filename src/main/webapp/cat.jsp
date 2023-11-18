<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="cat.css">
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            display: flex;
            font-weight: 300;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            overflow: hidden;
            height: 100vh;
        }

        h1 {
            margin: 10px;
        }

        .container {
            display: flex;
            overflow-x: auto; /* Enable horizontal scrolling */
        }

        .box {
            background-color: white;
            border: 2px solid #3b3b3b;
            color: #000;
            flex: 0 0 auto; /* Let boxes grow and shrink within container */
            width: 400px;
            height: 200px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin-right: 20px; /* Add space between boxes */
            cursor: pointer;
            transition: transform 0.4s ease-in-out, box-shadow 0.3s;
        }

        .box:hover {
            transform: scale(1.1);
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
        }

        .box.show {
            opacity: 1;
            transform: scale(1);
        }

        .box h2 {
            font-size: 22px;
            font-weight: 400;
        }

        .arrow {
            font-size: 24px;
            cursor: pointer;
            margin-bottom: 20px;
        }
    </style>
    <title>Show Categories</title>
</head>
<body>
    <h1>Show Categories</h1>
    <div class="arrow">&#8594;</div> <!-- Click arrow to reveal boxes -->
    <div class="container">
        <div class="box">
            <h2>Home Accessories</h2>
        </div>

        <div class="box">
            <h2>Vehicles</h2>
        </div>

        <div class="box">
            <h2>Luxury</h2>
        </div>
        <div class="box">
            <h2>Cars</h2>
        </div>
    </div>

    <script>
        const boxes = document.querySelectorAll(".box");
        const arrow = document.querySelector(".arrow");
        let index = 0;

        function revealBox() {
            if (index < boxes.length) {
                boxes[index].classList.add('show');
                index++;
            }
        }

        arrow.addEventListener("click", revealBox);
    </script>
</body>
</html>
