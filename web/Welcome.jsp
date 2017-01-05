<%-- 
    Document   : Welcome
    Created on : 12 Apr, 2016, 12:27:41 AM
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demo Passport Application</title>
<style type="text/css">
body {
background: 
url("\Passport.jpg") right 0 repeat-y,
url("\Passport.jpg") left 0 repeat-y;
}

</style>        
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <table border="2" align="center" width="30%" height="50%" bgcolor="skyblue">
            <tr><td align="center"><h1>Welcome <%= session.getAttribute("Loginuser") %></h1></td></tr>
            <tr><td align="center"><a href="Apply.jsp">Apply for passport here</a></td></tr>
            <tr><td align="center"><a href=Status.jsp>View Status of your Application</a></td></tr>
            <tr><td align="center"><a href='Logout.jsp'>Logout</a></td></tr>
        </table>
    </body>
</html>
