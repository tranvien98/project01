import java.util.Scanner;
public class ucln_bcnn {
    public static Scanner scanner= new Scanner(System.in);
    public static  void main(String[] args)
    {
        System.out.println("Nhap a,b:");
        int a=ucln_bcnn.scanner.nextInt();
        int b=ucln_bcnn.scanner.nextInt();
        System.out.println("UCLN: "+tinhUcln(a,b));
        System.out.println("BCNN: "+tinhBcnn(a,b));
    }
    public static int tinhUcln(int a ,int b)
    {
        int ucln;
        int r=1;
        if(a<1||b<=1)
        {
           return -1;
        }
        {
            while (r>0)
            {
                r=a%b;
                a=b;
                b=r;
            }
            return a;
        }

    }
    public static int tinhBcnn(int a,int b)
    {
        return (a*b)/tinhUcln(a,b);
    }

}
