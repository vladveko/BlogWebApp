<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog</title>
</head>
<header>
    <jsp:include page="header.jsp"/>
</header>

<body>
    <c:forEach var="header" items="${headers}">
        <a href="Controller/com=getarticle&articleID=${header.id}">${header.header}</a>
    </c:forEach>
</body>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</html>
