<%-- 
    Document   : Status
    Created on : 12 Apr, 2016, 8:48:02 PM
    
--%>

<%@page import="java.sql.ResultSet"%>
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
        <table border="2" align="center" width="40%" bgcolor="skyblue">
        <tr><td align="center"><h4 align='right'><a href='Logout.jsp'>Logout</a></h4></td></tr>
        <tr><td align="center"><h4 align='right'><a href='Welcome.jsp'>Go back</a></h4></td></tr>
        </table>
        <table border="2" align="center" width="40%" bgcolor="skyblue">
        <%
        AllDAO ADAO=new AllDAO();
        String Appstatus="";
        int UID= ADAO.getUID((String)session.getAttribute("Loginuser"));
        //boolean status =ADAO.checkStatus(UID);
        ResultSet rs=ADAO.getStatement().executeQuery("select status from application where UID="+UID);
        while(rs.next()){ Appstatus=rs.getString("status");
        %>
        
            <%
            if(Appstatus.equalsIgnoreCase("Applied")) 
            {
            %>
            <tr><td align="center"><h1>Your have applied for a Passport</h1></td></tr>
            <%}
            else if(Appstatus.equalsIgnoreCase("Rejected"))
            {%>
              <tr><td align="center"><h1>Your application has been rejected.Please re-apply</h1></td></tr>
            <%}
            
            else if(Appstatus.equals("Approved"))
            {%>
            <tr><td align="center"><h1>Your application has been Approved.</h1></td></tr>
            <%}
            else if(Appstatus.equals("")) {%>
            <tr><td align="center"><h1>You have not applied for passport</h1></td></tr>
            <%}}%>
            
        </table>
    </body>
</html>
