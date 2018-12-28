package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import client.ChatClient;



public class HomeUI extends JFrame {
	JPanel pnTitle, pnMain, pnAside;
	JLabel lblTitle, lblHouse,lblOn;
	JButton btnHome, btnCustomer,btnEmploy, btnRoom, btnSetting, btnLogout, btnService;
	JMenuBar menubar;
	JMenu menuFile, menuEdit, menuHelp;
	JMenuItem itemNhanvien, itemKhach, itemPhong, itemDich, itemLogout,itemChat, itemDis, itemTk, itemLichsu;
	public static JTextArea userOn;
	public static ArrayList<String> userList = new ArrayList();
	public static String khachHang;
	public static String nhanVien;
	public static ArrayList<String> usersonline; 
	public static ChatClient chat;
	public HomeUI(String title, String nhanvien) {
		super(title);
		addControls();
		addEvents();
		HomeUI.nhanVien = nhanvien;
		System.out.println(HomeUI.nhanVien);
		chat = new ChatClient();
//		chat.userAdd(HomeUI.nhanVien);
	}
	public void addControls() {
		Container con = getContentPane();
		con.setLayout(null);			
		
		menubar = new JMenuBar();
		menuFile = new JMenu("Tài khoản");
		menuEdit = new JMenu("Chức năng");
		menuHelp = new JMenu("Lịch sử");
		
		itemNhanvien = new JMenuItem("Quản lý nhân viên");
		itemKhach = new JMenuItem("Quản lý khách hàng");
		itemPhong = new JMenuItem("Quản lý phòng");
		itemDich = new JMenuItem("Quản lý dịch vụ");
		itemChat = new JMenuItem("Tin nhắn");
		itemDis = new JMenuItem("Disconnect");
		itemLogout = new JMenuItem("Đăng xuất");
		itemTk = new JMenuItem("Tạo tài khoản");
		itemLichsu = new JMenuItem("Lịch sử giao dịch");
		
		
		menubar.add(menuFile);
		menubar.add(menuEdit);
		menubar.add(menuHelp);
		
		menuFile.add(itemTk);
		
		menuEdit.add(itemNhanvien);
		menuEdit.add(itemKhach);
		menuEdit.add(itemPhong);
		menuEdit.add(itemDich);
		menuEdit.add(itemChat);
		menuEdit.add(itemDis);
		menuEdit.add(itemLogout);
		
		menuHelp.add(itemLichsu);
		
		this.setJMenuBar(menubar);
		
		pnMain = new JPanel(null);
		pnMain.setBounds(150, 0, 800, 540);
		con.add(pnMain);
		pnAside = new JPanel(null);
		pnAside.setBounds(0, 0, 150,540);
		con.add(pnAside);
		lblOn = new JLabel("Online");
		lblOn.setBounds(50,10,100,30);
		pnAside.add(lblOn);
		
		userOn = new JTextArea();
		userOn.setBounds(10,50,130,460);
		userOn.setEditable(false);
		pnAside.add(userOn);
			
		lblHouse = new JLabel();
		lblHouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/room.jpg")));
		lblHouse.setBounds(10, 10, 800, 500);
		pnMain.add(lblHouse);
		
	}
	
	public void addEvents() {
		itemNhanvien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NhanVienUI em = new NhanVienUI();
				em.showWindow();
				
			}
		});
	    itemKhach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				KhachHangUI customer = new KhachHangUI();
				customer.showWindow();
				
			}
		});
	    itemLichsu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LichSuUI ls = new LichSuUI();
				ls.showWindow();
			}
		});
		
		itemPhong.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PhongUI room = new PhongUI();
				room.showWindow();
			}
		});
		
		itemDich.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DichVuUI dv = new DichVuUI();
				dv.showWindow();
			}
		});
		itemLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				LoginUI login = new LoginUI();
				login.showWindow();
			}
		});
		itemChat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				ChatClient ch = new ChatClient();
				chat.showWindow();
			}
		});
		itemDis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				chat.sendDisconnect();
				chat.Disconnect();
				
			}
		});
		itemTk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TaiKhoanUI tk = new TaiKhoanUI();
				tk.showWindow();
			}
		});
	}
	public void showWindow() {
		 this.setSize(950, 600);
	      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 	    this.setLocationRelativeTo(null);
	      this.setVisible(true);
	      this.setResizable(false);
	}
	public static void main(String[] args) {
		HomeUI hm = new HomeUI("title", "NV1");
		hm.showWindow();
	}
	public void userAdd(String data) {
		userList.add(data);

	}

	public static void writeUsers() {
		String[] tempList = new String[(userList.size())];
		userList.toArray(tempList);
		for (String token : tempList) {

			userOn.append(token + "\n");

		}

	}
}
