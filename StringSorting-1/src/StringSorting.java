import java.util.*;

//Sort the array of strings according to alphabetical order defined by another string
//https://www.geeksforgeeks.org/sort-the-array-of-strings-according-to-alphabetical-order-defined-by-another-string/

public class StringSorting 
{
	public static void main(String[] args) 
	{
		StringSorting StringSortingObj = new StringSorting();
		
		Scanner sc = new Scanner(System.in);
		String sortCriteria = sc.nextLine(); 
		
		String input = sc.nextLine();
		String[] inputArr = input.split(" ");
		//strArr[] = {“rainbow”, “consists”, “of”, “colours”}
		
		HashMap<Character, Integer> sortCriteriaMap = new HashMap<>(); 
		char[] sortArr = sortCriteria.toCharArray();
		
		for(int i = 0; i < sortArr.length; i++)
		{
			sortCriteriaMap.put(sortArr[i], i);
		}

		//sort (start) 
		for(int i = 0; i < inputArr.length; i++)
		{
			String minString = inputArr[i];
			int minIndex = i;
			boolean found = false;
			for(int j = i + 1; j < inputArr.length; j++)
			{
				if(StringSortingObj.compare(minString, inputArr[j], sortCriteriaMap))
				{
					minString = inputArr[j];
					minIndex = j;
					found = true; 
				}
			}
			
			if(found == true)//we swap
			{
				String temp = inputArr[i];
				inputArr[i] = minString;
				inputArr[minIndex] = temp;
			}
		
			//break;
		}
		//sort (end)
		
		for(int i = 0; i < inputArr.length; i++)
		{
			System.out.println(inputArr[i]);
		}
		
		sc.close();
	}
	
	public boolean compare(String a, String b, HashMap<Character, Integer> sortCriteriaMap)
	{
		//System.out.println("   "+a+"    "+b);
		
		char[] a_Arr = a.toCharArray();
		char[] b_Arr = b.toCharArray();
		int limit = Math.min(a_Arr.length, b_Arr.length);
		
		for(int i = 0; i < limit; i++)
		{	
			int a_index = sortCriteriaMap.get(a_Arr[i]);
			int b_index = sortCriteriaMap.get(b_Arr[i]);
			
			if(b_index < a_index) 
				return true;
			else if (a_index < b_index) 
				return false;
		}
		
		return false;
	}

}
