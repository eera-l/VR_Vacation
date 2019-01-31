<%-- 
    Document   : chatbot_jsp
    Created on : 12-gen-2019, 19.09.54
    Author     : Federica
    Funct.     : GUI class for the chatbot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
    </head>
    <body>
        <div class="container-fluid">
            <button id="chatButton" type="button" class="btn btn-info" data-container="body" 
                    data-toggle="popover" data-placement="left" 
                    data-html="true" href="#">
                ChatBot
            </button>

        </div>
        <script>
            var popoverContent = 
                    '<div id="popover-content" class="container-fluid">' +
                        '<h1>Chatbot</h1>' +
                        '<div class="form-group">'+
                            '<label>Your query: </label>' +
                            '<input class="border rounded" type="text" name="query" id="textInput" autocomplete="off"/>' +
                        '</div>'+
                        
                        '<div class="form-group">'+
                            '<button id="submit" class="btn btn-info">Send</button>' +
                        '</div>'+

                        '<div class="form-group">' +
                            '<label>Answer: </label>' +
                             '<div class="border rounded" >' +
                                '<p  style="margin-bottom: 1em;" id="answer">here comes you answer...</p>' +
                             '</div>' +
                        '</div>' +
                    '</div>';

            $("[data-toggle=popover]").popover({
                html: true,
                content: function () {
                    $(function () {
                        $('#submit').click(function (event) {
                            var query = $('#textInput').val();
                            $.get('Chatbot', {query: query}, function (responseText) {
                                $('#answer').text(responseText);
                            });
                        });
                    });
                    return popoverContent;
                }
            });


        </script>
    </body>
</html>

