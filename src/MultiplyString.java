
public class MultiplyString {
	public static void main(String[] args){
		String a="2";
		String b="3";
		String test="ab";
		//System.out.println(multiply(a,b));
		System.out.println(test.substring(1));
		System.out.println(test.substring(0, 0));
		for (int i = 0; i < test.length(); ++i) {
    		for (char c = 'a'; c <= 'z'; ++c) {
    			
    			String newStr = test.substring(0, i) + c + test.substring(i + 1);
    		System.out.println(newStr);
    		}
    	}
    	//inserting one character
    	for (int i = 0; i <= test.length(); ++i) {
    		for (char c = 'a'; c <= 'z'; ++c) {
    			
    			String newStr = test.substring(0, i) + c + test.substring(i);
    			System.out.println(newStr);
    		}
    	}
    	//deleting one character
    	for (int i = 0; i < test.length(); ++i) {
    		for (char c = 'a'; c <= 'z'; ++c) {
    			
    			String newStr = test.substring(0, i) + test.substring(i+1);
    			System.out.println(newStr);
    		}
    	}
	}
	public static String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num1.equals("0")||num2.equals("0")) return "0";
        if(num1.equals("1")||num2.equals("1")) return num1.equals("1")?num2:num1;
        char[] str1=num1.toCharArray();
        char[] str2=num2.toCharArray();
        int[] res=new int[num1.length()+num2.length()];
        int multicarry=0;
        int addcarry=0;
        for(int i=num1.length()-1;i>=0;i++){
            for(int j=num2.length()-1;j>=0;j++){
                int a=str2[j]-'0';
                int b=str1[i]-'0';
                int temp=a*b;
                res[j+i+1]=(temp%10+multicarry+addcarry+res[j+i+1])%10;
                multicarry=temp/10;
                addcarry=(temp%10+multicarry+addcarry+res[j+i+1])/10;
                if(j==0)
                res[res.length-num2.length()-1]+=multicarry>0?multicarry:0;
                multicarry=0;
            }
        }
        return res.toString();
    }
}
