import java.util.*;

class GameOfLifeOp
{
	int[][] current;
	int[][] future;
		
	int tRow, tCol;
	GameOfLifeOp(int tRow, int tCol)
	{
		this.tRow = tRow;
		this.tCol = tCol;
		
		current = new int[tRow][tCol];
		
		future = new int[tRow][tCol];
	}
	
	public void matrixInitialize(String line, int lineNum)
	{
		String[] lineArr = line.split("");
		for(int j = 0; j < lineArr.length; j++ )// j is column index.
		{
			if(lineArr[j].compareTo("#") == 0) current[lineNum][j] = 0;
			else if (lineArr[j].compareTo("@") == 0) current[lineNum][j] = 1;
		}
	}
	
	public void nextGen()
	{
		for(int i = 0; i < current.length; i++ )// j is column index.
		{
			for(int j = 0; j < current[i].length; j++ )// j is column index.
			{	
				int tNeighbors = neighborNumber(i, j);
				
				//for occupied cells
				if(current[i][j] == 1)
				{	
					if((tNeighbors == 0) || (tNeighbors == 1))
						future[i][j] = 0; //die
					else if(tNeighbors >= 4)
						future[i][j] = 0; //die
					else if ((tNeighbors == 2) || (tNeighbors == 3))
						future[i][j] = 1;//lives in the next generation.
				}
				else if (current[i][j] == 0)
				{	
					if (tNeighbors == 3)
						future[i][j] = 1;//new born in the next generation.
				}	
			}
		}
		
		resetInitialize(current, future);
	}
	
	public void resetInitialize(int[][] current, int[][] future)
	{
		//assign values of future to current
		for(int i = 0; i < future.length; i++ )
		{
			for(int j = 0; j < future[i].length; j++ )
				current[i][j] = future[i][j];
		}
		
		//reset future to ZERO
		for(int i = 0; i < future.length; i++ )
		{
			for(int j = 0; j < future[i].length; j++ )
				future[i][j] = 0;
		}
	}
	
	
	public int neighborNumber(int r, int c)
	{
		int neighbors = 0;
		for(int i = r -1; i <= r + 1; i++)
		{	
			for(int j = c - 1; j <= c + 1; j++)
			{
				if( ( (i >= 0) && (i < tRow) )  && ( (j >= 0) && (j < tCol) ) )//consider the limit  
				{
					if(current[i][j] == 1) neighbors++; 
				}
			}
		}
		
		if(current[r][c] == 1) neighbors--;
		return neighbors;
	}

	public int numOccupied()
	{
		int count = 0;
		for(int i = 0; i < current.length; i++ )// j is column index.
		{
			for(int j = 0; j < current[i].length; j++ )// j is column index.
			{
				if(current[i][j] == 1) count++;
			}
		}
		
		return count;
	}
}

public class GameOfLife 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String arrDimension = sc.nextLine();
		String[] rowCol = arrDimension.split(" ");
		int tRow = Integer.parseInt(rowCol[0]);
		int tCol = Integer.parseInt(rowCol[1]);
		
		GameOfLifeOp GameOfLifeObj = new GameOfLifeOp(tRow, tCol);
		
		int i = 0;
		while(i < tRow)
		{
			String line = sc.nextLine();
			GameOfLifeObj.matrixInitialize(line, i);
			i++;
		}
		
		int generations = Integer.parseInt(sc.nextLine());
		for(int k = 0; k < generations; k++)
		{
			GameOfLifeObj.nextGen();
		}
		System.out.println(GameOfLifeObj.numOccupied());
		
		sc.close();
	}
}

/*
 * public void display()
		{
			for(int i = 0; i < current.length; i++ )// j is column index.
			{
				for(int j = 0; j < current[i].length; j++ )// j is column index.
					System.out.print(current[i][j]+"   ");
				System.out.println();
			}
			
			
				for(int i = 0; i < future.length; i++ )// j is column index.
				{
					for(int j = 0; j < future[i].length; j++ )// j is column index.
						System.out.print(future[i][j]+"   ");
					System.out.println();
				}
			}
				
 * 
 */



