import java.util.Scanner;
public class XoaKiTu {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		System.out.println("Nhập xâu: ");
		String str=sc.nextLine();
		System.out.println("Nhập vị trí cần xóa: ");
		int pos=sc.nextInt();
		System.out.println("Xâu kết quả:"+xoaKiTu(str,pos));
	}
	public static String xoaKiTu( String input,int pos)
	{
		int size=input.length();
		if(pos<0||pos>=size )
		{
			System.out.println("Vị trí không hợp lệ");
			return null;
		}
		return input.substring(0,pos)+input.substring(pos+1);

	}

}
