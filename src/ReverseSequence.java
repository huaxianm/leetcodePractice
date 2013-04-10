import java.util.Stack;


public class ReverseSequence {
	public static void main(String[] args){
		reverse("I am a student");
	}
	public static void reverse(String str){
		Stack<String> stack=new Stack<String>();
		String temp="";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=' '){
				temp+=str.charAt(i);
			}else{
				stack.push(temp);
				temp="";
				continue;
			}
		}
		stack.push(temp);
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
	}
	
}
