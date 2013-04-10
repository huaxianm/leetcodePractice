
public class Permutation {
	public static void main(String[] args){
		String str="abcd";
		permutation(str.toCharArray(),0);
	}
	public static void permutation(char[] str,int n){
		if(str.length==0||n>str.length||n<0)
			return;
		if(n==str.length-1){
			System.out.println(new String(str));
		}else{
			for(int i=n;i<str.length;i++){
				char temp=str[n];
				str[n]=str[i];
				str[i]=temp;
				permutation(str,n+1);
				temp=str[n];
				str[n]=str[i];
				str[i]=temp;
			}
		}
	}
}
