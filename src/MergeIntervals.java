import java.util.ArrayList;


public class MergeIntervals {
	class Interval{
		int start;
		int end;
		Interval(int a,int b){
			start=a;
			end=b;
		}
	}
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	    ArrayList<Interval> result=new ArrayList<Interval>();
	    boolean isLarge=true;
	    for(int i=0;i<intervals.size();i++){
	        Interval temp=intervals.get(i);
	        if(temp.end<newInterval.start){
	            result.add(temp);
	            continue;
	        }
	        if(temp.start>newInterval.end){
	            if(isLarge){
	                result.add(newInterval);
	                isLarge=false;
	            }
	            result.add(temp);
	            continue;
	        }
	        newInterval.start=temp.start>newInterval.start?newInterval.start:temp.start;
	        newInterval.end=temp.end>newInterval.end?temp.end:newInterval.end;
	    }
	    if(isLarge){
	        result.add(newInterval);
	    }
	    return result;
	}

}
