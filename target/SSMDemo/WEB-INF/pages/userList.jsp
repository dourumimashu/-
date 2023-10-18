<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023/9/10
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>展示用户信息</title>
</head>
<body>
    <h2>用户信息如下：</h2>
    <table>
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
        </tr>
        <c:forEach items="${userList}" var="u">
            <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.age}</td>
            <td>${u.sex}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
