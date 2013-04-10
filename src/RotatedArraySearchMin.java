import java.util.HashMap;
import java.util.HashSet;


public class RotatedArraySearchMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={-1,3,4,-5,-7};
		System.out.println(check(array));
		int a=7;
		int b=3;
		System.out.println(a&b);
		subArraySumsZero();
	}
	public static boolean check(int[] list){
	     int[] temp = new int[list.length];
	     temp[0] = list[0]; 
	     for (int i = 1; i < list.length; i++){
	         temp[i] = temp[i-1] + list[i];
	         if (temp[i] == 0){
	             return true;
	         }
	      }
	         HashSet<Integer> hs = new HashSet<Integer>();
	         for (int i=0; i<temp.length; i++){
	               if (hs.contains(temp[i])){
	               return true;
	         }else{
	             hs.add(temp[i]);
	         }
	    }
	    return false;
	}
	private static void subArraySumsZero() {
        int [] seed = new int[] {-1,3,4,-7,5};
        int currSum = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < seed.length ; i ++){
            currSum += seed[i];
            if(currSum == 0){
                System.out.println("subset : { 0 - " + i + " }");
            }else if(sumMap.get(currSum) != null){
                System.out.println("subset : { " + (sumMap.get(currSum) + 1) + " - " + i + " }");
                sumMap.put(currSum, i);
            }else
                sumMap.put(currSum, i);
        }
        System.out.println("HASH MAP HAS: " + sumMap);
    }
	
}
