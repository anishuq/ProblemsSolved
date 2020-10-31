/*
 * Count number of equal pairs in a string
 * https://www.geeksforgeeks.org/number-equal-pairs-string/
 * 
 */

import java.util.*;

public class equalPairs 
{

	public static void main(String[] args) 
	{
		String input = "geeksforgeeks";
		char[] iArr = input.toCharArray();
		ArrayList<Character> inpList = new ArrayList<Character>();
		
		for(int i = 0; i < iArr.length; i++)
			inpList.add(iArr[i]);
		
		Set<Character> inpSet = new HashSet<Character>();
		inpSet.addAll(inpList);
		
		Map<Character, Integer> inpMap = new HashMap<>();
		Iterator<Character> it = inpSet.iterator();
		while(it.hasNext())
		{
			Character key = it.next();
			int freq = Collections.frequency(inpList, key);
			
			inpMap.put(key, freq);
		}
		
		int pairs = 0;
		for(Character ch : inpMap.keySet())
		{
			pairs = pairs + (inpMap.get(ch) * inpMap.get(ch)); 
		}
		
		System.out.println("Pairs:  "+pairs);
	}

}
