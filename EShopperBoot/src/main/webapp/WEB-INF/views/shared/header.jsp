<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<header id="header"><!--header-->
	<div class="header_top"><!--header_top-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="contactinfo">
						<ul class="nav nav-pills">
							<li><a href=""><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
							<li><a href=""><i class="fa fa-envelope"></i> info@domain.com</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="social-icons pull-right">
						<ul class="nav navbar-nav">
							<li><a href=""><i class="fa fa-facebook"></i></a></li>
							<li><a href=""><i class="fa fa-twitter"></i></a></li>
							<li><a href=""><i class="fa fa-linkedin"></i></a></li>
							<li><a href=""><i class="fa fa-dribbble"></i></a></li>
							<li><a href=""><i class="fa fa-google-plus"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div><!--/header_top-->
	
	<div class="header-middle"><!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="logo pull-left">
						<a href="${contextRoot}/home"><img src="${images}/home/logo.png" alt="" /></a>
					</div>
					<div class="btn-group pull-right">
						<div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
								USA
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="">Canada</a></li>
								<li><a href="">UK</a></li>
							</ul>
						</div>
						
						<div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
								DOLLAR
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="">Canadian Dollar</a></li>
								<li><a href="">Pound</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="shop-menu pull-right">
						<ul class="nav navbar-nav">
							<li><a href=""><i class="fa fa-user"></i> Account</a></li>
							<li><a href=""><i class="fa fa-star"></i> Wishlist</a></li>
							<li><a href="${contextRoot}/checkout"><i class="fa fa-crosshairs"></i> Checkout</a></li>
							<li><a href="${contextRoot}/cart"><i class="fa fa-shopping-cart"></i> Cart</a></li>
							<li><a href="${contextRoot}/manage/add-product"><i class="fa fa-briefcase"></i> Manager</a></li>
							<security:authorize access="isAnonymous()">
								<li><a href="${contextRoot}/login" class="active"><i class="fa fa-lock"></i> Login</a></li>
							</security:authorize>
							<security:authorize access="isAuthenticated()">
								<li><a href="${contextRoot}/logout" class="active"><i class="fa fa-lock"></i>Logout</a></li>
							</security:authorize>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div><!--/header-middle-->

	<div class="header-bottom"><!--header-bottom-->
		<div class="container">
			<div class="row">
				<div class="col-sm-9">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<div class="mainmenu pull-left">
						<ul class="nav navbar-nav collapse navbar-collapse">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu">
									<li><a href="${contextRoot}/shop">Products</a></li>
									<li><a href="${contextRoot}/product-details">Product Details</a></li> 
									<li><a href="${contextRoot}/checkout">Checkout</a></li> 
									<li><a href="${contextRoot}/cart">Cart</a></li> 
									<li><a href="login.html" class="active">Login</a></li> 
								</ul>
							</li> 
							<li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu">
                                       <li><a href="blog.html">Blog List</a></li>
									<li><a href="blog-single.html">Blog Single</a></li>
                                   </ul>
                            </li> 
							<li><a href="${contextRoot}/notfound">404</a></li>
							<li><a href="${contextRoot}/contact-us">Contact</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="search_box pull-right">
						<input type="text" placeholder="Search"/>
					</div>
				</div>
			</div>
		</div>
	</div><!--/header-bottom-->
</header><!--/header-->
