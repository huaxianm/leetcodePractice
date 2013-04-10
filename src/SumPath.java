
public class SumPath {
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(1);
		root.right=new TreeNode(2);
		root.right.right=new TreeNode(3);
		int mymax=root.data;
		System.out.println(maxPathSum(root,mymax));
	}
	public static int maxPathSum(TreeNode root,int mymax) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int val=maxSum(root,mymax);
        return Math.max(mymax,val);
    }
    
    static int maxSum(TreeNode root,int mymax){
        if(root==null)
            return 0;
        int left=maxSum(root.left,mymax);
        int right=maxSum(root.right,mymax);
        int localmax=root.data;
        if(left>0)
            localmax+=left;
        if(right>0)
            localmax+=right;
        mymax=Math.max(mymax,localmax);
        return Math.max(root.data,Math.max(root.data+left,root.data+right));
    }
}
