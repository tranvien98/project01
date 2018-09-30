package java_basic3;

public class soHoanHao {
	public static final int N=500000000;
	public static void main(String[] args)
	{
	    int[] d=new int[N];
	    for(int i=1;i<N;i++)
	    	d[i]=1;
	    for(int i=2;i<N;i++)
	    {
	    	for(int j=2;i*j<N;j++)
	    	{
	    	   d[i*j]+=i;
	    	
	    	}
	    	   if(d[i]==i) System.out.println(i);
	    }
	}
}
