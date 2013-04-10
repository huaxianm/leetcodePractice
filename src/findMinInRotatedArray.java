
public class findMinInRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={4,5,6,7,8,9,1,2,3};
		System.out.println(a[searchmin(a,a.length)]);
	}
	static int searchmin(int a[], int length)
	{
	if(length==0 || length < 1)
	return -1;
	if(length == 1)
	return a[--length];
	if(length == 2)
	return a[0] >= a[1] ? a[1] : a[0];

	int low = 0;
	int high = length-1;
	while(low < high)
	{
	int mid = (low+high) >>1;
	int vlow = a[low];
	int vmid = a[mid];
	int vhigh = a[high];

	if( a[mid-1] > a[mid] && a[mid+1] > a[mid] )
	{
	return mid;
	}

	if(vlow >= vmid || vmid < vhigh)
	{
	high = mid-1;
	}
	else
	{
	low = mid+1;
	}
	}
	return low;
	}

}
