import java.util.Stack;
public class SimplifyPath {
	public static void main(String[] args){
		String str="/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
		System.out.println(simplifyPath(str));
		System.out.println(10/3);
	}
	public static String simplifyPath(String path) {
	       if (path == null || path.length() == 0) return "/";

	    Stack<String> stack = new Stack<String>();
	    String[] splits = path.trim().split("/");
	    for (String s : splits) {
	        if (s == null || s.length() == 0 || s.equals(".")) {
	            // Do nothing;
	        } else if (s.equals("..")) {
	            // Pop if stack is not empty;
	            if (stack.size() > 0) stack.pop();
	        } else {
	            // Push all others to stack.
	            stack.push(s);
	        }
	    }

	    // Remember, stack can be empty.
	    if (stack.isEmpty()) return "/";

	    StringBuffer buf = new StringBuffer();
	    while (!stack.isEmpty()) {
	        buf.insert(0, stack.pop());
	        buf.insert(0, "/");
	    }

	    return buf.toString();
	    }
}
