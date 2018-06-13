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
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${images}/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${images}/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${images}/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${images}/ico/apple-touch-icon-57-precomposed.png">
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<!--/head-->

<body>
	<!-- header phase-->
	<%@include file="./shared/header.jsp"%>

	<div class="container">
		<div class="jumbotron">
			<h1>Manage products of Eshopper</h1>
		</div>
		<c:if test="${not empty message}">
			<div class="row">
				<div class="col-sm-12">
					<div class="alert alert-success alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						${message}
					</div>
				</div>
			</div>
		</c:if>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4>Add new product into shop online</h4>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-7">
						<sf:form action="${contextRoot}/manage/products" modelAttribute="product" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label for="name">Name</label>
								<sf:input type="text" class="form-control" path="name" id="name"
									placeholder="Product name" />
								<sf:errors path="name" cssClass="error" element="em" />
							</div>
							<div class="form-group">
								<label for="quanity">Quantity</label>
								<sf:input type="text" class="form-control" path="quanity"
									id="quanity" placeholder="Quantity of product" />
								<sf:errors path="quanity" cssClass="error" element="em" />
							</div>
							<div class="form-group">
								<label for="unitPrice">Price</label>
								<sf:input type="text" class="form-control" path="unitPrice"
									id="unitPrice" placeholder="Price of product" />
								<sf:errors path="unitPrice" cssClass="error" element="em" />
							</div>
							<div class="form-group">
								<label for="saleOff">Percent sale off</label>
								<sf:input type="text" class="form-control" id="saleOff"
									path="saleOff" placeholder="Sale of of product" />
								<sf:errors path="saleOff" cssClass="error" element="em" />
							</div>
							<div class="form-group">
								<label for="category_id">Category</label>
								<sf:select class="form-control" path="category.id"
									id="category_id">
									<%-- <sf:option value="" label="-- select category of product --"/> --%>
									<sf:options items="${categories}" itemValue="id"
										itemLabel="name" />
								</sf:select>
								<sf:errors path="category.id" cssClass="error" element="em" />
							</div>
							<div class="form-group">
								<label for="description">Description</label>
								<sf:textarea rows="3" class="form-control" id="description"
									path="description" placeholder="Description of product" />
								<sf:errors path="description" cssClass="error" element="em" />
							</div>
							<div class="form-group">
								<label for="exampleInputFile">Image of product</label>
								<sf:input type="file" id="exampleInputFile" path="file" />
							</div>

							<div class="form-group">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />
								<!-- Hidden fields for submit -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="active" />
								<sf:hidden path="imageURL" />
								<sf:hidden path="purchasedCount" />
								<sf:hidden path="views" />
							</div>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->

	<!--Footer phase-->
	<%@include file="./shared/footer.jsp"%>

	<script src="${js}/jquery.js"></script>
	<script src="${js}/price-range.js"></script>
	<script src="${js}/jquery.scrollUp.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/jquery.prettyPhoto.js"></script>
	<script src="${js}/main.js"></script>
	<script type="text/javascript">
		window.setTimeout(function() {
			$(".alert").fadeTo(500, 0).slideUp(500, function() {
				$(this).remove();
			});
		}, 3000);
	</script>
</body>
</html>
