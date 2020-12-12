<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog</title>
</head>
<header>
    <jsp:include page="header.jsp"/>
</header>

<body>
    <c:if test="${param.regstate == 'error'}">
        <h3>Something went wrong. Try again!</h3>
    </c:if>
    <c:if test="${param.regstate == 'exists'}">
        <h3>This login is taken. Choose another one</h3>
    </c:if>

    <div class="reg">
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="register"/>

            <br/>
            <label for="login">Login</label>
            <input type="text" id="login" name="login"/>

            <br/>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>

            <br/>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>

            <br/>
            <label for="firstname">First Name</label>
            <input type="text" id="firstname" name="firstname"/>

            <br/>
            <label for="lastname">Last Name</label>
            <input type="text" id="lastname" name="lastname"/>

            <br/>
            <input type="submit" value="Register"/>
        </form>
    </div>

    <div>
        <h3>Go to login page if you already have account!</h3>
        <button onclick="location.href='Controller?com=gotologin'">Sign In</button>
    </div>
</body>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</html>
