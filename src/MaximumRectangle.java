import java.util.Stack;
public class MaximumRectangle {
	public static void main(String[] args){
		char[][] array={{'1','1','0','0','0'},{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','1','1'},{'0','0','1','1','1'}};
		System.out.println(maximalRectangle(array));
	}
	 public static int maximalRectangle(char[][] matrix) {
	        if(matrix.length == 0) 
	            return 0;
	        int[][] auxillary = new int[matrix.length][matrix[0].length];
	        for(int i = 0; i < matrix.length; ++i) {
	            for(int j = 0; j < matrix[i].length; ++j) {
	                auxillary[i][j] = Character.getNumericValue(matrix[i][j]);
	            }
	        }
	        for(int i = 1; i < auxillary.length; ++i) {
	            for(int j = 0; j < auxillary[i].length; ++j) {
	                if(auxillary[i][j] == 1)
	                    auxillary[i][j] = auxillary[i-1][j] + 1;
	            }
	        }
	        
	        int max = 0;
	        for(int i = 0; i < auxillary.length; ++i) {
	            max = Math.max(max, largestRectangleArea(auxillary[i]));
	        }
	        return max;
	    }
	    
	    private static int largestRectangleArea(int[] height) {
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
