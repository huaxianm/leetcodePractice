import java.util.*;
class solution{
public static void main(String[] args){
    String[] str=new String[2];
    Scanner sc1 = new Scanner(System.in);
    str[0] = sc1.nextLine();      
    str[1]=sc1.nextLine();
    Hashtable<Character,Integer> hash=new Hashtable<Character,Integer>();
    boolean isAnagram=true;
    for(int i=0;i<str[0].length();i++){
        char temp=str[0].charAt(i);
        if(temp==' '){
        continue;
        }
        if(hash.containsKey(temp)){
            int a=hash.get(temp);
            a++;
            hash.put(temp,a); 
        }else{
         	hash.put(temp,1);   
        } 
}	
     for(int i=0;i<str[1].length();i++){     
      	char temp=str[1].charAt(i);
         if(temp==' ') continue;
         if(!hash.containsKey(temp)){
          isAnagram=false;
             break;
         }else{
          int a=hash.get(temp);
             a--;
             if(a!=0)
             hash.put(temp,a);
             else
             hash.remove(temp);
         }     
     }
           if(hash.size()==0) 
        	isAnagram=true;
           else
           isAnagram=false;
           if(isAnagram){
               System.out.println("Anagrams!");}
           else{
               System.out.println("Not anagrams!");   
           }
    
}
}