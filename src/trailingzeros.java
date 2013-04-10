
public class trailingzeros {
	public static void main(String[] args){
		System.out.println(countfactzeros(10));
	}
	public static int countfactzeros(int num){
		int count=0;
		if(num<0){
			return -1;
		}
		for(int i=5;num/i>0;i*=5){
			count+=num/i;
		}
		return count;
	}
}
