<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/user/login" method="post">
    <input type="text" name="userId" value="1">
    <input type="text" name="userName" value="zjwzjw">
    <input type="password" name="pwd" value="123456">
    <input type="submit" value="登录">
    <input type="reset" value="重置">
    <input type="button" value="注册">
</form>
<script src="<c:url value="/js/login.js"/>"></script>
</body>
</html>