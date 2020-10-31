import java.util.*;

public class WildCardTest 
{
	public void doIT(List<?> l)
	{
		System.out.println("Type:  "+l.getClass().toString());
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
