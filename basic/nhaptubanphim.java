
import  java.io.*;
public class nhaptubanphim {
    public static void main(String[] args)
    {
        char ch='t';
        try
        {
            System.out.println("Moi ban nhap 1 ky tu");
            ch=(char) System.in.read();
            System.out.println("Ky tu vua nhap : "+ch);
        }
        catch(Exception e)
        {
            System.out.println("Nhap loi !");
        }

    }

}
