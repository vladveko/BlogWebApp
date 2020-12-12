<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
    <div class="nav">
        <a href="#">Articles</a>
    </div>
    <c:if test="${user != null}">
    <div>
        <button>Sign Out</button>
    </div>
    </c:if>
    <div>
        <button>Sign In</button>
    </div>
</body>
</html>