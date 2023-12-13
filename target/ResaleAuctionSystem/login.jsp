
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Resale Auction Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <jsp:include page="./css/loginCss.jsp" />
    </head>
    <body>
        <div class="container">
            <h1 class="title">Resale Auction</h1>
            <div class="card">
                <div class="card-body">

                    <form action="./login" method="post">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <div class="input-group">
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary" name="login">Login</button>
                    </form>
                </div>
            </div>

            <div class="text-center">
                <div class="registration-links">
                    <a href="./register.jsp">Register</a> | <a href="./forgotpassword">Forgot Password</a>
                </div>
            </div>
        </div>
    </body>

    </html>