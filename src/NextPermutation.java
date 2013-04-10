
public class NextPermutation {
	public static void main(String[] args){
		int[] s={2,2,7,5,4,3};
		int[] test={3,2,1};
		nextPermutation(s);
	}

	public static void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = num.length;
        for (int i = n - 1; i >= 1; i--) {
            if (num[i] > num[i-1]) {
                //swap the 2 numbers
                swapRange(num, i, n-1);
                for (int j = i; j < n; j++) {
                    if (num[j]>num[i-1]) {
                        swap(num, i-1, j);
                        return;
                    }
                }
            }
        }
 
        //swap each pair
        swapRange(num, 0, n-1);
    }
 
    public static void swapRange(int[] num, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(num, i, j);
        }
    }
 
    public static void swap(int[] num, int i, int j) {
        if (num[i] == num[j]) return;
        num[i] = num[i]^num[j];
        num[j] = num[i]^num[j];
        num[i] = num[i]^num[j];
    }
}
