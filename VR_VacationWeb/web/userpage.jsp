<%-- 
    Document   : userpage
    Created on : 20-gen-2019, 20.58.00
    Author     : Federica
    Funct.     : GUI class for the userpage. Displays
                 user info and history of orders
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
            <%
                String result = "";
                if (request.getAttribute("result") != null) {
                    result = (String) request.getAttribute("result");
                }
                List<Order> orders = null;
                if (request.getAttribute("orders") != null) {
                orders = (List<Order>) request.getAttribute("orders"); 
                }
                
            %>

            <div class="text-center">
                <h2>Order History</h2>
            </div>
            <div class="container">
                <div class="row" style=" margin-left:10px">
                    <div class="col-xs-2">
                        <h3 style="font-style: bold;"> Name: </h3>
                    </div>
                    <div class="col-sm-8">
                        <h3> ${user_first_name} ${user_last_name} </h3>
                    </div>
                </div>
                <div class="row" style=" margin-left:10px">
                    <div class="col-xs-2">
                        <h3 style="font-style: bold;"> Email address: </h3>
                    </div>
                    <div class="col-sm-8">
                        <h3>${email_address}</h5>
                    </div>
                </div>
                <div>
                    <br>
                    <h2><%=result%></h2>
                </div>
            </div>

            <div>
                <br>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Order number</th>
                            <th>Package</th>
                            <th>Experience</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%if (orders != null) {
                            for (int i = 0; i < orders.size(); i++) {%>    
                        <tr>

                            <td>
                                <div><%=orders.get(i).getOrderId()%></div>
                            </td>


                            <%      
                                for (Package pack : orders.get(i).getPackages()) {%> 

                            <td>
                                <div><%=pack.getName()%></div>
                            </td>
                            <%
                                    
                                }
                                for (Experience exp : orders.get(i).getExperiences()) {%>

                            <td>
                                <div><%=exp.getName()%></div>
                            </td>
                            <%}
                                %>

                        </tr>
                        <%} }%>
                    </tbody>
                </table>

                </ul>
            </div>
        </div>
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
