import java.util.*;
public class DoiBatKySang10 {
    public static final char CHAR_55 = 55;
    public static final char CHAR_48 = 48;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("nhap so: ");
        String str = DoiBatKySang10.scanner.nextLine();
        System.out.println("nhap co so");
        int b = DoiBatKySang10.scanner.nextInt();
        DoiBatKySang10.tinhSo(str, b);
    }
    public static void tinhSo(String str, int b) {
        if (b <= 1 || b >= 17) {
            System.out.println("nhap sai");
        }
        else
            {
                int ketQua=0;
                int size = str.length();
                for (int i = 0; i < size; i++) {
                    int ch=(int)(str.charAt(i)-CHAR_48);
                    int ck=(int)(str.charAt(i)-CHAR_55);
                    if(ck>=10&&ck<=15)
                    {
                        ketQua+=ck*Math.pow(b,(size-i-1));
                    }
                   else
                    {
                        ketQua+=ch*Math.pow(b,(size-i-1));
                    }
                }
                System.out.println("ketqua: "+ ketQua);
         }
    }
}
