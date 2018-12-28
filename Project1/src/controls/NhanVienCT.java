package controls;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import unit.NhanVien;



public class NhanVienCT {
    
	public Connection conn;
	public  void connect() {
		MyConnect myConn = new MyConnect();
		conn = myConn.getConnection();
		
	}	
  public ResultSet getData() {
	  ResultSet rs = null ;
	  Statement st ;
	
	   try {
		st =   (Statement) conn.createStatement();
		rs = st.executeQuery("SELECT * FROM nhanvien;");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Loi get DataNV");
	}
	  return rs; 
  }
  public ResultSet getDataId(String id) {
	  String sqlcommand = "SELECT * FROM nhanvien WHERE MANV = ?;";
	  ResultSet rs = null ;
	  PreparedStatement pst;
	try {
		pst = (PreparedStatement) conn.prepareStatement(sqlcommand);
		pst.setString(1, id);
		rs = pst.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Loi get DataIdNV");
	}
	
	  return rs;
  }
  public void deleteId(String id) {
	  String sqlcommand = "DELETE FROM nhanvien WHERE MANV = ?;";
	
	  PreparedStatement pst;
	  
	  try {
		pst = (PreparedStatement) conn.prepareStatement(sqlcommand);
		pst.setString(1, id);
		pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Loi deleteIdNV");
	}
	
	  
  }
  public void insert(NhanVien nv) {
	  String sqlcommand = "INSERT INTO nhanvien (MANV, TENNV, CHUCVU, LUONGNV, NGAYSINH, GIOITINH, DIACHI, CHUTHICH) VALUES (?, ?, ?, ?, ?, ?, ?, ?);"; 
	
	  PreparedStatement pst ;
	  
	  try {
		pst = (PreparedStatement) conn.prepareStatement(sqlcommand);
		pst.setString(1, nv.getMaNV());
		pst.setString(2, nv.getTenNV());
		pst.setString(3, nv.getChucVu());
		pst.setDouble(4, nv.getLuong());
		pst.setString(5, nv.getNgaySinh());
		pst.setString(6, nv.getGioiTinh());
		pst.setString(7, nv.getDiaChi());
		pst.setString(8, nv.getChuThich());
		pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.toString());
	}

  }
  public void updateId(NhanVien nv) {
	  	String sqlcommand = "UPDATE nhanvien SET TENNV = ?, CHUCVU = ?, LUONGNV = ?, NGAYSINH = ?, GIOITINH = ? , DIACHI = ?, CHUTHICH = ? WHERE MANV = ?;"; 
	  	PreparedStatement pst ;
	  
	  	try {
			pst = (PreparedStatement) conn.prepareStatement(sqlcommand);
			pst.setString(8, nv.getMaNV());
			pst.setString(1, nv.getTenNV());
			pst.setString(2, nv.getChucVu());
			pst.setDouble(3, nv.getLuong());
			pst.setString(4, nv.getNgaySinh());
			pst.setString(5, nv.getGioiTinh());
			pst.setString(6, nv.getDiaChi());
			pst.setString(7, nv.getChuThich());
			
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
		NhanVienCT nv = new NhanVienCT(); 
		nv.connect();
	
	}
}
