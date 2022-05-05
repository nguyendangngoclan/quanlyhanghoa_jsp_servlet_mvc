package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;


import com.sun.jdi.connect.spi.ClosedConnectionException;



import model.bean.HangHoa;

public class ShowProductListDAO extends BaseDAO {

	public ArrayList<HangHoa> getDsHangHoa() {
		ArrayList<HangHoa> returnedList = new ArrayList<HangHoa>();
		Connection connection = getConnection();
		String sql = "SELECT *FROM HangHoa";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			HangHoa item = null;
			while(rs.next()) {
				item = new HangHoa();
				item.setMaHH(rs.getString("maHH"));
				item.setTenHH(rs.getString("tenHH"));
				item.setDonGiaThamKhao(rs.getDouble("dongiathamkhao"));
				item.setDonViTinh(rs.getString("donvitinh"));
				item.setGhiChu(rs.getString("ghichu"));
				
				returnedList.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList;
	}

	public ArrayList<HangHoa> getDsHangHoa(int pageNumber) {
		ArrayList<HangHoa> tempList = new ArrayList<HangHoa>();
		ArrayList<HangHoa> returnedList = new ArrayList<HangHoa>();
		int itemNumber=0;
		Connection connection = getConnection();
        String sql = "SELECT mahh, tenhh, dongiathamkhao, donvitinh, ghichu FROM HangHoa ORDER BY mahh";                
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
        	pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();           
            HangHoa item = null;
            
            while (rs.next()&& itemNumber<pageNumber*20) {
                item = new HangHoa();
                item.setMaHH(rs.getString("mahh"));
                item.setTenHH(rs.getString("tenhh"));
                item.setDonGiaThamKhao(rs.getDouble("dongiathamkhao"));
                item.setDonViTinh(rs.getString("donvitinh"));
                item.setGhiChu(rs.getString("ghichu"));
                
                tempList.add(item);
            }
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			closeConnection(connection, pstmt, rs);
		}
        int pageQuantity=(int)Math.ceil(tempList.size()/20.0);
        if(pageNumber>pageQuantity||pageNumber<=0) {
        	 return returnedList;
        }else {
        	for(int i=(pageNumber-1)*20;(i<pageNumber*20)&&(i<tempList.size());i++) {
        		returnedList.add(tempList.get(i));
        	}
        }
		return returnedList;
	}

	public int getTotalPageNumber() {
		Connection connection = getConnection();
        String sql = "SELECT count(mahh) as tongsodong FROM HangHoa";                
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int totalPageNumber = 0;
        try {
        	pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();          
            if (rs.next()) {
                    totalPageNumber = rs.getInt("tongsodong");
            }
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeConnection(connection, pstmt, rs);
		}
		return (int)Math.ceil(totalPageNumber / 20.0);
	}
	
	public ArrayList<HangHoa> getDsHangHoaBySQL(int pageNumber) {
		 ArrayList<HangHoa> returnedList = new ArrayList<HangHoa>();
		 Connection connection = getConnection();
		 String sql = "SELECT * FROM (SELECT RowNum = ROW_NUMBER() OVER (ORDER BY mahh), * FROM HangHoa) "
		 		+ "AS tempTable WHERE RowNum > (? * (? - 1)) AND RowNum <= (? * (? - 1)) + ? ORDER BY mahh"; 
		 PreparedStatement pstmt = null;
         ResultSet rs = null; 
         
         try {
        	 pstmt = connection.prepareStatement(sql);

             pstmt.setString(1, "20");

             pstmt.setString(2, String.valueOf(pageNumber));

             pstmt.setString(3, "20");

             pstmt.setString(4, String.valueOf(pageNumber));

             pstmt.setString(5, "20");                        

             

             rs = pstmt.executeQuery();

             

             HangHoa item = null;

             

             while (rs.next()) {

                     item = new HangHoa();

                     item.setMaHH(rs.getString("mahh"));

                     item.setTenHH(rs.getString("tenhh"));

                     item.setDonGiaThamKhao(rs.getDouble("dongiathamkhao"));

                     item.setDonViTinh(rs.getString("donvitinh"));

                     item.setGhiChu(rs.getString("ghichu"));

                     

                     returnedList.add(item);
             }
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList;
	}

}
