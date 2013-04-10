import java.util.Hashtable;


public class ReverseString {
	public static void main(String[] args){
		String str="abcdegeq";
		int n=findMedian(3,9,4);
		Hashtable<Character, Integer> tab=new Hashtable<Character, Integer>();
		String str1="helloworld";
		char ob[]=str1.toCharArray();
        for(int i=0;i<str1.length();i++){
        	tab.put(ob[i], i);
        }
        System.out.println(tab.get('e'));
        tab.put('e', 1111);
        System.out.println(tab.get('e'));
		System.out.println(reverse(str));
		System.out.println(n);
		System.out.println(fibonaci(5));
	}
	public static String reverse(String str){
		char array[]=str.toCharArray();
		int last=str.length()-1;
		int mid=last/2;
		char temp=' ';
		for(int i=0;i<=mid;i++){
			temp=array[last];
			array[last]=array[i];
			array[i]=temp;
			last--;
		}
		
		return new String(array);
	}
	public static int findMedian(int a, int b, int c){
		int m = Math.min(a,b);
		   int n = Math.min(b,c);
		   int o = Math.min(c,a);
		   return(m^n^o);
	}
	public static int fibonaci(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		return fibonaci(n-1)+fibonaci(n-2);
	}
}
