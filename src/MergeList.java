
public class MergeList {
	public static void main(String[] args){
		ListNode node1=new ListNode(5);
		ListNode node2=new ListNode(1);
		node2.next=new ListNode(2);
		node2.next.next=new ListNode(4);
		System.out.println(mergeTwoLists(node1,node2).val);
	}
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1==null&&l2==null) return null;
	        if(l1==null||l2==null) return l1==null?l2:l1;
	        ListNode node1=l1;
	        ListNode node2=l2;
	        ListNode head=null;
	        ListNode curr=null;
	        while(node1!=null&&node2!=null){
	            if(head==null){
	                if(node1.val>node2.val){
	                    head=curr=node2;
	                    node2=node2.next;
	                    curr.next=null;
	                }else{
	                    head=curr=node1;
	                    node1=node1.next;
	                    curr.next=null;
	                }
	            }else{
	                if(node1.val<node2.val){
	                    curr.next=node1;
	                    curr=node1;
	                    node1=node1.next;
	                    curr.next=null;
	                }else{
	                   
	                    curr.next=node2;
	                     curr=node2;
	                    node2=node2.next;
	                    curr.next=null;
	                }
	                    
	            }
	        }
	        if(node1!=null) curr.next=node1;
	        else if(node2!=null) curr.next=node2;
	        return head;
	    }
}
