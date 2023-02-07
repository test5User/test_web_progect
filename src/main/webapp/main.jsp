<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main</title>
</head>
<body>

<c:forEach var="cook" items="${cookie}">
    <li>
        <p><c:out value="${cook.value.name}" /></p>
        <p><c:out value="${cook.value.value}" /></p>
    </li>
</c:forEach>


</body>
</html>