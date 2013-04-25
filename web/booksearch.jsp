<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : Feb 27, 2012, 10:05:39 PM
    Author     : AparnaHarish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bookstore Page</title>
    </head>
    <body>
        

        
        <div id="container">

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
        <br> <br> <br> <br> <br>
	
    <center><img src="books-arent-dead.jpg" width="200" height="100" alt="books-arent-dead"/>
    </center>
         <form method="POST"
action=http://localhost:8080/ahbooks/yourbookstore>
        <center>
Search for the book titled
<input type="text" name="categ" value="" size="50" />
<input type="Submit" value="Search">
</center>
<br> <br>
<center>


</center>
             
       
    </body>
</html>
