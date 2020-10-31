import java.util.*;

public class recursionPractice {
/*
	boolean flag = false;
	public String getSubString(String subStr,int s, int e)
	{
		return subStr.substring(s, e + 1);//extract including e index. 
	}
	
	
	public void isPalindrome(String str)
	{
		//ONLY ONE CONDITION WILL FULFILL AT A TIME.
		if(str.length() <= 1) 
		{
			System.out.println("length:  "+str.length()+"   Palindrome");
			flag = true;
		}
		else if(str.charAt(0) != str.charAt(str.length() - 1))
		{
			System.out.println("Not Palindrome");
			flag = false;
		}
		else 
		{
			str = getSubString(str,1,str.length()-2);
			isPalindrome(str);
		}
	}
*/	
	
	public static void main(String[] args) 
	{
		//recursionPractice recursionObj = new recursionPractice();
		//System.out.println("Extract:  "+recursionObj.getSubString("Anisul", 0, 3));
		//recursionObj.isPalindrome("tattarrattat");
		//recursionObj.isPalindrome("kuddus");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		palindrome2 palindrome2Obj = new palindrome2();
		
		palindrome2Obj.isPalindrome(str);
		
		
		sc.close();
	}

}
