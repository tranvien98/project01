import java.util.Scanner;

public class exSwitch {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("nhap so tu 1 den muoi");
		int so = sc.nextInt();
		switch (so) {
		case 0:
			System.out.println("không");
			break;
		case 1:
			System.out.println("một");
			break;
		case 2:
			System.out.println("hai");
			break;
		case 3:
			System.out.println("ba");
			break;
		case 4:
			System.out.println("bốn");
			break;
		case 5:
			System.out.println("năm");
			break;
		default:
			System.out.println("Không nằm trong khoảng từ 1-5");

		}
	}
}
