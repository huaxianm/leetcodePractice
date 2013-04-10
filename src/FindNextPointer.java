import java.util.LinkedList;


public class FindNextPointer {
	public static void main(String[] args){
		TreeLinkNode root=new TreeLinkNode(0);
		root.left=new TreeLinkNode(1);
		root.right=new TreeLinkNode(2);
		connect(root);
	}
	 public static void connect(TreeLinkNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(root==null) return;
	        LinkedList<LinkedList<TreeLinkNode>> list=new LinkedList<LinkedList<TreeLinkNode>>();
	        helper(0,list,root);
	        for(int i=0;i<list.size();i++){
	            LinkedList<TreeLinkNode> newlist=list.get(i);
	            for(int j=0;j<newlist.size();j++){
	                TreeLinkNode node=newlist.get(j);
	                if(j==newlist.size()-1){
	                    node.next=null;
	                }else{
	                    node.next=newlist.get(j+1);
	                }
	            }
	        }
	    }
	    public static void helper(int level, LinkedList<LinkedList<TreeLinkNode>> arr, TreeLinkNode root){
	        if(root==null) return;
	        if(arr.size()==level){
	            LinkedList<TreeLinkNode> partial=new LinkedList<TreeLinkNode>();
	            partial.add(root);
	            arr.add(partial);
	        }else{
	            LinkedList<TreeLinkNode> partial=arr.get(level);
	            partial.add(root);
	        }
	        helper(level+1,arr,root.left);
	        helper(level+1,arr,root.right);
	    }
}
