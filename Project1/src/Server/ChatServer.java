package Server;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ui.HomeUI;



public class ChatServer extends JFrame {
	ArrayList clientOutputStreams;
	ArrayList<String> onlineUsers;
	JTextArea chatArea;
	JPanel pnMain;
	JButton btnStart, btnStop;

	public ChatServer() {
		addControls();
		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();
		con.setLayout(null);
		this.setTitle("Server");

		pnMain = new JPanel(null);
		pnMain.setBounds(0, 0, 500, 500);
		con.add(pnMain);

		chatArea = new JTextArea();
		chatArea.setBounds(10, 10, 470, 350);
		chatArea.setEditable(false);
		pnMain.add(chatArea);

		btnStart = new JButton("Start");
		btnStart.setBounds(100, 390, 100, 40);
		pnMain.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.setBounds(320, 390, 100, 40);
		pnMain.add(btnStop);
	}
	public void addEvents() {
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 Thread starter = new Thread(new ServerStart());
			        starter.start();

			        chatArea.append("Server started. \n");
			}
		});
		btnStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				  tellEveryone("Server:is stopping and all users will be disconnected.\n:Chat");
			        chatArea.append("Server stopping... \n");
			        
			}
		});

      
	}
	public void showWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		ChatServer sv = new ChatServer();
		sv.showWindow();
	}

	public class ClientHandler implements Runnable {
		BufferedReader reader;
		Socket sock;
		PrintWriter client;

		public ClientHandler(Socket clientSocket, PrintWriter user) {
			// new inputStreamReader and then add it to a BufferedReader
			client = user;
			try {
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			} // end try
			catch (Exception ex) {
				chatArea.append("Error beginning StreamReader. \n");
			} // end catch

		} // end ClientHandler()
		
		public void run() {
			String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat";
			String[] data;
			if(reader != null) {
			try {
				while ((message = reader.readLine()) != null) {

					chatArea.append("Received: " + message + "\n");
					data = message.split(":");
					for (String token : data) {

						chatArea.append(token + "\n");

					}

					if (data[2].equals(disconnect)) {
						tellEveryone((data[0] + ":has disconnected." + ":" + chat));
						userRemove(data[0]);

						

					} else if (data[2].equals(connect)) {

						tellEveryone((data[0] + ":" + data[1] + ":" + chat));
						userAdd(data[0]);

					} else if (data[2].equals(chat)) {

						tellEveryone(message);

					} else {
						chatArea.append("No Conditions were met. \n");
					}

				} // end while
			} // end try
			catch (Exception ex) {
				chatArea.append("Lost a connection. \n");
				ex.printStackTrace();
				clientOutputStreams.remove(client);
			} // end catch
			}
		} // end run()
		
	} // end class ClientHandler

	/** Creates new form ServerWindow */
	public class ServerStart implements Runnable {
		public void run() {
			clientOutputStreams = new ArrayList();
			onlineUsers = new ArrayList();

			try {
				ServerSocket serverSock = new ServerSocket(5000);

				while (true) {
					// set up the server writer function and then begin at the same
					// the listener using the Runnable and Thread
					Socket clientSock = serverSock.accept();
					PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
					clientOutputStreams.add(writer);

					// use a Runnable to start a 'second main method that will run
					// the listener
					Thread listener = new Thread(new ClientHandler(clientSock, writer));
					listener.start();
					HomeUI.userList = onlineUsers;
					chatArea.append("Got a connection. \n");
				} // end while
			} // end try
			catch (Exception ex) {
				chatArea.append("Error making a connection. \n");
			} // end catch

		} // end go()
	}

	public void userAdd(String data) {
		String message, add = ": :Connect", done = "Server: :Done", name = data;
		chatArea.append("Before " + name + " added. \n");
		onlineUsers.add(name);
		chatArea.append("After " + name + " added. \n");
		String[] tempList = new String[(onlineUsers.size())];
		onlineUsers.toArray(tempList);

		for (String token : tempList) {

			message = (token + add);
			tellEveryone(message);
		}
		tellEveryone(done);
	}

	public void userRemove(String data) {
		String message, add = ": :Connect", done = "Server: :Done", name = data;
		onlineUsers.remove(name);
		String[] tempList = new String[(onlineUsers.size())];
		onlineUsers.toArray(tempList);

		for (String token : tempList) {

			message = (token + add);
			tellEveryone(message);
		}
		tellEveryone(done);
	}

	public void tellEveryone(String message) {
		// sends message to everyone connected to server
		Iterator it = clientOutputStreams.iterator();

		while (it.hasNext()) {
			try {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				chatArea.append("Sending: " + message + "\n");
				writer.flush();
				chatArea.setCaretPosition(chatArea.getDocument().getLength());

			} // end try
			catch (Exception ex) {
				chatArea.append("Error telling everyone. \n");
			} // end catch
		} // end while
	} // end tellEveryone()

}
