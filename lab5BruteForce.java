import java.util.*;

class minWindowOp
{
	int min = 71;
	String minWindow = "";
	
	public void minWindowDetection(String str, String letter)
	{
		for(int i = 0; i < str.length(); i++)
		{
			for(int j = 0; j < str.length() - i; j++)
			{
				String window = str.substring(i , i + j + 1);
				if(window.length() >= letter.length())
				{
					if(isCharactersPresent(window, letter))
					{
						if(window.length() < min)
						{
							min = window.length();
							minWindow = window;
						}
					}
				}
			}
		}
		
		display();
	}
	public boolean isCharactersPresent(String window, String letter)
	{
		char[] lettersArr = letter.toCharArray();
		int found = 0;
		for(int i = 0; i < lettersArr.length; i++)
		{
			int index = window.indexOf(lettersArr[i]);
			if(index != -1) found++;
		}
		if(found == letter.length()) return true;
		else return false;
	}
	
	public void display()
	{
		System.out.println("Min Length:  "+min+"   Window:  "+minWindow);
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
