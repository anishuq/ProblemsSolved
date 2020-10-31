import java.util.*;

public class ContinousInputs 
{
	int[] inputArr = new int[5];
	int i = 0;
	public void takeInput()
	{
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			inputArr[i] = sc.nextInt();
			i++;
			if(i == inputArr.length) break;
		}
		
		for(int j : inputArr)
			System.out.println(j);
		
		sc.close();
	}
}
