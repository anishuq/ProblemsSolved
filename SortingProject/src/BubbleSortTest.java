
public class BubbleSortTest 
{
	public int[] bubbleSortOp(int[] paramList)
	{
		for(int out = (paramList.length - 1); out > 0; out-- )
		{
			for(int in = 0; in < out; in++) //the value of out is reduced at each iteration.
			{
				if(paramList[in] > paramList[in + 1])//swap condition
				{
					int temp = paramList[in + 1];
					paramList[in + 1] = paramList[in];
					paramList[in] = temp;
				}
			}
		}

		return paramList;
	}
	
	public String[] bubbleSortOpString(String[] paramList)
	{
		for(int out = (paramList.length - 1); out > 0; out-- )
		{
			for(int in = 0; in < out; in++) //the value of out is reduced at each iteration.
			{
				if( (paramList[in].compareTo(paramList[in + 1])) > 0 )//swap condition
				{
					String temp = paramList[in + 1];
					paramList[in + 1] = paramList[in];
					paramList[in] = temp;
				}
			}
		}

		return paramList;
	}
	
}
