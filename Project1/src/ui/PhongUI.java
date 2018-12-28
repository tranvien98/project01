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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controls.PhongCT;
import unit.Phong;

public class PhongUI extends JDialog{
	JPanel pnTitle, pnMain, pnInfo, pnList;
	JButton btnAdd, btnDatPhong, btnEdit, btnDelete, btnExit, btnDispose, btnOK, btnCancel;
	JLabel lblTitle, lblContent, lblInfo, lblMa, lblName, lblPrice, lblLoai, lblStatus, lblChuThich;
	JTextField txtMa, txtName, txtPrice, txtLoai, txtStatus,txtChuThich;
	JTable table;
	PhongCT phCT = new PhongCT();
	private boolean isUpdate = false;
	public PhongUI() {
		phCT.connect();
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
		
		lblContent = new JLabel("Quản lý phòng");
		lblContent.setBounds(300, 20, 250, 40);
		lblContent.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		pnMain.add(lblContent);
		
		pnInfo = new JPanel(null);
		pnInfo.setBounds(20, 80, 760, 250);
		pnInfo.setBorder(BorderFactory.createLineBorder(Color.black));
		pnMain.add(pnInfo);
		
		lblInfo = new JLabel("Thông tin phòng");
		lblInfo.setBounds(20, 0, 150, 20);
		pnInfo.add(lblInfo);
		
		lblMa = new JLabel("Mã phòng");
		lblMa.setBounds(20, 40, 100, 20);
		pnInfo.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setBounds(120, 40, 200, 20);
		pnInfo.add(txtMa);
		
		lblName = new JLabel("Tên phòng");
		lblName.setBounds(20, 70, 100, 20);
		pnInfo.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(120, 70, 200, 20);
		pnInfo.add(txtName);
		
		lblLoai = new JLabel("Loại phòng");
		lblLoai.setBounds(20, 100, 100, 20);
		pnInfo.add(lblLoai);
		
		txtLoai = new JTextField();
		txtLoai.setBounds(120, 100, 200, 20);
		pnInfo.add(txtLoai);
		
		lblPrice = new JLabel("Giá phòng");
		lblPrice.setBounds(400, 40, 100, 20);
		pnInfo.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(500, 40, 200, 20);
		pnInfo.add(txtPrice);
		
		lblStatus = new JLabel("Tình trạng");
		lblStatus.setBounds(400, 70, 100, 20);
		pnInfo.add(lblStatus);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(500, 70, 200, 20);
		pnInfo.add(txtStatus);
		
		lblChuThich = new JLabel("Chú thích");
		lblChuThich.setBounds(400, 100, 100, 20);
		pnInfo.add(lblChuThich);
		
		txtChuThich = new JTextField();
		txtChuThich.setBounds(500, 100, 200, 20);
		pnInfo.add(txtChuThich);
		
	
		
	
		
		btnAdd = new JButton("Thêm");
		btnAdd.setBounds(50, 150, 80, 30);
		pnInfo.add(btnAdd);
		
		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setBounds(200, 150,100, 30);
		pnInfo.add(btnDatPhong);
		
		btnEdit = new JButton("Sửa");
		btnEdit.setBounds(350, 150, 80, 30);
		pnInfo.add(btnEdit);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setBounds(500, 150, 80, 30);
		pnInfo.add(btnDelete);
		
		btnExit = new JButton("Thoát");
		btnExit.setBounds(650, 150, 80, 30);
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
	
		btnDatPhong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DatPhongUI dat = new DatPhongUI();
				dat.showWindow();
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
		PhongUI ql = new PhongUI();
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
	private Phong getPhong() {
		String maPhong = txtMa.getText().trim().toUpperCase();
		String tenPhong = txtName.getText().trim();
		String loaiPhong = txtLoai.getText().trim();
		Double giaPhong;
		try {
			giaPhong = Double.parseDouble(txtPrice.getText().trim());
		} catch (Exception e) {
			return null;
		}
	
		String chuThich = txtChuThich.getText().trim();
		String tinhTrang =txtStatus.getText().trim();

		if (maPhong.equals("") || tenPhong.equals("") || loaiPhong.equals("") || 
			tinhTrang.equals("") )
			return null;
		Phong ph = new Phong(maPhong, tenPhong, loaiPhong, giaPhong, tinhTrang, chuThich);
		return ph;
	}
	public void addOrUpdate() {
		Phong ph = getPhong();
		if (ph != null) {
			if (isUpdate) {
				phCT.updateId(ph);
				loadData();
				isUpdate = false;
			} else {
				phCT.insert(ph);
				loadData();
			}
			clear();
			setDisplayInput(false, false);
		} else {
			JOptionPane.showMessageDialog(null, "Lỗi !",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void clear() {
		txtMa.setText("");
		txtName.setText("");
		txtPrice.setText("");
		txtLoai.setText("");
		txtChuThich.setText("");
		txtStatus.setText("");
		
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
      		phCT.deleteId((String) table.getValueAt(row, 0));
			loadData();
      	  }
		
	}
	private void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = phCT.getData();
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
			txtName.setText((String) table.getValueAt(row, 1));
			txtLoai.setText((String) table.getValueAt(row, 2));
			txtPrice.setText((String) table.getValueAt(row, 3));
			txtStatus.setText((String) table.getValueAt(row, 4));
			txtChuThich.setText((String) table.getValueAt(row, 5));
			
		}
		txtMa.setEnabled(display);
		txtName.setEnabled(display);
		txtLoai.setEnabled(display);
		txtPrice.setEnabled(display);
		txtStatus.setEnabled(display);
		txtChuThich.setEnabled(display);
	
		btnOK.setEnabled(display);
		btnCancel.setEnabled(display);

		return true;

	}
}
