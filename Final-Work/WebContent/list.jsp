<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" align="center">
	<tr><td></td><td>名称</td><td>图片</td><td>描述</td><td>价格</td><td>产品类型</td><td>操作</td></tr>
	<c:forEach items="${list }" var="p">
		<tr>
		<td><input type="checkbox" name="pid" value="${p.id }" /></td>
		<td>${p.name }</td><td>${p.img}</td><td>${p.description}</td><td>${p.price }</td><td>${p.producttypeid }</td>
		<td>
			<a href="addShoppingCart?ProductName=${p.name}&ProductPrice=${p.price}">加入购物车</a>
		</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>