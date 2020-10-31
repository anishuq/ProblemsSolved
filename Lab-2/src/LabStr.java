import java.util.*;

class ngramOp
{
	public void gramFreq(String input, int ngram)
	{
		String[] inpArr = input.split(" ");
		ArrayList<String> inpList = new ArrayList<String>(); 
		for(int i = 0; i < inpArr.length; i++)
		{
			if(inpArr[i].length() > 0) //get rid of spaces 
				inpList.add(inpArr[i]);
		}

		//collect the necessary substrings
		ArrayList<String> ngramList = new ArrayList<String>();
		for(String s : inpList)
		{
			if(s.length() >= ngram)
			{
				int start = 0;
				int end = start + ngram;  
				
				while(end <= s.length())
				{
					ngramList.add(s.substring(start, end));
					start = start + 1;
					end = start + ngram;
				}
			}
		}
		
		Collections.sort(ngramList); //for strings with same frequency.
		
		for(int i = 0; i < ngramList.size(); i++)
		{
			System.out.println(ngramList.get(i));
		}
		
		int maxFreq = 0;
		String maxStr = "";
		Set<String> unique = new HashSet<>();
		unique.addAll(ngramList);
		Iterator<String> it = unique.iterator();
		while(it.hasNext())
		{		
			String pattern = it.next();
			int freq = Collections.frequency(ngramList, pattern);
			System.out.println(freq+"   "+pattern);
			
			if(freq > maxFreq)
			{
				maxFreq = freq;
				maxStr = pattern;
			}
		}
		
		System.out.println("Max Freq: "+ maxFreq + " String: "+maxStr);
	}
}

public class LabStr 
{
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());
		String input = "";
		
		int i = 0;
		while(i < lines)
		{
			String temp = sc.nextLine();
			temp = temp.trim();
			
			input = input + " " + temp;
			input = input.trim();
			
			i++;
		}
		
		int ngram = Integer.parseInt(sc.nextLine());
		
		input = input.toLowerCase();
		
		//parse the input.
		char[] inpArr = input.toCharArray();
		for(int j = 0; j < inpArr.length; j++)
		{
			int ascii = (int)inpArr[j];
			if((ascii < 97) || (ascii > 122)) //not a character
			{
				inpArr[j] = ' ';
			}
		}
		
		String parsedInput = new String(inpArr);
		
		ngramOp ngramObj = new ngramOp();
		ngramObj.gramFreq(parsedInput, ngram);
		
		sc.close(); //last line of main.
	}
}
