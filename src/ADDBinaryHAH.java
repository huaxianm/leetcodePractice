
public class ADDBinaryHAH {
	public static void main(String[] args){
		String finalresult=addBinary("11","1");
		System.out.println(finalresult);
		int[] a={1,2,3,4,5,6};
		int[] b=new int[5];
		System.arraycopy(a, 1, b, 0, 5);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
	}
	public static String addBinary(String a, String b) {
        int lengtha=a.length();
        int lengthb=b.length();
        boolean isCarried=false;
        String result="";
        if(a==""&&b=="") return result;
        if(lengtha>lengthb){
            int n=0;
            while(n!=lengtha-lengthb){
                b="0"+b;
                n++;
            }
        }else{
            int n=0;
            while(n!=lengtha-lengthb){
                a="0"+a;
                n++;
            }
        }
        for(int i=Math.max(lengtha,lengthb);i>0;i--){
            char str1=a.charAt(i-1);
            char str2=b.charAt(i-1);
            if(str1=='1'&&str2=='1'){
                result=isCarried?"1"+result:"0"+result;
                isCarried=true;
            }
            else if((str1=='1'&&str2=='0')||(str1=='0'&&str2=='1')){
                if(isCarried){
                    result="0"+result;
                    isCarried=true;
                }
                else{
                    result="1"+result;
                    isCarried=false;
                }
            }
            else if(str1=='0'&&str2=='0'){
                if(isCarried){
                    result="1"+result;
                    isCarried=false;
                }
                else{
                    result="0"+result;
                    isCarried=false;
                }
            }
            
        }
        result=isCarried?"1"+result:result;
        return result;
        
    }
}
