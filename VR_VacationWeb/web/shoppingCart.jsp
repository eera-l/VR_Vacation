<%-- 
    Document   : shoppingCart
    Created on : 05/01/2019, 9:14:54 PM
    Author     : Felicity
--%>
<%@page import="java.util.ArrayList, hibernate.Package, hibernate.Experience"%>
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
          ArrayList<Experience> exps =(ArrayList<Experience>) request.getAttribute("experiences"); 
          String introText = (String)request.getAttribute("introText"); 
          String error = (String)request.getAttribute("error");
          String total = (String)request.getAttribute("total");
        %>
        <div id="nav"></div>
        <div class="container">
            <div>
                <h1> Shopping Cart</h1><br><br>
                <h3><%=introText%></h3>
            </div>
            <ul class="list-group">
            <form action="ShoppingCart" method="POST">            
            
            <% 
                if (packages != null) {
                    for (hibernate.Package pack : packages) {           %>                
                    
                <li class="list-group-item" ><input type="hidden" name="package_to_remove" value="<%=pack.getPackageId()%>"/><%=pack.getName() + "            Price: " + pack.getPrice() + " SEK."%><input type="submit" id="btn_remove" value="Remove" style="position: absolute; top: 10%; left: 92%; color: grey;" class="btn btn-outline-secondary"/></li>
                
                    <%}
                }%>
            </form>
            <form action="ShoppingCart" method="POST"> 
                <% 
                    if (exps != null) {
                        for (hibernate.Experience exp : exps) {           %>                
                    
                <li class="list-group-item" ><input type="hidden" name="experience_to_remove" value="<%=exp.getExperienceId()%>"/><%=exp.getName() + "            Price: " + exp.getPrice() + " SEK."%><input type="submit" id="btn_remove" value="Remove" style="position: absolute; top: 10%; left: 92%; color: grey;" class="btn btn-outline-secondary"/></li>
                
                    <%}
                }%>
                 </form>
            </ul>
                <h3><%= total%></h3>
            <br><br>
            <div>
                <h4 style="color: red;"><%= error %></h4>
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
                           if (packages !== null)
                                window.location.href = '/VR_VacationWeb/loading.jsp';
                   });
                   
               });
            
        </script>
    </body>
</html>
