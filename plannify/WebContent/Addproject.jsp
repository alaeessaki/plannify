<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="ISO-8859-1">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="css/style.css">
  <title>Document</title>
  <title>Insert title here</title>
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
        <a href=""> <i class="fa fa-bell mb-3" aria-hidden="true"><span class="badge badge-dark">4</span></i></a>
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
                  <a class="nav-link" href="index.html">projects</a>
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
    <h1 class="text-center mt-3">Add Your Project</h1>
    <div class="container-fluid center mt-4 ">

      <form method="Get" action="AddprjServlet">
        <div class="form-group center col-md-9  ml-5 ">
          <label for="exampleInputText1">Name of project</label>
          <input type="text" class="form-control" id="exampleInputText1" aria-describedby="textHelp"
            placeholder="Enter name of project" name="name_project">
        </div>
        <div class="form-group center col-md-9  ml-5 ">
          <label for="exampleInputText1">Team</label>
          <select class="form-control"name="team" >
            <option>Default team 1</option>
            <option>Default team 1</option>
          </select>
        </div>
        <div class="form-group center col-md-9  ml-5 ">
          <label for="exampleInputText1">Project Category</label>
          <select class="form-control" name="categ">
            <option>Default select 1</option>
            <option>Default select 2</option>
          </select>
        </div>


        <div class="form-group center col-md-9 ml-5 ">
          <label for="exampleFormControlTextarea1">Description </label>
          <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="description"></textarea>
        </div>

        <button type="submit" class="btn ml-15 text-white pull-left"
          style=" background-color: #fe7568 !important;margin-left:60px;">Add project</button>
      </form>
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

</html>