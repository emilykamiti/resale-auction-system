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

        /* Styles for navigation bar */
        .navbar {
            display: flex;
            justify-content: flex-start; /* Changed to flex-start */
            align-items: center;
            padding: 20px;
            position: fixed;
            width: 100%;
            z-index: 1000;
            top: 0; /* Placing the navbar at the top */
            background-color: transparent;
        }

        .dropdown {
            margin-right: 20px;
            position: relative; /* Added position relative */
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: blue; /* Changed background color to blue */
            min-width: 150px; /* Slightly increased width */
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
            padding: 10px; /* Added padding for spacing */
        }

        .dropdown.active .dropdown-content {
            display: block;
        }

        .dropdown-item {
            margin-bottom: 10px; /* Adding some space between items */
        }

        .dropdown-item a {
            display: block;
            font-weight: bold;
            color: black;
            text-decoration: none; /* Removing underline */
            padding: 8px 0;
        }

        .dropdown-item a:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <div class="dropdown" id="dropdown">
            <button class="dropdown-btn" onclick="toggleDropdown()">Category</button>
            <div class="dropdown-content">
                <div class="dropdown-item">
                    <a href="#">Accessory</a>
                </div>
                <div class="dropdown-item">
                    <a href="#">Luxury</a>
                </div>
                <div class="dropdown-item">
                    <a href="#">Food</a>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <h1 class="heading">eSales Auctioning</h1>
        <p class="paragraph">Own Your Price!</p>
        <p class="paragraph">You're just one bid away!</p>
        <a href="./home" class="button">Click to proceed</a>
    </div>

    <script>
        function toggleDropdown() {
            const dropdown = document.getElementById('dropdown');
            dropdown.classList.toggle('active');
        }
    </script>
</body>
</html>
