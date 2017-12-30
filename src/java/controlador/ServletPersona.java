/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;


import modelo.Persona;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Daniel Mendoza 
 */
@WebServlet(name = "ServletPersona", urlPatterns = {"/ServletPersona"})
public class ServletPersona extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        // Configurar el formato de los decimales
        DecimalFormat df = new DecimalFormat("#.##");
        
        //arrays para realizar los calculos
        double[] pesosArrayDbl = new double[6];
        double[] estaturaArrayDbl = new double[6];
        
        //recibir los datos ingresados por el usuario
        String nombre = request.getParameter("Nombre");
        String apellidoPat = request.getParameter("ApellidoPat");
        String apellidoMat = request.getParameter("ApellidoMat");
        String genero = request.getParameter("Genero");
        String edad = request.getParameter("Edad");
        String estatura = request.getParameter("Estatura");
        String peso = request.getParameter("Peso");
        
        //recibir los datos ingresados por el usuario 
        String[] pesosArray = new String[6]; 
        pesosArray[0] = request.getParameter("Peso");
        pesosArray[1] = request.getParameter("Peso1");
        pesosArray[2] = request.getParameter("Peso2");
        pesosArray[3] = request.getParameter("Peso3");
        pesosArray[4] = request.getParameter("Peso4");
        pesosArray[5] = request.getParameter("Peso5"); 
        
        //recibir los datos ingresados por el usuario
        String[] estaturaArray = new String[6]; 
        estaturaArray[0] = request.getParameter("Estatura");
        estaturaArray[1] = request.getParameter("Estatura1");
        estaturaArray[2] = request.getParameter("Estatura2");
        estaturaArray[3] = request.getParameter("Estatura3");
        estaturaArray[4] = request.getParameter("Estatura4");
        estaturaArray[5] = request.getParameter("Estatura5"); 
        

        //Validar campos vacios
        if (nombre.equals("") || apellidoPat.equals("") ||  apellidoMat.equals("") || genero.equals("") || 
                edad.equals("") || estatura.equals("") || peso.equals("") ){
            
            //Envio a la pagina de error
            String error = "Existen campos sin completar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        
        }else{
            
                //validar datos vacios dentro de los array
        for(int i=0 ; i < estaturaArray.length ; i++){
            if(pesosArray[i].isEmpty() || estaturaArray[i].isEmpty()){
                
                //Envio a la pagina de error
                String error = "Existen campos sin completar";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                
            }
        } // fin bloque for
 
        
            //declaracion de variables para 'parsear'
            int edadInt = 0;
            double estaturaDbl= 0;
            double pesoDbl= 0;
  
            try
            {
                edadInt = Integer.parseInt(edad);
                estaturaDbl = Double.parseDouble(estatura);
                pesoDbl = Double.parseDouble(peso);
                
                //Convertir a double los datos de los arrays
                for(int a=0; a < pesosArrayDbl.length;a++){
                    pesosArrayDbl[a] = Double.parseDouble(pesosArray[a]);
                    estaturaArrayDbl[a] = Double.parseDouble(estaturaArray[a]);
                }
            }
            catch(NumberFormatException ex){
                //envio a la pagina de error
                String error = "Por favor ingrese solo numeros en los campos estatura y peso";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } //fin bloque try-catch
            
            
            //array que contendra los imc historicos
            double[] imcArray = new double[6];
            
            //Variable que contendran datos estadisticos
            double promedioPeso = 0;
            double promedioEstatura = 0;
            double promedioImc = 0;
            double Imc;
            double Pci;
            
            //Calculos
            for(int e=0;e<pesosArray.length;e++){
                estaturaArrayDbl[e] = estaturaArrayDbl[e] / 100; 
                imcArray[e] = pesosArrayDbl[e] / Math.pow(estaturaArrayDbl[e], 2);
                
                
                promedioImc = promedioImc + imcArray[e];
                promedioEstatura = promedioEstatura + estaturaArrayDbl[e];
                promedioPeso = promedioPeso + pesosArrayDbl[e];
            }
            
                promedioImc = promedioImc / 6;
                promedioEstatura = promedioEstatura / 6 ;
                promedioPeso = promedioPeso / 6; 
                
                estaturaDbl = estaturaDbl / 100;
                Imc = pesoDbl / Math.pow(estaturaDbl, 2);
                
                if ("Femenino".equals(genero)){
                    Pci = 21.5 * Math.pow(estaturaDbl, 2);
                }else{
                    Pci = 23 * Math.pow(estaturaDbl, 2);
                }
               
                //calcular clasificacion imc
                String clasificacion = "";
                if (Imc < 16.00) clasificacion = "Infrapeso: Delgadez severa";
                if (16.00 <= Imc && Imc <= 16.99) clasificacion = "Infrapeso: Delgadez moderada";
                if (17.00 <= Imc && Imc <= 18.49) clasificacion = "Infrapeso: Delgadez aceptable";
                if (17.00 <= Imc && Imc <= 18.49) clasificacion = "Infrapeso: Delgadez aceptable";
                if (18.50 <= Imc && Imc <= 24.99) clasificacion = "Peso normal";
                if (25.00 <= Imc && Imc <= 29.99) clasificacion = "Sobrepeso";
                if (30.00 <= Imc && Imc <= 34.99) clasificacion = "Obeso: Tipo I";
                if (35.00 <= Imc && Imc <= 40.00) clasificacion = "Obeso: Tipo II";
                if (40.00 < Imc) clasificacion = "Obeso: Tipo III";
                
                //Calcular aumento o disminucion de peso
                String resultado = "";
                if(pesoDbl==pesosArrayDbl[5]) resultado = "has matenido tu mismo peso";
                if(pesoDbl<pesosArrayDbl[5]) resultado = "disminuyo tu peso en " + String.valueOf(pesosArrayDbl[5] - pesoDbl) + " kg";
                if(pesoDbl>pesosArrayDbl[5]) resultado = "aumento tu peso en " + String.valueOf(pesoDbl - pesosArrayDbl[5]) + " kg";
                
          
            
            //enviar datos a constructor de la clase persona
           Persona per = new Persona(nombre, apellidoPat, apellidoMat, genero, edadInt, estaturaDbl, pesoDbl);
           
           //enviar datos a la pagina jsp 
           request.getSession().setAttribute("nombre",per.getNombre() + " " + per.getApellidoPat() + " " + per.getApellidoMat());
           request.getSession().setAttribute("genero", per.getGenero());
           request.getSession().setAttribute("edad", edad);
           request.getSession().setAttribute("estatura", df.format(per.getEstatura()));
           request.getSession().setAttribute("peso", df.format(per.getPeso()));
           request.getSession().setAttribute("imc", df.format(Imc)); 
           request.getSession().setAttribute("pci", df.format(Pci));
           request.getSession().setAttribute("ArrayImc", imcArray);
           request.getSession().setAttribute("ArrayPesos", pesosArray);
           request.getSession().setAttribute("ArrayEstatura", estaturaArrayDbl);
           request.getSession().setAttribute("promedioImc", df.format(promedioImc));
           request.getSession().setAttribute("promedioPeso", df.format(promedioPeso));
           request.getSession().setAttribute("clasificacion", clasificacion);
           request.getSession().setAttribute("resultado", resultado);
           request.getSession().setAttribute("promedioEstatura", df.format(promedioEstatura));
           
           //redireccionar a jsp
           request.getRequestDispatcher("DatosPersona.jsp").forward(request, response);
            
        } //fin bloque if-else
        
        
    }//fin metodo dopost

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
