package Swing;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Jlabel extends JFrame {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Jlabel(){
		// thiet lap khung 
		setLayout(new GridLayout(1,3,5,5));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// tao anh
		Icon icon = new ImageIcon(getClass().getResource("phukien.png"));
		//taoj noi dung
		JLabel lb1 = new JLabel("hello");
		JLabel lb2 = new JLabel("world");
		JLabel lb3 = new JLabel("hello",icon,JLabel.CENTER);
		add(lb1);
		add(lb2);
		add(lb3);
		lb3.setHorizontalTextPosition(JLabel.LEFT);
		lb3.setVerticalTextPosition(JLabel.BOTTOM);
		// hien thi
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Jlabel();
	}
}
