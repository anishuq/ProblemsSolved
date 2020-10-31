import java.util.*;

/*
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 * https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
 */

public class PairSum {

	public static void main(String[] args) 
	{
		Integer[] input = {1, 4, 45, 45, 6, 10, -8};
		int sum = 10;// change the inout here.
		
		ArrayList<Integer> inpList = new ArrayList<Integer>(Arrays.asList(input)); 
		Collections.sort(inpList);
		
		boolean found = false;
		int start = 0;
		int end = inpList.size() - 1;
		
		while(start < end)
		{
			int res = inpList.get(start) + inpList.get(end);
			if(res == sum)
			{
				System.out.println("Number pair:"+inpList.get(start) + " and "+ inpList.get(end));
				found = true;
				break;
			}
			else if(res > sum)
			{
				end = end - 1;
			}
			else if(res < sum)
			{
				start = start + 1;
			}
		}
		
		if(found == false) System.out.println("Number cannot be generated.");
		
	}

}
