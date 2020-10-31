
//https://coderbyte.com/algorithm/two-sum-problem

import java.util.*;

public class twoSumProblem {

	public static void main(String[] args) 
	{
		int[] input = { 2, 4, 3, 3 };
		int sum = 6;
		ArrayList<Integer> pairList = new ArrayList<Integer>();
		
		for(int i = 0; i < input.length; i++)
		{
			if(pairList.isEmpty()) pairList.add(input[i]);
			else
			{
				int element = sum - input[i];
				if(pairList.contains(element))
				{
					System.out.println("pair:  "+input[i] + "   "+element);
				}
				else
					pairList.add(element);
			}
		}
	}

}
