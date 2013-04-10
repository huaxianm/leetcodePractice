import java.util.ArrayList;


public class Kuohao {
	public static void main(String[] args){
		int a=5;
		System.out.println(a|11);
		System.out.println(generateParenthesis(3));
	}
	public static ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
       ArrayList<String> res=new ArrayList<String>();
       if(n==0) return res;
       res.add("()");
       int count=1;
       while(count<n){
           ArrayList<String> temp=new ArrayList<String>();
           for(int i=0;i<res.size();i++){
               String tempstr=res.get(i);
               if(!temp.contains(tempstr+"()")){
                   temp.add(tempstr+"()");
               }
               if(!temp.contains("()"+tempstr)){
                   temp.add("()"+tempstr);
               }
               for(int j=0;j<tempstr.length();j++){
                   if(tempstr.charAt(j)=='('){
                       String str=insert(tempstr,j+1);
                       if(!temp.contains(str))
                       temp.add(str);
                   }else{
                       continue;
                   }
               }
           }
          // res.clear();
           res.addAll(temp);
           count++;
       }
       return res;
       
    }
    public static String insert(String s, int i){
        return s.substring(0,i)+"()"+s.substring(i);
    }
}
