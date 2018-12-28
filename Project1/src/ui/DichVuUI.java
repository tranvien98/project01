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

import controls.DichVuCT;
import controls.MyConnect;
import unit.DichVu;



public class DichVuUI extends JDialog{
	public Connection conn;
	JPanel pnTitle, pnMain, pnInfo, pnList, pnDat;
	JButton btnAdd, btnEdit, btnDelete, btnExit,btnOK, btnCancel, btnDispose,btnDat;
	JLabel lblTitle, lblContent, lblInfo,lblMa,lblCmt, lblName, lblMaddv, lblMakh, lblMadv;
	JTextField txtMa, txtCmt, txtName, txtMaddv,txtMakh, txtMadv ;
	JTable table;
	DichVuCT dvCT = new DichVuCT();
	private boolean isUpdate = false;
	public DichVuUI() {
		dvCT.connect();
		addControls();
		addEvents();
		setDisplayInput(false, false);
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
		
		lblContent = new JLabel("Quản lý dịch vụ");
		lblContent.setBounds(300, 20, 250, 40);
		lblContent.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		pnMain.add(lblContent);
		
		pnInfo = new JPanel(null);
		pnInfo.setBounds(20, 80, 350, 450);
		pnInfo.setBorder(BorderFactory.createLineBorder(Color.black));
		pnMain.add(pnInfo);
		
		lblInfo = new JLabel("Thông tin dịch vụ");
		lblInfo.setBounds(20, 0, 150, 20);
		pnInfo.add(lblInfo);
		
		lblMa = new JLabel("Mã dịch vụ");
		lblMa.setBounds(20,50,100,20);
		pnInfo.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setBounds(120,50,200,20);
		pnInfo.add(txtMa);
		
		lblCmt = new JLabel("Tên dịch vụ");
		lblCmt.setBounds(20, 90, 100, 20);
		pnInfo.add(lblCmt);
		
		txtCmt = new JTextField();
		txtCmt.setBounds(120, 90, 200, 20);
		pnInfo.add(txtCmt);
	
		lblName = new JLabel("Giá");
		lblName.setBounds(20, 130, 100, 20);
		pnInfo.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(120, 130, 200, 20);
		pnInfo.add(txtName);
	

		
		btnAdd = new JButton("Thêm");
		btnAdd.setBounds(70, 180, 80, 30);
		pnInfo.add(btnAdd);
		
		btnEdit = new JButton("Sửa");
		btnEdit.setBounds(180, 180, 80, 30);
		pnInfo.add(btnEdit);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setBounds(70, 240, 80, 30);
		pnInfo.add(btnDelete);
		
		btnExit = new JButton("Thoát");
		btnExit.setBounds(180, 240, 80, 30);
		pnInfo.add(btnExit);
		
		btnOK = new JButton("OK");
		btnOK.setBounds(80,300,80,30);
		pnInfo.add(btnOK);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(170,300,80,30);
		pnInfo.add(btnCancel);
		
		btnDat = new JButton("Đặt");
		btnDat.setBounds(150,400,80,30);
		pnInfo.add(btnDat);
		
		pnList = createTablePanel();
		pnList.setBounds(400, 80, 390, 220);
		pnList.setLayout(new GridLayout(1, 1));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		pnList.setBorder(BorderFactory.createLineBorder(Color.black));
		pnMain.add(pnList);
		
		pnDat = new JPanel(null);
		pnDat.setBounds(400,305,390,220);
		pnDat.setBorder(BorderFactory.createLineBorder(Color.black));
		pnMain.add(pnDat);
		
		lblMaddv = new JLabel("Mã đặt dịch vụ");
		lblMaddv.setBounds(20,50,150,20);
		pnDat.add(lblMaddv);
		
		txtMaddv = new JTextField();
		txtMaddv.setBounds(120,50,200,20);
		pnDat.add(txtMaddv);
		
		lblMakh = new JLabel("Mã khách hàng");
		lblMakh.setBounds(20, 90, 100, 20);
		pnDat.add(lblMakh);
		
		txtMakh = new JTextField();
		txtMakh.setBounds(120, 90, 200, 20);
		pnDat.add(txtMakh);
	
		lblMadv = new JLabel("Mã dịch vụ");
		lblMadv.setBounds(20, 130, 100, 20);
		pnDat.add(lblMadv);
		
		txtMadv = new JTextField();
		txtMadv.setBounds(120, 130, 200, 20);
		pnDat.add(txtMadv);
	
	
	}
	public void addEvents() {

		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				add();
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				update();
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				delete();
			}
		});
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!txtMa.getText().equals("")) {
					addOrUpdate();
				}
				if(!txtMaddv.getText().equals("")) {
					addDat();
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cancel();
			}
		});
		btnDispose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		btnDat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn cột ", "", JOptionPane.ERROR_MESSAGE);
					return;
				}
				txtMakh.setText(HomeUI.khachHang);
				txtMadv.setText((String)table.getValueAt(row, 0));
				btnOK.setEnabled(true);
				btnCancel.setEnabled(true);
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
		DichVuUI dv = new DichVuUI();
		dv.showWindow();
		
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
	private DichVu getDichVu() {
		String maDV = txtMa.getText().trim().toUpperCase();
		String tenDV = txtCmt.getText().trim();
		Double gia;
		
		try {
			gia = Double.parseDouble(txtName.getText().trim());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		
			
		if (maDV.equals("") || tenDV.equals("") )
			return null;
		DichVu dv = new DichVu(maDV, tenDV, gia);
		return dv;
	}
	public void addOrUpdate() {
		DichVu dv = getDichVu();
		if (dv != null) {
			if (isUpdate) {
				dvCT.updateId(dv);
				loadData();
				isUpdate = false;
			} else {
				dvCT.insert(dv);
				loadData();
			}
			clear();
			setDisplayInput(false, false);
		} else {
			JOptionPane.showMessageDialog(null, "Loi !",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void clear() {
		txtMa.setText("");
		txtName.setText("");
		txtCmt.setText("");
		txtMaddv.setText("");
		txtMakh.setText("");
		txtMadv.setText("");
		
	}
	private void cancel() {
		clear();
		setDisplayInput(false, false);
	}
	private void add() {
		setDisplayInput(true, false);
	}
	private void update() {
		if (setDisplayInput(true, true)) {
			isUpdate = true;
		} else {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhật!", "Error update",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	private void delete() {
		int row = table.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn cột ", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		  int input = JOptionPane.showOptionDialog(null, "Bạn chắc chắn muốn xóa", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
       
      	  if(input == JOptionPane.OK_OPTION)
      	  {
      		dvCT.deleteId((String) table.getValueAt(row, 0));
			loadData();
      	  }
		
	}
	private void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = dvCT.getData();
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
	private boolean setDisplayInput(boolean display, boolean update) {
		if (update && table.getSelectedRow() < 0) {
			return false;
		} else if (update) {
			int row = table.getSelectedRow();
			txtMa.setText((String) table.getValueAt(row, 0));
			txtCmt.setText((String) table.getValueAt(row, 1));
			txtName.setText((String) table.getValueAt(row, 2));
		
		}
		txtMa.setEnabled(display);
		txtCmt.setEnabled(display);
		txtName.setEnabled(display);

		btnOK.setEnabled(display);
		btnCancel.setEnabled(display);

		return true;

	}
	private void addDat() {
		MyConnect myConn = new MyConnect();
		conn = (Connection) myConn.getConnection();
		String sql = "INSERT INTO `datdv` (`MADDV`, `MAKH`, `MADV`) VALUES (?, ?, ?);";
		String maDdv = txtMaddv.getText().trim().toUpperCase();
		String maKh = txtMakh.getText().trim().toUpperCase();
		String maDv = txtMadv.getText().trim().toUpperCase();
		
		if(maDdv.equals("") || maKh.equals("") || maDv.equals(""))
		{
			return;
		}
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, maDdv);
			pst.setString(2, maKh);
			pst.setString(3, maDv);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
