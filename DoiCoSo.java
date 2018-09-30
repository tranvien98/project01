import java.util.*;
public class DoiCoSo {
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Nhap so can doi");
        int a=DoiCoSo.scanner.nextInt();
        System.out.println("Nhap co so");
        int b=DoiCoSo.scanner.nextInt();
        DoiCoSo.tinhCoSo(a,b);
    }
    public static void tinhCoSo(int a , int b)
    {
        char arr[] ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        if(b<=1 || b>16)
        {
            System.out.println("nhap sai co so") ;
        }
        else
        {
            Stack st= new Stack();
            while(a>0)
            {
                st.push(arr[a%b]);
                a=a/b;
            }
            System.out.println("ket qua: ");
            while (!st.isEmpty())
            {
                System.out.print(st.pop());
            }
        }
    }


}
