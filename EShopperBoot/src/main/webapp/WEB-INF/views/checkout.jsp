<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sping:url var="css" value="/css" />
<sping:url var="js" value="/js" />
<sping:url var="images" value="/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Checkout | E-Shopper</title>
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
    <style >
		.error {
			color: #ff0000;
			font-style: italic;
		}
	</style>
</head><!--/head-->

<body>
	<!--header phase-->
	<%@include file="./shared/header.jsp"%>

	<section id="cart_items" style="margin-bottom: 20px;">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Check out</li>
				</ol>
			</div><!--/breadcrums-->

			<div class="step-one">
				<h2 class="heading">Step1</h2>
			</div>
			<div class="checkout-options">
				<h3>New User</h3>
				<p>Checkout options</p>
				<ul class="nav">
					<li>
						<label><input type="checkbox"> Register Account</label>
					</li>
					<li>
						<label><input type="checkbox"> Guest Checkout</label>
					</li>
					<li>
						<a href=""><i class="fa fa-times"></i>Cancel</a>
					</li>
				</ul>
			</div><!--/checkout-options-->

			<div class="register-req">
				<p>Please use Register And Checkout to easily get access to your order history, or use Checkout as Guest</p>
			</div><!--/register-req-->

			<div class="review-payment">
				<h2>Review & Payment</h2>
			</div>

			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="cart_product">
								<a href=""><img src="${images}/home/${product.imageURL}" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">${product.name}</a></h4>
								<p>Web ID: ${product.id}</p>
							</td>
							<td class="cart_price">
								<p>$${product.unitPrice}</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">$${product.unitPrice}</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>

						<tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr>
										<td>Cart Sub Total</td>
										<td>$59</td>
									</tr>
									<tr>
										<td>Exo Tax</td>
										<td>$2</td>
									</tr>
									<tr class="shipping-cost">
										<td>Shipping Cost</td>
										<td>Free</td>										
									</tr>
									<tr>
										<td>Total</td>
										<td><span>$61</span></td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="payment-options">
				<span>
					<label><input type="checkbox"> Direct Bank Transfer</label>
				</span>
				<span>
					<label><input type="checkbox"> Check Payment</label>
				</span>
				<span>
					<label><input type="checkbox"> Paypal</label>
				</span>
			</div>

			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-12 clearfix">
						<div class="bill-to">
							<p>Bill To</p>
							<div class="form-one">
								<form action="/add-to-cart/${product.id}" method="post">
									<sf:input type="text" placeholder="Company Name" path="address.companyName"/>
									<input type="text" value="${user.email}" disabled/>
									<input type="text" value="${product.name}" disabled/>
									<sf:input type="text" placeholder="First Name *" path="user.firstName"/>
									<sf:errors path="user.firstName" cssClass="error" element="em" />
									<sf:input type="text" placeholder="Middle Name" path="user.middleName"/>
									<sf:errors path="user.middleName" cssClass="error" element="em" />
									<sf:input type="text" placeholder="Last Name *" path="user.lastName"/>
									<sf:errors path="user.lastName" cssClass="error" element="em" />
									<sf:input type="text" placeholder="Address 1 *" path="address.addressOne"/>
									<sf:errors path="address.addressOne" cssClass="error" element="em" />
									<sf:input type="text" placeholder="Address 2" path="address.addressTwo"/>
									<sf:input type="text" placeholder="Zip / Postal Code *" path="address.postalCode"/>
									<sf:errors path="address.postalCode" cssClass="error" element="em" />
									<sf:select path="address.country">
										<sf:option value="">-- Country --</sf:option>
										<sf:options items="${countryList}"/>
									</sf:select>
									<sf:errors path="address.country" cssClass="error" element="em" />
									<br><br>
									<sf:select path="address.city">
										<sf:option value="">-- State / Province / Region --</sf:option>
										<sf:options items="${cityList}"/>
									</sf:select>
									<sf:errors path="address.city" cssClass="error" element="em" />
									<br><br>
									<sf:input type="text" placeholder="Phone *" path="user.phone"/>
									<sf:errors path="user.phone" cssClass="error" element="em" />
									<sf:input type="text" placeholder="Mobile Phone" path="user.mobilePhone"/>
									<sf:errors path="user.mobilePhone" cssClass="error" element="em" />
									<sf:input type="text" placeholder="Fax" path="user.fax"/>
									<sf:errors path="user.fax" cssClass="error" element="em" />
									<sf:hidden path="user.username"/>
									<sf:hidden path="user.id"/>
									<sf:hidden path="user.email"/>
									<button class="btn btn-primary" type="submit">Get Quotes</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section> <!--/#cart_items-->

	<!--Footer phase-->
	<%@include file="./shared/footer.jsp"%>

	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/jquery.scrollUp.min.js"></script>
	<script src="${js}/jquery.prettyPhoto.js"></script>
	<script src="${js}/main.js"></script>
	<!-- <script type="text/javascript">
		$('button[name="refreshCart"]').click(function(){
			// fetch the cart line id
			var cartLineId = $(this).attr('value');
			var countElement = $('#count_' + cartLineId);
			
			var originalCount = countElement.attr('value');
			var currentCount = countElement.val();
			
			// work only when the count has changed
			if(currentCount !== originalCount) {
				if(currentCount < 1 || currentCount > 3) {
					// reverting back to the original count
					// user has given value below 1 and above 3
					countElement.val(originalCount);
					bootbox.alert({
						size: 'medium',
						title: 'Error',
						message: 'Product count should be minium 1 and maximum 3!'
					});
				} else {
					var updateUrl= window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
					// forward it to the controller
					window.location.href = updateUrl;
				}
			}
		});
	</script> -->
</body>
</html>
