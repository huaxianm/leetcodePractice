import java.util.Scanner;


public class Stairs {
	 public static void main(String[] args) {
	        Scanner scnr=new Scanner(System.in);
	        int x=scnr.nextInt();
	        int b=0;
	        while (x!=0){
	            b|=( x &1);
	            x>>=1;
	            if(x==0)
	            	break;
	            b<<=1;
	        }
	        System.out.println(b);
	    }
}
