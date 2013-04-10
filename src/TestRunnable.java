
public class TestRunnable {
	public static void main(String[] args){
	RunnableThread instance=new RunnableThread();
	Thread thread=new Thread(instance);
	thread.start();
	while(instance.count!=5){
		try{
			Thread.sleep(250);
		}catch(InterruptedException exc){
			exc.printStackTrace();
		}
	}
	}
}
