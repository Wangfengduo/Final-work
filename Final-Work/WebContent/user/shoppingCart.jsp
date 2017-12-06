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
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />


<!-- animate.css -->
<link rel="stylesheet" href="assets/animate.css" />



<!-- Owl Carousel Assets -->
<link href="assets/owl-carousel/owl.carousel.css" rel="stylesheet">

<link  href="assets/style.css" rel="stylesheet">

<!-- favicon -->
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
<link rel="icon" href="images/favicon.png" type="image/x-icon">


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
      <h1><a class="navbar-brand logo" href="index.jsp">时尚 </a></h1>
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
      </ul>
      
      <form class="navbar-form navbar-left searchbar" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="搜索商品">
        </div>
      </form>
      <ul class="nav navbar-nav">
        <li><a href="login.jsp" data-target="#login"><span class="glyphicon glyphicon-user"></span> 登陆</a>
        <li><a href="register.jsp" data-target="#login"><span class="glyphicon glyphicon-user"></span>  注册</a></li>
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



<div class="container">
	<div class="content inside-page register">
		<h1 class="title">购物车</h1>
		<div class="breadcrumb"><a href="index.html">主页</a> / 我的购物车</div>
		
			<fieldset>
		     <div class="form-horizontal content-center">
		       <form action="order.controller">
		        <table class="cart_table" border="1px" width="80%" align="center">
		          <tr class="cart_title"> 
		            <td align="center">商品名</td>
		            <td align="center">单价</td>
		            <td align="center">数量</td>
		            <td align="center">操作</td>
		          </tr>
		          <c:forEach items="${shoppingList}" var="pd">
		          <tr>
		          	<td>${pd.name }</td>
		          	<td>${pd.price}</td>
		          	<td>
		          	<div class="add-plus-input">
						<input type="button" class="add btn" value="-" />
						<input type="text" class="num" name="number" value="1" size="1"/>
						<input type="button" class="plus btn" value="+" />
					</div>
		          	</td>
		          	<td><a href="clearSomeone.controller?name=${pd.name}" class="continue">删除</a></td>
		          </tr>
		          </c:forEach>
		          <tr>
					<td colspan="4" style="text-align: center;">
						<input type="submit" value="生成订单">
					</td>
				  </tr>
		        </table>
		        </form></br>
		        <form align="center">
		        	<a href="product"><input type="button" value="继续购物"></a>
		        	<a href="clearshoppingCart"><input type="button" value="清空购物车"></a>
		        	
		        </form>
		        </div>
		        </fieldset>
		      <div class="clear"></div>
		</div>
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