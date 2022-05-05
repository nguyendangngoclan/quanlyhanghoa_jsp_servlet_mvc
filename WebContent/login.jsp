<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
<% 
	String error = request.getParameter("error");
%>
<%=("1".equals(error))?"Mời bạn đăng nhập!" : ""
%>
<%=("2".equals(error))?"Thông tin đăng nhập không đúng!" : ""
%>

	<h1>ĐĂNG NHẬP</h1>
	<form action="login" method="post">
	Tên đăng nhập: <input type="text" name="tenDangNhap"/>
	Mật khẩu: <input type="password" name="matKhau" />
	<input type="submit" value="Đăng nhập" />
	<input type="button" value="Quay về trang chủ">
	</form>
</body>
</html>