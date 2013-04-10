
public class SpiralArray {
	public static void main(String[] args){
		System.out.println(generateMatrix(3));
	}
	 public static int[][] generateMatrix(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int[][] arr=new int[n][n];
	        if(n==0) return arr;
	        if(n==1) {
	            arr[0][0]=1;
	            return arr;
	        }
	        int layer=(n+1)/2;
	        int i=0;
	        int next=1;
	        while(i<layer){
	            for(int index=i;index<n-i;index++){
	                arr[i][index]=next;
	                next++;
	            }
	            for(int index=i+1;index<n-i;index++){
	                arr[index][n-i-1]=next;
	            
	                next++;
	            }
	            for(int index=n-1-i;index>=i;index--){
	                arr[n-i-1][index]=next;
	                next++;
	            }
	            for(int index=n-1-i;index>=i+1;index--){
	                arr[index][i]=next;
	                next++;
	            }
	            i++;
	        }
	        return arr;
	    }
}
