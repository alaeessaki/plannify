<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/project.css">
    <title>Worklab</title>
</head>

<body>

    <nav class="left-nav">
        <div class="content d-flex flex-column justify-content-between h-100">
            <div class="top-content d-flex flex-column text-center">
                <a href="index.html" class="mt-3"><img src="assets/images/logo-sm.png" class="logo"
                        alt="logo with background"></a>
                <a href=""><i class="fa fa-plus mt-3" aria-hidden="true"></i></a>
            </div>
            <div class="bottom-content d-flex flex-column text-center">
                <a href=""> <i class="fa fa-bell mb-3" aria-hidden="true"><span
                            class="badge badge-dark">4</span></i></a>
                <a href=""> <i class="fa fa-info mb-3" aria-hidden="true"></i>
                </a>
                <a href="logout"> <i class="fa fa-user mb-3" aria-hidden="true"></i>
                </a>
            </div>
        </div>
    </nav>

    <nav class="second-nav">
        <div class="content">
            <h2 class="text-center mt-4 pb-2">${project.nom }</h2>
            <div class="back-to-project d-flex flex-row align-items-center">
                <a href="projects"><i class="fa fa-arrow-left mr-2" aria-hidden="true"></i></a>
                <a href="projects">Back to projects</a>
            </div>

            <hr>
            <p>Issues and filters</p>
            <ul class="nav-list pl-4 mt-2">
                <li class="nav-item">
                    <a class="nav-link" href="#">My open issues</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Resolved by me</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">All issues</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Open issues</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Done issues</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Created recently</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Resolved recently</a>
                </li>
            </ul>
            <hr>
        </div>
    </nav>


    <main>


    </main>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>