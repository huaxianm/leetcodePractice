import java.util.Stack;
public class Pairs {
	public static void main(String[] args){
		System.out.println(isInterleave("aa","ab","aaba"));
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s3=="") return true;
        if(s3.length()!=s1.length()+s2.length()) return false;
        if(s1==""&&s2=="") return true;
        if(s1==""||s2==""){
            String s=s1==""?s2:s1;
            return s3.equals(s);
        }
       Stack<Character> stack1=new Stack<Character>();
       Stack<Character> stack2=new Stack<Character>();
       for(int i=0;i<s1.length();i++)
       stack1.push(s1.charAt(i));
        for(int i=0;i<s2.length();i++)
       stack2.push(s2.charAt(i));
       for(int i=s3.length()-1;i>=0;i--){
           char a=s3.charAt(i);
           if(!stack1.isEmpty()&&stack1.peek()==a){
               stack1.pop();
               continue;
           }
           else if(!stack2.isEmpty()&&stack2.peek()==a){
               stack2.pop();
               continue;
               
           }
           else{
               return false;
           }
       }
       return true;
    }
}
