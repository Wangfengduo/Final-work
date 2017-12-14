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
			订单信息</div>
		      <div class="feat_prod_box_details">
		       <form action="${ctx}/showOrder">
		        <table class="cart_table">
		          <tr class="cart_title">
		            <td>订单号</td>
		            <td>所购产品</td>		            	            
		          </tr>		          		       
		          <tr>
		          	<td>${id}</td>
		          	<td>
		          	<c:forEach items="${str}" var="pd">
		            ${pd }
		            </c:forEach>
		            </td>
		          </tr>		         
		        </table>
		        </form>
		        <a href="${ctx}/orderInfo" class="checkout">返回 &gt;</a> 
		       
		      </div>
		      <div class="clear"></div>
		</div>
</body>
</html>