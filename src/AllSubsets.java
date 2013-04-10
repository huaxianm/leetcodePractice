import java.util.ArrayList;


public class AllSubsets {
	public static void main(String[] args){
		int[] arr={1,2};
		String a="abcdegf";
		System.out.println(subsets(arr).toString());
		System.out.println(a.substring(2, 3));
		System.out.println(a.substring(2));
		
	}
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(S.length==0) return new ArrayList<ArrayList<Integer>>();
        java.util.Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> array=new ArrayList<Integer>();
        array.add(S[0]);
        result.add(array);
        int i=1;
       while(i<S.length){
            int temp=S[i];
            ArrayList<ArrayList<Integer>> result1=new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> arr:result){
                ArrayList<Integer> newone=new ArrayList<Integer>();
                newone.addAll(arr);
                newone.add(temp);
                result1.add(newone);
            }
            result.addAll(result1);
            ArrayList<Integer> now=new ArrayList<Integer>();
            now.add(temp);
            result.add(now);
            i++;
        }
        return result;
    }
}
