
public class PermutationSequence {
	 public static void main(String[] args){
		 System.out.println(getPermutation(3,3));
	 }
	 public static String getPermutation(int n, int k) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	 
	        if (n==1) {
	            return "1";
	        }
	        int fac = 1; //n-1 factorial
	        for (int i = 1; i <= n-1; i++) {
	            fac *= i;
	        }
	 
	        StringBuilder sb = new StringBuilder();
	 
	        boolean[] used = new boolean[n];
	        for (int i = 0; i < n; i++) {
	            used[i] = false;
	        }
	 
	        k--; //k starting from 1 is messing things up
	        for (int i = 0; i < n; i++) {
	            int d = k/fac + 1; //d-th available number
	            int j = 0;
	            for (; j < n; j++) {
	                if (used[j] == false) {
	                    d--;
	                }
	                if (d == 0) {
	                    break;
	                }
	            }
	            used[j] = true;
	            sb.append(j+1);
	            if (i < n-1) {
	                k = k%fac;
	                fac = fac/(n-1-i);
	            }
	        }
	        return sb.toString();
	    }
}
