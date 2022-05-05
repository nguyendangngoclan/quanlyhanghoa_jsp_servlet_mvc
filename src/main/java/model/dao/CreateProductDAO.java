	package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateProductDAO extends BaseDAO {
	
        public String insertProduct(String maHH, String tenHH, String dvt,
        		String donGiaTK, String ghiChu) {
        	
        		Connection connection = getConnection();
                String sql = "INSERT INTO HANGHOA (MaHH,TenHH,DonGiaThamKhao,DonViTinh" + ",GhiChu) VALUES (?,?,?,?,?)";                
                PreparedStatement pstmt = null;
                	try {
                        pstmt = connection.prepareStatement(sql);
                        pstmt.setString(1, maHH);
                        pstmt.setString(2, tenHH);
                        pstmt.setDouble(3, Double.valueOf(donGiaTK));
                        pstmt.setString(4, dvt);
                        pstmt.setString(5, ghiChu);
                        
                        int x = pstmt.executeUpdate();
                        System.out.println("Đã chèn số record: " + x);          
                	} catch (SQLException e) {
                        e.printStackTrace();
                        //String errorMessage = e.getMessage();
                        //if (errorMessage != null && errorMessage.contains("The duplicate key value is")) {
                                return "Duplicate ID Error";
                	//}
                } finally {
                        closeConnection(connection, pstmt, null);
                }  
                	return "No error";
        }

		public String getLastestMaHH() {
			String lastestMaHH = null;           
            Connection connection = getConnection();
            String sql = "SELECT TOP 1 MaHH FROM HangHoa ORDER BY MaHH DESC";                
            PreparedStatement pstmt = null;
            ResultSet rs = null;           
            try {
                    pstmt = connection.prepareStatement(sql);
                    rs = pstmt.executeQuery();                        
                    if (rs.next()) {
                            lastestMaHH = rs.getString("MaHH");
                    }                  
            } catch (SQLException e) {                 
                    e.printStackTrace();
            } finally {
                    closeConnection(connection, pstmt, rs);

            }           
            		return lastestMaHH;
    }
}