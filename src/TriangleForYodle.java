import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/*
 * author:James Man
 */

public class TriangleForYodle {
	public static void main(String[] args) throws IOException{
		if(args.length<1){
			System.out.println("Please provide filepath for input");
			System.exit(0); 
		}
		String filepath=args[0];
		BufferedReader in = new BufferedReader(new FileReader(filepath));
		try{
			String readline="";
			ArrayList<ArrayList<Integer>> triangle=new ArrayList<ArrayList<Integer>>();
			while((readline=in.readLine())!=null){
				if(readline.equals(""))
					continue;
				else{
					String[] str=readline.split(" ");
					ArrayList<Integer> partial=new ArrayList<Integer>();
					for(int i=0;i<str.length;i++){
						partial.add(Integer.parseInt(str[i]));
					}
					triangle.add(partial);
				}
			}
			System.out.println(maximumTotal(triangle));
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	public static int maximumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle==null || triangle.size()==0) return 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<triangle.size();i++){
            ArrayList<Integer> temp = triangle.get(i);
            res.add(0,i>0?temp.get(0)+res.get(0):temp.get(0));
            for(int j=1;j<res.size()-1;j++){
                res.set(j,Math.max(res.get(j),res.get(j+1))+temp.get(j));
            }
            if(res.size()>1)
                res.set(res.size()-1,res.get(res.size()-1)+temp.get(res.size()-1));
        }
        
        int max=Integer.MIN_VALUE;
        for(Integer temp:res){
            max=Math.max(temp,max);
        }
        return max;
    }

}
