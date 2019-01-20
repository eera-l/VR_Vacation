<%-- 
    Document   : shoppingCart
    Created on : 05/01/2019, 9:14:54 PM
    Author     : Felicity
--%>
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
        <div id="nav"></div>
        <div class="container">
            <div>
                <h1> Shopping Cart</h1>
                <p>Select items</p>
            </div>
            <c:forEach var="package" items="${packages}">
                <div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox"  id="defaultCheck1">
                        <label class="form-check-label" for="defaultCheck1">${package.name}</label>
                    </div>
                </div>
            </c:forEach> 
            <div>
                <a href="${pageContext.request.contextPath}/ShoppingCart" class="btn btn-primary">Checkout</a>
            </div>
            <a href='#'style="position: fixed; left: 90%; bottom: 0; width: 10%; background-color: #2f3338; color: white; text-align:center;"
               onclick='javascript:window.open("chatbot_jsp.jsp", "_blank", "scrollbars=1,resizable=1,height=400,width=500");' title='Chatbot'>Chatbot</a> 
        </div>
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
