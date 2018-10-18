package java_basic3;
import java.util.*;
public class TongFibonaci {
	public static Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {
	   System.out.println("nhap N: ");
	   int n=sc.nextInt();
	   int sum=0;
	   for(int i=1;i<=n;i++)
	   {
		   sum+=fibonaci(i);
		   System.out.println(fibonaci(i));
	   }
	   System.out.println("tổng: "+sum);
}
   public static int fibonaci(int n) {
       if (n < 0) {
           return -1;
       } else if (n == 0 || n == 1) {
           return n;
       } else {
           return fibonaci(n - 1) + fibonaci(n - 2);
       }
   }
}
