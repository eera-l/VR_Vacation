<%-- 
    Document   : userpage
    Created on : 20-gen-2019, 20.58.00
    Author     : Federica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <%
        String result = (String)request.getAttribute("result"); 
          
        %>
        <h1><%=result%></h1>
    </body>
</html>
