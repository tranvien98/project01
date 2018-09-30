
class Point extends Shape {
	protected int x,y;
	public void point()
	{
		setPoint(0,0);
	}
	public void point(int a,int b)
	{
		setPoint(a,b);
	}
	public void setPoint(int a,int b)
	{
		x=a;
		y=b;
	}
	public int getX() //lay x
	{
		return x;
	}
	public int getY() //lay y
	{
		return y;
	}
	// biểu diễn 1 điểm
	public String display()
	{
		return "["+x+","+y+"]";
	}
	//trả lại tên đối tượng
	public String getName()
	{
		return "Point";
	}

}
