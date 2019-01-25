<%-- 
    Document   : navBar
    Created on : 19-Jan-2019, 17:37:50
    Author     : felic
--%>

<%@page import="bean.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">VR Vacations</a>
            <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarHamburger">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarHamburger">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/VR_VacationWeb/">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li id="package" class="nav-item">
                        <a class="nav-link" href="/VR_VacationWeb/Packages">Packages</a>
                    </li>
                    <li id="destination" class="nav-item">
                        <a class="nav-link" href="/VR_VacationWeb/Destinations">Destinations</a>
                    </li>
                    <li id="policy" class="nav-item">
                        <a class="nav-link" href="/VR_VacationWeb/PolicyServlet">Policy</a>
                    </li>
                    <li id="faq" class="nav-item">
                        <a class="nav-link" href="/VR_VacationWeb/FAQServlet">FAQ</a>
                    </li>
                </ul>
                <ul class="navbar-nav navbar-right">
                    <li id="cart" class="disabled">
                        <a  class="navbar-brand" href="/VR_VacationWeb/ShoppingCart"><span class="fa fa-shopping-cart"></span>  Cart </a>
                    </li>
                    <li  id="signUp">
                        <a class="navbar-brand" href="/VR_VacationWeb/SignUp"><span class="fa fa-user"></span> Sign Up</a>
                    </li>
                    <li id="logIn">
                        <a  class="navbar-brand" href="/VR_VacationWeb/LogIn"><span class="fa fa-sign-in"></span> Login</a>
                    </li>
                    <%
                        UserBean userBean = new UserBean();
                        String username = userBean.getUserName();
                                if (userBean.checkIfUserLoggedIn()) {%>

                    <script>
                        $(function () {
                            $('#user').show();
                            $('#logIn').hide();
                            $('#signUp').hide();
                        });
                    </script>
                    <%}%>
                    <li id="user">
                        <a  class="navbar-brand hidden" ><span class="fa fa-user"></span> <%=username%> </a>
                    </li>
                </ul>  
            </div>
        </nav>
        <script>
            $(function () {
                var pageURL = window.location.pathname;
                switch (pageURL) {
                    case '/VR_VacationWeb/ShoppingCart':
                        $('#cart').hide();
                        break;
                    case '/VR_VacationWeb/SignUp':
                        $('#signUp').hide();
                        break;
                    case '/VR_VacationWeb/LogIn':
                        $('#logIn').hide();
                        break;
                    case '/VR_VacationWeb/Packages':
                        $('#package').addClass("active");
                        break;
                    case '/VR_VacationWeb/Destinations':
                        $('#destination').addClass("active");
                        break;
                }
            });

        </script>

    </body>
</html>
