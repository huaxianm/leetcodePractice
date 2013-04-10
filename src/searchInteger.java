
public class searchInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array={{1,3,5}};
		System.out.println(searchMatrix(array,1));
	}
	 public static boolean searchMatrix(int[][] matrix, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int left=0;
	        int right=matrix.length*matrix[0].length;
	        while(left<right){
	            int mid=(left+right)/2;
	            int val=getValue(matrix,mid);
	            if(val==target)
	                return true;
	            else if(val>target){
	                left=mid+1;
	            }else{
	                right=mid-1;
	            }
	        }
	        return false;
	    }
	    public static int getValue(int[][] matrix, int index){
	        int row=index/matrix[0].length;
	        int col=index%matrix[0].length;
	        return matrix[row][col];
	    }

}
