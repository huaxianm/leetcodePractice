
public class ComplexNode {

	int val;
	ComplexNode next;
	ComplexNode sibling;
	ComplexNode(int x) {
	         val = x;
	       next = null;
	       sibling=null;
	     }
	ComplexNode(){
		next=null;
		sibling=null;
		val=0;
	}

}
