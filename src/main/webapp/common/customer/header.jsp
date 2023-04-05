<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="container-fluid">
	<div class="row align-items-center py-3 px-xl-5">
		<div  class="col-lg-3 d-none d-lg-block">
			<a href="" class="text-decoration-none">
				<h1 class="m-0 display-5 font-weight-semi-bold">
					<span class="text-primary font-weight-bold border px-3 mr-1">PET</span>SHOP
				</h1>
			</a>
		</div>
		<div class="col-lg-6 col-6 text-left">
			<form action="">
				<div class="input-group">
					<input type="text" class="form-control"
						placeholder="Search for products">
					<div class="input-group-append">
						<span class="input-group-text bg-transparent text-primary">
							<i class="fa fa-search"></i>
						</span>
					</div>
				</div>
			</form>
		</div>
		<div class="col-lg-3 col-6 text-right">
			<a href="" class="btn border"> <i
				class="fas fa-heart text-primary"></i> <span class="badge">0</span>
			</a> <a id="addtocart" href='<c:url value="/cart"/>' class="btn border"> <i
				class="fas fa-shopping-cart text-primary"></i> <span class="badge">${cart.size()}</span>
			</a>
		</div>
	</div>
</div>

<div class="container-fluid mb-5">
	<div class="row border-top px-xl-5">

		<div class="col-lg-9">
			<nav
				class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
				<a href="" class="text-decoration-none d-block d-lg-none">
					<h1 class="m-0 display-5 font-weight-semi-bold">
						<span class="text-primary font-weight-bold border px-3 mr-1">PET</span>SHOP
					</h1>
				</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto py-0">
						<c:set var="count" value="1"></c:set>
						<c:forEach var="item" items="${menu}" varStatus="index">
							<c:if test="${index.first}">
								<a href='<c:url value="/trang-chu"/>' class="nav-item nav-link">${item.menu_name}</a>
							</c:if>

							<c:if test="${not index.first}">
								<c:if test="${empty item.item_id}">
									<a href='<c:url value="/san-pham/${item.item_id}"/>'
										class="nav-item nav-link">${item.menu_name}</a>
								</c:if>

								<c:if test="${not empty item.item_id}">
									<div class="nav-item dropdown">

										<a href='<c:url value="/san-pham/${item.item_id}"/>'
											class="nav-link dropdown-toggle">${item.menu_name} </a>
										<div class="dropdown-menu rounded-0 m-0">

											<%-- <c:if test="${count==1}">
												<c:forEach var="type" items="${item01}">
													<a href="cart.html" class="nav-link dropdown-toggle" data-toggle="dropdown">1</a>
												</c:forEach>

											</c:if>

											<c:if test="${count!=1}">
												<c:forEach var="type" items="${item02}">
													<a href="cart.html" class="dropdown-item">${type.type_name}</a>
												</c:forEach>
											</c:if> --%>

										</div>
									</div>
									<c:set var="count" value="${count+1}"></c:set>
								</c:if>

							</c:if>
						</c:forEach>
					</div>
					<c:if test="${empty LoginInfo}">
						<div class="navbar-nav ml-auto py-0">
							<a href='<c:url value="/dang-nhap"/>' class="nav-item nav-link">Đăng
								nhập</a> <a href='<c:url value="/dang-ky"/>'
								class="nav-item nav-link">Đăng ký</a>
						</div>
					</c:if>
					<c:if test="${not empty LoginInfo}">
						<div class="navbar-nav ml-auto py-0">
							<%-- <a href='' class="nav-item nav-link">${LoginInfo.tenDangNhap}</a> --%>
							<div class="dropdown">
								<a class="nav-link dropdown-toggle" href='<c:url value="/thong-tin-tai-khoan"/>' role="button"
									data-toggle="none" aria-haspopup="true"
									aria-expanded="false"> ${LoginInfo.tenDangNhap} </a>
								<!-- <div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="/abcd">Thông tin tài khoản</a> <a
										class="dropdown-item" href="/xyz">Đăng xuất</a>
								</div> -->
							</div>
							<a href='<c:url value="/dang-xuat"/>' class="nav-item nav-link">Đăng
								xuất</a>
						</div>
					</c:if>
				</div>
			</nav>
		</div>
	</div>
</div>
<!-- Navbar Start -->

<!-- Navbar End -->