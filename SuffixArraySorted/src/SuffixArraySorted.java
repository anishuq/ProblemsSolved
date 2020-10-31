//Suffix Array
//https://www.geeksforgeeks.org/suffix-array-set-1-introduction/

import java.util.*;

class element implements Comparable<element>
{
	int index;
	String suffix;
	
	element(int index, String suffix)
	{
		this.index = index;
		this.suffix = suffix;
	}
	
	public int compareTo(element e)
	{
		if(this.suffix.compareTo(e.suffix) > 1)
			return 1;
		if(this.suffix.compareTo(e.suffix) == 0)
			return 0;
		else return -1;
	}
}

public class SuffixArraySorted 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		ArrayList<element> suffixList = new ArrayList<element>(); 
		for(int i = 0; i < input.length(); i++)
		{
			suffixList.add(new element(i, input.substring(i, input.length()) ));
		}
		
		Collections.sort(suffixList);
		
		System.out.println("Suffix Array:   ");
		for(int i = 0; i < suffixList.size(); i++)
		{
			System.out.print(suffixList.get(i).index+",  ");
		}
		
		sc.close();
	}

}
