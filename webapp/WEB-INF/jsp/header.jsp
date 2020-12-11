<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<header>
    Blog
</header>
    <div class="nav">
        <a href="'Controller?command=all_articles'">Articles</a>
    </div>
<c:choose>
    <c:when test="${user != null}">
        <div>
            <button onclick="location.href='Controller?command=signin'">Sign In</button>
        </div>
    </c:when>
    <c:otherwise>
        <div>
            <button onclick="location.href='Controller?command=signout'">Sign Out</button>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
