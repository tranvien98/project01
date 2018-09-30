package java_basic3;

import java.util.Scanner;

public class ThuaSo {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Nhap so: ");
		int n = ThuaSo.sc.nextInt();
		phanTich(n);
	}

	public static void phanTich(int n) {
		double res = Math.sqrt(n);
		for (int i = 2; i < res; i++)
			for (; n % i == 0; n = n / i) {
				System.out.print(i + ".");
			}
			System.out.print(n);
	}
}
