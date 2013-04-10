import java.util.Stack;


public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] array={{'0','0','0'},{'0','0','0'},{'0','0','0'},{'0','0','0'}};
		System.out.println(maximalRectangle(array));
	}
	public static int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length==0)
            return 0;
        int[][] helper=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                helper[i][j]=matrix[i][j]-'0';
            }
        }
        for(int i=1;i<helper.length;i++){
            for(int j=0;j<helper[0].length;j++)
            {
                if(helper[i][j]==1)
                helper[i][j]=helper[i-1][j]+1;
            }
        }
        int max=0;
        for(int i=0;i<helper.length;i++){
            max=Math.max(largestRectangleArea(helper[i]),max);
        }
        return max;
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
