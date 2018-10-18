import  java.util.Scanner;
public class GiaiThuaKoDeQuy{
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Moi ban nhap a: ");
        int a =GiaiThuaKoDeQuy.scanner.nextInt();
        System.out.println("Giai thua cua "+a+"= "+GiaiThuaKoDeQuy.tinhGiaiThua(a));
    }
    public static long tinhGiaiThua(int n)
    {
        long gt=1;
        if(n==0||n==1)
        {
            return gt;
        }
        else
        {
            for(int i=2;i<=n;i++)
            {
                gt=gt*i;
            }
        }
        return gt;

    }


}