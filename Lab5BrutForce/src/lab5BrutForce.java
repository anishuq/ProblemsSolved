import java.util.*;

class strWindowOp
{
	List<String> subStrList = new ArrayList<>();
	
	public void allPossibleSubstr(String str, String letters)
	{
		
		//find all possible substring of str (start).
		for(int i = 0; i < str.length(); i++)
		{
			for(int j = i + 1; j <= str.length(); j++)//less than or equal to, because  
			{					//substring method's end index is exclusive.
				String subStr = str.substring(i, j);
				
				if(subStr.length() >= letters.length()) 
					subStrList.add(subStr);
			}
		}//find all possible substring of str (end).
		
		Map<Character, Integer> lettersFreqMap = characterFreq(letters);
		char[] lettersArr = letters.toCharArray();
		
		//letters will be compared to each substring.
		int minLength = 71; //as 70 was the max limit. 
		String minStrWin = "";
		for(String s : subStrList)
		{//1
			int found = 0;
			Map<Character, Integer> tmpFreqMap = characterFreq(s); 
			
			/*
			 * Each key and corresponding value from "letters"
			 * compared with each substring.
			 */
			
			for(Character key: lettersFreqMap.keySet())
			{//2
				if(tmpFreqMap.containsKey(key))//letters key exists in sub string.
				{ 
					if(lettersFreqMap.get(key) <= tmpFreqMap.get(key))
					{
						found++;
					}
				}
			}//2
			/* IF we put lettersFreqMap.get(key) == tmpFreqMap.get(key) then
			 * the following condition would fail:
			 * 
			 * String: WRTnmJWoapLjmnAJrorewapnvaPlwxcvaTjr
			 * Pattern: JavaPro
			 * 
			 * Window: JrorewapnvaP
			 * The window can have more occurrences of a letter, e.g. 'r'. So the
			 * key's value in pattern can be equal OR less than the value of
			 * substring. In other words, substring can have higher frequency
			 * of certain characters.  
			 */
			
			if(found == lettersFreqMap.keySet().size())
			{
				if(s.length() < minLength)
				{
					minLength = s.length();
					minStrWin = s;
				}
			}
		}//1
		
		System.out.println(minStrWin.trim());
	}
	
	public Map<Character, Integer> characterFreq(String param)
	{
		Map<Character, Integer> charFreq = new HashMap<Character, Integer>();
		char[] paramArr = param.toCharArray();
		
		for(int i = 0; i < paramArr.length; i++)
		{
			if(charFreq.containsKey(paramArr[i]) == false)
			{
				charFreq.put(paramArr[i], 1);
			}
			else
			{
				int value = charFreq.get(paramArr[i]);
				charFreq.put(paramArr[i], value + 1);
			}
		}
		
		return charFreq;
	}
}

public class lab5BrutForce 
{
	public static void main(String[] args) 
	{
		lab5BrutForce lab5BrutForceObj = new lab5BrutForce();
		strWindowOp strWindowObj = new strWindowOp(); 
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String letters = sc.nextLine();
		
		if( (str.length() <= 70) && (letters.length() <= str.length() ) ) 
		{
			strWindowObj.allPossibleSubstr(str, letters);
		}
		else System.out.print("");
		
		sc.close();
	}

}
