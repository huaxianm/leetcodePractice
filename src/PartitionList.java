
public class PartitionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node=new ListNode(2);
		node.next=new ListNode(1);
		node.next.next=new ListNode(4);
		node.next.next.next=new ListNode(1);
		node.next.next.next.next=new ListNode(5);
		node.next.next.next.next.next=node;
//		ListNode temp=reverse1(node,null);
//	//	ListNode temp=reverseBetween(node,1,3);
//		while(temp!=null){
//		System.out.println(temp.val);
//		temp=temp.next;
//		}
		System.out.println(isCycle(node));
	}
	public static boolean isCycle(ListNode head){
		ListNode slow=head;
		ListNode fast=head;
		while(slow!=null&&fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				return true;
			}
		}
		return false;
	}
	public static ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null)
            return null;
        ListNode smallfirst=null;
        ListNode smalllast=null;
        ListNode largefirst=null;
        ListNode largelast=null;
        while(head!=null){
            if(head.val<x){
                if(smallfirst==null){
                    smallfirst=head;
                    smalllast=smallfirst;
                }else{
                    smalllast.next=head;
                    smalllast=smalllast.next;
                }
            }else{
                 if(largefirst==null){
                    largefirst=head;
                    largelast=largefirst;
                }else{
                    largelast.next=head;
                    largelast=largelast.next;
                }
            }
            head=head.next;
        }
        if(smallfirst==null){
            return largefirst;
        }else{
            smalllast.next=largefirst;
            return smallfirst;
        }
    }
	 public static ListNode reverseBetween(ListNode head, int m, int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	       if(head==null) return head;
	        ListNode dummy=new ListNode(0);
	        dummy.next = head;
	        ListNode pre = dummy;
	        ListNode cur = head;
	        int c = 0;
	        while(cur!=null && ++c<n){
	            if(c<m) pre = cur;
	            cur = cur.next;
	            }
	        ListNode end = cur.next;
	        cur = reverse(pre,end);
	        cur.next = end;
	        return dummy.next;
	    }
	    static ListNode reverse(ListNode prev, ListNode end){
	            ListNode last = prev.next;
	            ListNode cur = last.next;
	            while(cur!=end){
	                last.next = cur.next;
	                cur.next = prev.next;
	                prev.next = cur;
	                cur = last.next;
	                }
	            return last;
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

}
