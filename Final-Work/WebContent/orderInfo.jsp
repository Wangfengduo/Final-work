<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="left_content">
			<div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>
			我的订单</div>
		      <div class="feat_prod_box_details">
		       <form action="order.action">
		        <table class="cart_table">
		          <tr class="cart_title">
		            <td>订单号</td>
		            <td>订单人</td>
		            <td>订单时间</td>
		            <td>处理状态</td>	
		            <td>操作</td>	            
		          </tr>
		          <c:forEach items="${OrderInfoList}" var="order">
		          <tr>
		          	<td>${order.orderId }</td>
		          	<td>${username}</td>
		          	<td>${order.orderTime}</td>
		          	<td>${order.orderState}</td>
		          	<td>
		          	  <a href="${ctx}/deleteOrder?orderId=${order.orderId}">删除</a>
		          	  <a href="${ctx}/changeState?orderId=${order.orderId}">取消</a>
		          	  <a href="${ctx}/showOrder?orderId=${order.orderId}">详情</a>
		          	</td>
		          </tr>
		          </c:forEach>
		        </table>
		        </form>
		      </div>
		      <div class="clear"></div>
		</div>
</body>
</html>