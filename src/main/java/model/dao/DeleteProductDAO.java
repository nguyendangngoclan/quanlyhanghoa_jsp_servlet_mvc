package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteProductDAO extends BaseDAO {

	public void deleteProduct(String proId) {
		Connection connection = getConnection();
		String sql = "DELETE FROM HangHoa WHERE mahh=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, proId);
			pstmt.executeUpdate();
			int x = pstmt.executeUpdate();
			System.out.println("Đã xóa số record:"+x);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connection, pstmt, null);
		}
	}

}
