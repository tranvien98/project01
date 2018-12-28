package client;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ui.HomeUI;

public class ChatClient extends JFrame {
	JPanel pnMain;
	JTextArea userArea, chatArea, inputArea;
	JLabel lblUser, lblTitle;
	JButton btnSend,btnExit, btnConn;
	String username, serverIP = "192.168.56.1";
	int Port = 5000;
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;
	ArrayList<String> userList = HomeUI.userList;
	Boolean isConnected = false;

	public ChatClient() {
		addControls();
		addEvents();
		connect();
	}

	public void addControls() {
		Container con = getContentPane();
		con.setLayout(null);

		pnMain = new JPanel(null);
		pnMain.setBounds(0, 0, 700, 600);
		con.add(pnMain);
		lblTitle = new JLabel("Tin nhắn");
		lblTitle.setBounds(200, 20, 100, 30);
		pnMain.add(lblTitle);

		lblUser = new JLabel("Danh sách online");
		lblUser.setBounds(550, 40, 120, 30);
		pnMain.add(lblUser);

		chatArea = new JTextArea();
		chatArea.setBounds(20, 80, 470, 200);
		chatArea.setEditable(false);
		pnMain.add(chatArea);

		userArea = new JTextArea();
		userArea.setBounds(505, 80, 170, 350);
		userArea.setEditable(false);
		pnMain.add(userArea);

		inputArea = new JTextArea();
		inputArea.setBounds(20, 300, 340, 150);
		pnMain.add(inputArea);

		btnSend = new JButton("Gửi");
		btnSend.setBounds(370, 390, 100, 30);
		pnMain.add(btnSend);
		
		btnConn = new JButton("Kết nối lại");
		btnConn.setBounds(200,500,120,30);
		pnMain.add(btnConn);
		
		btnExit = new JButton("Thoát");
		btnExit.setBounds(350,500,120,30);
		pnMain.add(btnExit);

	}
	public void addEvents() {
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				  String nothing = "";
			        if ((inputArea.getText()).equals(nothing)) {
			            inputArea.setText("");
			            inputArea.requestFocus();
			        } else {
			            try {
			            	
			               writer.println(username + ":" + inputArea.getText() + ":" + "Chat");
			               writer.flush(); // flushes the buffer
			            } catch (Exception ex) {
			                chatArea.append("Message was not sent. \n");
			            }
			            inputArea.setText("");
			            inputArea.requestFocus();
			        }

			        inputArea.setText("");
			        inputArea.requestFocus();
			}
		});
		btnConn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				connect();
			}
		});
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				sendDisconnect();
				dispose();
			}
		});
	}
	public void showWindow() {
		this.setSize(700, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		ChatClient ch = new ChatClient();
		ch.showWindow();
	}

	public class IncomingReader implements Runnable {

		public void run() {
			String[] data;
			String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

			try {
				while ((stream = reader.readLine()) != null) {

					data = stream.split(":");

					if (data[2].equals(chat)) {

						chatArea.append(data[0] + ": " + data[1] + "\n");
						chatArea.setCaretPosition(chatArea.getDocument().getLength());

					} else if (data[2].equals(connect)) {

						chatArea.removeAll();
						userAdd(data[0]);

					} else if (data[2].equals(disconnect)) {

						userRemove(data[0]);

					} else if (data[2].equals(done)) {
						HomeUI.userOn.setText("");
						userArea.setText("");
						HomeUI.writeUsers();
						writeUsers();
						HomeUI.userList.clear();

					}

				}
			} catch (Exception ex) {
			}
		}
	}

	public void ListenThread() {
		Thread IncomingReader = new Thread(new IncomingReader());
		IncomingReader.start();
	}

	public void userAdd(String data) {
		userList.add(data);

	}

	public void userRemove(String data) {
		chatArea.append(data + " has disconnected.\n");

	}

	public void writeUsers() {
		String[] tempList = new String[(userList.size())];
		userList.toArray(tempList);
		for (String token : tempList) {

			userArea.append(token + "\n");

		}

	}
    public void connect() {                                              
        
            if (isConnected == false) {
            username = HomeUI.nhanVien;

            try {
                sock = new Socket(serverIP, Port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(username + ":has connected.:Connect"); // Displays to everyone that user connected.
                writer.flush(); // flushes the buffer
                isConnected = true; // Used to see if the client is connected.
            } catch (Exception ex) {
                chatArea.append("Cannot Connect! Try Again. \n");
            }
            ListenThread();
        } else if (isConnected == true) {
            chatArea.append("You are already connected. \n");
        }
    } 
	public void sendDisconnect() {

		String bye = (username + ": :Disconnect");
		try {
			writer.println(bye); // Sends server the disconnect signal.
			writer.flush(); // flushes the buffer
			reader = null;
		} catch (Exception e) {
			chatArea.append("Could not send Disconnect message.\n");
		}

	}

	public void Disconnect() {

		try {
			chatArea.append("Disconnected.\n");
			sock.close();
		} catch (Exception ex) {
			chatArea.append("Failed to disconnect. \n");
		}
		reader = null;
		isConnected = false;
		userArea.setText("");
	}
}
