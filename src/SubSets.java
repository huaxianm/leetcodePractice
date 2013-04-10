import java.util.ArrayList;


public class SubSets {
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		int[] num={1,2,2};
		res=subsetsWithDup(num);
		System.out.println(res.size());
	}
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        if(num.length==0) return res;
        java.util.Arrays.sort(num);
        res.add(temp);
        generate(num,0,temp,res);
        return res;
    }
    static void generate(int[] num, int step, ArrayList<Integer> partial, ArrayList<ArrayList<Integer>> array){
        ArrayList<Integer> newone=new ArrayList<Integer>();
        newone.addAll(partial);
    	for(int i=step;i<num.length;i++){
    		newone.add(num[i]);
            array.add(newone);
            if(i!=num.length-1){
                generate(num,i+1,newone,array);
            }
            newone.remove(newone.size()-1);
            while(i<num.length-1&&num[i]==num[i+1])
            i++;
        }
    }
}
