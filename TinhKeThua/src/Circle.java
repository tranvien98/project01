
class Circle extends Point {
     protected double radius;
     public void circle()
     {
    	 setRadius(0);
     }
     public void circle(double r,int a,int b)
     {
    	  super.point(a,b);
    	 setRadius(r);
     }
     public void setRadius(double r)
     {
    	 radius=(r>0?r:0);
     }
     public double getRadius()
     {
    	 return radius;
     }
     public double area()
     {
    	 return Math.PI*radius*radius;
     }
     public String display()
     {
    	 return "center = " +super.display()+"radius = "+radius;
     }
     public String getName()
     {
    	 return "Circle";
     }
}
