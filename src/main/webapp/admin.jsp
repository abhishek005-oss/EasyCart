<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.entities.User"%>
    <%@page import="com.ekart.FactoryProvider"%>
    <%@page import="com.entities.Category"%>
    <%@page import="com.entities.Product" %>
    <%@page import="com.dao.CategoryDao" %>
    <%@ page import="java.util.List" %>

<%
User user=(User)session.getAttribute("current_user");
 if(user==null)
 {
 session.setAttribute("message","You are not logged in!!");
 response.sendRedirect("Login.jsp");
 return;
 }
else{
if (user.getUsertype().equals("normal")){
session.setAttribute("message","You are not Admin");
response.sendRedirect("Login.jsp");
return;
}
}
%>
<html>
<head>
<%@include file="components/common_css_js.jsp" %>

<title>
admin_panel
</title>
</head>
<body>
<%@include file="components/navbar.jsp"%>

<div class="container admin">
<%@include file="components/message.jsp" %>

<div class="row mt-3">
<div class="col-md-4">
<div class="card text-center">
<div class="card-body">
<div class="container">
<img style="max-width:125px;" class ="img-fluid rounded-circle" src="img/teamwork.png" alt="user-icon">
</div>
<h1> 100 </h1>
<h1> Users </h1>
</div>
</div>
</div>
<div class="col-md-4">
<div class="card text-center">
<div class="card-body">
<div class="container">
<img style="max-width:125px;" class ="img-fluid rounded-circle" src="img/category.png" alt="user-icon">
</div>
<h1> 300 </h1>
<h1> Categories</h1>
</div>
</div>
</div>
<div class="col-md-4">
<div class="card text-center">
<div class="card-body">
<div class="container">

<img style="max-width:125px;" class ="img-fluid rounded-circle" src="img/packaging.png" alt="user-icon">
</div>
<h1> 400 </h1>
<h1> Products </h1>
</div>
</div>
</div>

</div>

<!--Second row-->
<div class="row mt-3">
<div class="col-md-6">
<div class="card text-center" data-toggle="modal" data-target="#addCategoryModal">
<div class="card-body">
<div class="container">
<img style="max-width:125px;" class ="img-fluid rounded-circle" src="img/category (1).png" alt="user-icon">
</div>
<p class="mt-2">Click here to add new category!!</p>
<h1> Add Category</h1>
</div>
</div>
</div>


<div class="col-md-6">

<div class="card text-center" data-toggle="modal" data-target="#addProductModal">
<div class="card-body">
<div class="container">
<img style="max-width:125px;" class ="img-fluid rounded-circle" src="img/add-to-cart.png" alt="user-icon">
</div>
<p class="mt-2"> Click  here to add new product!! </p>
<h1> Add Product</h1>
</div>
</div>
</div>
</div>
</div>
<div class="modal" tabindex="-1" id="addProductModal">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header custom-bg text-white">
        <h5 class="modal-title"> Fill Product Details </h5>
        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
            <form action="ProductOperationServlet" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="operation" value="addProduct"/>
                    <div class="form-group">
                    <input type="text" class="form-control"  name="pName" placeholder="Enter Product title" required/>
                     </div>
                    <div class="form-group">
                     <input type="text" class="form-control"  name="pDesc" placeholder="Enter Product description" required/>
                    </div>
                    <div class="form-group">
                    <input type="number" class="form-control"  name="pPrice" placeholder="Enter Product Price" required/>
                    </div>
                    <div class="form-group">
                    <input type="number" class="form-control"  name="pDiscount" placeholder="Enter Product Discount" required/>
                            </div>
                            <div class="form-group">
                                            <input type="number" class="form-control"  name="pQuantity" placeholder="Enter Product Quantity" required/>
                                           </div>
                                           <!-- Product category-->
                                           <%
                                          CategoryDao cDao= new CategoryDao(FactoryProvider.getFactory());
                                           List<Category> list1=cDao.getCategories();
                                           %>
                                           <div class="form-group">
                                           <select name="catId" class="form-control" id="">
                                           <%
                                           for(Category c:list1){
                                           %>
                                           <option value="<%=c.getCategoryid()%>"><%=c.getCTitle()%></option>
                                           <% } %>
                                           </select>
                                           </div>

                    <div class="form-group">
                    <label for="pPhoto">Select Picture for the Product</label><br>
                                    <input type="file" class="form-control"  name="pPhoto" required/>

                                    </div>
                    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-outline-success" >Add Product</button>
      </div>
      </form>
      </div>
    </div>
  </div>
</div>

<div class="modal" id="addCategoryModal">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header custom-bg text-white">
        <h5 class="modal-title" id="exampleModalLabel">Fill Category details...</h5>
        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="ProductOperationServlet" method="post" enctype="multipart/form-data">
        <input type="hidden" name="operation" value="addCategory"/>
        <div class="form-group">
        <input type="text" class="form-control"  name="catTitle" placeholder="Enter category title" required/>

        </div>
        <div class="form-group">
        <textarea style="height:320px;" class="form-control" placeholder="Enter category description" name="catDescp"></textarea>
        </div>

        <div class="container text-center">
        <button class="btn btn-outline-success" type="submit"> Add Category </button>
         <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

        </div>
        </form>
      </div>
     </div>
</div>





<!-- Modal -->


</body>
</html>