<%-- 
    Document   : error
    Created on : Mar 8, 2012, 9:41:54 AM
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
        <br><br><br>
        <font size="10" face="arial" color="black">
    <%
     String err= (String)request.getAttribute("err");
        out.println(err);
        %>
    </div>
    </body>
</html>
