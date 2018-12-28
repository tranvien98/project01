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

import controls.KhachHangCT;
import unit.KhachHang;

public class KhachHangUI extends JDialog{
	JPanel pnTitle, pnMain, pnInfo, pnList;
	JButton btnAdd, btnEdit, btnDelete, btnExit,btnOK, btnCancel, btnDispose, btnThanh, btnDichVu;
	JLabel lblTitle, lblContent, lblInfo,lblMa,lblPhong, lblCmt, lblName, lblAddress, lblEmail, lblGender, lblSdt;
	JTextField txtMa, txtCmt, txtName, txtAddress, txtEmail, txtGender, txtSdt,txtPhong;
	JTable table;
	KhachHangCT khCT = new KhachHangCT();
	private boolean isUpdate = false;
	public KhachHangUI() {
		khCT.connect();
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
		
		lblContent = new JLabel("Quản lý khách hàng");
		lblContent.setBounds(300, 20, 250, 40);
		lblContent.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		pnMain.add(lblContent);
		
		pnInfo = new JPanel(null);
		pnInfo.setBounds(20, 80, 760, 250);
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
		
		btnAdd = new JButton("Thêm");
		btnAdd.setBounds(100, 150, 80, 30);
		pnInfo.add(btnAdd);
		
		btnEdit = new JButton("Sửa");
		btnEdit.setBounds(250, 150, 80, 30);
		pnInfo.add(btnEdit);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setBounds(400, 150, 80, 30);
		pnInfo.add(btnDelete);
		
		
		btnOK = new JButton("OK");
		btnOK.setBounds(250,200,80,30);
		pnInfo.add(btnOK);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(400,200,80,30);
		pnInfo.add(btnCancel);
		
		btnThanh = new JButton("Thanh Toán");
		btnThanh.setBounds(600,220,120,30);
		pnInfo.add(btnThanh);
		
		btnDichVu = new JButton("Dịch vụ");
		btnDichVu.setBounds(600,180,120,30);
		pnInfo.add(btnDichVu);
		
		pnList = createTablePanel();
		pnList.setBounds(20, 350, 760, 200);
		pnList.setLayout(new GridLayout(1, 1));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		pnList.setBorder(BorderFactory.createLineBorder(Color.black));
		pnMain.add(pnList);
		
	
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
				addOrUpdate();
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
	
	
		btnThanh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				HomeUI.khachHang = (String)table.getValueAt(row, 0);
				HoaDonUI hd = new HoaDonUI();
				hd.showWindow();
			}
		});
		btnDichVu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				HomeUI.khachHang = (String)table.getValueAt(row, 0);
				DichVuUI dv = new DichVuUI();
				dv.showWindow();
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
		KhachHangUI kh = new KhachHangUI();
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
	public void addOrUpdate() {
		KhachHang kh = getKhachHang();
		if (kh != null) {
			if (isUpdate) {
				khCT.updateId(kh);
				loadData();
				isUpdate = false;
			} else {
				khCT.insert(kh);
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
		txtAddress.setText("");
		txtEmail.setText("");
		txtGender.setText("");
		txtSdt.setText("");
		txtPhong.setText("");
		
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
      		khCT.deleteId((String) table.getValueAt(row, 0));
			loadData();
      	  }
		
	}
	private void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = khCT.getData();
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
			txtAddress.setText((String) table.getValueAt(row, 3));
			txtEmail.setText((String) table.getValueAt(row, 4));
			txtGender.setText((String) table.getValueAt(row, 5));
			txtSdt.setText((String) table.getValueAt(row, 6));
			txtPhong.setText((String) table.getValueAt(row, 7));
		}
		txtMa.setEnabled(display);
		txtCmt.setEnabled(display);
		txtName.setEnabled(display);
		txtAddress.setEnabled(display);
		txtEmail.setEnabled(display);
		txtGender.setEnabled(display);
		txtSdt.setEnabled(display);
		txtPhong.setEnabled(display);
		btnOK.setEnabled(display);
		btnCancel.setEnabled(display);

		return true;

	}
	
}
