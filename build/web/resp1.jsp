<%-- 
    Document   : resp1
    Created on : Mar 8, 2012, 11:25:26 AM
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
        <br><br>
    <center>
    <%
     String uname= (String)request.getAttribute("uname");
      String addr= (String)request.getAttribute("addr");
      out.println("Book will be shipped to : ");
              %>
              <br>
              <br>
              <%
        out.println(uname);
      out.println(addr);
        %>
        <br><br>
    Book will be shipped in 5 days
    </center>
    </body>
</html>
