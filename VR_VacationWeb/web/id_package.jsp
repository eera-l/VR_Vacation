<%-- 
    Document   : id_package
    Created on : 05/01/2019, 5:42:12 PM
    Author     : Felicity
--%>

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
            <div class="container-fluid">
                <div class="card" >
                    <img src="${pageContext.request.contextPath}/${package.imagePath}" class="card-img-top" alt="image"></a>
                    <div class="card-body">
                        <h5 class="card-title">${package.name}</h5>
                        <p class="card-text">${package.description}</p>
                        <p class="card-text"><small class="text-muted">${package.price}</small> SEK</p>
                        <div id="addedToCart"></div>
                        <button id="addToCart" class="btn btn-primary">Add to cart</button>
                        <button id="goToCart" class="btn btn-info">Go to cart</button>
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
                $('#addToCart').click(function (event) {
                    var addPackToCart = ${package.packageId}
                    $.get('ID_Package', {addPackToCart: addPackToCart}, function (responseText) {
                        $('#addedToCart').text(responseText);
                        $('#addedToCart').addClass('alert alert-info');
                    });
                });
            });
            $(function () {
                $('#goToCart').click(function () {
                    window.location.href = '/VR_VacationWeb/shoppingCart.jsp';
                });
            });
            $(function () {
                $('#chatbot').load("${pageContext.request.contextPath}/chatbot_jsp.jsp");
            });
        </script>
    </body>
</html>