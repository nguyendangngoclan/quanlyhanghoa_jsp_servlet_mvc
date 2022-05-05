<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ của Admin</title>
</head>
<body>
<% 
	if(session.getAttribute("accountInfor")==null){
		response.sendRedirect("login.jsp?error=1");
	}else{
%>
 <div style="background-color: yellow; width: 100px"><a href="ShowProductListServlet">Hàng hóa</a></div>
 <div><%=(String)session.getAttribute("accountInfor")%></div> 
  <div style="background-color: yellow; width: 100px"><a href="LogoutServlet">Đăng xuất</a></div>
 <%} %> 
</body> 
</html>