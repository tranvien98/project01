import java.util.Scanner;
import java.util.Arrays;
public class Mang {
	public static Scanner sc=new Scanner(System.in);
   public static void main(String[] args)
   {
	   System.out.println("Nhập số phần tử của mảng: ");
	   int n=sc.nextInt();
	   int[] arr=new int[n];
	   for(int i=0;i<n;i++)
	   {
		   System.out.println("Nhập phần tử thứ "+i+" ");
		   arr[i]=sc.nextInt();
	   }
	   System.out.println("Mảng ban đầu nhập là: ");
	   for(int i=0;i<n;i++)
	   {
		   System.out.print(arr[i]+"\t");
	   }
	   System.out.print("\n");
	  
	   int max=arr[0];
	   int min=arr[0];
	   for(int i=0;i<n;i++)
	   {
		   if(arr[i]>max)
		   {
			   max=arr[i];
		   }
	   }
	   for(int i=0;i<n;i++)
	   {
		   if(arr[i]<min)
		   {
			   min=arr[i];
		   }
	   }
	   System.out.println("Phần tử lớn nhất trong mảng là: "+max);
	   System.out.println("Phần tử nhỏ nhất trong mảng là: "+min);
	   System.out.println("Phần tử chẵn trong mảng là:");
	   {
		   for(int i=0;i<n;i++)
		   {
			   if(arr[i]%2==0)
			   {
				   System.out.print(arr[i]+"\t");
			   }
		   }
	   }
	   System.out.print("\n");
	   System.out.println("Mảng sau khi đã sắp xếp là: ");
	   Arrays.sort(arr);
	   for(int i=0;i<n;i++)
	   {
		   System.out.print(arr[i]+"\t");
	   }
	   
	   
   }
}
