
public class RemoveDuplicateArray {
	public static void main(String[] args){
		int[] arr={1,1,1,2,2,2,3,4,5};
		System.out.println(removeDuplicates(arr));
	}
	public static int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len=A.length;
        if(len==0) return 0;
        if (len<1)return 0;

    int i = 1;
    int j = 0;
    int val = A[j]; //init val with A[0];

    while(++j < len)
        if(val != A[j])
            val = A[i++] = A[j];

    return i;
    }
}
