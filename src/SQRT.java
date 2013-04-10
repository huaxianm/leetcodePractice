
public class SQRT {
	public static void main(String[] args){
		System.out.println(sqrt(1000));
	}
	public static int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int i=1;
        int prev=0;
        while(i<Integer.MAX_VALUE){
            int square=i*i;
            if(x>square){
                prev=i;
                i++;
            }else if(x==square){
                return square/2;
            }else{
                break;
            }
        }
        return prev;
        
    }
}
