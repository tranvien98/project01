import java.util.Scanner;
public class GiaiThuaDeQuy
{
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("nhap a: ");
        int a= GiaiThuaDeQuy.scanner.nextInt();
        System.out.println("giai thua cua "+a+" la : "+GiaiThuaDeQuy.tinhGiaiThua(a));
    }
    public  static long tinhGiaiThua(int n)
    {
        if(n<=1) return 1;
        else
        {
            return n*tinhGiaiThua(n-1);
        }
    }


}
