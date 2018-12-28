package ui;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controls.KhachHangCT;
import controls.MyConnect;
import controls.PhongCT;
import unit.KhachHang;

public class DatPhongUI extends JDialog{
	public Connection conn;
	JPanel pnTitle, pnMain, pnInfo, pnList;
	JButton btnDispose,btnNhan, btnChon;
	JLabel lblMa, lblTitle, lblContent, lblInfo, lblCmt, lblName, lblAddress, lblEmail, lblGender, lblSdt, lblPhong, lblChon;
	JTextField txtMa, txtPhong, txtCmt, txtName, txtAddress, txtEmail, txtGender, txtSdt;
	JTable table;
	PhongCT phCT = new PhongCT();
	KhachHangCT khCT = new KhachHangCT();
	public DatPhongUI() {
		phCT.connect();
		khCT.connect();
		addControls();
		addEvents();
		loadData();
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
		
		lblContent = new JLabel("Đặt phòng");
		lblContent.setBounds(360, 20, 250, 40);
		lblContent.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		pnMain.add(lblContent);
		
		pnInfo = new JPanel(null);
		pnInfo.setBounds(20, 80, 760, 150);
		pnInfo.setBorder(BorderFactory.createLineBorder(Color.black));
		pnMain.add(pnInfo);
		
		lblInfo = new JLabel("Thông tin khách hàng");
		lblInfo.setBounds(20, 0, 150, 20);
		pnInfo.add(lblInfo);
		
		lblMa = new JLabel("Mã KH");
		lblMa.setBounds(20,30,100,20);
		pnInfo.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setBounds(120,30,200,20);
		pnInfo.add(txtMa);
		
		lblCmt = new JLabel("Số CMND");
		lblCmt.setBounds(20, 60, 100, 20);
		pnInfo.add(lblCmt);
		
		txtCmt = new JTextField();
		txtCmt.setBounds(120, 60, 200, 20);
		pnInfo.add(txtCmt);
		
		lblName = new JLabel("Họ Tên");
		lblName.setBounds(20, 90, 100, 20);
		pnInfo.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(120, 90, 200, 20);
		pnInfo.add(txtName);
		
		lblAddress = new JLabel("Địa Chỉ");
		lblAddress.setBounds(20, 120, 100, 20);
		pnInfo.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(120, 120, 200, 20);
		pnInfo.add(txtAddress);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(400, 30, 100, 20);
		pnInfo.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(500, 30, 200, 20);
		pnInfo.add(txtEmail);
		
		lblGender = new JLabel("Giới Tính");
		lblGender.setBounds(400, 60, 100, 20);
		pnInfo.add(lblGender);
		
		txtGender = new JTextField();
		txtGender.setBounds(500, 60, 200, 20);
		pnInfo.add(txtGender);
		
		lblSdt = new JLabel("Số Điện Thoại");
		lblSdt.setBounds(400, 90, 100, 20);
		pnInfo.add(lblSdt);
		
		txtSdt = new JTextField();
		txtSdt.setBounds(500, 90, 200, 20);
		pnInfo.add(txtSdt);
		
		lblPhong = new JLabel("Mã phòng");
		lblPhong.setBounds(400,120,100,20);
		pnInfo.add(lblPhong);
		
		txtPhong = new JTextField();
		txtPhong.setBounds(500,120,200,20);
		pnInfo.add(txtPhong);
				
		pnList = createTablePanel();
		pnList.setBounds(20, 300, 760, 200);
		pnList.setLayout(new GridLayout(1, 1));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		pnList.setBorder(BorderFactory.createLineBorder(Color.black));
		pnMain.add(pnList);
		
		lblChon = new JLabel("Chọn phòng");
		lblChon.setBounds(10,270,80,20);
		pnMain.add(lblChon);
		 btnChon = new JButton("Chọn");
		 btnChon.setBounds(700,270,80,20);
		 pnMain.add(btnChon);
		 
		btnNhan = new JButton("Nhận phòng");
		btnNhan.setBounds(340, 510, 150, 30);
		pnMain.add(btnNhan);
	}
	public void addEvents() {
		btnDispose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		btnChon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				txtPhong.setText((String) table.getValueAt(row, 0));
			}
		});
		btnNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				add();
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
		DatPhongUI ql = new DatPhongUI();
		ql.showWindow();
	}
	public JPanel createTablePanel() {
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(table = createTable()));
		return panel;
	}

	public JTable createTable() {
		JTable table = new JTable();
		return table;
	}
	private void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = phCT.getCon();
		try {
			ResultSetMetaData rsMD = rs.getMetaData();
			int colNumber = rsMD.getColumnCount() - 1;
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
		table.setModel(model);
	}
	private KhachHang getKhachHang() {
		String maKH = txtMa.getText().trim().toUpperCase();
		String tenKH = txtName.getText().trim();
		String cmnd = txtCmt.getText().trim();
		String diaChi = txtAddress.getText().trim();
		String email = txtEmail.getText().trim();
		String gioiTinh = txtGender.getText().trim();
		String sdt = txtSdt.getText().trim();
		String maPhong = txtPhong.getText().trim();

		if (maKH.equals("") || tenKH.equals("") || cmnd.equals("") || diaChi.equals("") 
				|| email.equals("") || gioiTinh.equals("") ||sdt.equals("") )
			return null;
		KhachHang kh = new KhachHang(maKH, tenKH, cmnd, diaChi, email, gioiTinh, sdt, maPhong);
		return kh;
	}
	public void add() {
		KhachHang kh = getKhachHang();
	
		  int input = JOptionPane.showOptionDialog(null, "Nhận phòng", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
	       
      	  if(input == JOptionPane.OK_OPTION)
      	  {
      		if (kh != null) {
      			
				khCT.insert(kh);
				MyConnect myConn = new MyConnect();
				conn = (Connection) myConn.getConnection();
				String maPhong = txtPhong.getText().trim().toUpperCase();
				String sql = "UPDATE phong SET TINHTRANG = 'Hết' WHERE MAPHONG = ?";			
				PreparedStatement pst ;
				try {
					pst = (PreparedStatement) conn.prepareStatement(sql);
					pst.setString(1, maPhong);
					pst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Lỗi !",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
      	  }
	}
}
