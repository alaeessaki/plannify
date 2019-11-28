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
    <title>Sign up to Plannify</title>
</head>

<body>
    <div class="container-fluid box">
        <div class="row h-100">
            <div class="col-8 left-panel"></div>
            <div class="col-4 right-panel d-flex justify-content-center">
                <form action="" method="post">
                    <h3 class="text-center">Sign up</h3>
                    <div class="form-group">
                        <input type="text" class="input-style" name="nom" id="" aria-describedby="helpId"
                            placeholder="Nom">
                    </div>
                    <div class="form-group">
                        <input type="text" class="input-style" name="prenom" id="" aria-describedby="helpId"
                            placeholder="Prenom">
                    </div>
                    <div class="form-group">
                        <input type="email" class="input-style" name="email" id="" aria-describedby="helpId"
                            placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="input-style" name="password" id="" aria-describedby="helpId"
                            placeholder="Password">
                    </div>
                    <div class="form-group">
                        <input type="password" class="input-style" name="password" id="" aria-describedby="helpId"
                            placeholder="Confirm Password">
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="terms">
                        Accepter <span class="terms">les termes et les policies</span> du logiciel
                    </div>
                    <div class="d-flex justify-content-center">
                        <button type="reset" class="btn-cancel">Cancel</button>
                        <button type="submit" class="btn-validate">Confirm</button>
                    </div>
                    <div class="d-flex mt-3">
                        <p>You already have an account ? </p> <a href="#" class="login-redirect ml-2">Login<i
                                class="fa pl-2 fa-arrow-right"></i> </a>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>

</html>