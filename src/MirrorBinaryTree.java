
public class MirrorBinaryTree {
	public static void main(String[] args){
		TreeNode node=new TreeNode(1);
		node.left=new TreeNode(2);
		node.right=new TreeNode(3);
		node.left.left=new TreeNode(4);
		preorder(node);
		System.out.println();
		mirror(node);
		preorder(node);
		System.out.println();
		
		
	}
	public static void preorder(TreeNode node){
		if(node==null)
			return;
		System.out.print(node.data+" ");
		preorder(node.left);
		preorder(node.right);
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
}
