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
    <div id="nav"></div>
    <div class="container-fluid">
        <h1>Destinations</h1>
        <div class="card-deck">
            <c:forEach var="destination" items="${destinations}">
                <div class="card" style="width: 18rem;">
                     <img src="${destination.imagePath}" class="card-img-top" alt="image" >
                    <div class="card-body">
                        <h5 class="card-title">${destination.name}</h5>
                        <a href="${pageContext.request.contextPath}/Packages?destinationId=${destination.destinationId}" class="btn btn-primary">View Packages...</a>
                    </div>
                </div>              
            </c:forEach> 
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
    </script>
</body>
</html>
