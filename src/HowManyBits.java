
public class HowManyBits {
	static int countSetBits(int n)
	{
	  int count = 0;
	  while(n>0)
	  {
	    count += n & 1;
	    n >>= 1;
	  }
	  return count;
	}
	 
	/* Program to test function countSetBits */
	public static void main(String[] args)
	{
	    int i = 9;
	    System.out.println(countSetBits(4));
	}
}
