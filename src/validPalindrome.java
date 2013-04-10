
public class validPalindrome {
	 public boolean isPalindrome(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	     
	           // if(a>=0&&a<=9||a>=17&&a<=42||a>=49&&a<=75)
		 s=s.toLowerCase();
	     if(s.length() == 0) return true;
	     int length=s.length();
	     int i=0;
	     int j=length-1;
	     while(i<j){
	         while(!isValid(s.charAt(i))&&i<j) i++;
	    	 while(!isValid(s.charAt(j))&&i<j) j--;
	    	 if(i>=j) break;
	    	 if(s.charAt(i)!=s.charAt(j))
	    		 return false;
	    	 else{
	    		 i++;
	    		 j--;
	    	 }
	     }return true;
	 }

	public boolean isValid( char c) {
//			if( c>='0' && c<='9' ) return true;
//			if( c>='a' && c<='z' ) return true;
//			if( c>='A' && c<='Z' ) return true;
//			return false;
			if(c>='0'&&c<='9')return true;
			if(c>='a'&&c<='z') return true;
			if(c>='A'&&c<='Z') return true;
			return false;}
}
