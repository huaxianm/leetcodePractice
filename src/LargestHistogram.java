import java.util.Stack;


public class LargestHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={4,2};
		System.out.println(largestRectangleArea(array));
	}
	 public static int largestRectangleArea(int[] height) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(height.length==0)
	            return 0;
	        Stack<Integer> stack=new Stack<Integer>();
	        int max=Integer.MIN_VALUE;
	        for(int i=0;i<height.length;i++){
	            if(stack.isEmpty()||height[i]>=stack.peek()){
	                stack.push(height[i]);
	            }else{
	                int count=0;
	                while(!stack.isEmpty()&&stack.peek()>height[i]){
	                    count++;
	                    max=Math.max(stack.pop()*count,max);
	                }
	                for(int j=0;j<count+1;j++){
	                    stack.push(height[i]);
	                }
	            }
	        }
	        int count=0;
	        while(!stack.isEmpty()){
	            count++;
	            max=Math.max(stack.pop()*count,max);
	        }
	        return max;
	    }
}
