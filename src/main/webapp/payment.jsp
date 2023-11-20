<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Make Payment</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
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
        input[type="date"],
        input[type="number"],
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
</head>
<body>
<div class="container">
    <h1 class="title">Make Payment</h1>
    <div class="card">
        <div class="card-body">
            <form action="./payment" method="post">
                <div class="form-group">
                    <label for="amount">Amount</label>
                    <input type="text" class="form-control" id="amount" name="amount" required>
                </div>
                <div class="form-group">
                    <label for="paymentDate">Payment Date</label>
                    <input type="date" class="form-control" id="paymentDate" name="paymentDate" required>
                </div>
                <div class="form-group">
                    <label for="paymentMethod">Payment Method</label>
                    <input type="text" class="form-control" id="paymentMethod" name="paymentMethod" required>
                </div>
                <div class="form-group">
                    <label for="transactionId">Transaction ID</label>
                    <input type="text" class="form-control" id="transactionId" name="transactionId" required>
                </div>
                <button type="submit" class="btn btn-primary" name="makePayment">Make Payment</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
