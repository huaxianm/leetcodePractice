
public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=";,";
		System.out.println(isPalindrome(str));
	}
	 public static boolean isPalindrome(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(s.length()==0)
	            return true;
	        s=s.toLowerCase();
	        int start=0;
	        int end=s.length()-1;
	        while(start<end){
	            while(start<s.length()&&!checkValid(s.charAt(start))){
	                start++;
	            }
	            while(end>=0&&!checkValid(s.charAt(end))){
	                end--;
	            }
	            if(s.charAt(start)!=s.charAt(end))
	                return false;
	            else{
	                start++;
	                end--;
	            }
	        }
	        return true;
	    }
	    public static boolean checkValid(char c){
	        if((c>='a'&&c<='z')||(c>='0'&&c<='9')){
	            return true;
	        }else{
	            return false;
	        }
	    }

}
