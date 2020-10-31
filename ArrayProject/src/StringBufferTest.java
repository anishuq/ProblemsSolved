import java.util.Scanner;

public class StringBufferTest {
	public void bufferTest()
	{
		Scanner inputData = new Scanner(System.in);
		/*
		System.out.println("Input String: \n");
		
		String inputStr = inputData.nextLine();
		
		StringBuffer mutableStr = new StringBuffer(inputStr);
		System.out.println("length:   "+mutableStr.length());
		
		mutableStr = mutableStr.append(" Late Night BS! ");
		System.out.println("appended:   "+mutableStr);
		
		System.out.println("Input Second String: \n");
		String secStr = inputData.nextLine();
		
		mutableStr.append(secStr,3,10);
		
		System.out.println("again appended:   "+mutableStr);
		
		double pi = 3.14;
		
		mutableStr.append(pi);
		
		System.out.println("again appended:   "+mutableStr);
		
		char[] text = {'w','h','o',' ','i','s',' ','a','n',' ','a','s','s','h','o','l','e'};
		
		mutableStr.append(text,10,7);
		System.out.println("again appended:   "+mutableStr);
		
		//replace in StringBuffer
		System.out.println("Input First String: \n");
		StringBuffer f_Str = new StringBuffer(inputData.nextLine());
		
		System.out.println("Input Sub String to replace: \n");
		String s_Str = inputData.nextLine();
				
		System.out.println("Input Replacement String: \n");
		String t_Str = inputData.nextLine();
		
		int index = f_Str.indexOf(s_Str);
		f_Str.replace(index, index + t_Str.length(), t_Str);
		
		System.out.println("Replaced String:   "+f_Str);	
		
		f_Str.insert(7, "How de");
		
		System.out.println("Inserted String:   "+f_Str);
		
		f_Str.setCharAt(15, 'X'); 
		
		System.out.println("setCharAt String:   "+f_Str);
		
		f_Str.deleteCharAt(15) ;
		
		System.out.println("Deleted String:   "+f_Str);
		
		f_Str.delete(f_Str.indexOf("fck"), f_Str.indexOf("fck") + 3) ;
		
		System.out.println("Deleted String:   "+f_Str);
		*/
		System.out.println("Input String: \n");
		
		StringBuffer testStr = new StringBuffer(inputData.nextLine());
		
		StringBuffer newStr = new StringBuffer(20);
		System.out.println("Capacity:   "+newStr.capacity());
		
		String[] strArr = {"asad ","is ","a ","horney ","boy."};

		for(int i = 0; i<strArr.length; i++ )
			newStr.append(strArr[i]);
		
		
		System.out.println("new string:   "+newStr);
		System.out.println("new string length:   "+newStr.length());
		System.out.println("Capacity:   "+newStr.capacity());
		
		
		
		
	}
}
