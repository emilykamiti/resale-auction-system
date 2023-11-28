<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Item Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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

        .title {
            font-family: 'Times New Roman', serif;
            font-size: 24px;
            font-weight: bold;
            color: #000000;
            text-transform: uppercase;
            text-align: center;
            margin: 20px 0;
        }

        .form-group {
            margin-bottom: 20px;
        }

        input[type="text"],
        input[type="password"],
        .btn {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            box-sizing: border-box;
        }

        button {
            background-color: #FFA500;
            color: white;
        }

        button:hover {
            background-color: #FF8C00;
        }
    </style>

/head>
<body>
    <div class="container">
        <h1>Add Item</h1>
        <form action="./item" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="type">Type:</label>
                <select class="form-control" id="type" name="type" required>
                    <option value="HOME_ACCESSORIES">Home Accessories</option>
                    <option value="LUXURY">Luxury</option>
                    <option value="FURNITURE">Furniture</option>
                    <option value="CARS">Cars</option>
                </select>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" step="0.01" class="form-control" id="price" name="price" required>
            </div>
            <div class="form-group">
                <label for="image">Image:</label>
                <input type="file" class="form-control" id="image" name="image" accept="image/*" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Item</button>
        </form>
    </div>
</body>
</html>
