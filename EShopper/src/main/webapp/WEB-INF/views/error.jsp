<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
</head><!--/head-->

<body>
	<!-- header phase-->
	<%@include file="./shared/header.jsp"%>

	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
						<div class="jumbotron">
							<h1>${errorTitle}</h1>
							<hr />
							<blockquote style="word-wrap:break-word">
								${errorDescription}
							</blockquote>
						</div>
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
