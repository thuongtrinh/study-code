<div class="container">
	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active"> ${product.name} </li>
			</ol>
		</div>
	</div>

	<div class="row">
		<div class="col-sx-12 col-sm-4">
			<div class="thumbnail">
				<img alt="image_logo" src="${images}/${product.code}.jpg" class="img img-responsive" />
			</div>
		</div>

		<div class="col-sx-12 col-sm-8">
			<h3> ${product.name} </h3>
			<hr/>
			<p>${product.description}</p>
			<hr/>
			<h4>Price: <strong>&#8377; ${product.unitPrice} /-</strong></h4>
			<hr/>

			<security:authorize access="hasAuthority('USER')">
				<c:choose>
					<c:when test="${product.quantity < 1}">
						<h6>Qty. Available: <span style="color: red">Out of Stock!</span></h6>
						<a href="javascript:void(0)" class="btn btn-success disable"><strike>
						<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</strike></a>
						<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
					</c:when>
					<c:otherwise>
						<h6>Qty. Available: ${product.quantity}</h6>
						<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
						<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
						<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
					</c:otherwise>
				</c:choose>
			</security:authorize>
			
			<security:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${product.id}/product" class="btn btn-warning">
					<span class="glyphicon glyphicon-pencil"></span> Edit</a>
			</security:authorize>
		</div>
	</div>
</div>

