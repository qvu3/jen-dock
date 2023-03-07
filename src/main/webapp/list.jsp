<%--
  Created by IntelliJ IDEA.
  User: Astorrevu
  Date: 10/24/22
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Son Vu Todo App</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <br>
    <h1>Welcome to the Todo Web Application!</h1>
    <i>Developed by: Vu Quang Hoai Son</i>
    <br><br>

    <h3>1. This is the List of all Todos</h3>
    <table>

    <tr>
        <td>Id</td><td>Description</td><td>Status</td>
    </tr>
    <c:forEach items="${listTodo}" var="r">

    <tr><td><c:out value="${r.id}"></c:out></td>
        <td><c:out value="${r.description}"></c:out></td>
        <td><c:out value="${r.status}"></c:out></td>
    </tr>
    </c:forEach>
    </table>
    <br>
    <h3>2. Insert New Todo</h3>
    <form action="InsertServlet">
     >> Enter Description:   <input type="text" name="desc"><br>
     >> Enter Status:        <input type="text" name="stat"><br>
        <br><input type="submit">
    </form>
    <br>
    <h3>3. Edit An Existing Todo</h3>
    <form action="EditServlet">
    >> Enter the Todo ID:           <input type="text" name="id"><br>
    >> Enter updated Description:   <input type="text" name="u-desc"><br>
    >> Enter updated Status:        <input type="text" name="u-stat"><br>
        <br><input type="submit">
    </form>
    <br>
    <h3>4. Delete A Todo</h3>
    <form action="DeleteServlet">
        >> Enter the Todo ID to delete: <input type="text" name="id"><br>
        <br><input type="submit">
    </form>
    <br><br><br>


</body>
</html>
