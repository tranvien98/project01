package Swing;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
public class Jtext extends JFrame{
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public Jtext()
        {
        	//tao khung 
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	setLayout(new GridLayout(2,1,5,5));
        	// tao jtextfield
        	JTextField fl = new JTextField(20);
        	add(fl);
        	//tao button
        	  JButton btn = new JButton("ok");
        	add(btn);
        	// hien thi
        	pack();
        	setVisible(true);
        	setLocationRelativeTo(null);
        }
		public static void main(String[] args) {
			new Jtext();
		}
}
