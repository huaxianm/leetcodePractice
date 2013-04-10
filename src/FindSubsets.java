import java.util.ArrayList;
import java.util.List;


public class FindSubsets {
	static int[] a = {3,4,9,14,15,19,28,37,47,50,54,56,59,61,70,73,78,81,92,95,97,99};

	  public static void main(String[] args) {
	    List<Integer> b = new ArrayList<Integer>();

	    int count = 0;
	    for (int i = 0; i < a.length; i++) {
	        for (Integer t:b) {
	        if(a[i]==t)
	        {
	            count++;
	            }
	        }

	        int size = b.size();
	        for (int j = 0; j < size; j++) {
	        if(b.get(j) + a[i] <=99)
	            b.add(b.get(j) + a[i]);
	        }
	            b.add(a[i]);
	    }

	    System.out.println(count);

	  }
}
