
public class DivideWithoutOthers {
	public static void main(String[] args){
		int a=1500000000;
		int b=2;
		//int result=divide(-100,-3);
		//System.out.println(result);
		System.out.println(minDistance("abcefge","abcd"));
		System.out.println(dividewithbit(a,b));
	}
	 public static int divide(int dividend, int divisor) {
	        // Start typing your Java solution below
	        boolean negative=false;
	       
	       int result=0;
	       if(dividend<0){
	           negative=true;
	           dividend=-dividend;
	       }
	       if(divisor<0){
	           negative=!negative;
	           divisor=-divisor;
	       }
	       if(dividend==0){
	           return 0;
	       }
	       int substract=divisor;
	       while(dividend>=divisor){
	            dividend=dividend-substract;
	            result=result+1;
	       }
	       int finalresult=negative?-result:result;
	       return finalresult;
	        
	    }
	 public static int dividewithbit(int dividend, int divisor) // return c=a/b;
	 {
	     long a = dividend;
	     long b = divisor;

	     if (b == 0)
	         throw new ArithmeticException();

	     boolean neg = false;
	     if (a < 0)
	         neg = !neg;

	     if (b < 0)
	         neg = !neg;

	     a = Math.abs(a);
	     b = Math.abs(b);

	     int d = 0;
	     while (b << d <= a)
	     {
	         d++;
	     }

	     int c = 0;

	     for (int i = d; i >= 0; i--)
	     {
	         if (b << i <= a)
	         {
	             c |= 1 << i;
	             a -= b << i;
	         }
	     }

	     if (neg)
	         c = -c;
	     return c;
	 }


	 public static int minDistance(String word1, String word2) {
	        int length1=word1.length()+1;
	        int length2=word2.length()+1;
	        int[][] array=new int[length1][length2];
	        for(int i=0;i<length1;i++){
	            array[i][0]=i;
	        }
	         for(int i=0;i<length2;i++){
	            array[0][i]=i;
	        }
	         for(int i = 1; i < length1 ; ++ i)
	    {
	        for(int j = 1; j < length2 ; ++ j)
	        {
	            if(word1.charAt(i-1) == word2.charAt(j-1))
	                array[i][j] = array[i - 1][j - 1];
	            else
	            {
	                int deletion = array[i][j - 1] + 1;
	                int insertion = array[i - 1][j] + 1;
	                int substitution = array[i - 1][j - 1] + 1;
	                int temp=deletion>=insertion?insertion:deletion;
	                array[i][j] = temp>substitution?substitution:temp;
	            }
	        }
	    }
	    return array[length1-1][length2-1];
	}
}
