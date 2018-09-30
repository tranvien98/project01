
public class Test {
    public static void main(String[] args) {
		Botmi a;
		a = new BanhMi();
		System.out.println("Bột làm bánh mì cần: "+ a.layBot());
		a = new BanhNgot();
		System.out.println("Bột làm bánh ngọt cần: "+ a.layBot());
		a = new BanhKem();
		System.out.println("Bột làm bánh kem cần: "+ a.layBot());
	}
}
