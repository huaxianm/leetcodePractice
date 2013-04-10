import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
class Position{
	int row;
	int col;
	int altitude;
	Position(){
		row=0;
		col=0;
		altitude=0;
	}
	Position(int a, int b,int val){
		row=a;
		col=b;
		altitude=val;
	}
}

public class Palantir {
	static int length=0;
	private static HashMap<Position,Position> map=new HashMap<Position,Position>();
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		length=Integer.parseInt(sc.nextLine());
		Position[][] farm=new Position[length][length];
		int count=length;
		//import farm information
		while(count>0){
			String[] str=sc.nextLine().split(" ");
			if(str.length>length) {
				throw new Exception("wrong input");
			}
			for(int i=0;i<str.length;i++){
				Position p=new Position(length-count,i,Integer.parseInt(str[i]));
				farm[length-count][i]=p;
			}
			count--;
		}
		try{
		getMap(farm);
		ModifyMap();
		PrintResult();
	}catch(Exception e){
		System.err.println(e.getMessage());
	}
}
	
	public static void PrintResult(){
		Hashtable<Position,Integer> hash=new Hashtable<Position, Integer>();
		Set<Position> set=map.keySet();
		Iterator<Position> iter=set.iterator();
		while(iter.hasNext()){
			Position p=map.get(iter.next());
			if(hash.containsKey(p)){
				int a=hash.get(p);
				a++;
				hash.put(p, a);
			}else{
				hash.put(p, 1);
			}
		}
		Set<Position> hashset=hash.keySet();
		Iterator<Position> hashiter=hashset.iterator();
		for(int i=0;i<hash.size();i++){
			System.out.print(hash.get(hashiter.next())+" ");
		}
	}
	//try to get all pairs with the relation currentposition and which block the flow will go to
	public static void getMap(Position[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				Position current=arr[i][j];
				Position minposition=current;
				if(current.row-1>0){
					minposition=arr[i-1][j].altitude<current.altitude?arr[i-1][j]:minposition;
				}
				if(current.col-1>0){
					minposition=arr[i][j-1].altitude<current.altitude?arr[i][j-1]:minposition;
				}
				if(current.row+1<length){
					minposition=arr[i+1][j].altitude<current.altitude?arr[i+1][j]:minposition;
				}
				if(current.col+1<length){
					minposition=arr[i][j+1].altitude<current.altitude?arr[i][j+1]:minposition;
				}
				map.put(arr[i][j], minposition);
			}
		}	
	}
	//
	public static void  ModifyMap(){
		Set<Position> set=map.keySet();
		Iterator<Position> iter=set.iterator();
		while(iter.hasNext()){
			Position p=iter.next();
			Position q=p;
			while(!isfoundsink(q,map.get(q))){
				Position temp=map.get(q);
				map.remove(q);
				q=temp;
			}
			map.put(p, q);
		}
	}
	public static boolean isfoundsink(Position p, Position q){
		return p.row==q.row&&p.col==q.col&&p.altitude==q.altitude;
	}
	
}
