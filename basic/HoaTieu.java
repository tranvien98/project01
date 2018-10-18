package java_basic3;
import java.util.Scanner;
public class HoaTieu {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
        System.out.println("Nhap n: ");
        int n=sc.nextInt();
        n=(n/2)*2+1;
        int mid= n*2 +n/2;
        int[][] d=new int[5*n][5*n];
        for(int i=0;i<5*n;i++)
        {
        	for(int j=0;j<5*n;j++)
        	{
        		d[i][j]=1;
        	}
        }
        for(int i=0;i<5*n;i++)
        {
        	for(int j=0;j<5*n;j++)
        	{
        		if(i+j<mid) d[i][j]=0;
        		if(i+j>3*mid) d[i][j]=0;
        		if(i-j>mid) d[i][j]=0;
        		if(j-i>mid) d[i][j]=0;
        		if(i>n-1 && i<2*n&& j>n-1&& j<2*n) d[i][j]=0;
        		if(i>3*n-1&& i<4*n && j>n-1&& j<2*n) d[i][j]=0;
        		if(i>n-1&& i<2*n && j>3*n-1&& j<4*n) d[i][j]=0;
        		if(i>3*n-1&& i<4*n && j>3*n-1&& j<4*n) d[i][j]=0;
        	}
        }
        for(int i=0;i<5*n;i++)
        {
        	for(int j=0;j<5*n;j++)
        	{
        	   if(d[i][j]==1)System.out.print("  *");
        	   else System.out.print("   ");
        	}
        	System.out.println("");
        }
    }
}
