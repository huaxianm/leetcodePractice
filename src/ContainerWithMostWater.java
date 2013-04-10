
public class ContainerWithMostWater {
	 public static void main(String[] args){
		 int[] height={1,1};
		 System.out.println(maxArea(height));
		 System.out.println(reverse(-28009));
		 String a="Test";
		 String b="Test";
		 b=b.toUpperCase();
		 System.out.println(a);
		 System.out.println(b);
	 }

	 public static int maxArea(int[] height) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(height.length==0) return 0;
	        int max=0;
	        int i=0;
	        int j=height.length-1;
	        while(i<j){
	            if(height[i]>=height[j]){
	                max=Math.max(max,(j-i)*height[j]);
	                j--;
	            }else{
	                 max=Math.max(max,(j-i)*height[i]);
	                i++;
	            }
	        }
	        return max;
	    }
	 public static int reverse(int x) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        boolean isNegative=x<0?true:false;
	        x=Math.abs(x);
	        int result=0;
	        while(x>0){
	            result=result*10+x%10;
	            x/=10;
	        }
	        return isNegative?-result:result;
	    }
}
