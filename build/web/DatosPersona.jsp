<%-- 
    Document   : DatosPersona
    Created on : 03-09-2016
    Author     : Daniel Mendoza
--%>


<%@page import="java.io.PrintWriter"%>
<%@page import ="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<% 
    DecimalFormat df = new DecimalFormat("#.##");
    
    //recibimos las variables enviadas por el servlet
    String nombre = (String) request.getSession().getAttribute("nombre");
    String genero = (String) request.getSession().getAttribute("genero");
    String edad = (String) request.getSession().getAttribute("edad");
    String estatura = (String) request.getSession().getAttribute("estatura");
    String peso = (String) request.getSession().getAttribute("peso");
    String imc = (String)request.getSession().getAttribute("imc"); 
    String pci = (String)request.getSession().getAttribute("pci"); 
    double[] ArrayImc = (double[]) request.getSession().getAttribute("ArrayImc");       
    String[] ArrayPesos = (String[]) request.getSession().getAttribute("ArrayPesos");               
    double[] ArrayEstatura = (double[]) request.getSession().getAttribute("ArrayEstatura"); 
    String promedioImc = (String) request.getSession().getAttribute("promedioImc");
    String promedioPeso = (String) request.getSession().getAttribute("promedioPeso");
    String promedioEstatura = (String) request.getSession().getAttribute("promedioEstatura");
    String clasificacion = (String) request.getSession().getAttribute("clasificacion");
    String resultado = (String) request.getSession().getAttribute("resultado");
    
 %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <div class="exp"><center>
                <img src="css/img/logo.png" align="center" class="logo" ><br><br>
                <h2>Gracias <%= nombre%> por utilizar MedCal</h2>
                <h2>estos son los datos que ingresaste.</h2>
                <br>
                <br>
                Datos personales:
                <table id='rounded-corner'>
                    <tr>
                        <th>Dato</th>
                        <th>Registro</th>
                    </tr>
                    <tr>
                        <td>Nombre:</td>
                        <td><%=nombre %></td>
                    </tr>
                    <tr>
                        <td>Genero:</td>
                        <td><%=genero %></td>
                    </tr>
                    <tr>
                        <td>Edad:</td>
                        <td><%=edad %></td>
                    </tr>
                    <tr>
                        <td>Estatura:</td>
                        <td><%=estatura %> m</td>
                    </tr>
                    <tr>
                        <td>Peso</td>
                        <td><%=peso %> kg</td>
                    </tr>
                    <tr>
                        <td>Imc</td>
                        <td><%=imc %></td>
                    </tr>
                    <tr>
                        <td>Clasificación</td>
                        <td><%=clasificacion %></td>
                    </tr>
                    <tr>
                        <td>En seis meses</td>
                        <td><%=resultado %></td>
                    </tr>
                    <tr>
                        <td>Pci</td>
                        <td><%=pci %></td>
                    </tr>
                </table>
                    <br><br>
                    Tabla Imc:
                    <table id='rounded-corner'>
                        <tr>
                            <th>IMC</th>
                            <th>Clasificacion</th>
                        </tr>
                        <tr>
                            <td>Menor a 16.00</td>
                            <td>Infrapeso: Delgadez severa</td>    
                        </tr>
                        <tr>
                            <td>16.00 - 16.99</td>
                            <td>Infrapeso: Delgadez moderada</td>    
                        </tr>
                        <tr>
                            <td>17.00 - 18.49</td>
                            <td>Infrapeso: Delgadez aceptable</td>    
                        </tr>
                        <tr>
                            <td>18.50 - 24.99</td>
                            <td>Peso normal</td>    
                        </tr>
                        <tr>
                            <td>25.00 - 29.00</td>
                            <td>Sobrepeso</td>    
                        </tr>
                        <tr>
                            <td>30.00 - 34.99</td>
                            <td>Obeso: Tipo I</td>    
                        </tr>
                        <tr>
                            <td>35.00 - 40.00</td>
                            <td>Obeso: Tipo II</td>    
                        </tr>
                        <tr>
                            <td>Mayor a 40.00</td>
                            <td>Obeso: Tipo III</td>    
                        </tr>
                    </table>    
                    <br><br>
                    Datos historicos:
        <% 
        int cont = 1;
        
                out.println("<table id='rounded-corner'>");
                    out.println("<tr>");
                        out.println("<th></th>");
                        out.println("<th>Estatura</th>");
                        out.println("<th>Peso</th>");
                        out.println("<th>Imc</th>");
                    out.println("</tr>");
                    
                    //Ciclo for que recorre los arrays para mostrar su contenido
                    for(int i=0;i<6;i++){
                    out.println("<tr>");
                        out.println("<td>Mes "+cont+"</td>");
                        out.println("<td>"+ArrayEstatura[i]+" m</td>");
                        out.println("<td>"+ArrayPesos[i]+" kg</td>");
                        out.println("<td>"+df.format(ArrayImc[i])+"</td>");
                    out.println("</tr>");
                    cont++;
                    }
                    out.println("<tr>");
                        out.println("<td>Promedios</td>");
                        out.println("<td>"+promedioEstatura+"</td>");
                        out.println("<td>"+promedioPeso+"</td>");
                        out.println("<td>"+promedioImc+"</td>");
                    out.println("</tr>");
                out.println("</table>");  
        %>
        <h2>¿Deseas calcular con otros datos?</h2>
        <button type="button" onclick="location='IngresoDatos1.html'">Calcular</button>
            </center></div></body>
</html>
