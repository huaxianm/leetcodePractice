import java.util.LinkedList;


public class maxPathSum {

	/**
	 * @param args
	 */
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node=new TreeNode(-3);
		node.left=new TreeNode(1);
		node.right=new TreeNode(2);
		node.left.left=new TreeNode(4);
		node.left.right=new TreeNode(5);
		levelOrder(node);
		mirror(node);
		levelOrder(node);
		//System.out.println(maxPathSum(node));
	}
	public static void levelOrder(TreeNode node){
		TreeNode root=node;
		LinkedList<TreeNode> list=new LinkedList<TreeNode>();
		list.add(root);
		while(!list.isEmpty()){
			LinkedList<TreeNode> newone=new LinkedList<TreeNode>();
			for(TreeNode temp:list){
				if(temp.left!=null)
				newone.add(temp.left);
				if(temp.right!=null)
				newone.add(temp.right);
				System.out.print(temp.data+" ");
			}
			System.out.println();
			list.clear();
			list.addAll(newone);
		}
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
