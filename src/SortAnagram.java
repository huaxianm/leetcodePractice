import java.util.Hashtable;
import java.util.LinkedList;


public class SortAnagram {
	public void sort(String[] array){
		Hashtable<String,LinkedList<String>> hash=new Hashtable<String,LinkedList<String>>();
		for(String s:array){
			char[] ch=s.toCharArray();
			java.util.Arrays.sort(ch);
			String key=ch.toString();
			if(!hash.containsKey(key)){
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams=hash.get(key);
			anagrams.push(s);
		}
		int index=0;
		for(String key:hash.keySet()){
			LinkedList<String> list=hash.get(key);
			for(String t:list){
				array[index]=t;
				index++;
			}
		}
	}
}
