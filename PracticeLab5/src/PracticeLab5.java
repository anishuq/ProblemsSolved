import java.util.*;

class minWindowOp
{
	public void minWindowDetection(String str, String letter)
	{
		int minLength = Integer.MAX_VALUE; 
		String minString = "";
		if(str.length() < letter.length())
			System.out.println("No Such Window exists.");
		else
		{	//all possible sub string
			for(int i = 0; i < str.length(); i++)
			{
				for(int j = 0; j < str.length() - i; j++)
				{
					String window = str.substring(i, i + j + 1);
					if(window.length() >= letter.length() )
					{
						if(isPresent(window, letter))
						{	
							if(window.length() < minLength)
							{
								minLength = window.length();
								minString = window;
							}
						}	
					}
				}
			}
			System.out.println("   "+minString);
		}
		
	}
	
	public boolean isPresent(String tWindow, String pattern)
	{
		int found = 0;
		char[] patternArr = pattern.toCharArray();
		for(int i = 0; i < pattern.length(); i++)
		{
			int index = tWindow.indexOf(patternArr[i]);
			if(index != -1)
			{
				tWindow = tWindow.substring(0, index) + tWindow.substring(index + 1);
				found++;
			}
		}
		if(found == pattern.length()) return true;
		else return false;
	}
}



public class PracticeLab5 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String letter = sc.nextLine();
		
		minWindowOp minWindowObj = new minWindowOp();
		minWindowObj.minWindowDetection(str, letter);
		
		sc.close();
	}
}
