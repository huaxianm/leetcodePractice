
public class ShiftString {
	public static void main(String[] args){
		String str="abcdefg";
		System.out.println(shift(str,2));
	}
	public static String shift(String str,int n){
		int onefirst=0;
		int oneend=n-1;
		int twofirst=n;
		int twoend=str.length()-1;
		String result=reverse(str,onefirst,oneend);
		result=reverse(result,twofirst,twoend);
		result=reverse(result,0,twoend);
		return result;
	}
	public static String reverse(String str, int n, int m){
		char[] ch=str.toCharArray();
		while(n<=m){
			char temp=ch[n];
			ch[n]=ch[m];
			ch[m]=temp;
			n++;m--;
		}
		return new String(ch);
	}
}
