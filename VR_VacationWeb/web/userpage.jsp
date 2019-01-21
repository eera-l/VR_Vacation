<%-- 
    Document   : userpage
    Created on : 20-gen-2019, 20.58.00
    Author     : Federica
--%>

<%@page import="java.util.List, hibernate.Order, hibernate.Package"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body>
        <div id="nav"></div>
        <%
        String result = (String)request.getAttribute("result"); 
        List<Order> orders = (List<Order>)request.getAttribute("orders");
        List<Package> packages = (List<Package>)request.getAttribute("packages");
        %>
        <h1><%=result%></h1>
        <ul class="list-group">
            <% 
                for (Order order : orders) {           %>                
                    
                <li class="list-group-item" ><%=order.getOrderId()%></li>
                <ul class="list-group">
                     <% 
                            for (Package pack : packages) {           %> 
                            <li class="list-group-item" ><%=pack.getName()%></li>
                             <%}%>
                </ul>
                <%}%>
            </ul>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script>
            $(function () {
                $("#nav").load("${pageContext.request.contextPath}/navBar.jsp");
            });
         </script>
    </body>
</html>
