package controls;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.PreparedStatement;


import unit.Phong;

public class PhongCT {
	public Connection conn;

	public void connect() {
		MyConnect myConn = new MyConnect();
		conn = myConn.getConnection();
	}
	public ResultSet getData() {
		String sql = "SELECT * FROM phong;";
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
	public ResultSet getCon() {
		String sql = "SELECT * FROM phong WHERE TINHTRANG = 'Còn';";
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
		String sql = "SELECT * FROM phong WHERE MAPHONG = ?;";
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
		String sql = "DELETE FROM phong WHERE MAPHONG = ?";
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
	public void insert(Phong ph) {
		String sql = "INSERT INTO `phong` (`MAPHONG`, `TENPHONG`, `LOAIPHONG`, `GIAPHONG`, `TINHTRANG`, `CHUTHICH`) VALUES (?, ?, ?, ?, ?, ?);";
		
		PreparedStatement pst;
		
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, ph.getMaPhong());
			pst.setString(2, ph.getTenPhong());
			pst.setString(3, ph.getLoaiPhong());
			pst.setDouble(4, ph.getGiaPhong());
			pst.setString(5, ph.getTinhTrang());
			pst.setString(6, ph.getChuThich());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
	
	}
	public void updateId(Phong ph) {
		String sql = "UPDATE phong SET  TENPHONG = ?, LOAIPHONG = ?, GIAPHONG = ?, TINHTRANG = ?, CHUTHICH = ? WHERE MAPHONG = ?;";

		PreparedStatement pst;
		
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(6, ph.getMaPhong());
			pst.setString(1, ph.getTenPhong());
			pst.setString(2, ph.getLoaiPhong());
			pst.setDouble(3, ph.getGiaPhong());
			pst.setString(4, ph.getTinhTrang());
			pst.setString(5, ph.getChuThich());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("LOI updateKH");
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
		PhongCT ph = new PhongCT();
		ph.connect();
//		ph.showData(ph.getDataId("P105"));
	}

}
