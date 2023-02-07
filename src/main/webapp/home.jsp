<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String header = "Hello from JSP";
%>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2><%= header %></h2>
    <p>Today <%= new java.util.Date() %></p>
</body>
</html>