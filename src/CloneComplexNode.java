
public class CloneComplexNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNode root=new ComplexNode(1);
		ComplexNode root1=new ComplexNode(2);
		ComplexNode root2=new ComplexNode(3);
		ComplexNode root3=new ComplexNode(4);
		ComplexNode root4=new ComplexNode(5);
		root.next=root1;
		root1.next=root2;
		root2.next=root3;
		root3.next=root4;
		root.sibling=root2;
		root1.sibling=root4;
		root3.sibling=root1;
		ComplexNode node=cloneList(root);
		
		while(node!=null){
		System.out.println("current value is "+node.val);
		if(node.sibling!=null)
		System.out.println("its sibling is "+node.sibling.val);
		node=node.next;
		}
	}
	public static ComplexNode cloneList(ComplexNode root){
		clone(root);
		setSibling(root);
		return seperate(root);
	}
	public static void clone(ComplexNode root){
		ComplexNode node=root;
		while(node!=null){
			ComplexNode temp=new ComplexNode();
			temp.next=node.next;
			temp.val=node.val;
			temp.sibling=null;
			node.next=temp;
			node=temp.next;
		}
	}
	public static void setSibling(ComplexNode root){
		ComplexNode node=root;
		while(node!=null){
			ComplexNode clone=node.next;
			if(node.sibling!=null){
				clone.sibling=node.sibling.next;
			}
			node=clone.next;
		}
	}
	public static ComplexNode seperate(ComplexNode root){
		ComplexNode node=root;
		ComplexNode clonehead=null;
		ComplexNode clonenode=null;
		if(node!=null){
			clonehead=clonenode=node.next;
			node.next=clonehead.next;
			node=node.next;
		}
		while(node!=null){
			clonenode.next=node.next;
			clonenode=clonenode.next;
			node.next=clonenode.next;
			node=node.next;
		}
		return clonehead;
	}

} 
