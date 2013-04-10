
public class ReverseLinkedList {
	public static void main(String[] args){
		
		ListNode node=new ListNode(1);
		set(node);
		System.out.println(node.val);
		node.next=new ListNode(2);
		node.next.next=new ListNode(3);
		node.next.next.next=new ListNode(4);
		ListNode copy=node;
		while(copy!=null){
			System.out.print(copy.val+" ");
			copy=copy.next;
		}
		System.out.println();
		ListNode newnode=reverse1(node,null);
		while(newnode!=null){
			System.out.print(newnode.val+" ");
			newnode=newnode.next;
		}
		//System.out.println(reverseBetween(node,1,4).val);
		//System.out.println(reverse(node).val);
		System.out.println(reverse12(node,null).val);
		//System.out.println(Math.pow(10, 2));
		ListNode pi=new ListNode(3);
		  oop(pi);
		  System.out.println(pi.val);
	}
	public static void oop(ListNode ii ) {
		ListNode isa=new ListNode(9);
    	ii=isa;
    	
    }

  
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode g = new ListNode(0);
        g.next = head;
        ListNode prev = head, cur = head.next, next = null, x = g;
         
        while (true) {
            if (count >= m && count < n) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            else if (count < m){
                x = prev;
                prev = cur;
                cur = cur.next;
            }
            else if (count == n) {
                x.next.next = cur;
                x.next = prev;
                break;
            }
            count++;
        }
 
        return g.next;
    }
	public static ListNode reverse(ListNode node){
		if(node==null) return null;
		ListNode pre=node;
		ListNode next=node.next;
		ListNode ne=null;
		while(next!=null){
			ne=next.next;
			next.next=pre;
			pre=next;
			next=ne;
		}
		node.next=null;
		node=pre;
		return node;
	}
	public static ListNode reverse1(ListNode head, ListNode previous) {
		 
		 if(head.next==null){
			 head.next=previous;
			 return head;
		 }
		 else{
		ListNode node=reverse1(head.next,head);
		head.next=previous;
		return node;
		 }
	 }
	public static void set(ListNode node){
		node.val=9;
	}
	public static ListNode reverse12(ListNode head,ListNode head1) {
		 
		 if(head==null) return head;
		 if(head.next==null) {
			 head1=head;
			 return head;
			 
		 }
		 
		reverse1(head.next,head1).next=head;
		head.next=null;
		return head;
		 
	 }

}
