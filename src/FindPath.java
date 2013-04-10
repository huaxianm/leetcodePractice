import java.util.ArrayList;
import java.util.Iterator;


public class FindPath {
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(1);
		ArrayList<Integer> result=new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
		getPath(root,arr,4,0,result);
		System.out.println(arr.toString());
	}
	public static void getPath(TreeNode root, ArrayList<ArrayList<Integer>> arr,int expectsum, int cursum,ArrayList<Integer> partial){
		if(root==null)
			return;
		cursum+=root.data;
		partial.add(root.data);
		if(root.left==null&&root.right==null&&cursum==expectsum){
//			Iterator iter=arr.iterator();
//			while(iter.hasNext()){
//				System.out.print(iter.next()+" ");
//			}
//			System.out.println();
			arr.add(partial);
			return;
		}
		if(root.left!=null)
			getPath(root.left,arr,expectsum,cursum,partial);
		if(root.right!=null)
			getPath(root.right,arr,expectsum,cursum,partial);
		cursum-=root.data;
	}
}
