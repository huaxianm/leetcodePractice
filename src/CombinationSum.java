import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CombinationSum {
	public static void main(String[] args){
		int[] arr={7,2,3,4,5};
		System.out.println(combinationSum(arr,7).get(0));
	}
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
            int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int current = 0;
        compute(candidates, target, current, temp, res);

        return res;
    }

    static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void compute(int[] candidates, int target, int current,
            ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        if (current > target)
            return;

        if (current == target) {
            ArrayList<Integer> list = new ArrayList<Integer>(temp);
            java.util.Collections.sort(list);
            String sig = list.toString();
            if (!map.containsKey(sig)) {
                res.add(list);
                map.put(sig, 1);
            }

            return;
        }

        int len = candidates.length;
        for (int i = 0; i < len; i++) {
            int value = candidates[i];
            temp.add(value);
            current += value;
            compute(candidates, target, current, temp, res);
            temp.remove(temp.size() - 1);
            current -= value;
        }
    }

}
