package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


import controls.MyConnect;


public class LichSuUI extends JDialog{
	Connection conn;
	JPanel pnTitle, pnMain, pnInfo, pnList;
	JButton btnAdd, btnEdit, btnDelete, btnExit,btnOK, btnCancel, btnDispose, btnThanh, btnDichVu;
	JLabel lblTitle, lblContent, lblInfo;
	JTable table;

	public LichSuUI() {

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
		
		lblContent = new JLabel("Quản lý hóa đơn");
		lblContent.setBounds(300, 20, 250, 40);
		lblContent.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		pnMain.add(lblContent);

		
	

		
		
		pnList = createTablePanel();
		pnList.setBounds(20, 70, 760, 400);
		pnList.setLayout(new GridLayout(1, 1));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		pnList.setBorder(BorderFactory.createLineBorder(Color.black));
		pnMain.add(pnList);
		
	
	}
	public void addEvents() {

	btnDispose.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
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
		LichSuUI kh = new LichSuUI();
		kh.showWindow();
		
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
		MyConnect myConn = new MyConnect();
		conn = (Connection) myConn.getConnection();
		DefaultTableModel model = new DefaultTableModel();
		
		String sql = "SELECT * FROM hoadon";
		ResultSet rs = null;
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ResultSetMetaData rsMD = rs.getMetaData();
			int colNumber = rsMD.getColumnCount();
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

	
}
