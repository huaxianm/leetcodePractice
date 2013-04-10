import java.util.ArrayList;


public class Spiral {
	public static void main(String[] args){
		int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		ArrayList<Integer> finalresult=spiralOrder(arr);
		for(int i=0;i<finalresult.size();i++)
		System.out.println(finalresult.get(i));
	}
	
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length==0) return new ArrayList<Integer>();
        ArrayList<Integer> result=new ArrayList<Integer>();
        spiral(matrix,matrix.length,matrix[0].length,0,result);
        return result;
        
    }
    public static void spiral(int[][] matrix, int m,int n, int level, ArrayList<Integer> array){
        if(m<=0||n<=0) return;
        if(m==1){
            for(int i=0;i<n;i++){
                array.add(matrix[level][level+i]);
            }
            return;
        }
        if(n==1){
            for(int i=0;i<m;i++){
                array.add(matrix[level+i][level]);
                
            }
            return;
        }
        for(int i=0;i<n-1;i++){
            array.add(matrix[level][i+level]);
        }
        for(int i=0;i<m-1;i++){
            array.add(matrix[i+level][n-1+level]);
        }
        for(int i=0;i<n-1;i++){
            array.add(matrix[m-1+level][n+level-1-i]);
        }
        for (int i = 0; i < m - 1; i++)
            array.add(matrix[level+m-1-i][level]);
 
            spiral(matrix, m-2, n-2, level+1,array);
}
}
