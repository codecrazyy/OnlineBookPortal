<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : result
    Created on : Feb 28, 2012, 2:00:28 PM
    Author     : AparnaHarish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
    <body>
        
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
        <p>
            <div id="about">    
                <div id="part2" style="width:600px;float:left;">
                    <br><br><br><br><br>
        <%
        List styles= (List)request.getAttribute("styles");
        Iterator it= styles.iterator();
        while(it.hasNext())
                       {
                        out.println("Book  "+it.next()+"\n");   
            %>
            <br><br>
            <%
            out.println("Author  "+it.next()+"\n");
             %>
            <br><br>
            <%
            out.println("Publisher  "+it.next()+"\n");
             %>
            <br><br>
            <%
            out.println("Amazon Rating  "+it.next()+"\n");
            
             %>
            <br><br>
            <%
            out.println("Cost  $"+it.next()+"\n");
             %>
            <br><br>
            <%
            out.println("Books in stock "+it.next()+"\n");
            
                       }
        %>
        <br><br>
        <font size="5" face="arial" color="black">
        <form method="GET"
action=http://localhost:8080/ahbooks/yourbookstore>
        Number of Books 
        <input type="text" name="num" value="1" size="10" />
                <input type="Submit" value=" BUY ">
                </div>
        
            </div>

    </body>
</html>
