import java.util.ArrayList;
import java.util.Iterator;


public class Triangle {
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a=new ArrayList<Integer>();
		ArrayList<Integer> b=new ArrayList<Integer>();
		ArrayList<Integer> c=new ArrayList<Integer>();
		a.add(1);
		b.add(2);
		b.add(3);
		c.add(6);
		c.add(5);
		c.add(7);
		res.add(a);
		res.add(b);
		res.add(c);
		System.out.println(minimumTotal(res));
	}
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle==null || triangle.size()==0) return 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<triangle.size();i++){
            ArrayList<Integer> temp = triangle.get(i);
            res.add(0,i>0?temp.get(0)+res.get(0):temp.get(0));
            for(int j=1;j<res.size()-1;j++){
                res.set(j,Math.min(res.get(j),res.get(j+1))+temp.get(j));
            }
            if(res.size()>1)
                res.set(res.size()-1,res.get(res.size()-1)+temp.get(res.size()-1));
        }
        
        int min=Integer.MAX_VALUE;
        for(Integer temp:res){
            min=Math.min(temp,min);
        }
        return min;
    }
}
