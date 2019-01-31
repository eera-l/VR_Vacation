<%-- 
    Document   : faq
    Created on : 12-gen-2019, 16.42.01
    Author     : Federica
    Funct.     : GUI class for the FAQ page
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
        <div id="nav"></div>
        <div class="container-fluid" style="padding:0% 28%;">
            <div id="chatbot" style="position: fixed; bottom: 10px; left: 90%"></div>
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
