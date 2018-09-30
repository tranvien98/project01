
public class ForAndForeach {
  public static void main(String[] args) {
	  int a[]= {1,2,3,4,5,6,7,8,9};
     System.out.println("VoNg lap su dung for:");	
     exampleFor(a);
     System.out.println("Vong lap su dung foreach:");
     exampleForeach(a);
}
  public static void exampleFor(int a[])
  {
	  int size = a.length;
	  for(int i=0;i<size;i++)
	  {
		  System.out.print(a[i]+"\t");
	  }
	  System.out.println("");
  }
  public static void exampleForeach(int a[])
  {
	  for(Integer key:a)
	  {
		  System.out.print(key+"\t");
	  }
	  System.out.println("");
  }
}
