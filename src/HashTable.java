import java.util.Hashtable;


public class HashTable {
	public static void main(String[] args){
		Hashtable company=new Hashtable();
		company.put("Google", "USA");
		company.put("Nokia", "Finland");
		company.put("Sony", "Japan");
		System.out.println(company.get("Google"));
		System.out.println(company.containsKey("Nokia"));
		int a=11;
		System.out.println(a>10?1:0);
	}
	
}
