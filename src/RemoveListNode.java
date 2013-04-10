
public class RemoveListNode {
	public static void main(String[] args){
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		ListNode node=head;
		while(node!=null){
			System.out.print(node.val+" ");
			node=node.next;
		}
		System.out.println();
		int[] array={1,2,3,4};
		Remove(head,array,array.length);
		ListNode node1=head;
		while(node1!=null){
			System.out.print(node1.val+" ");
			node1=node1.next;
		}
		System.out.println();
		System.out.println(removeNthFromEnd(head,1).val);
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0) return head;
        ListNode node=head;
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        if(n>=length) return null;
        int count=0;
        int index=length-n;
        if(index==1) return head.next;
        else{
            while(count<index-1){
                node=node.next;
                count++;
            }
        }
        node.next=node.next.next;
        return head;
    }
	static public ListNode Remove( ListNode firstNode, int[] removalRequests, int removalRequests_Length ) 
	{ 
	   //return null if empty list
	    if(firstNode==null)
	        return null;
	   //if nothing needs to be removed, just return
	    if(removalRequests.length==0)
	        return firstNode;
	    ListNode node=firstNode;
	    int count=0;
	    int index=0;
	    while(node!=null&&index<removalRequests_Length){
	           if(count!=removalRequests[index]-1){
	                 count++;
	                 node=node.next;
	         }else{
	        	 ListNode temp=node;             
	               while(index<removalRequests_Length&&count==removalRequests[index]-1){
	                 count++;
	                 index++;
	                 temp=temp.next;
	         }
	          node.next=temp.next;
	          node=node.next;
	          count++;                 
	         }
	   }
	     return firstNode;
	} 
}
