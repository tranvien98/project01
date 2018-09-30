import java.util.Scanner;
public class DemTuTrongChuoi {
  public static Scanner sc=new Scanner(System.in);
  public static char TAB='\t';
  public static char LINE='\n';
  public static char SPACE=' ';
  public static void main(String[] args)
  {
	  System.out.println("Nhập xâu cần đếm:");
	  String str=sc.nextLine();
	  System.out.println("Số từ trông xâu là "+countWord(str));
	  
  }
  public static int countWord(String str)
  {
	  if(str==null) return -1;
	  int count=0;
	  int size=str.length();
	  boolean isNotCount=true;
	  for(int i=0;i<size;i++)
	  {
		  if(str.charAt(i)!=TAB &&
			str.charAt(i)!=LINE &&
			str.charAt(i)!=SPACE)
		  {
			  if(isNotCount==true)
			  {
				  count++;
				  isNotCount=false;
				  
			  }
		  }
		  else 
			  isNotCount=true;
			  
	  }
	  return count;
	  
  }
}
