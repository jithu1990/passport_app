<%-- 
    Document   : Apply
    Created on : 12 Apr, 2016, 12:37:23 PM
    
--%>

<%@page import="com.passport.application.DAO.AllDAO"%>
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
        <h4 align='right'><a href='Welcome.jsp'>Go back</a></h4>
        <h1 align='center'>Please fill the following details</h1>
        <% response.addHeader("cache-control", "no-cache");
           response.addHeader("cache-control", "no-store");
            AllDAO ad=new AllDAO();
            String ACSRF= ad.getToken();
            session.setAttribute("ACSRF", ACSRF);
        %>
        <form action="PassportApply" method="post">
            <table border="2" align="center" width="25%" height="50%" bgcolor="skyblue">
            <tr><td>Given Name</td><td><input type="text" name="givenName"/></td></tr>
            <tr><td>Sir Name</td><td><input type="text" name="sirName"/></td></tr>
            <tr><td>Father's Name</td><td><input type="text" name="FatherName"/></td></tr>
            <tr><td>Mother's Name</td><td><input type="text" name="MotherName"/></td></tr>
            <tr><td>Place Of Birth</td><td><input type="text" name="PlaceBirth"/></td></tr>
            <tr><td>Address</td><td><input type="text" name="Address"/></td></tr>
            <tr><td>Pin Code</td><td><input type="text" name="PinCode"/></td></tr>
            <tr><td>E-Mail</td><td><input type="text" name="Email"/></td></tr>
            <tr><td>Phone</td><td><input type="text" name="Phone"/></td></tr>
            <input type="hidden" name="ACSRF" value=<%=ACSRF%> />
            <tr><td><input type='reset' value='Reset' style/></td><td><input type="submit" value="Apply"/></td></tr>
            
            <tr><td align="center"><%  
            if(null!=request.getAttribute("errorMessage"))
            {
            out.println(request.getAttribute("errorMessage"));
            }
            %></td></tr>
            
            </table>
        </form>
    </body>
</html>
