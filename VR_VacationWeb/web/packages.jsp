<%-- 
    Document   : packages
    Created on : 03/01/2019, 3:44:29 PM
    Author     : Felicity
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VR Vacation - Packages</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body>
        <div id="nav"></div>
        <div class="container-fluid">
            <h1>Packages</h1>
            <div class="card-deck">
                <c:forEach var="package" items="${packages}">
                    <div class="card" style="width: 18rem;">
                        <img src="${pageContext.request.contextPath}/${package.imagePath}" class="card-img-top" alt="image" >
                        <div class="card-body">
                            <h5 class="card-title">${package.name}</h5>
                            <a href="${pageContext.request.contextPath}/ID_Package?packageId=${package.packageId}" class="btn btn-primary">See more...</a>
                        </div>
                    </div>
                </c:forEach> 
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
                       $("#nav").load("/VR_VacationWeb/navBar.jsp");
                   });
        </script>
    </body>
</html>
