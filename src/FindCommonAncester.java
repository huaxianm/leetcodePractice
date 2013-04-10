import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class FindCommonAncester {
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		TreeNode root1=new TreeNode(2);
		TreeNode root2=new TreeNode(3);
		TreeNode root3=new TreeNode(4);
		TreeNode root4=new TreeNode(5);
		TreeNode root5=new TreeNode(6);
		TreeNode root6=new TreeNode(7);
		root.left=root1;
		root.right=root2;
		root2.left=root3;
		root2.right=root4;
		root4.right=root5;
		root5.left=root6;
		System.out.println(common(root,root3,root5).data);
		System.out.println(depth(root));                                                       
	}
	
	public static boolean cover(TreeNode root, TreeNode p){
		if(root==null) return false;
		if(root==p) return true;
		return cover(root.left,p)||cover(root.right,p);
	}
	public static TreeNode commonancester(TreeNode root,TreeNode p,TreeNode q){
		boolean isleft=cover(root.left,p);
		boolean isright=cover(root.left,q);
		if(isleft!=isright) return root;
		TreeNode side=isleft?root.left:root.right;
		return commonancester(side,p,q);
	}
	public static boolean getpath(TreeNode root,TreeNode p,LinkedList<TreeNode> arr){
		if(root==p) return true;
		arr.add(root);
		boolean found=false;
		if(root.left!=null)
			found=getpath(root.left,p,arr);
		if(!found&&root.right!=null)
			found=getpath(root.right,p,arr);
		if(!found)
			arr.pop();
		return found;
	}
	public static TreeNode lastcommonnode(LinkedList<TreeNode> l1,LinkedList<TreeNode> l2){
		TreeNode lastone=null;
		int count=0;
		while(l1.get(count)!=null&&l2.get(count)!=null){
			if(l1.get(count)==l2.get(count)){
				lastone=l1.get(count);
			}
			count++;
		}
		return lastone;
			
	}
	public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
		if(root==null||p==null||q==null)return null;
		LinkedList<TreeNode> p1=new LinkedList<TreeNode>();
		getpath(root,p,p1);
		LinkedList<TreeNode> p2=new LinkedList<TreeNode>();
		getpath(root,q,p2);
		return lastcommonnode(p1,p2);
	}
	public static TreeNode common(TreeNode root, TreeNode p, TreeNode q){
		if(root==null) return null;
		if(root==p&&root==q) return root;
		TreeNode x=common(root.left,p,q);
		if(x!=null&&x!=p&&x!=q) return x;
		TreeNode y=common(root.right,p,q);
		if(y!=null&&y!=p&&y!=q) return y;
		if(x!=null&&y!=null) return root;
		else if(root==p||root==q) return root;
		else
			return x==null?y:x;
	}
	public static int depth(TreeNode node){
		if(node==null) return 0;
		else{
			return 1+Math.max(depth(node.left), depth(node.right));
		}
	}
}
