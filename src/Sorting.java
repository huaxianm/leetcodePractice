
public class Sorting {
	public static void main(String[] args){
		int[] arr={3,4,1,9,2,7,5,0,11,30,22};
		quicksort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
		System.out.println(arr[i]);
		}
	}
	//bubblesort
	public static void bubblesort(int[] array){
		for(int i=1;i<array.length;i++){
			for(int j=0;j<array.length-i;j++){
			if(array[j]>array[j+1]){
				swap(array,j,j+1);
			}else{
				continue;
			}
		}
	}
	}
	public static void swap(int[] array, int a,int b){
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	//selectionsort
	public static void selectionsort(int[] array){
		int currentsmallest=0;
		for(int i=1;i<array.length;i++){
			for(int j=i-1;j<array.length;j++){
				if(array[j]<array[currentsmallest]){
					currentsmallest=j;
				}
				if(j==array.length-1){
					swap(array,i-1,currentsmallest);
					currentsmallest=i;
				}
			}
		}
	}
	//mergesort
	public static void mergesort(int[] array,int low,int high){
		if(low<high){
		int mid=(low+high)/2;
		mergesort(array,low,mid-1);
		mergesort(array,mid+1,high);
		merge(array,low,mid,high);
		}
	}
	public static void merge(int[] array,int low,int mid,int high){
		int[] helper=new int[array.length];
		for(int i=0;i<array.length;i++){
			helper[i]=array[i];
		}
		int helperleft=low;
		int helperright=mid+1;
		int current=low;
		while(helperleft<=mid&&helperright<=high){
			if(helper[helperleft]<=helper[helperright]){
				array[current]=helper[helperleft];
				helperleft++;
			}else{
				array[current]=helper[helperright];
				helperright++;
			}
			current++;
		}
		int remaining=mid-helperleft;
		for(int i=0;i<=remaining;i++){
			array[current+i]=helper[helperleft+i];
		}
	}
	//quicksort
	public static void quicksort(int[] arr,int a,int b){
		int index=partition(arr,a,b);
		if(a<index-1){
			quicksort(arr,a,index-1);
		}
		if(index<b){
			quicksort(arr,index,b);
		}
	}
	public static int partition(int[] arr,int a, int b){
		int pivot=arr[(a+b)/2];
		while(a<=b){
			while(arr[a]<pivot) a++;
			while(arr[b]>pivot) b--;
			if(a<=b){
				swap(arr,a,b);
				a++;
				b--;
			}
		}
		return a;
	}
}
