import java.util.*;

public class SelectionSortString 
{
	public static void main(String[] args) 
	{
		String[] input = {"paper", "true", "soap", "floppy", "flower"};
		
		for(int i = 0; i < input.length; i++)
		{
			String minString = input[i];
			int minIndex = i;
			boolean found = false;
			for(int j = i + 1; j < input.length; j++)
			{
				if(minString.compareTo(input[j]) > 0)
				{
					minString = input[j];
					minIndex = j;
					found = true;
				}
			}
			
			if(found == true)//swap
			{
				String temp = input[i];
				input[i] = minString;
				input[minIndex] = temp;
			}
		}
		
		for(int i = 0; i < input.length; i++)
			System.out.println(input[i]);
	}

}

/*
//Short cut way.
ArrayList<String> inpList = new ArrayList<String>(Arrays.asList(input));

Collections.sort(inpList);

for(int i = 0; i < inpList.size(); i++)
	System.out.println(inpList.get(i));
*/
