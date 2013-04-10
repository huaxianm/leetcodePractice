import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


public class twosumhashtable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,3,1,7,10,6,5,4};
		ArrayList<String> a=twosum(arr,10);
		for(String s:a){
			System.out.println(s);
		}
	}
	public static ArrayList<String> twosum(int[] array,int sum){
		Hashtable<Integer, Integer> hash=new Hashtable<Integer,Integer>();
		for(int i=0;i<array.length;i++){
			if(!hash.containsKey(array[i])){
				hash.put(array[i], sum-array[i]);
			}
		}
		ArrayList<String> arr=new ArrayList<String>();
		Set set=hash.keySet();
		Iterator iter=set.iterator();
		while(iter.hasNext()){
			Object object=iter.next();
			if(hash.containsKey(hash.get(object))){
				String str="<"+object.toString()+","+hash.get(object).toString()+">";
				if(!arr.contains(str))
						arr.add(str);
			}
		}
		return arr;
	}

}
