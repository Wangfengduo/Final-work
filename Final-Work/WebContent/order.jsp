<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Shops | The Bootstrap Themes</title>

<!-- Google fonts -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Old+Standard+TT:400,400italic' rel='stylesheet' type='text/css'>


<!-- font awesome -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<!-- bootstrap -->
<link rel="stylesheet" href="${ctx}/assets/bootstrap/css/bootstrap.min.css" />


<!-- animate.css -->
<link rel="stylesheet" href="${ctx}/assets/animate.css" />



<!-- Owl Carousel Assets -->
<link href="${ctx}/assets/owl-carousel/owl.carousel.css" rel="stylesheet">

<link  href="${ctx}/assets/style.css" rel="stylesheet">

<!-- favicon -->
<link rel="shortcut icon" href="${ctx}/images/favicon.png" type="image/x-icon">
<link rel="icon" href="${ctx}/images/favicon.png" type="image/x-icon">


</head>

<body id="home">






<div class="header">
<nav class="navbar  navbar-default navbar-fixed-top" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <h1><a class="navbar-brand logo" href="../main.jsp">时尚 </a></h1>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
      
      <ul class="nav navbar-nav">        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">收藏 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="collections.jsp">男士</a></li>
            <li><a href="collections.jsp">女士</a></li>
            <li><a href="collections.jsp">礼品</a></li>            
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">页 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="about.html">关于</a></li>
            <li><a href="terms.html">Terms</a></li>
            <li><a href="contact.html">Contact</a></li>            
          </ul>
        </li>
        <li><a href="${ctx }/admin/login.jsp">管理员登陆</a></li>
      </ul>
      
      <form class="navbar-form navbar-left searchbar" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="搜索商品">
        </div>
      </form>
      <ul class="nav navbar-nav">
        <li><a><span class="glyphicon glyphicon-user"></span>${lu.realName }</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle cart" data-toggle="dropdown"><span class="glyphicon glyphicon-shopping-cart"></span> 购物车 <span class="cart-counter">3</span> <span class="caret"></span></a>
          <div class="dropdown-menu mini-cart">
          <div class="row product-list">
            <div class="col-xs-3"><a href="#"><img src="images/photos/1.jpg" class="img-responsive" alt="product"></a></div>
            <div class="col-xs-7"><a href="#">White V-neck Tshirt</a></div>
            <div class="col-xs-1"><a href="#"><i class="fa fa-close"></i></a></div>
          </div>

          <div class="row product-list">
            <div class="col-xs-3"><a href="#"><img src="images/photos/2.jpg" class="img-responsive" alt="product"></a></div>
            <div class="col-xs-7"><a href="#">White V-neck Tshirt</a></div>
            <div class="col-xs-1"><a href="#"><i class="fa fa-close"></i></a></div>
          </div>

          <div class="clearfix">
          <a href="checkout.jsp" class="btn btn-primary">继续购物</a> <a href="checkout.jsp" class="btn btn-primary">结算</a>
          </div>

          </div>
        </li>
      </ul>
    </div><!-- Wnavbar-collapse -->
  </div><!-- container-fluid -->
</nav>
</div>




	<div class="left_content">
			<div class="title" style="
				margin-left:20px;
				padding-top:10px;
			"><h1>我的购物车</h1></div>
		      <div class="feat_prod_box_details" >
		        <form action="" name="productForm" id="productForm">
		        <table class="cart_table" border="1px" height="200px" width="40%" align="center">
		       		<tr>
		        		<td align="center">用户名</td>
		        		<td colspan="3" align="center">${username}</td>
		        		
		        	</tr>
		        	<tr>
		        		<td align="center">电话</td>
		        		<td colspan="3" align="center">${telephone }</td>
		        		
		        	</tr>
		        	<tr>
		        		<td align="center">地址</td>
		        		<td colspan="3" align="center">${address}</td>
		        		
		        	</tr>
		          	<tr>
						<td align="center">商品名称</td>
						<td align="center">单价</td>
						<td align="center">数量</td>
						<td align="center">总价格</td>
				
					</tr>
					<c:set var="i" value="0"></c:set>
					<c:set var="a" value="0"></c:set>
					<c:forEach items="${list}" var="pd">
						<tr>
							<td align="center">${pd.name}</td>
							<td align="center">￥${pd.price}</td>
							<td align="center">${sessionScope.num[i] }</td>	
				       	 	<td align="center">￥${sessionScope.num[i]*pd.price }</td>
				        	<c:set var="a" value="${a+sessionScope.num[i]*pd.price}"></c:set>
				        	<c:set var="i" value="${i+1 }"></c:set>
						</tr>
					</c:forEach>
                    <tr>
                        <td align="center"></td>
                        <td align="center"></td>
                        <td align="center"></td>
                        <td align="center">总价格:￥${a}</td>
                    </tr>
		        </table>
		        </form>
		        <br>
		        <form align="center">
		        	<a href="shoppingCart.jsp" class="continue">&lt; <input type="button" value="取消订单" class="btn btn-primary"></a>
		        	<a href="${ctx}/addOrder" class="checkout"><input type="button" value="确认订单" class="btn btn-primary">&gt;</a> </div>
		        </form>
		      <div class="clear"></div>
		</div>



<footer>
   <div class="container">
            <div class="row">
                <div class="col-sm-3 sitemap">
                    <h4>Sitemap</h4>
                    <ul class="list-unstyled">
                        <li><a href="#">主页</a></li>
                        <li><a href="#">Return Policy</a></li>
                        <li><a href="#">Terms and Condition</a></li>
                        <li><a href="#">Contact</a></li>                      
                    </ul>
                </div>              
                 
                
                <div class="col-sm-3 subscribe">
                    <h4>Enquiries</h4>
                    <p> 3488 Oak Avenue <br>
                    Lockport, NY 14094</p>

                    <i class="fa fa-envelope"></i> hello@bbbcc.com<br>
                    <i class="fa fa-phone"></i> 0000 000 000<br>
                </div>
                <div class="col-sm-3 joinus">
                    <h4>Subscribe</h4>
                    <div class="input-group"><input type="text" class="form-control" placeholder="Your Name"></div>
                    <div class="input-group"><input type="text" class="form-control email" placeholder="Your Email Address..."></div>
                    <button class="btn btn-primary"><i class="fa fa-paper-plane"></i> Subscribe</button>                   
                </div>
                <div class="col-sm-3">
                    <h4>Like and follow us</h4>
                    <span class="social"><a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-twitter"></i> <a href="#"><i class="fa fa-youtube"></i></a> <a href="#"><i class="fa fa-pinterest"></i></a></span>
                </div>

                
            </div>
            <!--/.row--> 
 
    
    <!--/.footer-bottom--> 
</div>
</footer>
<div class="copyright">
    <div class="container">
        
        © Copyright SHOPS 2015   
        <a href="http://thebootstrapthemes.com" class="pull-right">The Bootstrap Themes</a>

    </div>
</div>
</div>


<script src="assets/jquery.js"></script>



<!-- owlcarousel -->
<script src="assets/owl-carousel/owl.carousel.min.js"></script>

<!-- boostrap -->
<script src="assets/bootstrap/js/bootstrap.js" type="text/javascript" ></script>

<!-- jquery mobile -->
<script src="assets/mobile/touchSwipe.min.js"></script>
<script src="assets/respond/respond.js"></script>





<!-- custom script -->
<script src="assets/script.js"></script>

</body>
</html>