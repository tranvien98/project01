package controls;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.PreparedStatement;

import unit.KhachHang;

public class KhachHangCT {
	public Connection conn;

	public void connect() {
		MyConnect myConn = new MyConnect();
		conn = myConn.getConnection();
	}
	public ResultSet getData() {
		String sql = "SELECT * FROM khachhang;";
		ResultSet rs = null;
		PreparedStatement pst;
		
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("loi getDataKH");
		}
		return rs;
	}
	public ResultSet getDataId(String id) {
		String sql = "SELECT * FROM khachhang WHERE MAKH = ?;";
		ResultSet rs = null;
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Loi getDataIdKH");
		}
		return rs;
	}
	public void deleteId(String id) {
		String sql = "DELETE FROM `khachhang` WHERE `khachhang`.`MAKH` = ?";
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
	public void insert(KhachHang kh) {
		String sql = "INSERT INTO `khachhang` (`MAKH`, `CMND`, `TENKH`, `DIACHI`, `EMAIL`, `GIOITINH`, `SDT`, `MAPHONG`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement pst;
		
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, kh.getMaKH());
			pst.setString(2, kh.getCmnd());
			pst.setString(3, kh.getTenKH());
			pst.setString(4, kh.getDiaChi());
			pst.setString(5, kh.getEmail());
			pst.setString(6, kh.getGioiTinh());
			pst.setString(7, kh.getSdt());
			pst.setString(8, kh.getMaPhong());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
	
	}
	public void updateId(KhachHang kh) {
		String sql = "UPDATE khachhang SET  CMND = ?,TENKH = ?, EMAIL = ?, DIACHI = ?, GIOITINH = ?, SDT = ?, MAPHONG = ? WHERE MAKH = ?;";

		PreparedStatement pst;
		
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(8, kh.getMaKH());
		
			pst.setString(1, kh.getCmnd());
			pst.setString(2, kh.getTenKH());
			pst.setString(3, kh.getEmail());
			pst.setString(4, kh.getDiaChi());
		
			pst.setString(5, kh.getGioiTinh());
			pst.setString(6, kh.getSdt());
			pst.setString(7, kh.getMaPhong());
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
		KhachHangCT kh = new KhachHangCT();
		kh.connect();
//		kh.insert(new KhachHang("KA1", "ten", "12222", "Hà", "dsad", "NỮ", "0123333", "P105"));
	}

}
