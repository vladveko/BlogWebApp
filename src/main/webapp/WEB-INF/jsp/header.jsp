<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
    <div class="nav">
        <a href="Controller?com=getallarticles">Articles</a>
    </div>

    <c:if test="${user != null}">
    <div class="btn">
        <button>Sign Out</button>
    </div>
    </c:if>

    <div class="btn">
        <button onclick="location.href='Controller?com=gotologin'">Sign In</button>
    </div>

    <div class="btn">
        <button onclick="location.href='Controller?com=gotoregistration'">Sign Up</button>
    </div>
</body>
</html>