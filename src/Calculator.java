import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;



public class Calculator {
	public static void main(String[] args){
		System.out.println("type what need to be calculated");
		//Scanner sc=new Scanner(System.in);
		//String string=sc.next();
		//System.out.println("the result is "+string.charAt(0));
		System.out.println(calculation("10-2*3"));
	}
	public static int calculation(String str){
		LinkedList<Integer> list=new LinkedList<Integer>();
		char[] ch=str.toCharArray();
		for(int i=0;i<ch.length;i++){
			if(ch[i]=='+'||ch[i]=='-'||ch[i]=='*'||ch[i]=='/'){
				ch[i]=' ';
			}
		}
		String newone=new String(ch);
		String[] getnumber=newone.split(" ");
		for(int i=0;i<getnumber.length;i++){
			int number=Integer.parseInt(getnumber[i]);
			System.out.println(number);
			list.add(number);
		}
		return list.size();
	
	}
}
