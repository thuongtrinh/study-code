<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sping:url var="css" value="/resources/css" />
<sping:url var="js" value="/resources/js" />
<sping:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | E-Shopper</title>
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <link href="${css}/font-awesome.min.css" rel="stylesheet">
    <link href="${css}/prettyPhoto.css" rel="stylesheet">
    <link href="${css}/price-range.css" rel="stylesheet">
    <link href="${css}/animate.css" rel="stylesheet">
	<link href="${css}/main.css" rel="stylesheet">
	<link href="${css}/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${js}/html5shiv.js"></script>
    <script src="${js}/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="${images}/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${images}/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${images}/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${images}/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${images}/ico/apple-touch-icon-57-precomposed.png">
    <style type="text/css">
		.error {
			color: #ff0000;
			font-style: italic;
		}
		.cssRadio{
			height: 15px !important;
			width: 15px !important;
		}
	</style>
</head><!--/head-->

<body>
	<!-- header phase-->
	<%@include file="./shared/header.jsp"%>

	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
						<sf:form action="${contextRoot}/signup" modelAttribute="user" method="post">
							<sf:input type="text" path="username" placeholder="UserName"/>
							<sf:errors path="username" cssClass="error" element="em" />
							<sf:input type="email" path="email" placeholder="Email Address"/>
							<sf:errors path="email" cssClass="error" element="em" />
							<sf:input type="password" path="password" placeholder="Password"/>
							<sf:errors path="password" cssClass="error" element="em" />
							<div>
							<label class="radio-inline">
								<sf:radiobutton cssClass="cssRadio" path="role" value="ADMIN" checked="checked" label="Admin"/>
							</label>
							<label class="radio-inline">
								<sf:radiobutton cssClass="cssRadio" path="role" value="USER" label="User"/>
							</label></div>
							<button type="submit" class="btn btn-default">Signup</button>
							<sf:hidden path="enable"/>
						</sf:form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->

	<!--Footer phase-->
	<%@include file="./shared/footer.jsp"%>

	<script src="${js}/jquery.js"></script>
	<script src="${js}/price-range.js"></script>
    <script src="${js}/jquery.scrollUp.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/jquery.prettyPhoto.js"></script>
    <script src="${js}/main.js"></script>
</body>
</html>
