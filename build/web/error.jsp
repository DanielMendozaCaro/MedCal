<%--  
    Document   : Pagina de error
    Created on : 03-09-2016 
    Author     : Daniel Mendoza
--%>

<%
    String error = (String)request.getSession().getAttribute("error");
%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/estilos.css"> 
         <title>Error</title>
    </head>
    <body>
        <div class="exp">
            <center>
        <h1>Ha ocurrido un error: </h1>
        <h2> <%=error %></h2>
        <br>
        <img src="css/img/error.png" class="accion">
        <br>
        <button type="button" onclick="location='IngresoDatos1.html'">Volver</button>
            </center>
        </div>
    </body>
</html>
