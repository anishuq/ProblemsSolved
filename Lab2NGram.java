import java.util.*;

class NGramOP
{
	public String strCleanup(String p)
	{
		p = p.replaceAll("[^A-Za-z]", " ");
		//anything NOT a character replace with space.
		p = p.trim();// so that there is NO leading or lagging space.
		return p;
	}
	
	public void NGramBreakDown(String param, int ngram)
	{
		System.out.println(param);
		List<String> nGramStr = new ArrayList<>();
		List<String> inputStr = new ArrayList<>();//arraylist without any spaces.
		String[] strList = param.split(" ");
		
		for(String s: strList)
		{
			if(s.trim().length() > 0)//leave out the spaces. 
			{	
				inputStr.add(s);
				System.out.println("strList:  "+s);
			}
		}
		
		for(String s: inputStr)
		{
			System.out.println("inputStr:  "+s);
			if(s.length() >= ngram)
			{
				int begin = 0;
				int end = begin + ngram; 
				//System.out.println("start index:  "+begin+"  end index:  "+end);
				while(true)
				{
					String tmp = s.substring(begin, end); 
					//System.out.println("ngram string:  "+tmp);
					nGramStr.add(tmp);
					
					tmp = "";
					begin++;
					end = begin + ngram;
					//System.out.println("INSIDE start index:  "+begin+"  end index:  "+end);

					if(end > s.length()) break;
				}
				System.out.println("=======================================================");
			}
		}

		Collections.sort(nGramStr);
				
		//determine the max frequency
		int maxFreq = 0;
		String maxStr = "";
		int freq = 0;
		for(String s: nGramStr)
		{
			freq = Collections.frequency(nGramStr, s);
			if(freq > maxFreq)
			{
				maxFreq = freq;
				maxStr = s;
			}
		}
		
		switch(ngram)
		{
			case 1: System.out.println("Unigram "+maxStr);
			break;
			case 2: System.out.println("Bigram "+maxStr);
			break;
			case 3: System.out.println("Trigram "+maxStr);
			break;
		}
	}
}



public class LabStr 
{
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String para = "";
		
		int i = 0;
		
		int lines = Integer.parseInt(sc.nextLine());
		while(i<lines)
		{
			String tmp = sc.nextLine();
			tmp = tmp + " ";
			para = para + tmp;
			tmp = "";
			i++;
		}
		
		int grams = Integer.parseInt(sc.nextLine());
		
		NGramOP NGramObj = new NGramOP();
		para = NGramObj.strCleanup(para);
		//System.out.println(para);
		
		NGramObj.NGramBreakDown(para, grams);
		
		sc.close(); //last line of main.
	}
}
