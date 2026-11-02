<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 11/2/2026
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>add book</title>
</head>
<body>


<form method="POST" action="/Campus_Library_Manager_spring_war/books/add">

    <label>Title:
    <input type="text" name="title">
    </label>

    <label>Author
        <select name="authorId">
            <c:forEach var="author" items="${authors}">
                <option value="${author.id}">${author.name}</option>
            </c:forEach>
        </select>
    </label>

    <button>Add</button>

</form>



</body>
</html>
