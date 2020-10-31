
public class StringReplaceTest 
{
	String inputStr;
	
	StringReplaceTest(String paramStr)
	{
		inputStr = paramStr;
	}


	public void replaceAllStr()
	{
		String outputStr = null;
		String searchStr = "is";
		String replaceStr = "was";
		int i;
		do
		{
			i = inputStr.indexOf(searchStr);
			if(i!=-1)
			{
				outputStr = inputStr.substring(0,i);//gets 0 to i - 1.
				outputStr = outputStr+replaceStr;
				outputStr = outputStr+inputStr.substring(i+searchStr.length());
				inputStr = outputStr;
				System.out.println(outputStr);
			}
		}while(i!=-1);
		
		System.out.println("Ultimate String:  "+outputStr);
		
	}
}
