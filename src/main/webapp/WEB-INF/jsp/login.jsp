<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog</title>
</head>
<body>
    <h3>Sign In:</h3>
    <form action="Controller" method="post">
        <input type="hidden" name="command" value="signin"/>

        <br/>
        <label for="login">Login:</label>
        <input type="text" id="login" name="login"/>

        <br/>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"/>

        <br/>
        <input type="submit" value="Sign In"/>
    </form>

    <div>
        <h3>Go to registration page if you don't have account!</h3>
        <button onclick="location.href='Controller?command=gotoregistration'">Sign Up</button>
    </div>
</body>
</html>
