<%-- 
    Document   : policy
    Created on : 12-gen-2019, 16.41.41
    Author     : Federica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VR Vacation - Policy</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body>
        <div id="nav"></div>
        <div class="container-fluid">   
            <br><br>
            <h1>Virtual Travel Policy</h1><br><br>
            <h2>Technical requirements</h2><br>
            <p>To enjoy your Virtual Reality vacation make sure to use the latest generation Virtual Reality technology. VR Vacation is compatible with 
                Oculus Rift, HTC Vive and PlayStation VR systems. Download your favorite vacation package onto your Virtual Reality console from the Echo Store, HTC Store
                or PlayStore. Each purchase can be installed on maximum 5 consoles.</p><br><br>
            <h2>Medical recommendations</h2><br>
            <p>The prolonged use of Virtual Reality systems can cause nausea and motion sickness. Some of the experiences offered by VR Vacation take place
                in environments with flashing lights that may trigger epilepsy in predisposed individuals. Alcohol consumption and prescription drugs might
                aggravate the motion sickness effect. If you take any drugs consult with your physician before embarking on a VR Vacation. For a relaxing and 
                comfortable VR Vacation, avoid drinking alcohol for 3 hours prior to using your VR system. Avoid driving for half an hour after using VR Vacation.
            </p><br><br>
            <h2>Utilization</h2><br>
            <p>Use VR Vacation responsibly. VR Vacation is not legally responsible for any injuries occurred while using VR Vacation. Before starting a VR Vacation
                prepare a comfortable environment. Sit on a chair or couch. If your Vacation is adventurous, make sure you have space to move around freely.
                Remove any obstacles in your surroundings. For adventurous VR Vacation a free space of at least 20 square meters is recommended. Do not leave children under
                12 years old use VR Vacation unsupervised. Supervising is also recommended for users above 65 years old.</p><br><br><br>
        </div>
        <div id="chatbot" style="position: fixed; bottom: 10px; left: 90%"></div>
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
