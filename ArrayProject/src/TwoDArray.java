import java.util.*;

public class TwoDArray 
{
	public void arrTest()
	{
		int[][] matrix = new int[10][10];
		
		for(int row = 0; row < matrix.length; row++)
			for(int col = 0; col < matrix[row].length; col++)
				matrix[row][col] = (int)(Math.random() * 100);
		
		for(int row = 0; row < matrix.length; row++)
		{	
			for(int col = 0; col < matrix[row].length; col++)
				System.out.print(" "+matrix[row][col]);
			
			System.out.println();
		}
		//ragged array
		System.out.println("**************************************");
		int[][] r_matrix = new int[10][];
		
		for(int row = r_matrix.length - 1; row >= 0; row--)
			r_matrix[row] = new int[row+1]; //each row is an individual 1D array.
		
		for(int row = r_matrix.length - 1; row >= 0; row--)
			System.out.println("Lengths:  "+r_matrix[row].length);
		
	    
		System.out.println("**************************************");
		matrix = arrOp(matrix);
		
		for(int row = 0; row < matrix.length; row++)
		{	
			for(int col = 0; col < matrix[row].length; col++)
				System.out.print(" "+matrix[row][col]);
			
			System.out.println();
		}
	
		System.out.println("**************************************");
		List<Integer> maxRowList = maxRowth(matrix);
		for(Integer i : maxRowList)
			System.out.print("   "+i);
	}
	
	public int[][] arrOp(int[][] paramArr)
	{
		for(int row = 0; row < paramArr.length; row++)
			for(int col = 0; col < paramArr[row].length; col++)
				paramArr[row][col] = paramArr[row][col] + 10;
		
		return paramArr;
	}
	
	public List maxRowth(int[][] paramArr)
	{
		List<Integer> returnList = new ArrayList<>();
		
		int maxRowIndex = 0, maxRow = 0;
		for(int col = 0; col < paramArr[0].length; col++)//add values of row 0.
		{	
			maxRow = maxRow + paramArr[0][col];
			maxRowIndex = 0;
		}
		
		
		for(int row = 1; row < paramArr.length; row++)
		{
			int temp = 0;
			for(int col = 0; col < paramArr[row].length; col++)
			{	
				temp = temp + paramArr[row][col];
			}
			
			if (temp > maxRow)
			{
				maxRow = temp;
				maxRowIndex = row;
			}
		}
		
		System.out.println("Max Row:  "+maxRowIndex);
		System.out.println("Max Row Total:  "+maxRow);
		//populate ArrayList.
		for(int col = 0; col < paramArr[maxRowIndex].length; col++)
		{	
			returnList.add( new Integer(paramArr[maxRowIndex][col]) );
		}
		
		
		return returnList; 
	}

}
















