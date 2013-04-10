
public class Zoosk {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="091029023821736124ADSFSDVJKCXJZDSzfjsklqiwuenvcxadfasdbc";
		char a='a';
		System.out.println(a-'0');
		System.out.println(sort(str));
	}
	static String sort(String str){
		int[] helper=new int[256];
	    int len=str.length();
	    char[] ch=str.toCharArray();
	    for(int i=0;i<len;i++){
	        helper[ch[i]]++;
	    }
	    int index=0;
	    for(int i=0;i<256;i++){
	        while(helper[i]!=0){
	        	ch[index]=(char)i;
	            index++;
	            helper[i]--;
	        }
	    }
	    return new String(ch);
	}
}
