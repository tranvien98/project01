import java.util.Scanner;

public class nhap {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String ten;
        System.out.println("Mời bạn nhập tên: ");
        ten=sc.nextLine();
        int tuoi;
        System.out.println("Mời bạn nhập tuổi: ");
        tuoi= sc.nextInt();
        System.out.println("Thông tin bạn vừa nhập là: \n"+ten+"\n"+tuoi);

    }

}
