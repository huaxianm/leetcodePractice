
public class ThreadTest implements Runnable {
	public int count=0;
	public void run(){
		System.out.println("Starting");
		try{
			while(count<5){
				Thread.sleep(500);
				count++;
				System.out.println("current count is "+count);
			}
		}catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
		System.out.println("Terminated");
	}
	public static void main(String[] args){
		ThreadTest thread=new ThreadTest();
		Thread t=new Thread(thread);
		t.start();
		while(thread.count!=5){
			try{
				Thread.sleep(250);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
