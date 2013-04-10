
public class LeiJia {
	static class Temp{
		static int n;
		static int sum;
		Temp(){
		n++;
		sum+=n;
	}
		static void reset(){
			n=0;
			sum=0;
		}
		static int getSum(){
			return sum;
		}
	}
	public static void main(String[] args){
		Temp.reset();
		Temp[] a=new Temp[10];
		System.out.println(Temp.sum);
		SpecialQueue queue=new SpecialQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
	}
