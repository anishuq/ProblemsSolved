import java.util.*;

class bracketCheckOp
{
	public boolean isValidStr(String input)
	{
		Stack<Character> bStack = new Stack<Character>(); 
		char[] inpArr = input.toCharArray();
		for(int i = 0; i < inpArr.length; i++)
		{	
			if( (inpArr[i] == '(') || (inpArr[i] == '{') || (inpArr[i] == '[') )
				bStack.push(inpArr[i]);
			else if ( (inpArr[i] == ')') || (inpArr[i] == '}') || (inpArr[i] == ']') )  
			{	
				if (bStack.isEmpty()) 
					return false;
				else
				{
					/* Pop the top element from stack, if  
	                it is not a pair parenthesis of the current character i.e. inpArr[i]  
	                then there is a mismatch. In other words, 
	                poped character '(' must match with current character ')' i.e. inpArr[i].
	                */
					Character sBracket = bStack.pop();
					
					if(!isPair(sBracket, inpArr[i])) 
						return false;
				}
			}
		}
		
		if(bStack.isEmpty()) return true;
		else return false;
	}
	
	public boolean isPair(char sBracket, char eBracket)
	{
		if( (sBracket == '(' ) && (eBracket == ')' ) ) 
				return true;
		else if ( (sBracket == '{' ) && (eBracket == '}') ) 
				return true;
		else if ( (sBracket == '[' ) && (eBracket == ']' )) 
				return true;
		else return false;
	}
	
}

public class BracketMatching {

	public static void main(String[] args) 
	{
		bracketCheckOp bracketCheckObj =  new bracketCheckOp();
		
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());
		
		int i = 0;
		while(i < lines)
		{
			String bLine = sc.nextLine();
			System.out.println(bracketCheckObj.isValidStr(bLine));
			
			i++;
		}
		
		sc.close();
	}

}
