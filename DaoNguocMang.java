import java.util.ArrayList;
import java.util.Collections;

public class DaoNguocMang {
   public static void main(String[] args) {
	   ArrayList<String> list = new ArrayList<String>();
      list.add("1");
      list.add("2");
      list.add("3");
      list.add("4");
      list.add("5");
      System.out.println("Trước khi đảo ngược: " + list);
      Collections.reverse(list);
      System.out.println("Sau khi đảo ngược: " + list);
   }
}