import java.util.Hashtable;
import java.util.Iterator;


public class TwoSum {
	 public int[] twoSum(int[] numbers, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(numbers.length==0) 
	        return new int[2];
	        int[] res=new int[2];
	        Hashtable<Integer,Integer> hash=new Hashtable<Integer,Integer>();
	        for(int i=0;i<numbers.length;i++){
	            if(!hash.containsKey(i)){
	                hash.put(target-numbers[i],i);
	            }
	        }
	        Iterator<Integer> iter=hash.keySet().iterator();
	        while(iter.hasNext()){
	            int temp=iter.next();
	            if(hash.containsKey(target-temp)){
	                res[0]=hash.get(temp);
	                res[1]=hash.get(target-temp);
	            }
	            
	        }
	        return res;
	        
	    }
}
