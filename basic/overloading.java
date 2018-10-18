
public class overloading {
	public static void printlist(int arr[]) {
		for (Integer key : arr) {
			System.out.print(key + "\t");
		}
		System.out.println("");
	}

	public static void printlist(float arr[]) {
		for (Float key : arr) {
			System.out.print(key + "\t");
		}
		System.out.println("");
	}

	public static void printlist(char arr[]) {
		for (Character key : arr) {
			System.out.print(key + "\t");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6 };
		float b[] = { 1.5f, 2.5f, 3.5f, 4.5f, 5.5f, 6.5f };
		char c[] = { 'a', 'b', 'c', 'd', 'f', 'g' };
		printlist(a);
		printlist(b);
		printlist(c);
	}
}
