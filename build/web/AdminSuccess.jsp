<%-- 
    Document   : AdminSuccess
    Created on : 14 Apr, 2016, 12:47:14 AM
    
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
    <h4 align='right'><a href='Logout.jsp'>Logout</a></h4>
    <h4 align='right'><a href='PassportAdmin.jsp'>Go back</a></h4>
        
    <h4 align="center"><%  
    if(null!=request.getAttribute("Message"))
    {
        out.println(request.getAttribute("Message"));
    }
    %></h4>
    </body>
</html>
