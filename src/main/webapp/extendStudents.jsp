<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
    <c:choose>
      <c:when test="${ not empty students}">
        <h2>Students: </h2>
        <c:forEach var="stud" items="${students}">
          <p>id: ${stud.id} name: ${stud.fio} email: ${stud.email} </p>
        </c:forEach>
      </c:when>
      <c:otherwise>
        <p> ${message} </p>
      </c:otherwise>
    </c:choose>
</body>
</html>