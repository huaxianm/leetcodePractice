
public class KthNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={3,1,7,9,22,4,0,6,16};
		System.out.println(selectKth(array,0,array.length-1,5));
		System.out.println(select(array,0,array.length-1,5));
	}
	public static int selectKth(int[] array, int beg, int end,int k){
		int pivot=partition(array,beg,end);
		if(k==pivot+1){
			return array[k];
		}
		else if(k<pivot+1){
			return selectKth(array,beg,pivot-1,k);
		}else if(k>pivot+1){
			return selectKth(array,pivot,end,k);
		}
		return -1;
	}
	public static int partition(int[] array,int low, int high){
		int pivot=array[(low+high)/2];
		while(low<=high){
			while(array[low]<pivot){
				low++;
			}
			while(array[high]>pivot){
				high--;
			}
			if(low<=high){
				swap(array,low,high);
				low++;
				high--;
			}
		}
		return low;
	}
	public static void swap(int[] array,int low,int high){
		int temp=array[low];
		array[low]=array[high];
		array[high]=temp;
	}
	static int partition(int[] list,int left,int right,int pivotIndex){
		int pivotValue = list[pivotIndex];
			     swap(list,pivotValue,right);  // Move pivot to end
			     int storeIndex = left;
			     for(int i=left;i<=right-1;i++)
			     {  if (list[i] < pivotValue)
			             swap (list,storeIndex,i);
			             storeIndex++;
			     }
			             swap(list,right,storeIndex);  // Move pivot to its final place
			     return storeIndex;
	}
	static int select(int[] list,int left,int right,int k){
    if (left == right) // If the list contains only one element
        return list[left];  // Return that element
    // select pivotIndex between left and right
    int pivotNewIndex = partition(list, left, right, 4);
    int pivotDist = pivotNewIndex - left + 1;
    // The pivot is in its final sorted position,
    // so pivotDist reflects its 1-based position if list were sorted
    if (pivotDist == k)
        return list[pivotNewIndex];
    else if (k < pivotDist)
        return select(list, left, pivotNewIndex - 1, k);
    else
        return select(list, pivotNewIndex + 1, right, k - pivotDist);
}
}
