import java.util.*;

//Sum of similarities of string with all of its suffixes
//https://www.geeksforgeeks.org/sum-of-similarities-of-string-with-all-of-its-suffixes/

public class SuffixSum 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		ArrayList<String> prefixList = new ArrayList<String>();
		
		//get the prefixes.
		for(int i = 1; i <= input.length(); i++)
		{
			prefixList.add(input.substring(0, i));
		}
		
		ArrayList<String> suffixList = new ArrayList<String>();
		//get the suffixes.
		for(int i = 0; i < input.length(); i++)
		{
			suffixList.add(input.substring(i, input.length()));
		}
		
		int similarity = 0;
		for(int i = 0; i < suffixList.size(); i++)
		{
			for(int j = 0; j < prefixList.size(); j++)
			{
				if(suffixList.get(i).compareTo(prefixList.get(j)) == 0)
				{
					similarity = similarity + prefixList.get(j).length(); 
				}
			}
		}
		 
		System.out.println(similarity);
		
		sc.close();
	}

}
