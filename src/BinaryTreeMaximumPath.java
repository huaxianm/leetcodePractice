
public class BinaryTreeMaximumPath {
	public static void main(String[] args){
		TreeNode n=new TreeNode(1);
		n.left=new TreeNode(-2);
		n.right=new TreeNode(3);
		System.out.println(maxPathSum(n));
	}
	 public static int maxPathSum(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int[] res = maxPathSums(root);
	        return res[1];
	    }
	    
	    public static int[] maxPathSums(TreeNode root){
	        int[] res = new int[2];
	        if(root==null){
	            res[0]=Integer.MIN_VALUE;
	            res[1]=Integer.MIN_VALUE;
	            return res;
	        }
	        int[] fromLeft = maxPathSums(root.left),
	              fromRight = maxPathSums(root.right);
	        
	        int temp1 = fromLeft[0]>0?(fromLeft[0]+root.data):root.data;
	        int temp2 = fromRight[0]>0?(fromRight[0]+root.data):root.data;
	        
	        res[0]=Math.max(temp1,temp2);
	        res[1]=Math.max(fromLeft[1],Math.max(fromRight[1], Math.max(temp1+temp2-root.data,res[0])));
	        
	        return res;
	}
}
