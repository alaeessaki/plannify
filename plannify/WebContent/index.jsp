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
    <title> Projects page</title>
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
                 <a href="logout"><i class="fa fa-user mb-3" aria-hidden="true" id="triggerId" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false"></i></a>
                
                
            </div>
        </div>
    </nav>

    <nav class="second-nav">
        <div class="content">
            <h2 class="text-center mt-4">Plannify</h2>
            <ul class="nav-list pl-4 mt-4">
                <li class="nav-item">
                    <i class="fa fa-tasks" aria-hidden="true"></i>
                    <a class="nav-link" href="#">Tasks</a>
                </li>
                <li class="nav-item">
                    <i class="fa fa-folder" aria-hidden="true"></i>
                    <a class="nav-link" href="projects">Projects</a>
                </li>
                <li class="nav-item">
                    <i class="fa fa-users" aria-hidden="true"></i>
                    <a class="nav-link" href="team.jsp">Teams</a>
                </li>
                <li class="nav-item">
                    <i class="fa fa-list" aria-hidden="true"></i>
                    <a class="nav-link" href="users.jsp">Users</a>
                </li>
            </ul>
        </div>
    </nav>


    <main>
        <div class="title pl-3 d-flex flex-row justify-content-between ">
            <h1>Projects</h1>
            <a name="" id="" class="btn" href="Addproject.jsp" role="button">Add project</a>
        </div>
        <div class="recent-projects mb-3">
            <h2 class="pl-3 pb-2">Recent projects</h2>
            <div class="container-fluid">
                <div class="row">

                    <div class="col-6 col-md-4 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                            </div>
                            <div class="card-footer p-1 text-right">
                                <button class="btn mr-1" type="button" id="triggerId" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-ellipsis-v" aria-hidden="true"></i>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="triggerId">
                                    <button class="dropdown-item">Action</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-md-4 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                            </div>
                            <div class="card-footer p-1 text-right">
                                <button class="btn mr-1" type="button" id="triggerId" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-ellipsis-v" aria-hidden="true"></i>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="triggerId">
                                    <button class="dropdown-item" >Action</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-md-4 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                            </div>
                            <div class="card-footer p-1 text-right">
                                <button class="btn mr-1" type="button" id="triggerId" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-ellipsis-v" aria-hidden="true"></i>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="triggerId">
                                    <button class="dropdown-item">Action</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="d-flex flex-row p-3">
            <div class="input-group w-25 mr-3">
                <input type="text" class="form-control" placeholder="Search ..." aria-label="searching input"
                    aria-describedby="button-addon4">
                <div class="input-group-append" id="button-addon4">
                    <button class="btn btn-outline-secondary" type="button"><i class="fa fa-search"
                            aria-hidden="true"></i></button>
                </div>
            </div>
            <div class="btn-groupe d-flex flex-row">
                <div class="dropdown open mr-1">
                    <button class="btn view-btn dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                        View
                    </button>
                    <div class="dropdown-menu" aria-labelledby="triggerId">
                        <button class="dropdown-item" href="#">Action</button>
                    </div>
                </div>
                <div class="dropdown open">
                    <button class="btn filter-btn dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                        filter by
                    </button>
                    <div class="dropdown-menu" aria-labelledby="triggerId">
                        <button class="dropdown-item" href="#">Action</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="projects-list">
            <table class="table">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Type</th>
                        <th>Leader</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${projects}" var="project">
                    <tr>
                        <td scope="row"><a href="ProjectDetails?id=${project.id}">${project.nom }</a></td>
                        <td>${project.categorie.nom }</td>
                        <td><a href="">${user.nom}</a></td>
                        <td>
                            <div class="action">
                                <button class="btn mr-1" type="button" id="triggerId" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-ellipsis-v" aria-hidden="true"></i>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="triggerId">
                                    <a class="dropdown-item" href="UpdateProject?id=${project.id }">update</a>
                                    <a class="dropdown-item" href="DeleteProject?id=${project.id}">delete</a>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

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