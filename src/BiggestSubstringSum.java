
public class BiggestSubstringSum {
	public static void main(String[] args){
		int[] array={-11, -2, -3, -10, -4, -7, -2, -5,-13};
		System.out.println(biggestsum(array));
	}
	public static int biggestsum(int[] array){
		int curmax=0;
		int finalmax=0;
		int biggest=Integer.MIN_VALUE;
		boolean isallnegative=true;
		for(int i=0;i<array.length;i++){
			if(array[i]<0){
				biggest=Math.max(array[i], biggest);
			}else{
				isallnegative=false;
			}
			
			if(isallnegative&&i==array.length-1){
				if(array[i]<0)
					return Math.max(biggest, array[i]);
			}
		}
		for(int i=0;i<array.length;i++){
			curmax+=array[i];
			if(curmax<0)
				curmax=0;
			
			finalmax=Math.max(curmax, finalmax);
		}
		return finalmax;
	}
}
