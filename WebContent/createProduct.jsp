<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
           if (session.getAttribute("accountInfor") == null) {
                   response.sendRedirect("login.jsp?error=1");
           } else {     
       %>
        <% String error = request.getParameter("message"); %>
         <%=("1".equals(error)) ? "Lỗi trùng mã hàng hóa, bạn vui lòng thao tác lại!" : "" %>
        <%=("2".equals(error)) ? "Đã có lỗi không xác định được nguyên nhân, bạn thử vui lòng thao tác lại, hoặc liên hệ với người quản trị hệ thống!" : "" %>
		<%=("3".equals(error)) ? "Lỗi chưa nhập đầy đủ tên hàng hóa, đơn vị tính, đơn giá tham khảo!" : "" %>
		<%=("4".equals(error)) ? "Đơn giá tham khảo phải là số!" : ""%>
	
		<br>
		<% String tenHH = request.getParameter("tenHH") != null ? request.getParameter("tenHH") : ""; %>
		<% String dvt = request.getParameter("dvt") != null ? request.getParameter("dvt") : ""; %>
		<% String donGiaTK = request.getParameter("donGiaTK") != null ? request.getParameter("donGiaTK") : ""; %>
		<% String ghiChu = request.getParameter("ghiChu") != null ? request.getParameter("ghiChu") : ""; %>
	TẠO MỚI HÀNG HÓA
	<form action="CreateProductServlet" method="post">
	<!--  Mã hàng: <input type="text" name="maHH" />  -->
	Tên hàng: <input type="text" name="tenHH" id="tenHH" value="<%=tenHH %>"  />
	Đơn vị tính: <input type="text" name="dvt" id="dvt" value="<%=dvt%>"/>
	Đơn giá tham khảo: <input type="text" name="donGiaTK" id="donGiaTK" value="<%=donGiaTK %>"  />
	Ghi Chú: <input type="text" name="ghiChu" value="<%=ghiChu %>" />
	
	<input type="submit"  onclick="return true" value="Thêm" />
	<input type="reset" value="Hủy bỏ" />
	</form>
	
<script >
function validate() {
    var errorMessage = "";   
    if (document.getElementById("tenHH").value == "") {
            errorMessage = errorMessage + 'Hãy nhập tên hàng hóa; ';
    }    
    if (document.getElementById("dvt").value == "") {
            errorMessage = errorMessage + 'Hãy nhập đơn vị tính; ';
    }    
    if (document.getElementById("donGiaTK").value == "") {
            errorMessage = errorMessage + 'Hãy nhập đơn giá tham khảo; ';
    }
    var dgtkTmp = Number(document.getElementById("donGiaTK").value); 
    if (Number.isNaN(dgtkTmp)|| dgtkTmp < 0) {

        errorMessage = errorMessage + 'Đơn giá tham khảo phải là một số nguyên';

	}
    if (errorMessage != "") {
        alert(errorMessage);
}
    return errorMessage == "";

}
</script>
<%} %>	
</body>
</html>