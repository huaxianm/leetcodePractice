
public class LowestCommonAncester {
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
		mirror(root);
		System.out.println(findLCA(root,root1,root6).data);
		
	}
	public static void mirror(TreeNode root){
		if(root==null)
			return;
		mirror(root.left);
		mirror(root.right);
		TreeNode temp=null;
		temp=root.left;
		root.left=root.right;
		root.right=temp;
	}

	public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
		   if (root == null || p == null || q == null) return null;
		   if (root == p || root == q) return root;
		   TreeNode left = findLCA(root.left, p, q);
		   TreeNode right = findLCA(root.right, p, q);
		   if (left!=null && right!=null) return root;
		   if (left!=null) {
		      return left;
		   } else {
		      return right;
		   }
		}
}
