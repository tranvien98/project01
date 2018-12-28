package controls;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.PreparedStatement;

import unit.DichVu;



public class DichVuCT {
	public Connection conn;

	public void connect() {
		MyConnect myConn = new MyConnect();
		conn = myConn.getConnection();
	}
	public ResultSet getData() {
		String sql = "SELECT * FROM dichvu;";
		ResultSet rs = null;
		PreparedStatement pst;
		
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return rs;
	}
	public ResultSet getDataId(String id) {
		String sql = "SELECT * FROM dichvu WHERE MADV = ?;";
		ResultSet rs = null;
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return rs;
	}
	public void deleteId(String id) {
		String sql = "DELETE FROM dichvu WHERE MADV = ?";
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
	
	}
	public void insert(DichVu dv) {
		String sql = "INSERT INTO dichvu (MADV, TENDV, GIADV) VALUES (?, ?, ?);";
		
		PreparedStatement pst;
		
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, dv.getMaDV());
			pst.setString(2, dv.getTenDV());
			pst.setDouble(3, dv.getGia());
	
		
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
	
	}
	public void updateId(DichVu dv) {
		String sql = "UPDATE dichvu SET  TENDV = ?, GIADV = ? WHERE MADV = ?;";

		PreparedStatement pst;
		
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(3, dv.getMaDV());
			pst.setString(1, dv.getTenDV());
			pst.setDouble(2, dv.getGia());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
	public void showData(ResultSet rs)
	{
		try {
			while(rs.next()) {
				try {
					System.out.printf("%-10s %-20s \n",rs.getString(1),rs.getString(2));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DichVuCT ph = new DichVuCT();
		ph.connect();
//		ph.showData(ph.getDataId("DV1"));
	}

}
