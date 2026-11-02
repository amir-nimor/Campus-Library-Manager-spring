<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 11/2/2026
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>All authors</title>
</head>
<body>


<c:forEach var="author" items="${authors}">
    <h3>${author.name}  ${author.id}</h3>
</c:forEach>


</body>
</html>
