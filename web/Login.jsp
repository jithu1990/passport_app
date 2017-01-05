<html>
    <head>
        <title>Demo Passport Application</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
body {
background: 
url("\Passport.jpg") right 0 repeat-y,
url("\Passport.jpg") left 0 repeat-y;
}

</style>
    </head>
    <body>
        <form action="Login" method="post">
            <br>
            <br>
            <br>
            <br>
        <table border="2" align="center" width="30%" height="50%" bgcolor="skyblue">
            <tr><td align="center"><h1>Login here</h1></td></tr>
        
        <tr><td align="center">User Name:<input type="text" name="user"/><br></td></tr>
        
        <tr><td align="center">Password: <input type="password" name="pass"/><br></td></tr>
        
        <tr><td align="center"><input type="submit" value="Login"></td></tr>
        <tr><td align="center"><a href='Register.jsp'>Register here</a></td></tr>
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
