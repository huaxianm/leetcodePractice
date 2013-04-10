
public class QuickSort {
	public static void main(String[] args){
		int[] arr={4,1,2,9,10,6,0,44,23,8};
		quicksort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	public static void quicksort(int[] array, int left,int right){
		int index=partition(array,left,right);
		if(left<index-1){
			quicksort(array,left,index-1);
		}
		if(index<right){
			quicksort(array,index,right);
		}
	}
	public static int partition(int[] array,int left, int right){
		int mid=(left+right)/2;
		int temp=array[mid];
		while(left<=right){
			while(array[left]<temp) left++;
			while(array[right]>temp) right--;
			if(left<=right){
			swap(array,left,right);
			left++;
			right--;
			}
			}
		return left;
	}
	public static void swap(int[] array,int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
