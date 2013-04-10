import java.util.ArrayList;


public class ThreeSum {
	public static void main(String[] args){
		int arr[]={-1,0,1,2,-1,-4};
		 ArrayList<ArrayList<Integer>> finalresult=new ArrayList<ArrayList<Integer>>();
		 //finalresult=threeSum(arr);
		 finalresult=newthreeSum(arr);
		 System.out.println(finalresult.size());
	}
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        java.util.Arrays.sort(num);
          
	       ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	        for(int i=0;i<num.length;i++){
	            int left=i+1;
	            int right=num.length-1;
	            while(left<right&&num[i]<=0){
	                if((num[i]+num[left]+num[right])==0){
	                	ArrayList<Integer> arr=new ArrayList<Integer>();
	                    arr.add(num[i]);
	                    arr.add(num[left]);
	                    arr.add(num[right]);
	                    if(result.contains(arr)){
	                    	left++;
	                    	right--;
	                    }else{
	                    result.add(arr);
	                    left++;
	                    right--;}
	                }
	                else if((num[i]+num[left]+num[right])>0){
	                    right--;
	                }
	                else{
	                    left++;
	                }
	            }
	        }
	        return result;
	        
	    }
	public static ArrayList<ArrayList<Integer>> newthreeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> array=new ArrayList<ArrayList<Integer>>();
        if(num.length==0) return array;
        java.util.Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            int j=i+1;
            int m=num.length-1;
            ArrayList<Integer> arr=new ArrayList<Integer>();
            while(j<m){
                if(num[i]+num[j]+num[m]==0){
                    arr.add(num[i]);
                    arr.add(num[j]);
                    arr.add(num[m]);
                    array.add(arr);
                    j++;
                    m--;
                }else if(num[i]+num[j]+num[m]<0){
                    j++;
                }else{
                    m--;
                }
            }
        }
        return array;
    }
}
