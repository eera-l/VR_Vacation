<%-- 
    Document   : loading
    Created on : 20-gen-2019, 19.58.29
    Author     : Federica
    Funct.     : Simulates a loading process by
                 displaying a loading bar implemented in JavaScript
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing request...</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">VR Vacations</a></nav>
            <h1 style="position:relative; left: 35%; top: 70px;">Processing your request...</h1>
        <div style="position: relative; height:30px; width:50%; background-color: #bfbfbf; border-style: outset; border-radius: 25px; left: 25%; top: 320px; -webkit-box-shadow: 10px 10px 31px -6px rgba(0,0,0,0.75);
        -moz-box-shadow: 10px 10px 31px -6px rgba(0,0,0,0.75);
        box-shadow: 10px 10px 31px -6px rgba(0,0,0,0.75);">
        <div id="myBar" style="height:27px; width:0%; color:white; background-color: #18af46; text-align: center; font-family: Verdana; border-radius: 25px;">0%</div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script>
            window.onload = function() {
              var elem = document.getElementById("myBar"); 
              var width = 1;
              var id = setInterval(frame, 30);
              function frame() {
                if (width >= 100) {
                  clearInterval(id);
                  window.location.href = '/VR_VacationWeb/UserPageServlet';
                } else {
                  width++; 
                  elem.style.width = width + '%'; 
                  elem.innerHTML = width * 1  + '%';
                }
              }
            };
        </script>
    </body>
</html>
