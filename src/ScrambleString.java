import java.util.Arrays;


public class ScrambleString {
	public static void main(String[] args){
		String a="great";
		String b="rgeat";
		System.out.println(isScramble(a,b));
		System.out.println(a.substring(2));
	}

	public static boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1==null || s2==null || s1.length()!=s2.length()) return false;
        char[]c1=s1.toCharArray(), c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!(new String(c1)).equals(new String(c2))) return false;
        else if(s1.length()==1)return true;
    
        for(int i=0;i<s1.length()-1;i++){
            if(isScramble(s1.substring(0,i+1),s2.substring(s1.length()-i-1))
                  && isScramble(s1.substring(i+1),s2.substring(0,s1.length()-i-1))
                  || isScramble(s1.substring(0,i+1),s2.substring(0,i+1)) 
                  && isScramble(s1.substring(i+1),s2.substring(i+1)))return true;
        }
        return false;
    }
    }
