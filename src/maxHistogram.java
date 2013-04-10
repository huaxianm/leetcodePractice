import java.util.Stack;


public class maxHistogram {
	public static void main(String[] args){
		
		int[] height={1,1};
		System.out.println(largestRectangleArea(height));
	}
	public static int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height.length==0) return 0;
        int max=0;
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(height[0]);
        for(int i=1;i<height.length;i++){
            if(height[i]>=height[i-1]){
                stack.push(height[i]);
            }else{
                int count=1;
                while(!stack.isEmpty()&&height[i]<stack.peek()){
                    int cur=stack.pop();
                    max=Math.max(max,cur*count);
                    count++;
                }
                for(int j=0;j<count;j++){
                    stack.push(height[i]);
                }
            }
        }
        int count=1;
        int len=stack.size();
        for(int i=0;i<len;i++){
            int temp=stack.pop();
            max=Math.max(max,temp*count);
            count++;
        }
        return max;
    }
}
