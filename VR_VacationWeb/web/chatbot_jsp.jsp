<%-- 
    Document   : chatbot_jsp
    Created on : 12-gen-2019, 19.09.54
    Author     : Federica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            
            #textinput {
                padding: 5px; 
                width: 60%;
                border: 1px solid #2f3338; 
                -webkit-border-radius: 20px;
                -moz-border-radius: 20px;
                border-radius: 20px;
                user-select: none;
                -moz-user-select: none;
                -khtml-user-select: none;
                -webkit-user-select: none;
                -o-user-select: none;
            }
            
            #answer_con {
                height: 200px;
                width: 470px;
                margin-top: 10px;
                padding: 15px;
                border: 1px solid #2f3338; 
                -webkit-border-radius: 20px;
                -moz-border-radius: 20px;
                border-radius: 20px;
                box-shadow: 10px 10px 5px grey;
            }

            #submitbutton {
                background-color:#ededed;
                -moz-border-radius:28px;
                -webkit-border-radius:28px;
                border-radius:28px;
                border:1px solid #dcdcdc;
                display:inline-block;
                cursor:pointer;
                color:#777777;
                font-family:Arial;
                font-size:17px;
                padding:7px 12px;
                text-decoration:none;
                text-shadow:0px 1px 0px #ffffff;
                user-select: none;
                -moz-user-select: none;
                -khtml-user-select: none;
                -webkit-user-select: none;
                -o-user-select: none;
            }
            #submitbutton:hover {
                background-color:#dfdfdf;
            }
            #submitbutton:active {
                position:relative;
                top:1px;
            }

        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VR Vacation - Chatbot</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">VR Vacations</a>         
        </nav>
        <div class="container-fluid">
            <h1>Chatbot</h1>
            <% String query = "";
        if (request.getParameter("query") != null) {
            query = request.getParameter("query");
        }
        %>
        <form action="ChatbotServlet" method="POST">
            <b>Your query: </b> <input type="text" name="query" value="<%= query %>" id="textinput" autocomplete="off"/>
            <input type="submit" value="Send" id="submitbutton" />
        </form>
              <%@ page import="java.io.*, javax.servlet.jsp.JspWriter"%>
<% JspWriter localOut = out; 

        localOut.println("<div><b>Answer: </b>");
	if (request.getAttribute("answer") != null) {
            localOut.println(" <div id=\"answer_con\"><h4>" + request.getAttribute("answer") + "</h4></div>");
        } else {
            localOut.println(" <div id=\"answer_con\"><h4></h4></div>");
        }

%>
        </div>
        
        
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </body>
</html>
