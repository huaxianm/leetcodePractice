
public class FindStringInEmpty {
	public int searchString(String[] strings,String target,int first,int last){
		int mid=(first+last)/2;
		if(strings[mid].isEmpty()){
			int left=mid-1;
			int right=mid+1;
			while(true){
				if(left<first&&right>last) return -1;
				else if(right<=last&&!strings[right].isEmpty()){
					mid=right;
					break;
				}
				else if(left>=first&&!strings[left].isEmpty()){
					mid=left;
					break;
				}
				right++;
				left--;
			}
			}
			if(strings[mid]==target) return mid;
			else if(strings[mid].compareTo(target)>0){
				return searchString(strings,target,first,mid-1);
			}
			else{
				return searchString(strings,target,mid+1,last);
			}
		}
	public int search(String[] strings,String str){
		if(strings==null||str==null||str==""){
			return -1;
		}
		return searchString(strings,str,0,strings.length-1);
	}
	}

