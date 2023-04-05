<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!-- Footer Start -->
<div id="layoutSidenav">
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<div class="sb-sidenav-menu-heading">Core</div>
					<a class="nav-link" href="/petshop-test/trang-chu">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div> Trang chủ 
					</a>
					<div class="sb-sidenav-menu-heading">Interface</div>
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapseLayouts" aria-expanded="false"
						aria-controls="collapseLayouts">
						<div class="sb-nav-link-icon">
							<i class="fas fa-columns"></i>
						</div> Layouts
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseLayouts"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="layout-static.html">Static
								Navigation</a> <a class="nav-link" href="layout-sidenav-light.html">Light
								Sidenav</a>
						</nav>
					</div>
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapsePages" aria-expanded="false"
						aria-controls="collapsePages">
						<div class="sb-nav-link-icon">
							<i class="fas fa-book-open"></i>
						</div> Pages
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapsePages"
						aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav accordion"
							id="sidenavAccordionPages">
							<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
								data-bs-target="#pagesCollapseAuth" aria-expanded="false"
								aria-controls="pagesCollapseAuth"> Authentication
								<div class="sb-sidenav-collapse-arrow">
									<i class="fas fa-angle-down"></i>
								</div>
							</a>
							<div class="collapse" id="pagesCollapseAuth"
								aria-labelledby="headingOne"
								data-bs-parent="#sidenavAccordionPages">
								<nav class="sb-sidenav-menu-nested nav">
									<a class="nav-link" href="login.html">Login</a> <a
										class="nav-link" href="register.html">Register</a> <a
										class="nav-link" href="password.html">Forgot Password</a>
								</nav>
							</div>
							<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
								data-bs-target="#pagesCollapseError" aria-expanded="false"
								aria-controls="pagesCollapseError"> Error
								<div class="sb-sidenav-collapse-arrow">
									<i class="fas fa-angle-down"></i>
								</div>
							</a>
							<div class="collapse" id="pagesCollapseError"
								aria-labelledby="headingOne"
								data-bs-parent="#sidenavAccordionPages">
								<nav class="sb-sidenav-menu-nested nav">
									<a class="nav-link" href="401.html">401 Page</a> <a
										class="nav-link" href="404.html">404 Page</a> <a
										class="nav-link" href="500.html">500 Page</a>
								</nav>
							</div>
						</nav>
					</div>
					<div class="sb-sidenav-menu-heading">Addons</div>
					<a class="nav-link" href="charts.html">
						<div class="sb-nav-link-icon">
							<i class="fas fa-chart-area"></i>
						</div> Charts
					</a>
					<%-- <a class="nav-link" href="danh-sach-san-pham/${currentPage}">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Danh sách sản phẩm
                            </a> --%>
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapsePages" aria-expanded="false"
						aria-controls="collapsePages">
						<div class="sb-nav-link-icon">
							<i class="fas fa-book-open"></i>
						</div> Danh sách sản phẩm 
						
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapsePages"
						aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav accordion"
							id="sidenavAccordionPages">
							<c:forEach var="item" items="${dataItemType}">
								<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
									data-bs-target="#pagesCollapseAuth" aria-expanded="false"
									aria-controls="pagesCollapseAuth"> ${item.name}
									<div class="sb-sidenav-collapse-arrow">
										<i class="fas fa-angle-down"></i>
									</div>
								</a>
								
								<c:forEach var="itemTypeOfCategory" items="${typeOfCategory}">
								<c:if test="${item.item_id==itemTypeOfCategory.item_id}">
									<div class="collapse" id="pagesCollapseAuth"
										aria-labelledby="headingOne"
										data-bs-parent="#sidenavAccordionPages">
										<nav class="sb-sidenav-menu-nested nav">

 											<a class="nav-link" href="<c:url value="/home/danh-sach-san-pham/${itemTypeOfCategory.item_id }/${itemTypeOfCategory.type_id }/1"/>">${itemTypeOfCategory.type_name }</a> 
 									</nav>

									</div>
								</c:if>	
								</c:forEach>
								
								<%-- <c:if test="${item.item_id=='item02'}">
								<c:forEach var="itemTypeOfCategory" items="${cat}">
									<div class="collapse" id="pagesCollapseAuth"
										aria-labelledby="headingOne"
										data-bs-parent="#sidenavAccordionPages">
										<nav class="sb-sidenav-menu-nested nav">

											<a class="nav-link" href="<c:url value="/home/danh-sach-san-pham/${itemTypeOfCategory.item_id}/${itemTypeOfCategory.type_id}/1"/>">${itemTypeOfCategory.type_name }</a> 
										</nav>

									</div>
									
								</c:forEach>
								</c:if> --%>
							</c:forEach>
							<!-- <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Sản phẩm cho mèo
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="401.html">Thức ăn khô</a>
                                            <a class="nav-link" href="404.html">Thức ăn ướt</a>
                                            <a class="nav-link" href="500.html">Pate</a>
                                        </nav>
                                    </div> -->
						</nav>
					</div>
				</div>
			</div>
			<div class="sb-sidenav-footer">
				<div class="small">Logged in as:</div>
				Start Bootstrap
			</div>
		</nav>
	</div>
</div>