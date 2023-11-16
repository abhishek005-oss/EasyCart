<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.entities.User"%>
    <%
    User user2=(User)session.getAttribute("current_user");
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

    <h1> Hi <%=user2.getUsername() %></h1>
    </body>
    </html>