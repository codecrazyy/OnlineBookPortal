/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AparnaHarish
 */
@WebServlet(name = "payment", urlPatterns = {"/payment"})
public class payment extends HttpServlet {
 ServerInterface serverObject;
 String bname,cc,err;
           int bno=0,temp;
           List result=new ArrayList();
           float tcost, cost=0; //total cost= cost*num  of books user wants;
    
    @Override
    public void init(ServletConfig config)
          throws ServletException
    {
        try {
            int port=5555;
                   
                           Registry registry = LocateRegistry.getRegistry("localhost", 5005);  


                   serverObject = ( ServerInterface )
       Naming.lookup( "rmi://localhost:5005/Server" );
                    System.out.println( "connected to server: " + 
                                        serverObject.greetings( ) );
        } catch (IOException ex) {
            Logger.getLogger(yourbookstore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(yourbookstore.class.getName()).log(Level.SEVERE, null, ex);
        }    
             
    }

	 //   ClientInterface clientObject = new ClientImplementation();

	   // serverObject.registerForCallback( clientObject );

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet payment</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet payment at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String uname=request.getParameter("Name") ;
         System.out.println("Your name" +uname);
         String addr=request.getParameter("add") ;
         System.out.println("Your address" +addr);
         request.setAttribute("uname",uname) ;
         request.setAttribute("addr",addr);
        String sharedID =(String) request.getSession().getAttribute("sharedID") ;
         String temp= (String)request.getSession().getAttribute("temp");
         int t=Integer.parseInt(temp);
         System.out.println(sharedID);
         serverObject.updadb(sharedID,t);
         //request.getAttribute("sharedId");
                  System.out.println(t);

           RequestDispatcher view4= request.getRequestDispatcher("resp1.jsp");
           view4.forward(request,response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
    }

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
