package java_basic3;

import java.util.Scanner;

public class HoanVi {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("nhap n: ");
		int n = sc.nextInt();
		tinhHoanVi(n);
	}

	private void swapArray(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void tinhHoanVi(int n) {
		int[] a = new int[n];
		int dem = 1;
		HoanVi sw = new HoanVi();
		for (int i = 0; i < n; i++) {
			a[i] = i + 1;
			System.out.print(a[i] + " ");
		}
		System.out.println("");
		int i = n - 1;
		while (i > 0) {
			i = n - 1;
			for (int j = n - 1; j > 0; j--) {
				if (a[j - 1] < a[j]) {
					i = j;
					break;
				}
				i--;
			}
			if (i > 0) {
				int k;
				dem++;
				for (k = n - 1; k >= i; k--) {
					if (a[k] > a[i - 1]) {
						break;
					}

				}
				sw.swapArray(a, k, i - 1);
				// lat nguoc mang
				for (int j = i; j < i + (n - i) / 2; j++) {
					sw.swapArray(a, j, n - 1 + i - j);
				}
				for (int t = 0; t < n; t++) {
					System.out.print(a[t] + " ");
				}
			}
			System.out.println(" ");
		}
		System.out.println("Dem:" + dem);
		return;
	}
}
