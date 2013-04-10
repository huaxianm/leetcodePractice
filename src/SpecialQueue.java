import java.util.Stack;


public class SpecialQueue<T> {
	private Stack<T> stack1=new Stack<T>();
	private Stack<T> stack2=new Stack<T>();
	public void push(T a){
		stack1.push(a);
	}
	public void shift(){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
	}
	public T pop(){
		shift();
		return stack2.pop();
	}
}
