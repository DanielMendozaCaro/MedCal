package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public final class DatosPersona_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
    DecimalFormat df = new DecimalFormat("#.##");
    

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
 
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Datos</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/estilos.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"exp\"><center>\n");
      out.write("        <h1>Nombre ");
      out.print(nombre );
      out.write("</h1><br>\n");
      out.write("        <h1>Genero ");
      out.print(genero );
      out.write("</h1><br>\n");
      out.write("        <h1>Edad ");
      out.print(edad );
      out.write("</h1><br>\n");
      out.write("        <h1>Estatura ");
      out.print(estatura );
      out.write("</h1><br>\n");
      out.write("        <h1>Peso ");
      out.print(peso );
      out.write("</h1><br>\n");
      out.write("        <h1>Imc ");
      out.print(imc );
      out.write("</h1><br> \n");
      out.write("        <h1>Pci ");
      out.print(pci );
      out.write("</h1><br>\n");
      out.write("        ");
 
        int cont = 1;
        
                out.println("<table id='rounded-corner'>");
                    out.println("<tr>");
                        out.println("<th></th>");
                        out.println("<th>Estatura</th>");
                        out.println("<th>Peso</th>");
                        out.println("<th>Imc</th>");
                    out.println("</tr>");
                    
                    //Ciclo for que recorre los arrays
                    for(int i=0;i<6;i++){
                    out.println("<tr>");
                        out.println("<td>Mes "+cont+"</td>");
                        out.println("<td>"+ArrayEstatura[i]+"</td>");
                        out.println("<td>"+ArrayPesos[i]+"</td>");
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
        
      out.write("\n");
      out.write("            </center></div></body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
