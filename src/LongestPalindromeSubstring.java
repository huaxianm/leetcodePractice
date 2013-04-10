
public class LongestPalindromeSubstring {
	public static void main(String[] args){
		String str="FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequalNowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		long time=System.currentTimeMillis();
		System.out.println(longestPalindrome(str));
		System.out.println(System.currentTimeMillis()-time);
		long time1=System.currentTimeMillis();
		System.out.println(longestPalindromeSubstring(str));
		System.out.println(System.currentTimeMillis()-time1);
	}
	public static String longestPalindrome(String s) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	    if(s.length()==0) return "";
	    if(s.length()==1) return s;
	    for(int i=s.length();i>0;i--){
	        for(int j=0;j+i<=s.length();j++){
	            String string=s.substring(j,i+j);
	            if(check(string))
	            return string;
	            else 
	            continue;
	        }
	    }
	    return "";   
	}
	public static boolean check(String s){
	     char[] arr=s.toCharArray();
	    for(int i=0,j=arr.length-1;i<j;i++,j--){
	        char temp=arr[i];
	        arr[i]=arr[j];
	        arr[j]=temp;
	    }
	    String str=new String(arr);
	    return str.equals(s);
	}
	//better solution
	public static String longestPalindromeSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String lp=s.substring(0,1);
        for(int i=1;i<s.length();i++){
        	String lp1 = find_prolindrome(s,i-1,i);
            String lp2 = find_prolindrome(s,i-1,i+1);
            String longer = lp1.length()>lp2.length()?lp1:lp2;
            lp = longer.length()>lp.length()?longer:lp;
        }
        return lp;

    }
    public static String find_prolindrome(String s, int p, int q){
        if( q<s.length() && s.charAt(p)==s.charAt(q)){
            while(p-1>=0 && q+1<s.length() && s.charAt(p-1)==s.charAt(q+1))
        		{p--;q++;}

            return s.substring(p,q+1);
        }
        return "";
    }
}

