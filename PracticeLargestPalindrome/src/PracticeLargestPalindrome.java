import java.util.*;

class palindromeOP
{
	int max = 0;
	ArrayList<String> result = new ArrayList<String>();
	public void isPalindrome(String inp)
	{
		String[] inpArr = inp.split("");
		ArrayList<String> forward = new ArrayList<String>(Arrays.asList(inpArr)); 
		ArrayList<String> reverse = new ArrayList<String>(Arrays.asList(inpArr)); 
		Collections.reverse(reverse);
		
		if(forward.equals(reverse))
		{
			if(forward.size() > max)
			{
				result = forward;
				max = forward.size();
			}
		}
	}
	public void display()
	{
		System.out.print("MAX:  "+max+"   ");
		for(String s : result)
			System.out.print(s);
	}
}


public class PracticeLargestPalindrome {
	
	public static void main(String[] args) 
	{
		palindromeOP  palindromeOPObj = new palindromeOP();
		
		String input = "forgeeksskeegfor";
		
		for(int i = 0; i < input.length(); i++)
		{
			for(int j = 0; j < input.length() - i; j++)
				palindromeOPObj.isPalindrome(input.substring(i, i + j + 1 ));
		}
		palindromeOPObj.display();
	}
	
	
}
/*
for(String s : inpArr)
System.out.print(s);
	for(String s : forward)
				System.out.print(s);
		
			System.out.println();
		
*
*
*/