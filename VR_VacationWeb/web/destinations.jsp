<%-- 
    Document   : destinations
    Created on : 03/01/2019, 3:44:54 PM
    Author     : Felicity
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VR Vacation - Destinations</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">VR Vacations</a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarHamburger">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarHamburger">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Packages">Packages</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Destinations">Destinations</a>
                </li>
            </ul>
            <ul class="navbar-nav navbar-right">
                <li>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/ShoppingCart"><span class="fa fa-shopping-cart"></span>     </a>
                </li>
                <li>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/SignUp"><span class="fa fa-user"></span> Sign Up</a>
                </li>
                <li>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/LogIn"><span class="fa fa-sign-in"></span> Login</a>
                </li>
            </ul>  
        </div>
    </nav>
    <div class="container-fluid">
        <h1>Destinations</h1>
        <div class="card-deck">
            <c:forEach var="img" items="${imageList}">
                <a href="${pageContext.request.contextPath}/ID_Destination?img=${img}"<div class="card">
                        <iframe src="${img}" frameborder="0" width=308 height=1263 class="img-fluid card-img-top" allowfullscreen data-token="k6f7rb"></iframe>
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">${message}</p>
                            <p class="card-text"><small class="text-muted">${message}</small></p>
                        </div></a>               
            </c:forEach> 
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</body>
</html>