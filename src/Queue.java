
public class Queue {
	Node head,tail;
	void enqueue(int n){
		
		Node t=new Node(n);
		if(head==null) {
			tail=t;
			head=tail;
		}
		else{
			tail.next=t;
			tail=tail.next;
					}
	}
	Node dequeue(){
		if(head!=null){
			Node a=new Node();
			a=head;
			head=head.next;
			return a;
		}
		return null;
	}
}
