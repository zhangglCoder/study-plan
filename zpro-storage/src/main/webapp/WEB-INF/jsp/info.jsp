<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件下载</title>
</head>
<body>
<h3>文件下载</h3>

<c:forEach items="${files}" var="item">
    <li><a href="${pageContext.request.contextPath}/main/download?filename=${item.name}">${item.name}</a></li>
</c:forEach>

</a>
</body>
</html>