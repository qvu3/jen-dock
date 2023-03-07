<%--
  Created by IntelliJ IDEA.
  User: Astorrevu
  Date: 10/25/22
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo Form</title>
</head>
<body bgcolor="#faebd7">
    <br>
    <br>
    <form action="InsertServlet">
        - Enter Todo Description: <input type="text" name="desc"> <br>
        - Enter Todo Status:      <input type="text" name="stat"> <br>
        <input type="submit">
    </form>
</body>
</html>
