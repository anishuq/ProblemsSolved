import java.util.*;

public class histoGram 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		
		String[] inputArr = inputStr.split(" ");
		
		List<Integer> inputData = new ArrayList<>();
		
		for(String s: inputArr)
		{	
			//System.out.println(s);
			inputData.add(Integer.parseInt(s));
		}
		
		Collections.sort(inputData);
		int maxVal = Collections.max(inputData); 
		
		Set<Integer> setData = new HashSet<>();//to remove duplicates.
		setData.addAll(inputData);
		
		//System.out.println(setData);
		
		for(int j = 1; j <= maxVal; j++)
		{
			if(setData.contains(j))
			{
				int f = Collections.frequency(inputData, j);
				System.out.print(f+" ");
			}
			else
				System.out.print(0+" ");
		}
		
		
		sc.close();
	}

}
