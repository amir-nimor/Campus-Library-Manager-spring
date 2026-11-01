<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 11/1/2026
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>all book</title>
</head>
<body>


<c:forEach var="book" items="${books}">
    <h3>${book.title} <a href="/Campus_Library_Manager_spring_war/books/details/${book.id}">detailas</a> </h3>
</c:forEach>


</body>
</html>
