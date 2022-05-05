package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLoginDAO extends BaseDAO {

	public int getAccountRole(String tenDangNhap, String matKhau) {
		Connection connection = getConnection();
		String sql ="SELECT *FROM NHANVIEN where username=? AND password=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, tenDangNhap);
			pstmt.setString(2, matKhau);
			pstmt.execute();
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if("admin".equals(rs.getString("role"))) {
					return 1;
				}else {
					return 2;
				}
			}else {
				return 0;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeConnection(connection, pstmt, rs);
		}
		return 0;
	}

}
