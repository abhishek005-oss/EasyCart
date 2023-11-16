<%@page import="com.ekart.FactoryProvider" %>
<%@page import=" com.entities.Category"%>
<%@page import=" com.entities.Product"%>
<%@page import="com.ekart.Helper"%>
<%@page import=" com.dao.CategoryDao"%>
<%@page import=" com.dao.ProductDao" %>
<%@ page import="java.util.List" %>
<html>
<head>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
<%@include file="components/navbar.jsp"%>
<div class="row mt-3 mx-2 ">
<%
String cat=request.getParameter("category");
ProductDao dao=new ProductDao(FactoryProvider.getFactory());
List<Product> list=null;
if(cat==null || cat.trim().equals("all"))
{
list=dao.getAllProducts();
}
else
{
int cid=Integer.parseInt(cat.trim());
list=dao.getAllProductsById(cid);
}
CategoryDao cDao = new CategoryDao(FactoryProvider.getFactory());
List <Category> cList= cDao.getCategories();
%>
<div class="col-md-2" >
<ul class="list-group">
<a href="index.jsp?category=all" class="list-group-item active" style="background:#b39ddb; border-color:#b39ddb;">All Products</a>



<% for(Category c: cList)
{%>
  <li class="list-group-item"><a href="index.jsp?category=<%=c.getCategoryid()%>" style="color:black;"><%=c.getCTitle()+"<br>"%></a></li>


<%}%>
</ul>
</div>
<div class="col-md-10">
<div class="row mt-1">
<div class="col-md-12">
<div class="card-columns">
<%
for(Product p:list){
%>
<div class="card card-highlight">
<div class="container text-center">
<img src="img/products/<%=p.getpPhoto()%>" style="max-height:200px; max-width:100%; width:auto;"class="card-img-top m-2">
</div>
<div class="card-body">
<h5 class="card-title"><%=p.getPname()%></h5>
<p class="card-text">
<%=Helper.get10words(p.getPdesc())%>
</p>
</div>
<div class="footer text-center">
<button class="btn custom-bg text-white" onclick="add_to_cart(<%=p.getPid()%>,'<%=p.getPname() %>',<%=p.getPriceAfterApplyingDiscount()%>,<%=p.getpQuantity()%>)">Add to Cart</button>

<button class="btn btn-outline-success">&#8377;<%=p.getPriceAfterApplyingDiscount()%>/-<span class="text-secondary discount-label">&#8377;<%=p.getpPrice()%> <%=p.getpDiscount() %>%off </span></button>
</div>
</div>


<% }
 if(list.size()==0){
 out.println("<h2> No item in this category.. </h2>");
 }%>
</div>
</div>
</div>
</div>
<%@include file="components/common_modal.jsp"%>
</body>
</html>
