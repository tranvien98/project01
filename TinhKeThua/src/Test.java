
public class Test {
	public static void main(String[] args) {
	Point p=new Point();
	p.point(2,3);
	Circle c = new Circle();
	c.circle(2,5,6);
	System.out.println(p.getName());
	System.out.println(p.display());
	System.out.println(c.getName());
	System.out.println(c.display());
	System.out.println(c.area());
	
      }
}