<%-- 
    Document   : faq
    Created on : 12-gen-2019, 16.42.01
    Author     : Federica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VR Vacation - FAQ</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
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
                        <a class="nav-link" href="${pageContext.request.contextPath}/">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Packages">Packages</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Destinations">Destinations</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Policy">Policy</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Faq">FAQ</a>
                    </li>
                </ul>
                <ul class="navbar-nav navbar-right">
                    <li>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/ShoppingCart"><span class="fa fa-shopping-cart"></span> Cart</a>
                    </li>
                    <li>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/SignUp"><span class="fa fa-user"></span> Sign Up</a>
                    </li>
                    <li>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/LogIn"><span class="fa fa-sign-in"></span> Login</a>
                    </li>
                </ul>  
            </div>
        </nav>
        <div class="container-fluid" style="padding:0% 28%;">
            <br><br><h1>FAQ</h1><br><br>
            <h3>On which consoles can I use VR Vacation?</h3><br>
            <p>You can use it on Oculus GO, HTC Vive and PlayStation VR systems.</p><br>
            <h3>On how many systems can I install my VR Vacation?</h3><br>
            <p>You can install your VR Vacation on up to 5 consoles.</p><br>
            <h3>Can I be refunded for my purchase?</h3><br>
            <p>Yes, you can receive a total refund if the request is done within 14 days from the purchase and if the vacation has been 
            played for less than 3 hours.</p><br>
            <h3>Can I go on a virtual vacation offline?</h3><br>
            <p>No, to be able to use VR Vacation a connection to the Internet is necessary.</p><br>
            <h3>Can I use VR Vacation if I suffer from epilepsy?</h3><br>
            <p>Yes, VR vacation offers a variety of packages that are safe for users with epilepsy.</p><br>
            <h3>Can I add an experience after buying a vacation?</h3><br>
            <p>No, this is not possible at the moment. Please make sure to add all the experiences you plan on doing when you
            make an order.</p><br>
            <h3>Can I see my past orders?</h3><br>
            <p>Yes, you can see a history of your orders by visiting your account page.</p><br>
            <h3>How can I contact you?</h3><br>
            <p>If you have any questions you're welcome to contact us by sending an email to <a href="vr_vacation@hotmail.com">vr_vacation@hotmail.com</a>.</p><br><br>
        </div>
               
<a href='#'style="position: fixed; left: 90%; bottom: 0; width: 10%; background-color: #2f3338; color: white; text-align:center;"
 onclick='javascript:window.open("chatbot_jsp.jsp", "_blank", "scrollbars=1,resizable=1,height=400,width=500");' title='Chatbot'>Chatbot</a>      
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </body>
</html>
