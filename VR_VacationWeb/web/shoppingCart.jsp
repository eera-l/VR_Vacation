<%-- 
    Document   : shoppingCart
    Created on : 05/01/2019, 9:14:54 PM
    Author     : Felicity
--%>
<%@page import="java.util.ArrayList, hibernate.Package"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VR Vacations - Shopping Cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body>
        <%
        ArrayList<Package> packages =(ArrayList<Package>) request.getAttribute("packages"); 
          
        %>
        <div id="nav"></div>
        <div class="container">
            <div>
                <h1> Shopping Cart</h1><br><br>
                <h3>Here are the items in your shopping cart:</h3>
            </div>
            <form action="ShoppingCart" method="POST">            
            <ul class="list-group">
            <% 
                for (hibernate.Package pack : packages) {           %>                
                    
                <li class="list-group-item" ><input type="hidden" name="package_to_remove" value="<%=pack.getPackageId()%>"/><%=pack.getName()%><input type="submit" id="btn_remove" value="Remove" style="position: absolute; top: 10%; left: 92%; color: grey;" class="btn btn-outline-secondary"/></li>
                
                <%}%>
            </ul>
            </form>
            <br><br>
            <div>
                <a id="btn_checkout" class="btn btn-primary" style="color: white;">Checkout</a>
            </div>
            <div id="chatbot" style="position: fixed; bottom: 10px; left: 90%"></div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script>
            $(function () {
                $("#nav").load("${pageContext.request.contextPath}/navBar.jsp");
            });
            $(function () {
                $('#chatbot').load("${pageContext.request.contextPath}/chatbot_jsp.jsp");
            });
                   $(function () {
                       $('#btn_checkout').click(function (event) {
                       window.location.href = '/VR_VacationWeb/loading.jsp';
                   });
                   
               });
            
        </script>
    </body>
</html>
