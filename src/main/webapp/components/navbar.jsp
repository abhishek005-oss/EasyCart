 <%@page import="com.entities.User"%>

<%
User user1=(User)session.getAttribute("current_user");
%>
<nav class="navbar navbar-expand-lg navbar-light custom-bg">
<div class="container">

    <a class="navbar-brand" href="index.jsp">My Cart</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        
       
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Categories
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
       </ul>
      <form class="d-flex" style="margin-top:15px;" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-normal ml-3"style="color:black; border-color: black;" type="submit">Search</button>
      </form>
      
      <ul class="navbar-nav ml-auto text-right">
      <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#" data-toggle="modal" data-target="#cart"><i class="fa fa-cart-plus" aria-hidden="true" style="font-size:20px;"><span class="cart-items">( 0 )</span></i></a>
              </li>

      <%
      if(user1==null)
      {
      %>
      <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Login.jsp">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="register.jsp">Register</a>
        </li>
        <%
        }
        else{
        %>
        <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#"><%=user1.getUsername()%></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="LogoutServlet" >Logout</a>
                </li>
<% } %>
      </ul>
      
      
    </div>
  </div>

</div>
</nav>
