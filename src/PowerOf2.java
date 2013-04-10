
public class PowerOf2 {
	static int largestPrime(long n){
//		int divide=2;
//		while(n>1){
//			if(n%divide==0){
//				n=n/divide;
//			}
//			divide++;
//		}
//		return divide;
		int i;

        for (i = 2; i <= n; i++) {
            if (n % i == 0) {
                n /= i;
                i--;
            }
        }

        return i;
	}
	
	public static void main(String[] args){
		int value = 0;
        for(int i = 999;i >=100;i--)
        {
            for(int j = 999;j>=100;j--)
            {
                int value1 = i * j;
                StringBuilder sb1 = new StringBuilder(""+value1);
                String sb2 = ""+value1;
                sb1.reverse();
                if(sb2.equals(sb1.toString()) && value<value1) {
                    value = value1;

                }

            }
        }

        System.out.println(value);
		int n=3;
		while(n>1){
			for(int i=0;i<n;i++){
				System.out.println(i);
			}
			n--;
		}
		System.out.print(largestPrime(600851475143L));
	}
}
