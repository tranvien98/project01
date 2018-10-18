package Swing;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class COlor extends JFrame{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public COlor(){
	setLayout(new GridLayout(1,2,3,3));
	setSize(500,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JLabel lb1;
	lb1 = createJlabel("xinchao1", Color.black, Color.yellow);
	add(lb1);
	lb1 = createJlabel("hello2", Color.blue, Color.red);
	add(lb1);
	setLocationRelativeTo(null);
	setVisible(true);
}
   private JLabel createJlabel(String text,Color textcolor,Color bgcolor)
   {
	   JLabel lb = new JLabel(text);
	   // vi tri 
	   lb.setHorizontalAlignment(JLabel.CENTER);
	   //color
	   lb.setForeground(textcolor);
	   //background
	   lb.setOpaque(true);
	   lb.setBackground(bgcolor);
	   
	   return lb;
   }
   public static void main(String[] args) {
	new COlor();
}
}
