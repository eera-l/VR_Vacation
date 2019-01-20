<%-- 
    Document   : index
    Created on : 1-gen-2019, 17.27.54
    Author     : Federica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VR Vacation</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body>
        <div id="nav"></div>
        <div class="container text-center">
            <h1>Live your dream vacation from the comfort of your own home</h1> 

            <!--<iframe src="https://360player.io/p/wqosLr/" frameborder="0" width=560 height=315 class="img-fluid" allowfullscreen data-token="k6f7rb"></iframe>-->

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