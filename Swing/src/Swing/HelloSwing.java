package Swing;
import javax.swing.JFrame;
public class HelloSwing {
    public static void main(String[] args) {
		JFrame frame = new JFrame("Hello World");
		// thiet lap 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// thiet lap kich co
		frame.setSize(400,400);
		// thiet lap vi tri
		frame.setLocation(600, 400);
		// thiet lap hien thi
		frame.setVisible(true);
	}
}
