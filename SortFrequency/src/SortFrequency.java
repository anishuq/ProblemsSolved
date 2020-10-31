import java.util.*;
//Sort elements by frequency
//https://www.geeksforgeeks.org/sort-elements-by-frequency/

public class SortFrequency {

	public static void main(String[] args) 
	{
		//Integer[] input = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
		Integer[] input = {2, 5, 2, 8, 5, 6, 8, 8};
		ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(input));
		Set<Integer> inpSet = new HashSet<Integer>();
		inpSet.addAll(temp);
		
		int[][] fSort = new int[inpSet.size()][3];
		
		int i = 0;
		Iterator<Integer> it = inpSet.iterator();
		while(it.hasNext())
		{	
			fSort[i][0] = it.next();
			fSort[i][1] = Collections.frequency(temp, fSort[i][0]);
			
			//now we find the index in input array
			for(int j = 0; j < temp.size(); j++)
			{
				if(temp.get(j) == fSort[i][0])
				{
					fSort[i][2] = j;
					break;
				}
			}
			i++;		
		}
		
		//we sort based on frequency
		for(int k = 0; k < fSort.length; k++)
		{	
			int max = fSort[k][1];
			int maxFreqRow = k;
			boolean found = false;
			
			for(int l = k + 1; l < fSort.length; l++)
			{
				if(fSort[l][1] > max)
				{
					max = fSort[l][1];
					maxFreqRow = l;
					found = true;
				}
			}
			
			if(found == true)// we swap 
			{
				int t_value = fSort[k][0];
				int t_freq = fSort[k][1];
				int t_index = fSort[k][2];
				
				fSort[k][0] = fSort[maxFreqRow][0];
				fSort[k][1] = fSort[maxFreqRow][1];
				fSort[k][2] = fSort[maxFreqRow][2];
				
				fSort[maxFreqRow][0] = t_value; 
				fSort[maxFreqRow][1] = t_freq;
				fSort[maxFreqRow][2] = t_index;
			}
		}
		
		//we sort by index if freq are equal 
		for(int k = 0; k < fSort.length; k++)
		{	
			int index = fSort[k][2];
			int iRow = k;
			boolean found = false;
			
			for(int l = k + 1; l < fSort.length; l++)
			{
				if(fSort[k][1] == fSort[l][1]) //freq are equal
				{
					if(fSort[k][2] > fSort[l][2])
					{
						int t_value = fSort[k][0];
						int t_freq = fSort[k][1];
						int t_index = fSort[k][2];
						
						fSort[k][0] = fSort[l][0];
						fSort[k][1] = fSort[l][1];
						fSort[k][2] = fSort[l][2];
						
						fSort[l][0] = t_value; 
						fSort[l][1] = t_freq;
						fSort[l][2] = t_index;
					}
				}
			}
		}
		
		//display
		for(int k = 0; k < fSort.length; k++)
		{	
			for(int l = 0; l < fSort[k][1]; l++)
			{
				System.out.print(fSort[k][0]+"   ");
			}
		}	
	}
}



