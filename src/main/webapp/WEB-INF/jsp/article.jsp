<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog</title>
</head>
<header>
    <jsp:include page="header.jsp"/>
</header>

<body>
    <div class="article">
        <h2>${article.header}</h2>
        <h4>${article.subheader}</h4>
        <br>
        ${article.body}
    </div>
</body>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</html>
