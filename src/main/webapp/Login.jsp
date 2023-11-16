<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="components/common_css_js.jsp" %>

<meta charset="ISO-8859-1">
<title>User_login_EasyCart</title>
</head>
<body>
<%@include file="components/navbar.jsp" %>
<form action="LoginServlet" method="post">

<div class="container">
<div class="row">
<div class="col-md-6 offset-md-3">


<div class="card mt-3">
<%@include file="components/message.jsp" %>

<div class="card-header text-white text-center custom-bg">
<h3><i class="fa-solid fa-pen-to-square  text-dark"></i><br>Login Here</h3>
</div>
<div class="card-body">
<div class="mb-3">
  <label for="email" class="form-label">Email</label>
  <input type="text" class="form-control" id="email" name="email_id" placeholder="Enter your email" required>
</div>
<div class="mb-3">
  <label for="password" class="form-label">Password</label>
  <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
</div>
<a href="register.jsp" class="text-center  d-block text-dark"><i class="fa-solid fa-link"></i> If not registered click here!!</a>
</div>
<div class="card-footer">
<div class="container text-center">
<button class="btn btn-outline-success mr-4" type="submit">LogIn</button>
<button class="btn btn-outline-warning" type="reset">Reset</button>

</div>

</div>

</div>
</div>

</div>

</div>
</form>
</body>
</html>