<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>左侧导航menu</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/sdmenu.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa; SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;  SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url(images/main/leftbg.jpg) left top repeat-y #f2f0f5; width:194px;}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
	<div><img src="images/main/member.gif" width="44" height="44" /></div>
    <span>用户：${admin_username }<br>角色：管理员</span>
</div>
    <div style="float: left" id="my_menu" class="sdmenu">
      <div>
        <span>用户管理</span>
        <a href="userInfo" target="mainFrame" onFocus="this.blur()">查看用户</a>
      </div>
      <div>
        <span>管理员维护</span>
        <a href="changePwd.jsp" target="mainFrame" onFocus="this.blur()">修改密码</a>
        <a href="register.jsp" target="mainFrame" onFocus="this.blur()">新增管理员</a>
      </div>
      <div>
        <span>商品管理</span>
        <a href="${ctx }/admin/productlist" target="mainFrame" onFocus="this.blur()">商品列表</a>
        <a href="addProduct.jsp" target="mainFrame" onFocus="this.blur()">添加商品</a>
        <a href="updateProduct.jsp" target="mainFrame" onFocus="this.blur()">修改商品</a>
        <a href="addProductType.jsp" target="mainFrame" onFocus="this.blur()">添加类型</a>
      </div>
      <div>
        <span>订单管理</span>
        <a href="${ctx }/admin/finishOrder" target="mainFrame" onFocus="this.blur()">已支付订单</a>
        <a href="${ctx }/admin/deleteOrderList" target="mainFrame" onFocus="this.blur()">用户删除的订单</a>
        <a href="${ctx }/admin/orderlist" target="mainFrame" onFocus="this.blur()">查看所有订单</a>
      </div>
        
    </div>
</body>
</html>