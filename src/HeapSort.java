
public class HeapSort {
	public static int parent(int i) {
        return (i - 1)/2;
    }
 
    public static int left(int i) {
        return ((i + 1) *2) - 1;
    }
 
    public static int right(int i) {
        return (i + 1) *2;
    }
   
	public static void main(String[] args){
		for (int i = 0; i < 10; i++) {
            System.out.print(parent(i) + " ");
            System.out.print(left(i) + " ");
            System.out.println(right(i) + " ");
        }
		int[] arr={4,1,2,3,9,6,0,11,44,2};
		heapSort(arr);
		//buildMaxHeap(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println(3/2);
	}
	public static void maxHeapify(int[] A,int i, int j) {  //MAX-HEAPIFY(A, i)
		int left = 2*i+1; //l ← LEFT(i)
		int right = 2*i+2; //r ← RIGHT(i)
		int largest = -1;
		if ( left <= j && A[left] > A[i] ) { //if l ≤ heap-size[A] and A[l] > A[i]
			largest = left; //   then largest ←l
		} else { //else 
			 largest = i; //largest ←i
		}
		if (right <= j && A[right] > A[largest]) { //if r ≤ heap-size[A] and A[r] > A[largest]
			 largest = right;	//   then largest ←r
		}
		if (largest != i) {		//if largest <> i
			//   then exchange A[i] ↔ A[largest]
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;

			maxHeapify(A,largest, j);	//MAX-HEAPIFY(A, largest)
		}
	}
	public static void swap(int[] a, int i, int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void buildMaxHeap(int[] A) {
		for (int i=(int)((A.length-1)/2); i>=0; i--)
			maxHeapify(A,i,A.length-1);
	}
	public static void heapSort(int[] a) {
		 
		buildMaxHeap(a);
		for (int i = a.length - 1; i >= 1; i--) {
			swap(a,0,i);
			maxHeapify(a,0, i-1);
		}
    }
}
