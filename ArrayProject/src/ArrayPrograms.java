import java.util.*;


public class ArrayPrograms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner inputData = new Scanner(System.in);
		
		String s_str = inputData.nextLine(); 
		
		if(f_str.equals(s_str))
			System.out.println("Both r equal!");
		else if (f_str.equalsIgnoreCase(s_str))
				System.out.println("Both r equal!");
		else
			System.out.println("Both r NOT equal!");
		
		int vow = 0, spaces = 0, letters = 0;
		String inputStr = inputData.nextLine();
		inputStr = inputStr.toLowerCase();
		for (int i=0; i < inputStr.length(); i++)
		{
			char ch = inputStr.charAt(i); 
			
			if(ch == 'a' || ch == 'e' || ch == 'i' ||ch == 'o' || ch == 'u' )
				vow++;
			else if (Character.isWhitespace(ch))
				spaces++;
			else if(Character.isLetter(ch))
				letters++;
		}
			
		System.out.println("Vowels: "+vow+"\n"+"Spaces: "+spaces+"\n"+"Letters: "+letters+"\n");
		
		
        System.out.println("Input String: \n");
		String inputStr = inputData.nextLine();
				
        System.out.println("Input Sub String: \n");
		String subStr = inputData.nextLine(); 
				
		int index = -1;
		
		//find all occurrences of a substring
		
		index = inputStr.indexOf(subStr);
		while(index >= 0)
		{
			System.out.println("Sub String found at position:"+index+"\n");
			index = inputStr.indexOf(subStr, index+1);
		}
		
		//tokenizing a string.
		String inputStr = inputData.nextLine();
		String[] tokens = inputStr.split("[@]",2);
		
		System.out.println("token length:"+tokens.length);
		for(String str: tokens)
			System.out.println(""+str);
		
		String replaceString = inputStr.replace(' ', '@'); 
		System.out.println("altered:   "+replaceString);
		
		char[] chArray = inputStr.toCharArray();
		for(char ch : chArray)
			System.out.print("#"+ch);
		
		String convertFromChArr = new String(chArray);
			System.out.print("$$$$$"+convertFromChArr);
		*/
		//StringBufferTest strBuff = new StringBufferTest();
		//strBuff.bufferTest();
		TwoDArray TwoDTest = new TwoDArray();
		TwoDTest.arrTest();
	}

}
