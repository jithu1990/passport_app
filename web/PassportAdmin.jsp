<%-- 
    Document   : PassportAdmin
    Created on : 13 Apr, 2016, 10:26:37 PM
    
--%>

<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
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
        <h4 align='right'><a href='Logout.jsp'>Logout</a></h4>
        <h1 align='center'>Please Approve/Reject below applications</h1>
        <table border="2" align="center" width="40%" bgcolor="skyblue">
        <THEAD align='left'> <TR> <TH>UID</TH> <TH>Given Name</TH> <TH>E-mail</TH> <TH>Address</TH> <TH>Approve</TH> <TH>Reject</TH></TR> </THEAD>

        <% 
           AllDAO ADAO=new AllDAO();
           String UID,Name,Email,Address;
           ResultSet rs=ADAO.getStatement().executeQuery("select * from application where status='Applied'");
        while(rs.next())
        { %>
        <tr>
            <td><%=rs.getString("uid")%></td>
         <td><%=rs.getString("gname")%></td>
         <td><%=rs.getString("email")%></td>
         <td><%=rs.getString("address")%></td>
         <td><a href="AdminApproval?UID=<%=rs.getString("uid")%>&Name=<%=rs.getString("gname")%>&Status=Approved"><button type="button">Approve</button></a></td>
         <td><a href="AdminApproval?UID=<%=rs.getString("uid")%>&Name=<%=rs.getString("gname")%>&Status=Rejected"><button type="button">Reject</button></a></td>
        </tr>
       <% }
         %>
        </table>
    </body>
</html>
