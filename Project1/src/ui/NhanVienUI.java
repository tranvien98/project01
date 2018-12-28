package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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



import controls.NhanVienCT;
import unit.NhanVien;

public class NhanVienUI extends JDialog{
	JPanel pnTitle, pnMain, pnInfo, pnList;
	JButton btnAdd, btnEdit, btnDelete, btnExit, btnDispose, btnOK, btnCancel;
	JLabel lblTitle, lblContent, lblInfo, lblMaNV, lblTen, lblChucVu, lblLuong, lblNgaySinh, lblGioiTinh,  lblDiaChi, lblChuThich;
	JTextField txtMaNV, txtTen, txtChucVu, txtLuong, txtNgaySinh, txtGioiTinh, txtDiaChi,txtChuThich;
	JTable table;
	NhanVienCT nvCT = new NhanVienCT();
	private boolean isUpdate = false;
	public NhanVienUI() {
		nvCT.connect();
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
		
		lblContent = new JLabel("Quản lý nhân viên");
		lblContent.setBounds(300, 20, 250, 40);
		lblContent.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		pnMain.add(lblContent);
		
		pnInfo = new JPanel(null);
		pnInfo.setBounds(20, 80, 760, 250);
		pnInfo.setBorder(BorderFactory.createLineBorder(Color.black));
		pnMain.add(pnInfo);
		
		lblInfo = new JLabel("Thông tin nhân viên");
		lblInfo.setBounds(20, 0, 150, 20);
		pnInfo.add(lblInfo);
		
		lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setBounds(20, 30, 100, 20);
		pnInfo.add(lblMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(120, 30, 200, 20);
		pnInfo.add(txtMaNV);
		
		lblTen = new JLabel("Họ Tên");
		lblTen.setBounds(20, 60, 100, 20);
		pnInfo.add(lblTen);
		
		txtTen = new JTextField();
		txtTen.setBounds(120, 60, 200, 20);
		pnInfo.add(txtTen);
		
		lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setBounds(20, 90, 100, 20);
		pnInfo.add(lblChucVu);
		
		txtChucVu = new JTextField();
		txtChucVu.setBounds(120, 90, 200, 20);
		pnInfo.add(txtChucVu);
		
		lblLuong = new JLabel("Lương");
		lblLuong.setBounds(20, 120, 100, 20);
		pnInfo.add(lblLuong);
		
		txtLuong = new JTextField();
		txtLuong.setBounds(120, 120, 200, 20);
		pnInfo.add(txtLuong);
		
		lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setBounds(400, 30, 100, 20);
		pnInfo.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(500, 30, 200, 20);
		pnInfo.add(txtNgaySinh);
		
		lblGioiTinh = new JLabel("Giới Tính");
		lblGioiTinh.setBounds(400, 60, 100, 20);
		pnInfo.add(lblGioiTinh);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setBounds(500, 60, 200, 20);
		pnInfo.add(txtGioiTinh);
		
		lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setBounds(400, 90, 100, 20);
		pnInfo.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(500, 90, 200, 20);
		pnInfo.add(txtDiaChi);
		
		lblChuThich = new JLabel("Chú thích");
		lblChuThich.setBounds(400, 120, 100, 20);
		pnInfo.add(lblChuThich);
		
		txtChuThich = new JTextField();
		txtChuThich.setBounds(500, 120, 200, 20);
		pnInfo.add(txtChuThich);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setBounds(100, 150, 80, 30);
		pnInfo.add(btnAdd);
		
		btnEdit = new JButton("Sửa");
		btnEdit.setBounds(250, 150, 80, 30);
		pnInfo.add(btnEdit);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setBounds(400, 150, 80, 30);
		pnInfo.add(btnDelete);
		
		btnExit = new JButton("Thoát");
		btnExit.setBounds(550, 150, 80, 30);
		pnInfo.add(btnExit);
		
		
		btnOK = new JButton("OK");
		btnOK.setBounds(250,200,80,30);
		pnInfo.add(btnOK);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(400,200,80,30);
		pnInfo.add(btnCancel);
		
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
		btnExit.addActionListener(new ActionListener() {
			
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
		NhanVienUI nv = new NhanVienUI();
		nv.showWindow();
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
	private NhanVien getNhanVien() {
		String maNV = txtMaNV.getText().trim().toUpperCase();
		String tenNV = txtTen.getText().trim();
		String chucVu = txtChucVu.getText().trim();
		Double luong;
		try {
			luong = Double.parseDouble(txtLuong.getText().trim());
		} catch (Exception e) {
			return null;
		}
		
		String ngaySinh = txtNgaySinh.getText().trim();
		String gioiTinh = txtGioiTinh.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String chuThich = txtChuThich.getText().trim();

		if (maNV.equals("") || tenNV.equals("") || chucVu.equals("") ||
				gioiTinh.equals("") ||diaChi.equals("") )
			return null;
		NhanVien nv = new NhanVien(maNV, tenNV, chucVu, luong, ngaySinh, gioiTinh, diaChi, chuThich);
		return nv;
	}
	public void addOrUpdate() {
		NhanVien nv = getNhanVien();
		if (nv != null) {
			if (isUpdate) {
				nvCT.updateId(nv);
				loadData();
				isUpdate = false;
			} else {
				nvCT.insert(nv);
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
		txtMaNV.setText("");
		txtTen.setText("");
		txtChucVu.setText("");
		txtLuong.setText("");
		txtNgaySinh.setText("");
		txtGioiTinh.setText("");
		txtDiaChi.setText("");
		txtChuThich.setText("");
		
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
      		nvCT.deleteId((String) table.getValueAt(row, 0));
			loadData();
      	  }
		
	}
	private void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = nvCT.getData();
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
			txtMaNV.setText((String) table.getValueAt(row, 0));
			txtTen.setText((String) table.getValueAt(row, 1));
			txtChucVu.setText((String) table.getValueAt(row, 2));
			txtLuong.setText((String) table.getValueAt(row, 3));
			txtNgaySinh.setText((String) table.getValueAt(row, 4));
			txtGioiTinh.setText((String) table.getValueAt(row, 5));
			txtDiaChi.setText((String) table.getValueAt(row, 6));
			txtChuThich.setText((String) table.getValueAt(row, 7));
		}
		txtMaNV.setEnabled(display);
		txtTen.setEnabled(display);
		txtChucVu.setEnabled(display);
		txtLuong.setEnabled(display);
		txtNgaySinh.setEnabled(display);
		txtGioiTinh.setEnabled(display);
		txtDiaChi.setEnabled(display);
		txtChuThich.setEnabled(display);
		btnOK.setEnabled(display);
		btnCancel.setEnabled(display);

		return true;

	}

}
