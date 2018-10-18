import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MyConnect {
	private Connection connection;
	public  void connect() {
		final String url = "jdbc:mysql://localhost:3306/SinhVien";
		final String user = "root";
		final String password = "";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					connection = DriverManager.getConnection(url, user, password);
					System.out.println("Thanh Cong!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("That bai!");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("That bai!");
			}
		
	}	

	public ResultSet getData()
	{
		ResultSet rs = null;
		Statement st;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM SINHVIEN");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error!");
		}
		return rs;
	}
	public void showData(ResultSet rs)
	{
		try {
			while(rs.next()) {
				try {
					System.out.printf("%-10s %-20s %-10.1f %-10s \n",rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet getDataId(String id)
	{
		String sqlcommand = "SELECT * FROM SINHVIEN WHERE Ma_SV = ?";
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {			
			pst = connection.prepareStatement(sqlcommand);
			pst.setString(1, id);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error!" + e.toString());
		}
		return rs;
	}
	public void deleteId(String id)
	{
		String sqlcommand = "DELETE FROM SINHVIEN WHERE MA_SV = ?";
		PreparedStatement pst = null;
		try {			
			pst = connection.prepareStatement(sqlcommand);
			pst.setString(1, id);
			if(pst.executeUpdate()>0)
			{
			System.out.println("delete Success!");
			}
			else System.out.println("delete Error!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error!" + e.toString());
		}
	}
	public void insert(Student s)
	{
		String sqlcommand = "INSERT INTO SINHVIEN VALUE(?,?,?,?)";
		PreparedStatement pst = null;
		try {			
			pst = connection.prepareStatement(sqlcommand);
			pst.setString(1, s.getId());
			pst.setString(2, s.getName());
			pst.setDouble(3, s.getPoint());
			pst.setString(4, s.getGender());
			if(pst.executeUpdate()>0)
			{
			System.out.println("insert Success!");
			}
			else System.out.println("insert Error!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error!" + e.toString());
		}
	}
	public void update(String id, Student s)
	{
		String sqlcommand = "UPDATE SINHVIEN SET Ten_SV = ?,Diem = ?,Gioi_Tinh = ? WHERE Ma_SV = ?";
		PreparedStatement pst = null;
		try {			
			pst = connection.prepareStatement(sqlcommand);
			pst.setString(4, s.getId());
			pst.setString(1, s.getName());
			pst.setDouble(2, s.getPoint());
			pst.setString(3, s.getGender());
			if(pst.executeUpdate()>0)
			{
			System.out.println("update Success!");
			}
			else System.out.println("update Error!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error!" + e.toString());
		}
	}
	public static void main(String[] args) {
	    MyConnect myConnect = new MyConnect();
	    myConnect.connect();
//	    myConnect.showData(myConnect.getDataId("A15"));
//	    myConnect.deleteId("A14");
//	    myConnect.update(new Student("A14", "Nguyen Van A", 8.0, "NAM"));
//	    myConnect.showData(myConnect.getData());
	}
}
