import java.util.Stack;
public class MaxHistgram {
	public static void main(String[] args){
		int[] height={2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
	}
	public static int largestRectangleArea(int[] height) {
	    Stack<Integer> stack = 
	        new Stack<Integer>();
	    int max = 0;
	    int i = 0;
	    while(i < height.length) {
	        if(stack.isEmpty() || 
	            height[i] >= stack.peek()) {
	            stack.push(height[i]);
	            i++;
	        }
	        else {
	            int count = 0;
	            while(!stack.isEmpty() && 
	                stack.peek() > height[i]) {
	                count++;
	                int top = stack.pop();
	                max = Math.max(max, top * count);
	            }
	            for(int j = 0; j < count + 1; ++j) {
	                stack.push(height[i]);
	            }
	            i++;
	        }
	    }
	    
	    int count = 0;
	    while(!stack.isEmpty()) {
	        count++;
	        max = Math.max(max, stack.pop() * count);
	    }
	    return max;
	}

}
