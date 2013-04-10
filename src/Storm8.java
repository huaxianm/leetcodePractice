import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/**************************************
 * @author Huaxiang Man 
 * problem description: return the counting of the cyclic automorphism to the string. For example,a string "byebye":
 * it's cyclic string can be presented as:
 * shift one bit: yebyeb
 * shift two bits: ebyeby
 * shift three bits: byebye
 * shift four bits: yebyeb
 * shift five bits: ebyeby
 * a cyclic automorphism is a cyclic string that is equals to the original string, so for "byebye", 
 * there are two cyclic automorphisms including itself. 
 * 
 * My thought: The first idea comes to my mind is that we can generate all the possible combinations
 * of the string to check whether there exist a cyclic string that's equals to the original string, it 
 * works but it takes a lot of time. It's worse case time complexity is O(n). However, time is wasted
 * in the comparision and generation of all cyclic strings. So I mover forward to solution one:
 * 
 * Solution one (function name cyclic_automorphisms1()): 
 * Actually, we don't need to generate all cyclic strings, what we need to do is to find 
 * the prefix that shows up repeatedly and divide the length of the original string by the length of such
 * prefix string. For example, for string "byebyebyebyebyebye", if we can find the prefix "bye", whose
 * length is 3. Also, the length of  "byebyebyebyebyebye" is 18, so 18/3=6 is our answer. This solution
 * saves a lot of time to generate all combinations and exit early when getting a repeated prefix.
 * 
 * Solution two (function name cyclic_automorphisms():
 * Solution one seems good, but I believe we can do better. Carefully looking at the problem, we can find
 * an interesting phenomenon: a cyclic automorphisms is the combination the serveral identical substrings.
 * For example, for "abcdabcdabcdabcd", that is "abcd" showing up four times!. For "byebyebye", that is 
 * "bye" showing up three times! Thus, the length of the substring must be one of the approximate numbers.
 * Otherwise, it will never generate any cyclic automorphism. So for a string whose length is 10, to gain
 * cyclic automorphisms, only below cases can satisfy:aaaaaaaa(repeated substring length 1), ababababab 
 * (repeated substring length 2), abcdeabcde (repeated substring length) or abcdefghij (repeated substring
 * length 10, the string itself), nothing else!! So we just need to check whether such substring at the
 * specific position can lead to cyclic automorphisms. This solution greatly reduces the computing time.
 */

public class Storm8 {
	public static void main(String[] args){
		//test time spend for each solution
		String test="abcdefghijklmnopqrstuvwxyzadfssdwqevcxjkvldsjqwoiurvcnzlweopuwgoiudsfsduaifqwnelkjkldjfdsklafjdsakluieqoiwueiojvcfdsfdsafabcdefghijklmnopqrstuvwxyzadfssdwqevcxjkvldsjqwoiurvcnzlweopuwgoiudsfsduaifqwnelkjkldjfdsklafjdsakluieqoiwueiojvcfdsfdsaf";
		String test1="byebyebyebyebye";
		long starttime=System.currentTimeMillis();
		//optimal solution
		System.out.println(cyclic_automorphisms(test1));
		long endtime=System.currentTimeMillis();
		System.out.println((endtime-starttime)+"ms");
		long starttime1=System.currentTimeMillis();
		//less optimal solution
		System.out.println(cyclic_automorphisms1(test1));
		long endtime1=System.currentTimeMillis();
		System.out.println((endtime1-starttime1)+"ms");
	}
	public static int cyclic_automorphisms1(String s){
		if(s.length()==0)
			return 1;
		boolean found = false;
		String sub = null;
		int count = 0;
		//get all combination of strings, if we found the prefix that could lead to a cyclic automorphisms
		//we break the loop and divid it by the length of string 
		for(int i=1;i<s.length();i++){
			String temp = s.substring(i)+s.substring(0, i);
			if(temp.equals(s)){
				sub = s.substring(0,i);
				found = true;
				break;
			}
		}
		//do a division, we can get the count
		if(found){
			count = (s.length())/(sub.length());
			return count;
		}else
			return 1;
	}
	public static int cyclic_automorphisms(String s){
		if(s.length()==0)
			return 1;
		ArrayList<Integer> array=getAllApproximateNumber(s.length());
		String sub=s;
		int count=1;
		//we don't need to traverse all the characters in the string, to make a cyclic automorphism,
		//a certain substring should repeated show up to the end, what we need to do is find such
		//substring. 
		for(int i=0;i<array.size();i++){
			int a=array.get(i);
			//get the cyclic string
			String str=s.substring(a)+s.substring(0, a);
			//if the cyclic string is equals to the original one, we know we have found the repeated substring
			if(str.equals(s)){
				sub=s.substring(0, a);
				break;
			}
		}
		System.out.println(sub);
		count=s.length()/sub.length();
		return count;
	}
	//this function is to get all approximate numbers
	public static ArrayList<Integer> getAllApproximateNumber(int n){
		ArrayList<Integer> array=new ArrayList<Integer>();
		for(int i=2;i<=n/2;i++){
			int temp=n;
			while(temp%i==0){
				temp/=i;
				if(!array.contains(i))
				array.add(i);
			}
		}
		return array;
	}
}
