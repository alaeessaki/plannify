<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <title>login</title>
</head>

<body>
    <div class="container-fluid box-2 d-flex justify-content-center align-items-center">
        <div class="card-login d-flex justify-content-center align-items-center">
            <form action="login" method="post">
                <div class="form-group">
                    <input type="email" class="input-style" name="email" id="" aria-describedby="helpId"
                        placeholder="Email">
                </div>
                <div class="form-group">
                    <input type="password" class="input-style" name="password" id="" aria-describedby="helpId"
                        placeholder="Password">
                </div>
                <button type="submit" class="btn-login btn-block">LOGIN</button>
                <div class="d-flex mt-3">
                    <p>not registered yet ? </p> <a href="#" class="login-redirect ml-2">create account</a>
                </div>
            </form>
        </div>
    </div>

</body>

</html>