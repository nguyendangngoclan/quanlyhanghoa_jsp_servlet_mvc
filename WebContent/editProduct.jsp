<%@page import="java.text.DecimalFormat"%>
<%@page import="common.StringCommon"%>
<%@page import="model.bean.HangHoa"%>
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
	<%
	String error = request.getParameter("message");
	%>
	<%=("2".equals(error))
		? "Đã có lỗi không xác định được nguyên nhân, bạn thử vui lòng thao tác lại, hoặc liên hệ với người quản trị hệ thống!"
		: ""%>
	<%=("3".equals(error)) ? "Lỗi chưa nhập đầy đủ tên hàng hóa, đơn vị tính, đơn giá tham khảo!" : ""%>
	<%=("4".equals(error)) ? "Đơn giá tham khảo phải là số!" : ""%>
	<br>
	<%
	String maHH = null;
    String tenHH = null;
    String dvt = null;
    String donGiaTK = null;
    String ghiChu = null;
    if (error == null || "".equals(error)) {
    	HangHoa hangHoa = (HangHoa)request.getAttribute("hangHoa");
    	maHH = hangHoa.getMaHH();
        tenHH = hangHoa.getTenHH();
        dvt = hangHoa.getDonViTinh();
        donGiaTK = StringCommon.convertDoubleToString(hangHoa.getDonGiaThamKhao());
        ghiChu = hangHoa.getGhiChu();
    }else {
    	maHH = request.getParameter("maHH") != null ? request.getParameter("maHH") : "";
        tenHH = request.getParameter("tenHH") != null ? request.getParameter("tenHH") : "";
        dvt = request.getParameter("dvt") != null ? request.getParameter("dvt") : "";
        donGiaTK = request.getParameter("donGiaTK") != null ? request.getParameter("donGiaTK") : "";
        ghiChu = request.getParameter("ghiChu") != null ? request.getParameter("ghiChu") : "";
    }
	%>
	

	CHỈNH SỬA HÀNG HÓA
	<form action="EditProductServlet" method="post">
			Mã hàng: <input type="text"  value="<%=maHH%>" disabled="disabled"/>
			<input type="hidden" name="maHH" value="<%=maHH%>" />
            Tên hàng: <input type="text" name="tenHH" id="tenHH" value="<%=tenHH%>"/>
            Đơn vị tính: <input type="text" name="dvt" id="dvt" value="<%=dvt%>"/>
            Đơn giá tham khảo: <input type="text" name="donGiaTK" id="donGiaTK" value="<%=donGiaTK%>"/>
            Ghi chú: <input type="text" name="ghiChu" value="<%=ghiChu%>"/>
            <input type="submit"  onclick="return true" value="Sửa" />
			<input type="reset" value="Hủy bỏ" />
	</form>

	<script>
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
			if (Number.isNaN(dgtkTmp) || dgtkTmp < 0) {

				errorMessage = errorMessage
						+ 'Đơn giá tham khảo phải là một số nguyên';

			}
			if (errorMessage != "") {
				alert(errorMessage);
			}
			return errorMessage == "";

		}
	</script>
	<%
	}
	%>
</body>
</html>