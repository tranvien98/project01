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

public class TaiKhoanUI extends JDialog{
	public Connection conn;
	JPanel pnTitle, pnMain, pnInfo, pnList;
	JButton btnDispose,btnNhan, btnChon;
	JLabel lblMa, lblTitle, lblContent, lblInfo, lblCmt, lblName, lblPass,lblManv, lblChon;
	JTextField txtMa, txtPhong, txtCmt, txtName, txtPass,txtManv;

	public TaiKhoanUI() {	
		addControls();
		addEvents();
	}
	public void addControls() {
		Container con = getContentPane();
		con.setLayout(null);
		
		pnTitle = new JPanel(null);
		pnTitle.setBounds(0, 0, 500, 30);
		pnTitle.setBackground(new Color(178, 0, 31));
		con.add(pnTitle);
		
		lblTitle = new JLabel("VieHotel");
		lblTitle.setBounds(190, 0, 180, 20);
		lblTitle.setForeground(new Color(255, 255, 255));
		pnTitle.add(lblTitle);
		
		btnDispose =  new JButton(new ImageIcon(getClass().getResource("/image/dispose.jpg")));
		btnDispose.setBounds(470, 0, 30, 30);
		pnTitle.add(btnDispose);
		
		pnMain = new JPanel(null);
		pnMain.setBounds(0, 30, 500, 400);
		con.add(pnMain);
		
		lblContent = new JLabel("Tạo tài khoản");
		lblContent.setBounds(160, 20, 250, 40);
		lblContent.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		pnMain.add(lblContent);
		
		pnInfo = new JPanel(null);
		pnInfo.setBounds(20, 80, 460, 150);
		pnInfo.setBorder(BorderFactory.createLineBorder(Color.black));
		pnMain.add(pnInfo);
		
		
		lblMa = new JLabel("Mã TK");
		lblMa.setBounds(20,30,100,20);
		pnInfo.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setBounds(120,30,200,20);
		pnInfo.add(txtMa);
		
		lblName = new JLabel("Tên tài khoản");
		lblName.setBounds(20, 60, 100, 20);
		pnInfo.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(120, 60, 200, 20);
		pnInfo.add(txtName);
		
		lblPass = new JLabel("Mật khẩu");
		lblPass.setBounds(20, 90, 100, 20);
		pnInfo.add(lblPass);
		
		txtPass = new JTextField();
		txtPass.setBounds(120, 90, 200, 20);
		pnInfo.add(txtPass);
		
		lblManv = new JLabel("Mã nhân viên");
		lblManv.setBounds(20, 120, 100, 20);
		pnInfo.add(lblManv);
		
		txtManv = new JTextField();
		txtManv.setBounds(120, 120, 200, 20);
		pnInfo.add(txtManv);
		
		
	
		
	
		 
		btnNhan = new JButton("Tạo");
		btnNhan.setBounds(160, 300, 150, 30);
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
		
	
		btnNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				add();
			}
		});
	}
	public void showWindow() {
		  this.setSize(500,400);
	        setUndecorated(true);
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   	    this.setLocationRelativeTo(null);
	        this.setModal(true);
	        this.setVisible(true);
	}
	public static void main(String[] args) {
		TaiKhoanUI ql = new TaiKhoanUI();
		ql.showWindow();
	}



	public void add() {
	
	
		  int input = JOptionPane.showOptionDialog(null, "Tạo tài khoản", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
	       
      	  if(input == JOptionPane.OK_OPTION)
      	  {
      	
      			
		
				MyConnect myConn = new MyConnect();
				conn = (Connection) myConn.getConnection();
				
				String sql = "INSERT INTO `taikhoan` (`id_taikhoan`, `tentaikhoan`, `matkhau`, `level`, `MANV`) VALUES (?, ?, ?, '2', ?);";			
				String id = txtMa.getText().trim().toUpperCase();
				String tk = txtName.getText().trim();
				String pass = txtPass.getText().trim();
				String maNv = txtManv.getText().trim();
				PreparedStatement pst ;
				if(id.equals("") || tk.equals("") || pass.equals("") || maNv.equals(""))
					return ;
				try {
					pst = (PreparedStatement) conn.prepareStatement(sql);
					pst.setString(1, id);
					pst.setString(2, tk);
					pst.setString(3, pass);
					pst.setString(4, maNv);
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
