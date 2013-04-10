
public class Anything extends Successor {
	int b;
	String str;
	public Anything(int a){
		this.b=a;
	}
	public Anything(String s){
		this.str=s;
	}
	public Anything(int i, String m){
		this.b=i;
		this.str=m;
	}
	public void show(int u,String w){
		System.out.println("Show "+u+" "+w);
	}
	public static void main(String[] args){
		Successor s=new Successor();
		s.show("aaa");
		Anything a=new Anything(3,"bbb");
		a.show("aaa");
		a.show(5, "ooo");
		a.show(a.str);
		int int1=1;
		int int2=2;
		int1=int1^int2;
		System.out.println(int1);
		int2=int1^int2;
		System.out.println(int2);
		int1=int1^int2;
		System.out.println(int1);
	}
}
