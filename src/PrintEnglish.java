
public class PrintEnglish {
	public static String[] digit={"one","two","three","four","five","six","seven","eight","nine",};
	public static String[] teen={"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eightteen","nineteen"};
	public static String[] ten={"ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
	public static String[] bigs={"","thousand","million"};
	public static void main(String[] args){
		System.out.println(numtostring(1234123));
	}
	public static String numtostring(int number){
		if(number==0)
			return "zero";
		else if(number<0)
			return "negative"+numtostring(-1*number);
		int count=0;
		String str="";
		while(number>0){
			if(number%1000!=0){
				str=numtostring100(number%1000)+bigs[count]+" "+str;
			}
			number/=1000;
			count++;
		}
		return str;
	}
	public static String numtostring100(int number){
		String str="";
		if(number>=100){
			str+=digit[number/100-1]+" hundred ";
			number%=100;
		}
		if(number>=11&&number<=19){
			return str+teen[number-11]+" ";
		}else if(number==10||number>=20){
			str+=ten[number/10-1]+" ";
			number%=10;
		}
		if(number>=1&&number<=9){
			str+=digit[number-1]+" ";
		}
		return str;
	}
}
