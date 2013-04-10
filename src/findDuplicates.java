
public class findDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={1,2,1,3,4};
		long sum=0;
		int a=999999999;
		int b=999999999;
		sum=(long)(a+b);
		System.out.println(sum);
		System.out.println(findDup(array));
		System.out.println(findDuplicate(array));
	}
	static int findDup(int[] A) {
		  int ans = 0;
		  int n=A.length;
		  for (int i = 0; i < n; i++) {
		    ans ^= A[i];
		    ans ^= i;
		  }
		  return ans;
		}
	static long findDuplicate(int[] a){
		  long ret=0;
		  int n=a.length;
		  for(int i=0;i<n;i++){
		    ret+=a[i]-i;
		  } 
		  return ret;
		}
}
