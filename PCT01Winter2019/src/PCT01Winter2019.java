import java.util.*;
/*
 * You are given couple of coins of certain denomination (NOT sorted). 
 * What is the smallest amount that cannot be paid (there can be no return changes) ? 
 */

public class PCT01Winter2019 {

	public static void main(String[] args) 
	{
		//Integer[] coins = {2, 2 , 1 , 1, 3, 12, 10, 15};
		Integer[] coins = {2, 2 , 1 , 1, 15};
		ArrayList<Integer> coinList = new  ArrayList<Integer>(Arrays.asList(coins));
		
		Collections.sort(coinList);
		System.out.println(coinList);
		
		int i = 0;
		int total = 0;
		while(i < coinList.size())
		{
			total = total + coinList.get(i);
			System.out.println("Total:  "+total);
			//can I buy something that costs total+1?
			int j  = i + 1;
			if(j < coinList.size())
			{	
				System.out.println("Total + 1  "+(total + 1)+"   coin i + 1  "+coinList.get(j));
				if( coinList.get(j) <= (total + 1) )
				{	
					i++;
				}
				else
				{
					System.out.println("We cannot buy:  "+(total + 1));
					break;
				}
			}
			
		}
	}

}
