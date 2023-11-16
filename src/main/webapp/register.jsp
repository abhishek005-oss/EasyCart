<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="components/common_css_js.jsp" %>

<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<%@include file="components/navbar.jsp" %>
<div class="container-fluid">
<div class="row mt-5">
<div class="col-md-4 offset-md-4">
<div class="card">

<div class="card-body px-2">
<%@include file="components/message.jsp" %>

<img class="mx-auto d-block" width="64" height="64" src="https://img.icons8.com/external-bearicons-outline-color-bearicons/64/external-sign-up-call-to-action-bearicons-outline-color-bearicons-1.png" alt="external-sign-up-call-to-action-bearicons-outline-color-bearicons-1"/>
<h3 class="text-center my-3">SignUp Here</h3>
<form action="RegisterServlet" method="post">

<div class="mb-3">
  <label for="name" class="form-label">Username</label>
  <input type="text" class="form-control" id="name" placeholder="Enter your name" name="user_name" required>
</div>
<div class="mb-3">
  <label for="email" class="form-label">Email</label>
  <input type="email" class="form-control" id="email" placeholder="Enter your email" name="user_email" required>
</div>
<div class="mb-3">
  <label for="password" class="form-label">Password</label>
  <input type="password" class="form-control" id="password" placeholder="Enter your password" name="user_password" required>
</div>
<div class="mb-3">
  <label for="phone" class="form-label">Phoneno.</label>
  <input type="tel" class="form-control" id="phone" placeholder="Enter the value here" name="user_phone" required pattern="[0-9]{10}">
</div>
<div class="mb-3">
  <label for="name" class="form-label">UserAddress</label>
<textarea class="form-control" placeholder="Enter your address " style="height:180px;" name="user_address" required>
</textarea>


</div>
<div class="container text-center">
<button class="btn btn-outline-success" type="submit">Register</button>
<button class="btn btn-outline-warning" type="reset">Reset</button>

</div>

</form>

</div>
</div>


</div>
</div>
</div>

</body>
</html>