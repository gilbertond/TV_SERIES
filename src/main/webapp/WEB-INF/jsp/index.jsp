<%-- 
    Document   : index
    Created on : Aug 8, 2017, 4:26:56 PM
    Author     : gilberto
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EA-PROJ</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div style="background-color: #ffffff" class="container">
            <hr/>
            <div class="row">
                <div align="center" class="header panel alert-block alert-success"><!--style="background-color: #cc5c10;"-->
                    <h1>${data.subscriber[0]}</h1>
                    <h4 style="color: #000;font-style: italic">Your TV Series</h4>
                    <!--p>resize</p-->                
                    <div style="display: inline" align="center" class="alert alert-block alert-success">

                    </div>                                    
                </div>
            </div>
            <hr style="display: none"/>
            <div class="borderedTB">
                <div style="margin-left: 10px" class="row">
                    <h4>Select Option</h4>
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a data-toggle="tab" href="#home">Home</a>
                        </li>
                    </ul>                                
                </div>
                <div align="center" style="min-height: 200px;" class="tab-content">
                    <div id="home"  class="tab-pane fade in active">
                        <div align="center" style="width: 80%" class="input-group text-center">
                            Welcome content goes here      : ${msg}                  
                        </div>
                    </div>                    
                    <input type="hidden" id="dataholder"/>
                    <input type="hidden" id="idholder"/>
                    <input type="hidden" id="tid"/>
                    <p>
                    <hr style="display: none"/>
                    <div align="left" id="resultsDiv" class="">                    
                        <br/>
                    </div>                
                </div>           
            </div>
            <footer class="blockquote-reverse text-center">Copyright &copy; <fmt:formatDate pattern="YYYY" value="${data.today}"/></footer>   
        </div>
    </body>
</html>
