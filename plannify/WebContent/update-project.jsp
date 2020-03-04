<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>^
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
    <title>Update Project</title>
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
                <a href=""> <i class="fa fa-user mb-3" aria-hidden="true"></i>
                </a>
            </div>
        </div>
    </nav>

    <nav class="second-nav">
        <div class="content">
            <h2 class="text-center mt-4">Plannify</h2>
            <ul class="nav-list pl-4 mt-4">
                <li class="nav-item">
                    <i class="fa fa-tasks" aria-hidden="true"></i>
                    <a class="nav-link" href="#">my work</a>
                </li>
                <li class="nav-item">
                    <i class="fa fa-folder" aria-hidden="true"></i>
                    <a class="nav-link" href="projects">projects</a>
                </li>
                <li class="nav-item">
                    <i class="fa fa-users" aria-hidden="true"></i>
                    <a class="nav-link" href="team.html">Teams</a>
                </li>
                <li class="nav-item">
                    <i class="fa fa-list" aria-hidden="true"></i>
                    <a class="nav-link" href="users.html">Users</a>
                </li>
            </ul>
        </div>
    </nav>
    
    <main>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h3 class="text-center">
                                Edit Project :</h3>
                            <form class="form form-signup" role="form" action="UpdateProject" method="POST">
                                <div class="form-group">
                         			<input type="hidden" name="id" value="${project.id}">
                         			<input type="hidden" name="created_at" value="${project.created_at }"> 
                                    <label for="projectname">Nom du projet :</label>
                                    <input type="text" id="projectname" name="nom" class="form-control" value="${project.nom}" />
                                </div>

                                <div class="form-group">
                                    <label for="desc">Project Description :</label>
                                    <textarea class="form-control" id="desc" name="description" rows="4">${project.description }</textarea>
                                </div>

                                <div class="form-group">
                                    <label for="changeteam">change Team :</label>
                                    <select class="form-control" id="changeteam" name="team">
                                       <c:forEach items="${teams}" var="team">
	                                        <option value="${team.id}" <c:if test="${team.id == project.team.id}">selected="selected"</c:if>>${team.nom}</option>
                                       </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="changecat">change Categorie :</label>
                                    <select class="form-control" id="changecat" name="categorie">
                                        <c:forEach items="${categories }" var="categorie">
                                        	<option value="${categorie.id }" <c:if test="${categorie.id == project.categorie.id}">selected="selected"</c:if>>${categorie.nom}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <input type="submit" value="Update" name="submit" class="update-btn btn btn-sm btn-primary btn-block">
                            </form>
                        </div>
                    </div>
                </div>
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