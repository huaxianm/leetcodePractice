
public class FindFirstRepeatedInteger {

	/**
	 * @param args
	 */
	static class Test{
		private int a;
		Test(int m){
			this.a=m;
		}
		public void print(){
			System.out.println(a);
		}
	}
	static class TestChild extends Test{

		TestChild(int m) {
			super(m);
			// TODO Auto-generated constructor stub
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={2,1,4,3,5,5};
		findfirstRepeatedInteger(a,a.length);
		TestChild test=new TestChild(2);
	}
	public static void findfirstRepeatedInteger(int[] a, int N){
		for (int i = 0; i < N; i++) {
		     int x = a[i]; 
		     if ( x>= 0 ) { 
		         if ( a[x] < 0 ) { // means the xith item has been changed before. 
		          System.out.println(x);
		            break;
		         }
		         else {
		           a[x] = a[x]- N;
		         }
		     }
		     else { 
		         int orig = x + N; 
		         if ( a[orig] <= 0 ) { 
		        	 System.out.println(orig);
		             break;
		        }
		        else {
		            a[orig] = a[orig] - N;
		        }
		     }
		}
	}

}
