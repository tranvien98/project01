import java.util.Scanner;
public class PT_bac2 {
    public static Scanner scanner =     scanner = new Scanner(System.in);
    // ham main
    public static void main(String[] args)
    {

        System.out.println("Nhap he so a: ");
        float a= PT_bac2.scanner.nextFloat();
        System.out.println("Nhap he so b: ");
        float b=PT_bac2.scanner.nextFloat();
        System.out.println("Nhap he so c: ");
        float c= PT_bac2.scanner.nextFloat();
        PT_bac2.giaiPT2(a,b,c);
    }
    public static  void giaiPT2(float a, float b,float c )
    {
        if(a==0)
        {
            if(b!=0)
            {
                System.out.println("Phuong trinh co mot nghiem: "+ " x= "+(-c/b));
            }
            else
            {
                System.out.println("Phuong trinh vo nghiem !");
            }
        }
        else
        {
            float denta=b*b-4*a*c;
            if(denta> 0)
            {
                float x1= (float) ((-b+Math.sqrt(denta))/(2*a));
                float x2= (float) ((-b-Math.sqrt(denta))/(2*a));
                System.out.println("Phuong trinh co hai nghiem : x1= "+x1 + " x2= "+ x2);
            }
            else if(denta==0)
            {
                System.out.println("Phuong trinh co nghiem kep x= " + (-b/(2*a)));
            }
            else {
                System.out.println("Phuong trinh vo nghiem !");
            }
        }
    }



}
