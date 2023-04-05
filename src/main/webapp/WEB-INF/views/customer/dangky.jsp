
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng ký</title>
 
<style>
.red {
	color: red;
}
</style>
</head>
<body>
	<%
	String baoLoi = request.getAttribute("baoLoi") + "";
	baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;

	String tenDangNhap = request.getAttribute("tenDangNhap") + "";
	tenDangNhap = (tenDangNhap.equals("null")) ? "" : tenDangNhap;
	String tenKhachHang = request.getAttribute("tenKhachHang") + "";
	tenKhachHang = (tenKhachHang.equals("null")) ? "" : tenKhachHang;

	String gioiTinh = request.getAttribute("gioiTinh") + "";
	gioiTinh = (gioiTinh.equals("null")) ? "" : gioiTinh;

	String ngaySinh = request.getAttribute("ngaySinh") + "";
	ngaySinh = (ngaySinh.equals("null")) ? "" : ngaySinh;

	String soDienThoai = request.getAttribute("soDienThoai") + "";
	soDienThoai = (soDienThoai.equals("null")) ? "" : soDienThoai;

	String email = request.getAttribute("email") + "";
	email = (email.equals("null")) ? "" : email;

	String dongYNhanMail = request.getAttribute("dongYNhanMail") + "";
	dongYNhanMail = (dongYNhanMail.equals("null")) ? "" : dongYNhanMail;
	%>
	<!-- Topbar Start -->
	</hr>
	<div class="container">
		<form class="form" action="dang-ky" method="post">
			<div class="row">
				<div class="col-sm-6">
					<div class="text-center">
						<h3>ĐĂNG KÝ TÀI KHOẢN</h3>
					</div>

					<div class="red" id="baoLoi">
						<%=baoLoi%>
					</div>
					<div class="mb-3">
						<label for="tenDangNhap" class="form-label">Tên đăng nhập<span
							class="red">*</span></label> <input type="text" class="form-control"
							id="tenDangNhap" name="tenDangNhap" required="required"
							value="<%=tenDangNhap%>" >
					</div>
					<div class="mb-3">
						<label for="matKhau" class="form-label">Mật khẩu<span
							class="red">*</span></label> <input type="password" class="form-control"
							id="matKhau" name="matKhau" required="required"
							onkeyup="kiemTraMatKhau()">
					</div>
					<div class="mb-3">
						<label for="matKhauNhapLai" class="form-label">Nhập lại
							mật khẩu<span class="red">*</span> <span id="msg" class="red"></span>
						</label> <input type="password" class="form-control" id="matKhauNhapLai"
							name="matKhauNhapLai" required="required"
							onkeyup="kiemTraMatKhau()">
					</div>
					<div class="mb-3">
						<label for="tenKhachHang" class="form-label">Tên khách hàng<span
							class="red">*</span></label> <input type="text" class="form-control"
							id="tenKhachHang" name="tenKhachHang" required="required"
							value="<%=tenKhachHang%>" >
					</div>
					<hr />
					<div class="mb-3">
						<label for="gioiTinh" class="form-label">Giới tính</label> <select
							class="form-control" id="gioiTinh" name="gioiTinh">
							<option></option>
							<option value="Nam"
								<%=(gioiTinh.equals("Nam")) ? "selected='selected'" : ""%>>Nam</option>
							<option value="Nữ"
								<%=(gioiTinh.equals("Nữ")) ? "selected='selected'" : ""%>>Nữ</option>
							<option value="Khác"
								<%=(gioiTinh.equals("Khác")) ? "selected='selected'" : ""%>>Khác</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="ngaySinh" class="form-label">Ngày sinh</label> <input
							type="date" class="form-control" id="ngaySinh" name="ngaySinh"
							value="<%=ngaySinh%>">
					</div>
					<div class="mb-3">
						<label for="soDienThoai" class="form-label">Số điện thoại<span
							class="red">*</span></label> <input type="tel" class="form-control"
							id="soDienThoai" name="soDienThoai" required="required" value="">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							value="<%=email%>">
					</div>
					<hr />
					<div class="mb-3">
						<label for="dongYDieuKhoan" class="form-label">Đồng ý với
							<a>điều khoản của công ty </a><span id="red">*</span>
						</label> <input type="checkbox" class="form-check-input"
							id="dongYDieuKhoan" name="dongYDieuKhoan" required="required">
					</div>
					<div class="mb-3">
						<label for="dongYNhanMail" class="form-label">Đồng ý nhận
							email</label> <input type="checkbox" class="form-check-input"
							id="dongYNhanMail" name="dongYNhanMail">
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Đăng ký" name="submit" id="submit" />
				</div>



			</div>
		</form>
	</div>
</body>
<content tag="script">
<script>
	function kiemTraMatKhau() {
		matKhau = document.getElementById("matKhau").value;
		matKhauNhapLai = document.getElementById("matKhauNhapLai").value;
		if (matKhau != matKhauNhapLai) {
			document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
</script>
</content>

</html>