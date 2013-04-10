import java.util.ArrayList;


public class PathSumTwo {
	public static void main(String[] args){
		TreeNode root=new TreeNode(0);
		TreeNode root1=new TreeNode(1);
		TreeNode root2=new TreeNode(2);
		TreeNode root3=new TreeNode(3);
		TreeNode root4=new TreeNode(4);
		TreeNode root5=new TreeNode(5);
		TreeNode root6=new TreeNode(6);
		TreeNode root7=new TreeNode(7);
		TreeNode root8=new TreeNode(8);
		root.left=root1;
		root.right=root6;
		root1.left=root2;
		root1.right=root3;
		root3.right=root4;
		root4.left=root5;
		root6.left=root7;
		root6.right=root8;
		System.out.println(pathSum(root,3).toString());
	}
	 public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> path = new ArrayList<Integer>();
	        pathSum(root,sum,path,res);
	        return res;
	    }
	    
	    public static void pathSum(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
	        if(root==null) return;
	        if(root.left==null && root.right==null && sum==root.data){
	            ArrayList<Integer> p = new ArrayList<Integer>();
	            p.addAll(path);
	            p.add(root.data);
	            res.add(p);
	            return;
	        }
	        
	        path.add(root.data);
	        pathSum(root.left,sum-root.data,path,res);
	        pathSum(root.right,sum-root.data,path,res);
	        path.remove(path.size()-1);                 // path.remove((Integer)root.val) does not work for 2 cases in judge small. 
	    }  
}
