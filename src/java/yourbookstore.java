/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.rmi.*;

import java.net.*; 
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.servlet.ServletConfig;

/**
 *
 * @author AparnaHarish
 */
@WebServlet(name = "yourbookstore", urlPatterns = {"/yourbookstore"})
public class yourbookstore extends HttpServlet {
   ServerInterface serverObject;
 public String bname,cc,err;
         public  int bno=0,temp;
           public List result=new ArrayList();
           public float tcost, cost=0; //total cost= cost*num  of books user wants;
    
    @Override
    public void init(ServletConfig config)
          throws ServletException
    {
        try {
       
                   
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
            out.println("<title>Servlet yourbookstore</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet yourbookstore at " + request.getContextPath() + "</h1>");
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
     //   processRequest(request, response);
        
              Iterator it1= result.iterator();
           while(it1.hasNext())
                       {
                           bname = (String) it1.next();
                          
                        //out.println("Book  "+it.next()+"\n");   
                         System.out.println("Author  "+it1.next()+"\n");
            System.out.println("Publisher  "+it1.next()+"\n");
             System.out.println("Rating  "+it1.next()+"\n");
            //cc= (String)it1.next();
            //cost=Float.parseFloat(cc);
            //cc= (String)it1.next();
            //bno=Integer.parseInt(cc);
             cost=((Float)it1.next()).floatValue();
             bno=((Integer)it1.next()).intValue();
           //tcost=cost*bno;
             
                       }
           
        String num=request.getParameter("num") ;
      // System.out.println("no of books"+num);
        temp=Integer.parseInt(num);
        System.out.println("temp no"+temp);
        System.out.println("bno no"+bno);
        System.out.print("Name"+bname);
          //  request.getSession().setAttribute("sharedId", bname); // add to session

        request.getSession().setAttribute("temp",num);

        if(temp>bno)
        {
            err="Books out of Stock";
                    request.setAttribute("err",err) ;
           RequestDispatcher view3= request.getRequestDispatcher("error.jsp");
           view3.forward(request,response);
        return;
           // System.out.println(err);
        }
        else
        {
            tcost=temp*cost;
            System.out.println("total cost"+tcost);
            request.setAttribute("tcost",tcost) ;
            request.setAttribute("bname",bname);
            
           RequestDispatcher view1= request.getRequestDispatcher("gateway.jsp");
           view1.forward(request,response);
        
        
        
 
        }
        
         
      // int avail= serverObject.getavail(num);
       
         //request.setAttribute("styles",avail) ;
          // RequestDispatcher view1= request.getRequestDispatcher("result1.jsp");
          // view1.forward(request,response);
           
       
	/*}
	catch ( Exception e ) {
	    e.printStackTrace( );
	    System.exit( -1 );
	}*/
        
    
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
        // processRequest(request, response);
        // response.setContentType("text/html;charset=UTF-8");
        //    P//rintWriter out = response.getWriter();
        // out.println("Choose a category <br>");
        /*
         * try {
         *
         * int port=5555; ServerInterface serverObject = ( ServerInterface )
         * Naming.lookup( "rmi://localhost:" + port + "/Server" );
         * System.out.println( "connected to server: " + serverObject.greetings(
         * ) );
         */

        //   ClientInterface clientObject = new ClientImplementation();

        // serverObject.registerForCallback( clientObject );

        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            e.printStackTrace();
            hostname = "unknown";
        }


        String c = request.getParameter("categ");

        System.out.println("Got input" + c);
        result = serverObject.getdetails(c);
        if (result.isEmpty()) {
            err = "Book not Found";
            request.setAttribute("err", err);
            RequestDispatcher view2 = request.getRequestDispatcher("error.jsp");
            view2.forward(request, response);
            return;
        } else {
            request.setAttribute("styles", result);
            RequestDispatcher view = request.getRequestDispatcher("result.jsp");
            view.forward(request, response);
            return;
        }
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
