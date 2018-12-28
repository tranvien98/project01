package ui;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controls.DichVuCT;
import controls.KhachHangCT;
import controls.MyConnect;
import controls.PhongCT;



public class HoaDonUI extends JDialog{
	public Connection conn;
	JPanel pnTitle, pnMain, pnInfo, pnPhong, pnDichVu;
	JButton btnDispose,btnNhan, btnChon;
	JLabel lblMa, lblTitle, lblContent, lblInfo,  lblChon, lblDv, lblGiaPhong, lblGiadv, lblTong;
	JTextField txtPhong, txtDv, txtTong;
	JTable table1, table2, table3;
	KhachHangCT khCT = new KhachHangCT();
	PhongCT phCT = new PhongCT();
	DichVuCT dvCT = new DichVuCT();
	long Tong;
	public HoaDonUI() {
		khCT.connect();
		phCT.connect();
		dvCT.connect();
		addControls();
		addEvents();
		loadKh();
		loadPh();
		loadDv();
	}
	public void addControls() {
		Container con = getContentPane();
		con.setLayout(null);
		
		pnTitle = new JPanel(null);
		pnTitle.setBounds(0, 0, 800, 30);
		pnTitle.setBackground(new Color(178, 0, 31));
		con.add(pnTitle);
		
		lblTitle = new JLabel("VieHotel");
		lblTitle.setBounds(370, 0, 180, 20);
		lblTitle.setForeground(new Color(255, 255, 255));
		pnTitle.add(lblTitle);
		
		btnDispose =  new JButton(new ImageIcon(getClass().getResource("/image/dispose.jpg")));
		btnDispose.setBounds(770, 0, 30, 30);
		pnTitle.add(btnDispose);
		
		pnMain = new JPanel(null);
		pnMain.setBounds(0, 30, 800, 570);
		con.add(pnMain);
		
		lblContent = new JLabel("Hóa Đơn");
		lblContent.setBounds(360, 20, 250, 40);
		lblContent.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		pnMain.add(lblContent);
		
		pnInfo = createTablePanel1();
		pnInfo.setBounds(20, 80, 760, 40);
		pnInfo.setLayout(new GridLayout(1, 1));
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pnMain.add(pnInfo);
	    
		
		lblInfo = new JLabel("Thông tin khách hàng");
		lblInfo.setBounds(20, 50, 150, 20);
		pnMain.add(lblInfo);
	
				

		
		lblChon = new JLabel("Thông tin phòng");
		lblChon.setBounds(20,180,120,20);
		pnMain.add(lblChon);
		
		pnPhong = createTablePanel2();
		pnPhong.setBounds(20, 200, 760, 40);
		pnPhong.setLayout(new GridLayout(1, 1));
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pnMain.add(pnPhong);
		
		lblGiaPhong = new JLabel("Tổng tiền phòng");
		lblGiaPhong.setBounds(500,260,100,20);
		pnMain.add(lblGiaPhong);
		
		txtPhong = new JTextField();
		txtPhong.setBounds(610,260,100,20);
		txtPhong.setEditable(false);
		pnMain.add(txtPhong);
		
		lblDv = new JLabel("Thông tin dịch vụ");
		lblDv.setBounds(20,280,120,20);
		pnMain.add(lblDv);
		
		pnDichVu = createTablePanel3();
		pnDichVu.setBounds(20, 300, 760, 80);
		pnDichVu.setLayout(new GridLayout(1, 1));
		table3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pnMain.add(pnDichVu);
		
		lblGiadv = new JLabel("Tổng tiền dịch vụ");
		lblGiadv.setBounds(500,390,100,20);
		pnMain.add(lblGiadv);
		
		txtDv = new JTextField();
		txtDv.setBounds(610,390,100,20);
		txtDv.setEditable(false);
		pnMain.add(txtDv);
		
		lblTong = new JLabel("Tổng tiền");
		lblTong.setBounds(500,430,100,20);
		pnMain.add(lblTong);
		
		txtTong = new JTextField();
		txtTong.setBounds(610,430,100,20);
		txtTong.setEditable(false);
		pnMain.add(txtTong);
		 
		btnNhan = new JButton("Thanh toán");
		btnNhan.setBounds(340, 510, 150, 30);
		pnMain.add(btnNhan);
	}
	public void addEvents() {
		this.addComponentListener(new ComponentAdapter() {
					@Override
					public void componentShown(ComponentEvent arg0) {
						long giadv = 0;
						long giaph = 0;
						// TODO Auto-generated method stub
						if(!txtDv.getText().equals("")){
							giadv = Long.parseLong(txtDv.getText());
						}
						if(!txtPhong.getText().equals("")) {
							giaph= Long.parseLong(txtPhong.getText());
						}
						Tong = giadv + giaph;
						txtTong.setText(String.valueOf(Tong));
						if(check()) {
							btnNhan.setEnabled(false);
						
						}
						else {
							btnNhan.setEnabled(true);
							
						}
					}
		});
		btnDispose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		btnNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				add();
				dispose();
			}
		});
		
	
	
	}
	public void showWindow() {
		  this.setSize(800,600);
	        setUndecorated(true);
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   	    this.setLocationRelativeTo(null);
	        this.setModal(true);
	        this.setVisible(true);
	}
	public static void main(String[] args) {
		HoaDonUI ql = new HoaDonUI();
		ql.showWindow();
	}
	public JPanel createTablePanel1() {
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(table1 = createTable1()));
		return panel;
	}

	public JTable createTable1() {
		JTable table1 = new JTable();
		return table1;
	}
	public JPanel createTablePanel2() {
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(table2 = createTable2()));
		return panel;
	}

	public JTable createTable2() {
		JTable table2 = new JTable();
		return table2;
	}
	public JPanel createTablePanel3() {
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(table3 = createTable3()));
		return panel;
	}

	public JTable createTable3() {
		JTable table3 = new JTable();
		return table3;
	}
	private void loadKh() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = khCT.getDataId("KH1");
		try {
			ResultSetMetaData rsMD = rs.getMetaData();
			int colNumber = rsMD.getColumnCount()-1;
			String[] arr = new String[colNumber];
			for (int i = 0; i < colNumber; i++) {
				arr[i] = rsMD.getColumnName(i + 1);
			}
			model.setColumnIdentifiers(arr);
			while (rs.next()) {
				for (int i = 0; i < colNumber; i++) {
					arr[i] = rs.getString(i + 1);
				}
				model.addRow(arr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table1.setModel(model);
	}
	private void loadPh() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rskh = khCT.getDataId(HomeUI.khachHang);
		String maPhong = null;
		try {
			if(rskh.next()) {
			maPhong = rskh.getString("MAPHONG");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs= phCT.getDataId(maPhong);
		try {
			ResultSetMetaData rsMD = rs.getMetaData();
			int colNumber = rsMD.getColumnCount()-2;
			String[] arr = new String[colNumber];
			for (int i = 0; i < colNumber; i++) {
				arr[i] = rsMD.getColumnName(i + 1);
			}
			
			model.setColumnIdentifiers(arr);
			while (rs.next()) {
				for (int i = 0; i < colNumber; i++) {
					arr[i] = rs.getString(i + 1);
				}
				txtPhong.setText(arr[3]);
				model.addRow(arr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table2.setModel(model);
	}
	private void loadDv() {
		DefaultTableModel model = new DefaultTableModel();
		MyConnect myConn = new MyConnect();
		conn = (Connection) myConn.getConnection();
		String sql = "SELECT * FROM datdv WHERE MAKH = ?;";
		ResultSet rs = null;
		PreparedStatement pst;
		long giatong = 0;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql) ;
			pst.setString(1, HomeUI.khachHang);
			rs = pst.executeQuery();
			   if (rs != null) {
                   while(rs.next()) {
             	
                		ResultSet rs1 = dvCT.getDataId(rs.getString("MADV"));
                		try {
                			ResultSetMetaData rsMD = rs1.getMetaData();
                			int colNumber = rsMD.getColumnCount();
                			String[] arr = new String[colNumber];
                			for (int i = 0; i < colNumber; i++) {
                				arr[i] = rsMD.getColumnName(i + 1);
                			}
                			model.setColumnIdentifiers(arr);
                			while (rs1.next()) {
                				for (int i = 0; i < colNumber; i++) {
                					arr[i] = rs1.getString(i + 1);
                				}
                				giatong+=Long.parseLong(arr[2]);
                				model.addRow(arr);
                			}
                		} catch (SQLException e) {
                			e.printStackTrace();
                		}
                   }}}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
		txtDv.setText(String.valueOf(giatong));
		table3.setModel(model);
	}
	private void add() {
		MyConnect myConn = new MyConnect();
		conn = (Connection) myConn.getConnection();
		ResultSet rskh = khCT.getDataId(HomeUI.khachHang);
		String maPhong = null;
		try {
			if(rskh.next()) {
			maPhong = rskh.getString("MAPHONG");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "INSERT INTO `hoadon` (`MAHD`, `MANV`, `MAKH`, `MAPHONG`, `NGAY`, `GIAHD`, `TinhTrang`) VALUES (NULL, ?, ?, ?, ?, ?, 'Đã Thanh toán');";
		String sql2 = "UPDATE `phong` SET `TINHTRANG` = 'Còn' WHERE `phong`.`MAPHONG` = ?;";
		PreparedStatement pst;
		PreparedStatement pst2;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String dateFormat = formatter.format(date);
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, HomeUI.nhanVien);
			pst.setString(2, HomeUI.khachHang);
			pst.setString(3, maPhong);
			pst.setString(4, dateFormat);
			pst.setDouble(5, Tong);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst2 = (PreparedStatement) conn.prepareStatement(sql2);
			pst2.setString(1, maPhong);
			pst2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean check() {
		MyConnect myConn = new MyConnect();
		conn = (Connection) myConn.getConnection();
		String sql  = "SELECT * FROM hoadon WHERE MAKH = ? AND TinhTrang = 'Đã thanh toán'";
		PreparedStatement pst;
		ResultSet rs = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, HomeUI.khachHang);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()) {
				return true;
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

