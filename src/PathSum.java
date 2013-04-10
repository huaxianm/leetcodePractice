import java.util.ArrayList;


public class PathSum {
	public static void main(String[] args){
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(4);
		root.right=new TreeNode(8);
		root.left.left=new TreeNode(11);
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(4);
		root.left.left.left=new TreeNode(7);
		root.left.left.right=new TreeNode(2);
		root.right.right.left=new TreeNode(5);
		root.right.right.right=new TreeNode(1);
		ArrayList<ArrayList<Integer>> arr=pathSum(root,22);
		System.out.println(arr.get(0));
		
	}
	 public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<ArrayList<Integer>> array=new ArrayList<ArrayList<Integer>>();
	        if(root==null) return array;
	       // int leftsum=sum-root.data;
	        ArrayList<Integer> partial=new ArrayList<Integer>();
	       // partial.add(root.data);
	        path(root,sum,array,partial);
	        return array;
	        
	    }
	    public static void path(TreeNode node, int leftsum, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> partial){
	    if(node==null) return;
	    ArrayList<Integer> newone=new ArrayList<Integer>();
	    int left=leftsum-node.data;
	    newone.addAll(partial);
	    newone.add(node.data);
	    if(node.left==null&&node.right==null&&left==0){
	        arr.add(newone);
	    }else{
	        path(node.left,left,arr,newone);
	        path(node.right,left,arr,newone);
	    }
	    } 
}
