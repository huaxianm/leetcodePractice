
public class MergeSort {
	public static void main(String[] args){
		int array[]={1,3,5,6,8,2,10};
		mergesort(array,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	static void mergesort(int[] array,int low,int high){
		if(low<high){
			int middle=(low+high)/2;
			mergesort(array,low,middle);
			mergesort(array,middle+1,high);
			merge(array,low,middle,high);
		}
	
	}
	static void merge(int[] array,int low,int middle,int high){
		int[] helper=new int[array.length];
		for(int i=low;i<=high;i++){
			helper[i]=array[i];
		}
		int helperLeft=low;
		int helperright=middle+1;
		int current=low;
		while(helperLeft<=middle&&helperright<=high){
			if(helper[helperLeft]<=helper[helperright]){
				array[current]=helper[helperLeft];
				helperLeft++;
			}
			else{
				array[current]=helper[helperright];
				helperright++;
			}
			current++;
		}
		int remaining=middle-helperLeft;
		for(int i=0;i<=remaining;i++){
			array[current+i]=helper[helperLeft+i];
		}
	}
}
