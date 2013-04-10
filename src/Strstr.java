
public class Strstr {
	 public static String strStr(String haystack, String needle) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(needle==""||haystack==""||haystack.length()<needle.length()) return null;
	        int match=0;
	        int current=-1;
	        for(int i=0;i<haystack.length();i++){
	           if(haystack.charAt(i)==needle.charAt(0)){
	               match++;
	               current=i;
	               for(int j=1;j<needle.length();j++){
	                   if(i+j<haystack.length()&&haystack.charAt(i+j)==needle.charAt(j)){
	                       match++;
	                   }else{
	                       match=0;
	                       current=-1;
	                       break;
	                   }
	                   if(match==needle.length()) return haystack.substring(i);
	                  
	               }
	           }
	           else{
	               continue;
	           }
	        }
	        return null;
	        
	    }
	 public static void main(String[] args){
		 String a="hello";
		 String b="ll";
		 String c="bd";
		 String d="a";
		 String e="a";
		 System.out.println(strStr1(d,e));
		 System.out.println(strStr(a,b));
		 System.out.println(strStr(a,c));
		 System.out.println("The output of two instance:");
		    SingletonPattern sp=new SingletonPattern();
		    System.out.println("First Instance: "+SingletonPattern.getInstance());
		    sp=new SingletonPattern();
		    System.out.println("Second Instance:"+SingletonPattern.getInstance());
	 }
	 public static String strStr1(String haystack, String needle) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(needle.length()==0)
	            return haystack;
	        if(haystack.length()==0)
	            return null;
	        int index=0;
	        for(int i=0;i<haystack.length();i++){
	            if(needle.charAt(index)!=haystack.charAt(i)){
	                continue;
	            }else{
	                while(needle.charAt(index)==haystack.charAt(i+index)){
	                    index++;
	                    if(index==needle.length()-1)
	                        return haystack.substring(i);
	                }
	            }
	        }
	        return null;
	    }
}

class SingletonPattern
{
  private static SingletonPattern instance;
  SingletonPattern()
  { } 
public static synchronized SingletonPattern getInstance(){
  if (instance == null)
  {
    instance = new SingletonPattern();
  }
  return instance;
}
}
