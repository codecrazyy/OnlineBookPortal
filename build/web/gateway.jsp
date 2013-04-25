<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : gateway
    Created on : Mar 8, 2012, 10:24:03 AM
    Author     : AparnaHarish
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <div id="container" >

<div id="header" style="background-color:#000000;">
   
    <font size="5" face="arial" color="white">

<h1 style="margin-bottom:0;">Bargain Books</h1><br>
Buy books at great deals                         
</div>
        <font size="5" face="arial" color="black">

        <div id="body">
<div id="menu" style="width:300px;float:left;">
    <b><a href="booksearch.jsp">BookSearch</a></b><br /> </div>
<div id="men" style="width:300px;float:left;">
BestSellers<br>
</div>
     <div id="me" style="width:300px;float:left;">   
Sell your books<br>
     </div>
                   <div id="menu" style="width:300px;float:left;">
    <b><a href="index.jsp">Home</a></b><br /> </div>
        </div>
    </div>
        <div id="bb"><br><br><br>
        <font size="5" face="arial" color="black">
        <center>
            <form method="GET"
action=http://localhost:8080/ahbooks/payment>
         
          <%
     Float tcost= (Float)request.getAttribute("tcost");
     String bname=(String)request.getAttribute("bname");
     request.getSession().setAttribute("sharedID",bname);
        out.println("Total Cost : $" +tcost);
        out.println("for book "+bname);
        %>
        <br>        <br>
               
                <input type="hidden" name="hn" value="bname" size="30" readonly="readonly" />
Name : <input type="text" name="Name" value="" size="50" /><br>
             Credit Card : <input type="text" name="cc" value="" size="50" /><br>
             Expiry Date (mm/dd/yyyy): <input type="text" name="ed" value="" size="10" /><br>
             Card Security Code : <input type="text" name="ccc" value="" size="5" /><br>
             Address: <textarea name="add" rows="4" cols="20"></textarea><br><br>

                <input type="Submit" value=" BUY NOW ">
                <br>
                <br><br>
                <img src="visa.png" width="223" height="58" alt="visa"/>

             </center>
    </div>
    </body>
</html>
