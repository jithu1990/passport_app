<%-- 
    Document   : Logout
    Created on : 12 Apr, 2016, 9:28:23 PM
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <% session.invalidate(); 
           response.sendRedirect("Login.jsp");
        %>
    </body>
</html>
