package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {
	private static String hostName = "localhost"; // 127.0.0.1
	private static String password = "123123";
	private static String username = "sa1";
	private static String database = "DuAnWebFUGW";

	/**
	 *
	 * 
	 * 
	 * get connection to database
	 *
	 * 
	 * 
	 * @return Connection to database if connect success
	 * 
	 * @throws ClassNotFoundException
	 * 
	 * @throws SQLException
	 * 
	 */

	public Connection getConnection() {

		Connection conn = null;

		try {

			Class.forName("net.sourceforge.jtds.jdbc.Driver");

			String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":55086/" + database + ";CharacterSet=UTF-8";

			conn = DriverManager.getConnection(connectionURL, username, password);

			System.out.println("Connected!");

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return conn;

	}

	// public static void main(String[] args) {

	// BaseDAO baseDAO = new BaseDAO();

	// baseDAO.getConnection();

	// }

	public void closeConnection(Connection conn, PreparedStatement ps,ResultSet rs) {

		try {

			if (rs != null) {

				rs.close();

			}

			if (ps != null) {

				ps.close();

			}

			if (conn != null) {

				conn.close();

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
