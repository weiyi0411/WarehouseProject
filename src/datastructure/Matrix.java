package datastructure;
public class Matrix 
{
	int[][] matrix;
	// some appropriate private members.
	
	public Matrix(int nrNodes)
	{
		int [][]matrix =new int [nrNodes][nrNodes];
		for(int i=0;i<nrNodes;i++) {
			for (int j=0;j<nrNodes;j++) {
				matrix[i][j]=0;
			}
		}
		
		// allocate an N-by-N matrix where N = nrNodes
		// all elements are initially 0
	}
	
	public void set(int row, int col, Comparable weight)
	{
		matrix[row][col]=(int) weight;
		// store the weight at the given row and column.
	}

	public Comparable get(int row, int col)
	{
		return matrix[row][col];
		// return the weight at the given row and column.
	}
}