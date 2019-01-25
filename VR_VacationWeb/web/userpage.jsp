<%-- 
    Document   : userpage
    Created on : 20-gen-2019, 20.58.00
    Author     : Federica
--%>

<%@page import="hibernate.Experience"%>
<%@page import="java.util.List, hibernate.Order, hibernate.Package"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body>
       
        <div id="nav"></div>
         <div class="container">
            <h2>Name: </h2>
            <h3><%= request.getAttribute("user_first_name")%></h3><h3><%= " " + request.getAttribute("user_last_name")%></h3><br>
            <h2>Email address: </h2>
            <h3><%= request.getAttribute("email_address")%></h3>
            <br><br>
        </div>
        <%
        String result = (String)request.getAttribute("result"); 
        List<Order> orders = (List<Order>)request.getAttribute("orders");
        List<Package> packages = (List<Package>)request.getAttribute("packages");
        List<Integer> nums = (List<Integer>)request.getAttribute("num");
        int counter = 0;
        int temp = 0;
        %>
        <h2><%=result%></h2>
        <br>
        <ul class="list-group">
            <% 
                for (int i = 0; i < orders.size(); i++) {           %>                
                    
                <li class="list-group-item" ><%=orders.get(i).getOrderId()%></li>
                <ul class="list-group">
                     <% 
                            //for (int j = counter; j < counter + nums.get(i); j++) {     
                            for (Package pack : orders.get(i).getPackages()) {%> 
                            <li class="list-group-item" ><%=pack.getName()%></li>
                            <%
                                //temp = j;
                             }
                             for (Experience exp : orders.get(i).getExperiences()) {%>
                                <li class="list-group-item" ><%=exp.getName()%></li>
                             <%}
                             //counter = temp + 1;%>
                </ul>
                <%}%>
            </ul>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script>
            $(function () {
                $("#nav").load("${pageContext.request.contextPath}/navBar.jsp");
            });
         </script>
    </body>
</html>
