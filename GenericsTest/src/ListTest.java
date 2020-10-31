import java.util.*;

class listOp
{
	public void listOpTest()
	{
		List<String> ls1 = new ArrayList<>();
		
		ls1.add("How ");
		ls1.add("is ");
		ls1.add("it ");
		ls1.add("going?");
		
		/*
		for(int i = 0; i<ls1.size(); i++)
			System.out.print(ls1.get(i));
		
		Iterator it = ls1.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next());
		}
		*/
		List<Integer> ls2 = new ArrayList<>();
		
		ls2.add(125);
		ls2.add(4563);
		ls2.add(8522);
		ls2.add(10225);
		
		WildCardTest wt = new WildCardTest();
		wt.doIT(ls1);
		wt.doIT(ls2);
	}
	
	public void list2DTest()
	{
		List<String> ls1 = new ArrayList<String>();//first Row
		
		ls1.add("How ");
		ls1.add("is ");
		ls1.add("it ");
		ls1.add("going?");

		List<String> ls2 = new ArrayList<String>();//first Row
		
		ls2.add("It's ");
		ls2.add("not ");
		ls2.add("that ");
		ls2.add("bad!  ");
		ls2.add("However .... ");
		
		List< List<String> > ls2D = new ArrayList<>();
		ls2D.add(ls1);
		ls2D.add(ls2);
		
		
		for(int i = 0; i<ls2D.size(); i++)
		{	
			for(int j = 0; j < ls2D.get(i).size(); j++)
				System.out.print(ls2D.get(i).get(j));
			
			System.out.println();
		}
		/*
		Iterator it = ls.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next());
		}
		*/
	}
}

public class ListTest {

	public static void main(String[] args) 
	{
		//listOp l =  new listOp();
		//l.listOpTest();
		//l.list2DTest();
		
		//MapTest mapObj = new MapTest();
		//mapObj.MapOpTest();
		//GenericClassTest gct = new GenericClassTest();
		//gct.executeDummy();
		//GenericNodes gn = new GenericNodes();
		//gn.executeCode();
		
		GenericClassTest myObj = new GenericClassTest();
		myObj.executeDummy();
		
		//GenericSortTest sortObj = new GenericSortTest();
		//sortObj.dummy();
	}

}
