import java.util.*;


public class QueueTest 
{
	public void QueueOp() 
	{
		Queue q = new LinkedList();
		
		q.add("Hello");
		q.add("Blows");
		q.add(10);
		q.add(new Integer(15));
		q.add("--- 17 ---- ");
		
		
		Iterator qIt = q.iterator();
		while(qIt.hasNext())
			System.out.println(""+qIt.next());
		
		System.out.println("Show Head: "+q.peek());
		
		System.out.println("Remove: "+q.remove());
		System.out.println("Remove: "+q.remove());
		System.out.println("Remove: "+q.remove());
		
		System.out.println("New Head: "+q.peek());
		
	}
}
