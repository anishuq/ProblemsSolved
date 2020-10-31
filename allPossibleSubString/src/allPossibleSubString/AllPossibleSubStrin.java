package allPossibleSubString;

public class AllPossibleSubStrin {

	public static void main(String[] args) 
	{
		String[] strArr = {"1", "1", "2", "2", "3", "4"}; 
		int n = strArr.length;
		for(int i = 0; i < n; i++)
		{   for(int j = i; j < n; j++)
		    {   /* print substring from i to j */
		        for(int k = i; k <= j; k++)
		        {   
		        	System.out.print(strArr[k]);
		        }
		        System.out.println();
		    }
		}
	}

}
