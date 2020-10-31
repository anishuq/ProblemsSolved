import java.util.*;

public class Maptest {
	public void mapOp() 
	{
		Map p = new HashMap();
		
		p.put(1,"There ");
		p.put(2,"she ");
		p.put(3,"blows! ");
		p.put(4,new Double(123.56));
		
		Set myKeys = p.keySet();
				
		System.out.println("SIZE:  "+p.size());
		for(int i = 1; i <= p.size(); i++)
			System.out.println(p.get(new Integer(i)));
		
		
		
	}
}
