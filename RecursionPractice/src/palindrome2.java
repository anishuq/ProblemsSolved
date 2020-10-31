
public class palindrome2 
{
	String str = null;
	int low, high;
	
	public void isPalindrome(String str)
	{
		this.str = str;
		this.low = 0;
		this.high = str.length() - 1;
		
		System.out.println(isPalindrome(this.str, this.low, this.high));
	}
	public boolean isPalindrome(String str, int low, int high)
	{     
		if( (low > high) || (high == low) ) //One condition is when str length is even.
		{									//Another condition is when str length is odd.
			System.out.println("Low: "+low+"  High:  "+high);
			return true;
		}
		else if(str.charAt(low) != str.charAt(high)) return false;
		else
		{
			return isPalindrome(str, low + 1, high -1);
			//High increases and low decreases.
			//Terminating condition would be if low > high OR low == high. 
		}
	}
}
