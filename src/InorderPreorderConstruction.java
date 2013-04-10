
public class InorderPreorderConstruction {
	public static void main(String[] args){
		int[] preorder = {7,10,4,3,1,2,8,11};
		int[] inorder = {4,10,3,1,7,11,8,2};
		int prefix=0;
		TreeNode result=buildTree(preorder,inorder,0,inorder.length-1,prefix);
	}
	static TreeNode buildTree(int in[], int pre[], int inStrt, int inEnd,int prefix)
	{
	 
	  if(inStrt > inEnd)
	     return null;
	  TreeNode tNode = new TreeNode(pre[prefix]);
	 
	  /* If this node has no children then return */
	  if(inStrt == inEnd)
	    return tNode;
	 
	 
	  int inIndex = search(in, inStrt, inEnd, tNode.data);
	 
	  /* Using index in Inorder traversal, construct left and
	     right subtress */
	  tNode.left = buildTree(in, pre, inStrt, inIndex-1,prefix+1);
	  tNode.right = buildTree(in, pre, inIndex+1, inEnd,prefix+1);
	 
	  return tNode;
	}
	 
	/* UTILITY FUNCTIONS */
	/* Function to find index of value in arr[start...end]
	   The function assumes that value is present in in[] */
	static int search(int arr[], int strt, int end, int value)
	{
	  int i;
	  for(i = strt; i <= end; i++)
	  {
	    if(arr[i] == value)
	      return i;
	  }
	return -1;
	}
}

