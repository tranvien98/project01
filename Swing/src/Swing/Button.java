package Swing;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Button extends JFrame{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    JLabel lb;
   public Button()
   {
	   // tao khung
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setSize(300,200);
	   setLayout(new GridLayout(2,1,5,5));
	   // tao JLabel
	   lb = new JLabel("My Buttom");
	   lb.setHorizontalAlignment(JLabel.CENTER);
	   add(lb);
	   // tao buuton voi chu click button
	   JButton btn = new JButton("Click Button");
	   // tao hanh dong
	   btn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			  changeTextJLabel();
		}
	});
	   add(btn);
	   setVisible(true);
	   setLocationRelativeTo(null);
   }
   public  void changeTextJLabel()
   {
	   lb.setText("your click button");
   }
   public static void main(String[] args) {
	new Button();
}
}
