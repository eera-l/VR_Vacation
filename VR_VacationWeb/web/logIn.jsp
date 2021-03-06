<%-- 
    Document   : logIn.jsp
    Created on : 03/01/2019, 11:32:39 AM
    Author     : Felicity
    func       : log in  form
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VR Vacations - Log In</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body>
        <div id="nav"></div>
        <div class="container-fluid">
            <h1>Log In</h1>
            <form action="LogIn" method="POST">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="username" class="form-control" name="username" value="${username}" placeholder="user123">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" name="password">
                </div>
                <div>
                    <span class="error">${error}</span>
                </div>
                <button type="submit" class="btn btn-outline-secondary">Log In</button>
            </form>

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
