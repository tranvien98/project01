
import java.util.Scanner;

public class DEM_TU {
      public static char SPACE = ' ';
      public static char TAB = '\t';
      public static char LINE = '\n';
      public static void main (String[] args)
      {
          System.out.println("Mời bạn nhập: \n");
          Scanner sc= new Scanner(System.in);
          String str;
          str = sc.nextLine();
          System.out.println("số từ là: "+countWord(str));
      }
      public static int countWord(String str)
      {
          if(str == null) return -1;
          int count=0;
          boolean notCount=true;
          int size;
          size = str.length();
          for(int i=0;i<size;i++)
          {
              if(str.charAt(i)!=SPACE && str.charAt(i)!=TAB && str.charAt(i)!=LINE)
              {
                  if(notCount)
                  {
                      count++;
                      notCount=false;
                  }
              }
              else
              {
                  notCount=true;
              }
          }
          return count;
      }


}
