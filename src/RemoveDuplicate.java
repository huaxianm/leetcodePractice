import java.util.Hashtable;


public class RemoveDuplicate {
	public static void removeduplicate(ListNode node){
		if(node==null) return;
		Hashtable hashtable=new Hashtable();
		ListNode previous=null;
		while(node!=null){
			if(hashtable.containsKey(node.val))
			previous.next=node.next;
			else{
				hashtable.put(node.val, true);
				previous=node;
			}
			node=node.next;
		}
	}
}
