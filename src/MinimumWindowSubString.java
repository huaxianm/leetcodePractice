import java.util.Hashtable;
public class MinimumWindowSubString {
	public static void main(String[] args){
		String abc="abc";
		String bb="c";
		int[] a={0,4,7,9,10};
		int[] b={1,2,3,6};
		System.out.println(abc.substring(2, 3));
	//	System.out.println(minWindow(abc,bb));
		System.out.println(minWindow1(abc,bb));
		System.out.println(FindKth(a,0,a.length,b,0,b.length,9));
	}
	public static String minWindow(String s, String t) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0 || t.length()== 0)  return "";
        int[] tc=new int[256];//target count in T
        int[] hasfound=new int[256];
        for(int i = 0; i < 256; ++i) tc[i] = 0;
        for(int i = 0 ; i< t.length(); ++i) tc[t.charAt(i)-'0']++;
        int minbeg=0;
        int minend=0;
        int count=0;
        int minwindow=s.length()+1;
        int curmin;
        char cur;
        for(int i=0,j=0;j<s.length();j++){
            if(tc[s.charAt(j)-'0']==0)
        		continue;
        	cur=s.charAt(j);
        	hasfound[cur-'0']++;
        	if(hasfound[cur-'0']<=tc[cur-'0']){
        		count++;
        	}
        	if(count==t.length()){
        		while (tc[s.charAt(i)-'0'] == 0
                        || hasfound[s.charAt(i)-'0'] > tc[s.charAt(i)-'0'])
                        {
                            if (hasfound[s.charAt(i)-'0'] > tc[s.charAt(i)-'0'])
                                --hasfound[s.charAt(i)-'0'];
                            ++i;
                        }
                        
                        int length = j - i + 1;
                        if (length < minwindow)  
                        {
                            minbeg = i;
                            minend = j;
                            minwindow = length;
                        }
        	}
        	
        }
        return minwindow<=s.length()?s.substring(minbeg, minend+1):"";
    }
	public static String minWindow1(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] helper=new int[256];
        for(int i=0;i<T.length();i++){
            helper[T.charAt(i)-'0']++;
        }
        int[] need=new int[256];
        int count=0;
        int minbeg=0;
        int minlen=S.length()+1;
        for(int beg=0,end=0;end<S.length();end++){
            if(helper[S.charAt(end)-'0']==0)
                continue;
            need[S.charAt(end)-'0']++;
            if(need[S.charAt(end)-'0']<=helper[S.charAt(end)-'0'])
                count++;
            if(count==T.length()){
                while(helper[S.charAt(beg)-'0']==0||need[S.charAt(beg)-'0']>helper[S.charAt(beg)-'0']){
                    if(need[S.charAt(beg)-'0']>helper[S.charAt(beg)-'0'])
                        need[S.charAt(beg)-'0']--;
                    beg++;
                }
                int len=end-beg+1;
                if(len<minlen){
                    minbeg=beg;
                    minlen=len;
                }
            }
        }
        return minlen<S.length()?S.substring(minbeg,minlen+minbeg):"";
    }
	public static int FindKth(int[] A, int aoffset, int m, int[] B, int boffset, int n, int k)
    {
        //Keep the A is the shorter array.
        if (m > n) return FindKth(B, boffset, n, A, aoffset, m, k);

        if (m == 0) return B[k - 1];
        if (k == 1) return Math.min(A[aoffset], B[boffset]);

        //set pa and pb pointer
        int pa = Math.min(k / 2, m);
        int pb = k - pa;

        if (A[aoffset + pa - 1] < B[boffset + pb - 1]) return FindKth(A, aoffset + pa, m - pa, B, boffset, n, k - pa);

        return FindKth(A, aoffset, m, B, boffset + pb, n - pb, k - pb);
    }

}
