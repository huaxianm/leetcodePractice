
public class MultiplicationString {
	public static void main(String[] args){
		String a="111";
		String b="222";
		System.out.println(multiply(a,b));
	}
	public static String multiply(String num1, String num2) {
		char[] str1=num1.toCharArray();
        char[] str2=num2.toCharArray();
        int[] res=new int[num1.length()+num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int carry = 0;
            for (int j = 0; j < num2.length(); j++) {
                int d1 = str1[str1.length - 1 - i] - '0';
                int d2 = str2[str2.length - 1 - j] - '0';
                carry = d1 * d2 + res[i + j] + carry;
                res[i + j] = carry % 10;
                carry = carry / 10;
            }
            res[i + num2.length()] = carry;
        }
        
        int i = num1.length() + num2.length() - 1;
        while (i > 0 && res[i] == 0) i--;
        String result="";
        while (i >= 0) {
        	result+=res[i];
        	i--;
        }
        
        return result;
        
    }
}
