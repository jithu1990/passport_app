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
        <h1 align='center'>Register here</h1>
        <form action="Register" method="post">
       <table border="2" align="center" width="20%" bgcolor="skyblue">
        <tr><td>User Name</td><td><input type="text" name="user"/> </td></tr>
        <tr><td>Password</td><td><input type="password" name="pass"/></td>   
        <tr><td><input type="reset" value="cancel"></td><td><input type="submit" value="Register"></td></tr>
        
       </table>
            <h4 align='center'><a href='Login.jsp'>Go to Login</a></h4>
        </form>
    </body>
</html>
