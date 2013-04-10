import java.util.ArrayList;
import java.util.Collections;


public class Combination {
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> arr=combination(4,2);
		System.out.println(arr.toString());
		System.out.println(combine(1,1).toString());
	}
	public static ArrayList<ArrayList<Integer>> combination(int n,int k){
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> array=new ArrayList<Integer>();
		recursion(n,k,array,res);
		return res;
	}
	private static void recursion(int n, int k, ArrayList<Integer> partial,
		    ArrayList<ArrayList<Integer>> sol) {
		    if(partial.size() == k && !sol.contains(partial)) {
		        Collections.sort(partial);
		        sol.add(partial);
		    } else if(partial.size() > k) {
		        return;
		    } else {
		        for(int i = n; i >= 1; --i) {
		            ArrayList<Integer> partial_sol = new ArrayList<Integer>();
		            partial_sol.addAll(partial);
		            partial_sol.add(i);
		            recursion(i-1, k, partial_sol, sol);
		        }
		    }
		}
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> array=new ArrayList<ArrayList<Integer>>();
        combination(1,n,k,new ArrayList<Integer>(),array);
        return array;
    }
    public static void combination(int start, int n, int k, ArrayList<Integer> arr,
    ArrayList<ArrayList<Integer>> array){
        if(arr.size()==k){
            array.add(new ArrayList<Integer>(arr));
            return;
        }
            for(int i=start;i<=n;i++){
                ArrayList<Integer> newone=new ArrayList<Integer>(arr);
                newone.add(i);
                combination(i+1,n,k,newone,array);
                newone.remove(newone.size()-1);
            }
        }
}
