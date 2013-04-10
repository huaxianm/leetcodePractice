
public class setToZero {
	public static void settozero(int[][] matrix){
		boolean[] row=new boolean[matrix.length];
		boolean[] column=new boolean[matrix[0].length];
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0)
				{
					row[i]=true;
					column[j]=true;
				}
			}
			for(int i=0;i<matrix.length;i++)
				for(int j=0;j<matrix.length;j++){
					if(row[i]==true||column[j]==true)
						matrix[i][j]=0;
				}
	}
}
