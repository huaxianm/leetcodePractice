import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
public class Compression {
	public static void main(String[] args){
		System.out.println(compression("aaaabbbcccaaaa"));
	}
	public static String compression(String str)
	{
		Hashtable<String,Integer> hash=new Hashtable<String,Integer>();
		ArrayList a=new ArrayList();
		hash.put("a", 1);
		int ab=hash.get("a");
		hash.put("a", ab+1);
		hash.put("b", 44);
		hash.put("c", 43);
		Set newone=hash.keySet();
		Iterator next=newone.iterator();
		System.out.println(hash.size());
		while(next.hasNext()){
			System.out.println(hash.get(next.next()));
		}
		char[] ch =str.toCharArray();
		char currentChar=ch[0];
		int count=0;
		String result=""+currentChar;
		for(int i=0;i<str.length();i++){
			if(ch[i]==currentChar){
				count++;
			}
			else{
				result=result+count+ch[i];
				count=1;
				currentChar=ch[i];
			}
		}
		String finalResult=result+count;
		if(finalResult.length()==str.length())
		return str;
		else 
			return finalResult;
		
		
		
		
	}
}
