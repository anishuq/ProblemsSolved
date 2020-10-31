import java.util.*;

class lcPalindromeOp
{
	int max = 0;
	String result = "";
	
	public void findLCPalindrome(String inp)
	{
		String[] inpArr = inp.split("");
		//We must split it. Then each character turns to a string. Each String 
		//is a member of the ArrayList. That is ArrayList length = number of characters in inp. 
		ArrayList<String> forward = new ArrayList<String>(Arrays.asList(inpArr));
		ArrayList<String> reverse = new ArrayList<String>(Arrays.asList(inpArr));
		Collections.reverse(reverse);
		
		//do complement
		Iterator<String> it = forward.iterator();
		for(int i = 0; i < forward.size(); i++)
		{
			if(forward.get(i).compareTo("A") == 0)
				forward.set(i, "T");
			else if(forward.get(i).compareTo("T") == 0)
				forward.set(i, "A");
			else if(forward.get(i).compareTo("C") == 0)
				forward.set(i, "G");
			else if(forward.get(i).compareTo("G") == 0)
				forward.set(i, "C");
		}
		
		if(reverse.equals(forward)) 
		{	
			if(inp.length() > max)
			{
				max = inp.length();
				result = inp;
			}
		}
	}
	
	public void display()
	{
		System.out.println("max length:  "+max+"   Seq:  "+result);
	}
}
public class LongestCommonPalindrome {

	public static void main(String[] args) 
	{
		lcPalindromeOp lcPalindromeObj = new lcPalindromeOp();
		
		String dnaSeq = "GACACGACACACCTAGGTGGTTTTAGGTTTTA";
		
		for(int i = 0; i < dnaSeq.length(); i++)
		{
			for(int j = 0; j < dnaSeq.length() - i; j++)
			{
				lcPalindromeObj.findLCPalindrome(dnaSeq.substring(i , i + j + 1));
			}
		}
		lcPalindromeObj.display();
	}
}

