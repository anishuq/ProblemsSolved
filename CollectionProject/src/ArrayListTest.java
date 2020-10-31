import java.util.*;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		List myList = new ArrayList();
		String[] myArr = {"We ", "do ", "not ", "do ", "homework."};
		int[] toSort = {1000,230,3456,-90,50};
		//List num = Arrays.asList(toSort);
		
		Integer i = new Integer(100);
		
		myList.add("We ");
		myList.add(i);
		myList.add("are ");
		myList.add("bad ");
		myList.add(i);//duplicate test.
		myList.add("students. ");
		myList.add(10.48);

		for(Object o: myList)
			System.out.println(o);
		
		System.out.println("------------------------------------------");
		
		myList.set(2, "Kick him out   ");
		
		for(Object o: myList)
			System.out.println(o);
		
		List num = Arrays.asList(1000,230,3456,-90,50);
		Collections.sort( num );
		for(Object j: num)
			System.out.println(""+j);
		
		System.out.println("***********************************************");
		
		myList.addAll(num);
		Iterator myIt = myList.iterator();
		while(myIt.hasNext())
			System.out.println(""+myIt.next());
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		
		HashSetTest hs = new HashSetTest();
		hs.hashSetOp();
		
		QueueTest qt = new QueueTest();
		qt.QueueOp();
		*/
		//Maptest m = new Maptest();
		//m.mapOp();
		
		//StackLinkedList sListObj = new StackLinkedList();
		//sListObj.runCode();
		QueueLinkedList qListObj= new QueueLinkedList();
		qListObj.runCode();
	}

}
