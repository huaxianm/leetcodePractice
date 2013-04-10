
public class ClassicSingleton {
	public static int a;
	private static ClassicSingleton INSTANCE=null;
	private ClassicSingleton(){
		
	}
	public static ClassicSingleton getInstance(){
		if(INSTANCE==null){
			INSTANCE=new ClassicSingleton();
		}
		return INSTANCE;
	}
	public static void main(String[] args){
		int b=104;
		ClassicSingleton a=new ClassicSingleton();
		System.out.println(b/10);
	}
	
}
