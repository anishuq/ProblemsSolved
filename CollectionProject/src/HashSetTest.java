import java.util.*;

public class HashSetTest 
{
	public void hashSetOp() 
	{
		Set s = new HashSet();
		
		s.add("Hello");
		s.add("Hello");
		s.add(10);
		s.add(new Integer(10));
		s.add("10");
		//In Set, duplicates are NOT allowed.
		
		Iterator setIt = s.iterator();
		while(setIt.hasNext())
			System.out.println(""+setIt.next());
	}
}
