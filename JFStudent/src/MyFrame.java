import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isUpdate = false;
	MyConnect myConnect = new MyConnect();
	private JTextField tfmaSV, tfTen, tfDiem, tfGT;
	private JButton btnOk, btnCancel;
	private JTable table;

	public MyFrame() {
		// add main panel
		add(createMainPanel());
		setDisplayInput(false, false);
		myConnect.connect();
		// display
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createTitlePanel(), BorderLayout.PAGE_START);
		panel.add(createTablePanel(), BorderLayout.CENTER);
		panel.add(createBottomPanel(), BorderLayout.PAGE_END);
		return panel;
	}

	private JPanel createTitlePanel() {
		JPanel panel = new JPanel();
		JLabel lbTitle = new JLabel("Connect Data");
		panel.add(lbTitle);
		return panel;
	}

	private JPanel createTablePanel() {
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(table = createTable()));
		return panel;
	}

	private JTable createTable() {
		JTable table = new JTable();
		return table;
	}

	private JPanel createBottomPanel() {
		JPanel panel = new JPanel(new BorderLayout(10, 10));
		panel.setBorder(new EmptyBorder(5, 70, 10, 70));
		panel.add(createInputPanel(), BorderLayout.CENTER);
		panel.add(createButtonPanel(), BorderLayout.PAGE_END);
		return panel;
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel(new GridLayout(1, 3, 5, 5));
		panel.setBorder(new EmptyBorder(0, 40, 10, 40));
		panel.add(createButton("Add"));
		panel.add(createButton("Update"));
		panel.add(createButton("Delete"));
		return panel;
	}

	private JButton createButton(String text) {
		JButton bt = new JButton(text);
		bt.addActionListener(this);
		return bt;
	}

	private JPanel createInputPanel() {
		JPanel panel = new JPanel(new BorderLayout(10, 10));
		JPanel panelLeft = new JPanel(new GridLayout(4, 1, 5, 5));
		panelLeft.add(new JLabel("Ma_SV"));
		panelLeft.add(new JLabel("Ten_SV"));
		panelLeft.add(new JLabel("Diem"));
		panelLeft.add(new JLabel("Gioi_Tinh"));

		JPanel panelRight = new JPanel(new GridLayout(4, 1, 5, 5));
		panelRight.add(tfmaSV = new JTextField());
		panelRight.add(tfTen = new JTextField());
		panelRight.add(tfDiem = new JTextField());
		panelRight.add(tfGT = new JTextField());

		JPanel panelOk = new JPanel(new GridLayout(1, 2, 5, 5));
		panelOk.setBorder(new EmptyBorder(0, 50, 0, 50));
		panelOk.add(btnOk = createButton("Ok"));
		panelOk.add(btnCancel = createButton("Cancel"));

		panel.add(panelLeft, BorderLayout.WEST);
		panel.add(panelRight, BorderLayout.CENTER);
		panel.add(panelOk, BorderLayout.PAGE_END);
		return panel;
	}

	private boolean setDisplayInput(boolean display, boolean update) {
		if (update && table.getSelectedRow() < 0) {
			return false;
		} else if (update) {
			int row = table.getSelectedRow();
			tfmaSV.setText((String) table.getValueAt(row, 0));
			tfTen.setText((String) table.getValueAt(row, 1));
			tfDiem.setText((String) table.getValueAt(row, 2));
			tfGT.setText((String) table.getValueAt(row, 3));
		}
		tfmaSV.setEnabled(display);
		tfTen.setEnabled(display);
		tfDiem.setEnabled(display);
		tfGT.setEnabled(display);
		btnOk.setEnabled(display);
		btnCancel.setEnabled(display);

		return true;

	}

	private void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = myConnect.getData();
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

	private void delete() {
		int row = table.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Ban chua chon cot ", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int select = JOptionPane.showOptionDialog(null, "ban chac chan muon xoa", "xoa", 0, JOptionPane.YES_NO_OPTION,
				null, null, 1);
		if (select == 0) {
			myConnect.deleteId((String) table.getValueAt(row, 0));
			loadData();
		}
	}

	private void add() {
		setDisplayInput(true, false);
	}

	private Student getStudent() {
		String id = tfmaSV.getText().trim().toUpperCase();
		String name = tfTen.getText().trim();
		double point;
		try {
			point = Double.parseDouble(tfDiem.getText().trim());
		} catch (Exception e) {
			return null;
		}

		String gender = tfGT.getText().trim();
		if (id.equals("") || name.equals("") || gender.equals(""))
			return null;
		Student s = new Student(id, name, point, gender);
		return s;
	}

	private void update() {
		if (setDisplayInput(true, true)) {
			isUpdate = true;
		} else {
			JOptionPane.showMessageDialog(null, "Loi update!", "Error update",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void addOrUpdate() {
		Student st = getStudent();
		if (st != null) {
			if (isUpdate) {
				myConnect.update(st.getId(), st);
				loadData();
				isUpdate = false;
			} else {
				myConnect.insert(st);
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
			tfmaSV.setText("");
			tfTen.setText("");
			tfDiem.setText("");
			tfGT.setText("");
		}
		private void cancel() {
			clear();
			setDisplayInput(false, false);
		}
			

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Delete") {
			delete();
			return;
		}
		if (e.getActionCommand() == "Update") {
			update();
			return;
		}
		if (e.getActionCommand() == "Add") {
			add();
			return;
		}
		if (e.getSource() == btnOk) {
			addOrUpdate();
		}

		if (e.getSource() == btnCancel) {
			cancel();
		}
	}
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
		myFrame.loadData();
	}

}
