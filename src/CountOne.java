
public class CountOne {
	public static void main(String[] args){
		int n=1;
		System.out.println(n<<1);
	}

	public static int countone(int n){
		int count=0;
		while(n>0){
			if((n&1)==1){
				count++;
			}
			n>>=1;
		}
		return count;
	}
}
