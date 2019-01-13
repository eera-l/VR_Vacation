<%-- 
    Document   : signUp.jsp
    Created on : 03/01/2019, 11:32:16 AM
    Author     : Felicity
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VR Vacations - Sign Up</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body>
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
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/LogIn"><span class="fa fa-sign-in"></span> Login</a>
                    </li>
                </ul>  
            </div>
        </nav>
        <div class="container-fluid">
            <h1>Sign up</h1>
            <form action="SignUp" method="POST">
                <div class="alert alert-danger">
                    <b> ${error}</b>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" class="form-control" name="email" value="${user.emailAddress}" placeholder="name@example.com">
                </div>
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" name="username" placeholder="user123">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="text" class="form-control" name="password">
                </div>
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <input type="text" class="form-control" name="firstName" value="${user.firstName}">
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input type="text" class="form-control" name="lastName" value="${user.lastName}">
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Phone Number:</label>
                    <input type="text" class="form-control" name="phoneNumber" value="${user.phoneNumber}">
                </div>
                <div class="form-group">
                    <label for="street">Street:</label>
                    <input type="text" class="form-control" name="street" value="${user.addressStreet}">
                </div>
                <div class="form-group">
                    <label for="zipCode">Zip Code:</label>
                    <input type="text" class="form-control" name="zipCode" value="${user.addressZipCode}">
                </div>
                <div class="form-group">
                    <label for="city">City:</label>
                    <input type="text" class="form-control" name="city" value="${user.addressCity}">
                </div>
                <div class="form-group">
                    <label for="country">Country:</label>
                    <input type="text" class="form-control" name="country" value="${user.addressCountry}">
                </div>
                <div class="alert alert-danger">
                    <b> ${error}</b>
                </div>
                <button type="submit" class="btn btn-outline-secondary">Submit</button>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </body>
</html>
