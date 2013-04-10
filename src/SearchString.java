
public class SearchString {
	public int search(String[] strings,String str,int first,int last){
		int mid=(first+last)/2;
		if(strings[mid]==" "){
			int left=mid-1;
			int right=mid+1;
		while(true){
			if(left<first&&right>last){
				return -1;
			}
			else if(strings[right]!=" "&&right<=last){
				mid=right;
				break;
			}
			else if(strings[left]!=" "&&left>=first){
				mid=left;
				break;
			}
			right++;
			left--;
			}
		}
		if(strings[mid]==str) return mid;
		else if(strings[mid].compareTo(str)<0) return search(strings,str,mid+1,last);
		else return search(strings,str,first,mid-1);
	}
	
	}

