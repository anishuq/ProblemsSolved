import java.util.*;

public class MapTest 
{

	public void MapOpTest()
	{
		Map<Integer, String> mt = new HashMap<>();
		
		String[] testData = {"Testing ","a ","map ","is ","a ","great ","idea"};
		
		for(int i = 0; i < testData.length; i++ )
			mt.put(new Integer(i), testData[i]);
		
		for(int j = 0; j < mt.size(); j++ )
			System.out.println(mt.get(new Integer(j)));
	}
}
