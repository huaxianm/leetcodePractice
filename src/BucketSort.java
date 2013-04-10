
public class BucketSort {
	public static void main(String[] args){
		
		int[] arr={4,1,2,3,9,6,0,11,44,2};
		insertionsort(arr);
		//buildMaxHeap(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println(3/2);
	}
	public static void insertionsort(int[] a){
		int length=a.length;
		for(int i=1;i<length;i++){
			int temp=a[i];
			int j=i;
			while(j>0&&(a[j-1]>temp)){
				a[j]=a[j-1];
				j--;
			}
			a[j]=temp;
		}
	}
}
