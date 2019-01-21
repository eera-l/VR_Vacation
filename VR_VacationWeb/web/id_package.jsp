<%-- 
    Document   : id_package
    Created on : 05/01/2019, 5:42:12 PM
    Author     : Felicity
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VR Vacations - Package</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <div id="nav"></div>
    <body>
        <div class="container">
            <div class="card" >
                <img src="${package.imagePath}" class="card-img-top" alt="image"></a>
                <div class="card-body">
                    <h5 class="card-title">${package.name}</h5>
                    <p class="card-text">${package.description}</p>
                    <p class="card-text"><small class="text-muted">${package.price}</small> SEK</p>
                    <div id="addedToCart"></div>
                    <button id="addToCart" class="btn btn-primary">Add to cart</button>
                    <button id="goToCart" class="btn btn-info">Go to cart</button>
                </div>
                <h1 class="container text-center">Optional Add on Experiences</h1>
                <div class="container card-deck">
                    <c:forEach var="experience" items="${experiences}" varStatus="loop">
                        <div class="card">
                            <img src="${experience.imagePath}" class="card-img-top" alt="image" >
                            <div class="card-body">
                                <h4 class="card-title">${experience.name}</h4>
                                <p class="card-title">${experience.description}</p>
                                <div id="addedExperienceToCart${loop.index}" class="addedExperienceToCart"></div>
                                <button id="${experience.experienceId}${loop.index}" class="addExperienceToCart btn btn-primary">Add to cart</button>
                            </div>
                        </div>
                    </c:forEach> 
                </div>
            </div>
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
            $('#addToCart').click(function (event) {
                var addPackToCart = ${package.packageId}
                $.get('ID_Package', {addPackToCart: addPackToCart}, function (responseText) {
                    $('#addedToCart').text(responseText);
                    $('#addedToCart').addClass('alert alert-info');
                });
            });

        });
        $(function () {
            $('.addExperienceToCart').click(function (event) {
                var addExpToCart = $(this).attr('id');
                $.get('ID_Package', {addExpToCart: addExpToCart}, function (responseText) {
                    var label = document.getElementById(addExpToCart).previousElementSibling;
                    var labelId = label.id;
                    var element = document.getElementById(labelId);
                    $(element).text(responseText);
                    $(element).addClass('alert alert-info');

            });
        });
        $(function () {
            $('#goToCart').click(function (event) {
                window.location.href = '/VR_VacationWeb/ShoppingCart';
            });
        });
    </script>
</body>
</html>