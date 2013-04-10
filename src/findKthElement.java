import java.util.ArrayList;


public class findKthElement {
	 public static void main(String[] args){
		 int[] a={1,3,5,6,11};
		 int[] b={2,4,9};
		 ArrayList<Integer> array=new ArrayList<Integer>();
		 array.add(1);
		 array.add(0,1);
		 array.set(0, 2);
		 System.out.println(MedianofTwoSortedArraysOpt(a,b));
		 System.out.println(FindKth(a,0,a.length,b,0,b.length,4));
		 System.out.println(array.toString());
	 }
	 public static int findKthPosition(int A[], int B[], int k){
	        int start=0, end=A.length-1;
	        while(start<=end){
	            int cur = (start+end)/2;
	            if(cur<k && k<=B.length+cur+1 && (k==cur+1 || A[cur]>=B[k-2-cur]) && (k>cur+B.length || A[cur]<=B[k-1-cur])){
	                return cur;
	            }else if(cur>=k || (k<=cur+B.length && A[cur]>B[k-1-cur])){
	                end=cur-1;
	            }else{
	                start=cur+1;
	            }
	        }
	      return -1;
	    }
	 public static double MedianofTwoSortedArraysOpt(int[] A, int[] B)
     {
         int t = A.length + B.length;
         if (t % 2 == 0)
         {
             return ((double)FindKth(A, 0, A.length, B, 0, B.length, t / 2) +
                     (double)FindKth(A, 0, A.length, B, 0, B.length, t / 2 + 1)) / 2;
         }

         return FindKth(A, 0, A.length, B, 0, B.length, t / 2 + 1);
     }

     public static int FindKth(int[] A, int aoffset, int m, int[] B, int boffset, int n, int k)
     {
         //Keep the A is the shorter array.
         if (m > n) FindKth(B, boffset, n, A, aoffset, m, k);

         if (m == 0) return B[k - 1];
         if (k == 1) return Math.min(A[aoffset], B[boffset]);

         //set pa and pb pointer
         int pa = Math.min(k / 2, m);
         int pb = k - pa;

         if (A[aoffset + pa - 1] < B[boffset + pb - 1]) return FindKth(A, aoffset + pa, m - pa, B, boffset, n, k - pa);

         return FindKth(A, aoffset, m, B, boffset + pb, n - pb, k - pb);
     }
}
