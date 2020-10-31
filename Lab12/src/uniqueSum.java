import java.util.*;

public class uniqueSum 
{
	public void getAllCombination(String[] input, int combiLength, int uniqueSum)
	{
		String[] allCombination = new String[combiLength];
		int k = 0; //index for allCombination 
		for(int i = 0; i < input.length; i++)
		{
			allCombination[k] = input[i];
			k++;
			int limit = (int)(Math.pow(2, i) - 1);
			for(int j = 0; j < limit; j++)
			{
				allCombination[k] = input[i] + " " + allCombination[j];
				k++;
			}
		}
		
		//To remove duplicate combinations, we put "allCombination" into a SET.
		ArrayList<String> allCombinationList = new ArrayList<String>(Arrays.asList(allCombination));
		Set<String> allCombinationSet = new HashSet<>();
		allCombinationSet.addAll(allCombinationList);

		ArrayList<String> cList = new ArrayList<String>();
		Iterator<String> it = allCombinationSet.iterator();
		int count = 0;
		while(it.hasNext())
		{
			String tmp= it.next();
			String[] tmpArr = tmp.split(" ");
			int sum = 0;
			for(int i = 0; i < tmpArr.length; i++)
			{
				sum = sum + Integer.parseInt(tmpArr[i]);    
			}
			if(sum == uniqueSum)
			{
				cList.add(tmp);
				count++;
			}
		}
		
		System.out.println(""+count);
		System.out.println(""+cList);
}

	public static void main(String[] args) 
	{
		uniqueSum uniqueSumObj = new uniqueSum();
		
		Scanner sc = new Scanner(System.in);
		int uSum = Integer.parseInt(sc.nextLine());
		int totalElements = Integer.parseInt(sc.nextLine());
		String input = sc.nextLine();
		String[] inputArr = input.split(" ");
		
		int combiLength = (int)(Math.pow(2, totalElements) - 1);
		uniqueSumObj.getAllCombination(inputArr, combiLength, uSum);
		
		sc.close();
	}

}
/*
int[] elements = new int[totalElements];
		for(int i = 0; i < totalElements; i++)
		{
			elements[i] = Integer.parseInt(inputArr[i]);
		}
*/

//for(int l = 0; l < allCombination.length; l++)
		//	System.out.println(allCombination[l]);