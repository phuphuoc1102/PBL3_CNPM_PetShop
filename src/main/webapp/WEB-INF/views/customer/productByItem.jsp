<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
.category {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 20px;
}

.category-title {
	font-size: 18px;
	font-weight: bold;
	color: black;
}

.view-all {
	color: black;
	text-decoration: none;
	font-size: 16px;
	margin-left: 200px;
}

</style>
</head>
<body>
	
	<!-- Shop Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5">
			<!-- Shop Sidebar Start -->
			<div class="col-lg-3 col-md-12">
				<!-- Price Start -->
				<div class="border-bottom mb-4 pb-4">
					<h5 class="font-weight-semi-bold mb-4">${ItemType.name}</h5>
					<c:forEach var="item" items="${ItemType.typeOfCategoryList}">
						<form>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input" checked
									id="price-all"> <a class=""
									href='<c:url value="/san-pham/${item.type_id}/1"/>'
									for="price-all">${item.type_name}</a>
							</div>
						</form>
					</c:forEach> 
				</div>
				<!-- Price End -->


			</div>
			<!-- Shop Sidebar End -->


			<!-- Shop Product Start -->

			<div class="col-lg-9 col-md-12">
				<c:set var="start" value="0"></c:set>
				<c:set var="finish" value="8"></c:set>
				<c:set var="count" value="1"></c:set>
				<c:forEach var="type" items="${ItemType.typeOfCategoryList}">
					<c:set var="res" value="1"></c:set>
					<div class="category">
						<a class="category-title">${type.type_name}</a> <a
							href='<c:url value="/san-pham/${type.type_id}/1"/>'
							class="view-all">Xem tất cả ></a>
					</div>
					<div class="row pb-3">
						<c:forEach var="product" items="${productByTypeID}"
							begin="${start}" end="${finish}">
							<c:set var="count" value="${count+1}"></c:set>
							<c:set var="res" value="${res+1}"></c:set>
							<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
								<div class="card product-item border-0 mb-4">
									<div
										class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
										<a
											href="<c:url value="/chi-tiet-san-pham/${product.product_id}"/>"><img
											class="img-fluid w-100" src="${product.img}" alt=""></a>
									</div>
									<div
										class="card-body border-left border-right text-center p-0 pt-4 pb-3">
										<a
											href="<c:url value="/chi-tiet-san-pham/${product.product_id}"/>"><h6
												class="text-truncate mb-3">${product.product_name}</h6> </a>
										<div class="d-flex justify-content-center">
											<h6>${product.price}đ</h6>

										</div>
									</div>
									<div
										class="card-footer d-flex justify-content-between bg-light border">
											<a onclick="add('${product.product_id}')" class="btn btn-sm text-dark p-0"><i
											class="fas fa-shopping-cart text-primary mr-1 add-to-cart"></i>Thêm vào giỏ hàng</a>  
						
									</div>
								</div>
							</div>
							<c:if test="${res==9}">
								<c:set var="start" value="${count}"></c:set>
								<c:set var="finish" value="${count+8}"></c:set>

							</c:if>
						</c:forEach>
					</div>
				</c:forEach>
			</div>





		</div>
	</div>
	<!-- Shop Product End -->
	 <content tag="script"> 
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	 <script>
	function add(product_id) {
        $.ajax({
            url: "add-to-cart/" + product_id,
            type: "get",
            success: function () {
                $("#addtocart").load(location.href + " #addtocart>*","");
            }
        });
    }
</script> </content> 

</body>
</html>