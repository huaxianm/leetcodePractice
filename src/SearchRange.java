
public class SearchRange {
	public static void main(String[] args){
		int[] a={1};
		System.out.println(searchRange(a,1)[0]);
		System.out.println(searchRange(a,1)[1]);
	}
	 public static int[] searchRange(int[] A, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int length=A.length-1;
	        int[] error={-1,-1};
	        if(length==-1) return error;
	        int findtarget=search(A,0,length,target);
	        if(findtarget==-1) return error;
	        int start=findtarget-1;
	        int last=findtarget+1;
	        while(start>=0){
	            if(A[start]==target){
	                start--;
	            }else{
	                break;
	            }
	        }
	         while(last<=length){
	            if(A[last]==target){
	                last++;
	            }else{
	                break;
	            }
	        }
	        error[0]=start+1;
	        error[1]=last-1;
	        return error;
	        
	    }
	    public static int search(int[] a,int beg, int end, int target){
	        if(beg>end) return -1;
	        int mid=(beg+end)/2;
	        if(a[mid]==target) return mid;
	        else if(a[mid]>target) return search(a, beg, mid-1,target);
	        else return search(a, mid+1,end,target);
	    }
}
