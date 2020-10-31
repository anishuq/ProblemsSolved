import java.util.*;

class StringOP
{
	String tempStr;
	
	StringOP(String param)
	{
		tempStr = param;
	}
	
	public void duplicateTest()
	{
		String[] tempStrArr = tempStr.split(" ");
		
		//for(String s: tempStrArr)
		//	System.out.println(s);
		
		Set<String> stringSet = new LinkedHashSet<>();
		
		for(String s: tempStrArr)
			stringSet.add(s);

		Iterator e = stringSet.iterator();
		
		while(e.hasNext())
		{
			System.out.print(e.next()+" ");
		}
	}
	public void regionMatchTest(String str1, String str2)
	{
		boolean val = str1.regionMatches(4, str2, 4, 5);
		System.out.println("Match: "+val);
		
		val = str1.startsWith("quick", 2);	
		System.out.println("Match: "+val);
		
		val = str1.endsWith("fox");	
		System.out.println("Match: "+val);
	}
	
	public void findString(String paramStr)
	{
		System.out.println("Index of t:  "+paramStr.indexOf('t'));
		System.out.println("Last index of u:  "+paramStr.lastIndexOf('u'));
		
		System.out.println("Index of the:  "+paramStr.indexOf("the"));
		System.out.println("Last index of the:  "+paramStr.lastIndexOf("the"));
	
		System.out.println("$$ Index of the:  "+paramStr.indexOf("the", 5));
		System.out.println("$$ Last index of the:  "+paramStr.lastIndexOf("the",140));
	}
	
	public void splitString(String paramStr)
	{
		String inputStr = "";
		/*
		System.out.println("Input String");
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			String temp = sc.nextLine();
			if(temp.charAt(0) == '~') break;
			inputStr = inputStr + temp + "\n";
		}
		
		System.out.println(""+inputStr);
		
		sc.close();
		*/
		//After every punctuation add space.
		int i;
		String f_stop = ".";
		String replaceStr = " ";
		
		paramStr = paramStr.replaceAll("\\.", " . ");
		paramStr = paramStr.replaceAll("\\?", " ? ");
		paramStr = paramStr.replaceAll("\\,", " , ");
		paramStr = paramStr.replaceAll("\\!", " ! ");
		
		//System.out.println(paramStr);
		
		String[] inputStrArr = paramStr.split(" ");
		
		
		Set<String> s_str = new LinkedHashSet<>();
		Set<String> dupStr = new LinkedHashSet<>();
		
		for(String s: inputStrArr)
		{
			if(!s_str.add(s))
				dupStr.add(s);
		}
		
		System.out.println(s_str);
		System.out.println(dupStr);
	}
}


public class StringOPtest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String inputStr = "I love love java java . However, things things look dicy.";
		StringOP StringOPObj = new StringOP(inputStr);
		//StringOPObj.duplicateTest();
		//StringOPObj.regionMatchTest("The quick brown fox jumps over the lazy dog", "The quick blue fox jumps over the crazy dog");
		String poemStr = "Mother, the folk who live up in the clouds call out to me."
				+ "We play from the time we wake till the day ends."
				+ "We play with the golden dawn, we play with the silver moon."
				+ "I ask, But how am I to get up to you?The for the sake of the.";
	
		//StringOPObj.findString(poemStr);
		
		//StringReplaceTest StringReplaceObj = new StringReplaceTest("What is a bad idea?is that a worthy idea?");
		//StringReplaceObj.replaceAllStr();
		StringOPObj.splitString(poemStr);
	
	}

}
