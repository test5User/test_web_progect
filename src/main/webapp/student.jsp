<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student info</title>
</head>
<body>
    <h2>Student info</h2>
    <c:choose>
      <c:when test="${ not empty stud}">
        <p>Name: ${stud.getFio()}</p>
        <p>email: ${stud.email}</p>
      </c:when>
      <c:otherwise>
        <p> ${message} </p>
      </c:otherwise>
    </c:choose>
</body>
</html>