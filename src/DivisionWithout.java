
public class DivisionWithout {
	public static void main(String[] args){
		System.out.println(divide(13,3));
	}
	public static int divide(int dividend, int divisor) // return c=a/b;
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
}
