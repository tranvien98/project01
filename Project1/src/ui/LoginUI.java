package ui;


import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controls.MyConnect;

public class LoginUI extends JFrame {
 public Connection conn;
JPanel pnMain, pnTitle;
  JTextField txtUser;
  JPasswordField pwPass;
  JButton btnSignIn, btnSignUp, btnDispose;
  JLabel lblTitle, lblUesr, lblPass;
  public LoginUI() {
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
	  lblTitle.setBounds(225, 0, 50, 20);
	  lblTitle.setForeground(new Color(255, 255, 255));
	  pnTitle.add(lblTitle);
	  
	  btnDispose =  new JButton(new ImageIcon(getClass().getResource("/image/dispose.jpg")));
	  btnDispose.setBounds(470, 0, 30, 30);
	  pnTitle.add(btnDispose);
	  
	  pnMain = new JPanel(null);
	  pnMain.setBounds(0, 30, 500, 370);	  	  
	  con.add(pnMain);
	  
	  lblUesr = new JLabel("Tài Khoản");
	  lblUesr.setBounds(80, 80, 100, 30);
	  pnMain.add(lblUesr);
	  txtUser = new JTextField();
	  txtUser.setBounds(200, 80, 180, 30);
	  pnMain.add(txtUser);
	  
	  lblPass = new JLabel("Mật Khẩu");
	  lblPass.setBounds(80, 180, 100, 30);
	  pnMain.add(lblPass);
	  
	  pwPass = new JPasswordField();
	  pwPass.setBounds(200, 180, 180, 30);
	  pnMain.add(pwPass);
	  
	  btnSignIn = new JButton("Sign In");
	  btnSignIn.setBounds(100, 250, 80, 30);
	  pnMain.add(btnSignIn);
	  
	  btnSignUp = new JButton("Reset");
	  btnSignUp.setBounds(270, 250, 80, 30);
	  pnMain.add(btnSignUp);
  }
  public void addEvents() {
	  btnDispose.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              dispose();
          }
      });
	  btnSignIn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			  if (txtUser.getText().equals("") || new String(pwPass.getPassword()).equals("")) {
           	   JOptionPane.showOptionDialog(null, "Bạn chưa nhập đủ thông tin ", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);                 
                  return;
              }
			MyConnect myConn = new MyConnect();
			conn = (Connection) myConn.getConnection();
			String sql = "SELECT * FROM `taikhoan` WHERE tentaikhoan = ? AND matkhau = ?";
			ResultSet rs = null;
			PreparedStatement pst;
			String user = txtUser.getText().trim();
			String pass = new String(pwPass.getPassword());
			try {
				pst = (PreparedStatement) conn.prepareStatement(sql) ;
				pst.setString(1, user);
				pst.setString(2, pass);
				rs = pst.executeQuery();
				   if (rs != null) {
                       if (rs.next()) {
                           if (rs.getString("matkhau").equals(new String(pwPass.getPassword()))) {
                        	   dispose();
                        	   
                        	   HomeUI home = new HomeUI("VieHotel",rs.getString("MANV"));                 	 
                        	   home.showWindow();
                        	   
                        	   
                           } else {
                        	   JOptionPane.showOptionDialog(null, "Bạn nhập sai ", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);                           }
                       } else {
                    	   JOptionPane.showOptionDialog(null, "Tài khoản không tồn tại", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);                       }
                   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.toString());
			}
		
		}
	});
	  btnSignUp.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			txtUser.setText("");
			pwPass.setText("");
		}
	});
  }
  public void showWindow() {
      this.setSize(500,400);
      setUndecorated(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 	    this.setLocationRelativeTo(null);
      this.setVisible(true);
  }
  public static void main(String[] args) {
	LoginUI dn = new LoginUI();
	dn.showWindow();
}
  
}
