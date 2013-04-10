import java.util.ArrayList;
import java.util.List;


public class TextJustification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words={"Listen","to","many,","speak","to","a","few."};
		String[] test={"a"};
		ArrayList<String> array=fullJustify1(words,6);
		for(String str:array)
			System.out.println(str);
	}
	
	public static ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> array=new ArrayList<String>();
        if(words.length==0||L==0)
            return array;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<words.length;i++){
            String cur=words[i];
            if(sb.length()+cur.length()<=L){
                if(sb.length()==0)
            	sb.append(cur);
            	else
            	sb.append(" "+cur);
            }else{
            	String str=sb.toString();
            	array.add(justifyString(str,L));
            	sb=new StringBuffer();
            	sb.append(cur);
            	}
            }
        array.add(sb.toString());
        return array;
        }
	public static String justifyString(String str,int l){
		
		if(str==""||!str.contains(" ")){
			String output=str;
			int need=l-str.length();
			while(need>0){
				output+=" ";
				l--;
			}
			return output;
		}
		String[] words=str.split(" ");
    	int needtoadd=l-str.length()+words.length-1;
    	int perword=needtoadd/(words.length-1);
    	int extra=needtoadd-perword*(words.length-1);
    	String space="";
    	while(perword>0){
    		space+=" ";
    		perword--;
    	}
    	StringBuffer sb=new StringBuffer();
    	for(int i=0;i<words.length;i++){
    		sb.append(words[i]);
    		sb.append(space);
    		if(extra>0){
    			sb.append(" ");
    		}
    	}
    	return sb.toString();
    	
    	
	}
	 public static ArrayList<String> fullJustify1(String[] words, int L) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<String> result = new ArrayList<String>();
	        
	        int i = 0;
	        while (i < words.length) {
	            List<String> lineWords = new ArrayList<String>();
	            int curLen = 0;
	            do {
	                lineWords.add(words[i]);
	                curLen += words[i].length() + 1;
	                i++;
	            } while (i<words.length && words[i].length() + curLen <= L);
	            
	            result.add(justifyLine(lineWords, L - curLen + 1,  i==words.length, L));
	        }
	        return result;
	        }
	 static private String justifyLine(List<String> lineWords, int extralSpace, boolean b, int L) {
	        StringBuffer line = new StringBuffer();
	        if (b || lineWords.size() == 1) {
	            for (String w : lineWords) {    
	                line.append(w);
	                line.append(" ");
	            }
	            line.deleteCharAt(line.length() - 1);
	            for (int i = 0; i < extralSpace; i++) {
	                line.append(" ");
	            }
	            return line.toString();
	        }
	        
	        String nSpace = " ";
	        for (int i = 0; i < extralSpace / (lineWords.size() - 1); i++) {
	            nSpace += " ";
	        }
	        
	        int mSpace = extralSpace % (lineWords.size() - 1);
	        
	        for (int i = 0; i < lineWords.size(); i++) {
	            line.append(lineWords.get(i));
	            if (i < lineWords.size() - 1) {
	                line.append(nSpace);
	                if (i < mSpace) {
	                    line.append(" ");
	                }
	            }
	        }
	        
	        return line.toString();
	        
	    }
    }

