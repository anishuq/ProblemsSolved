import java.util.*;

class gramOp
{
	public void gramDetection(String input, int gram)
	{
		input  = input.replaceAll("[^A-Za-z]", " ");
		//System.out.println(input);
		String[] inputArr = input.split(" "); 
		
		ArrayList<String> gramList = new ArrayList<String>(); 
		//try with all possible substring
		
		for(int i = 0; i < inputArr.length; i++)
		{	
			//all possible sub string of inputArr[i] 
			for(int j = 0; j < inputArr[i].length(); j++)
			{
				for(int k = 0; k < inputArr[i].length() - j; k++)
				{
					String tmp = inputArr[i].substring(j, j + k +1);
					tmp = tmp.trim();
					if(tmp.length() == gram)
						gramList.add(tmp);
				}
			}
		}
		
		Collections.sort(gramList);
		int maxFreq = 0;
		String gramStr = "";
		for(String s : gramList)
		{
			int freq = Collections.frequency(gramList, s);
			if(freq > maxFreq)
			{
				maxFreq = freq;
				gramStr = s;
			}
		}
		
		switch(gram)
		{
			case 1: System.out.println("Unigram "+gramStr);
			break;
			case 2: System.out.println("Bigram "+gramStr);
			break;
			case 3: System.out.println("Trigram "+gramStr);
			break;
		}
	}
}
public class PracticeLab2 {

	public static void main(String[] args) 
	{
		gramOp gramObj = new gramOp();
		
		Scanner sc = new Scanner(System.in);
		int lineNumber = Integer.parseInt(sc.nextLine());
		String input = "";
		int i = 0;
		
		while(i < lineNumber)
		{
			String tmp = sc.nextLine();
			input = input + " " + tmp;
			
			i++;
		}
		input = input.trim();		
		int gram = Integer.parseInt(sc.nextLine());
		
		gramObj.gramDetection(input, gram);
		
		sc.close();
	}

}


/*
//ArrayList<String> inpList = new ArrayList<String>(Arrays.asList(inputArr));
		 
for(int i = 0; i < input.length(); i++)
{	
	for(int j = 0; j < input.length() - i; j++)
	{	
		String tmp = input.substring(i, i + j + 1);
		tmp = tmp.trim();
		if(tmp.length() == gram)
			gramList.add(tmp);
	}
}

Collections.sort(gramList);

//for(int i = 0; i < gramList.size(); i++)
//	System.out.println(gramList.get(i)+"   ");

int maxFreq = 0;
String maxStr = "";
int freq = 0;
for(String s: gramList)
{
	freq = Collections.frequency(gramList, s);
	if(freq > maxFreq)
	{
		maxFreq = freq;
		maxStr = s;
	}
}

switch(gram)
{
	case 1: System.out.println("Unigram "+maxStr);
	break;
	case 2: System.out.println("Bigram "+maxStr);
	break;
	case 3: System.out.println("Trigram "+maxStr);
	break;
}
*/