package java_basic3;

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
 
public class thongketu {
   public static final char TAB='\t';
   public static final char SPACE=' ';
   public static final char LINE='\n';
   public static final char DOT='.';
   public static Scanner sc = new Scanner(System.in);
   public static void main(String[] args)
   {
	   System.out.println("Nhập xâu :");
	   String str=sc.nextLine();
	   str=str.trim();
	   System.out.println("Kết quả: ");
	   Map<String, Integer> wordMap = countWord(str);
	   for(String key:wordMap.keySet())
	   {
		   System.out.println(key + " "+ wordMap.get(key));
	   }
	   
   }
   // hàm đếm từ
   public static Map<String, Integer> countWord(String input)
   {
	   //khởi tạo
	   Map<String, Integer> wordMap = new TreeMap<String, Integer>();
	   if(input==null) return wordMap;
	   int size=input.length();
	   StringBuilder sb=new StringBuilder();
	   for(int i=0;i<size;i++)
	   {
		   if(input.charAt(i)!=TAB &&
			  input.charAt(i)!=SPACE &&
			  input.charAt(i)!=LINE &&
			  input.charAt(i)!=DOT)
		   {
			   sb.append(input.charAt(i));
		   }
		   else
		   {
			   addWord(wordMap,sb);
			   sb =new StringBuilder();
		   }
	   }
	   addWord(wordMap,sb);
	   return wordMap;
   }
   public static void addWord(Map<String, Integer> wordMap, StringBuilder sb)
   {
	   String word=sb.toString();
	   if(wordMap.containsKey(word))
	   {
		   int count=wordMap.get(word) + 1;
		   wordMap.put(word, count);
	   }
	   else wordMap.put(word, 1);
   }
   
}

