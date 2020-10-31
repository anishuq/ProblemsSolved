import java.util.*;

class personNode
{
	String name;
	int age;
	
	personNode(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String toString()
	{
		return "Name: "+this.name+" Age: "+this.age;
	}
}

public class LinkedListLib 
{
	List<personNode> collectionObj = new ArrayList<>(); 
	List<personNode> linkedListObj;
	
	public void execute()
	{
		String[] philosophers = {"Plato", "Aristotle", "Kant", "Hume", "Descartes", "Socrates", "Wittgenstein", "Locke"};
	
		for(String s : philosophers)
			collectionObj.add( new personNode( s, (int)(Math.random()*100) ) );
	
	
		linkedListObj = new LinkedList<>(collectionObj);//linked list is filled.
		Iterator llIt;
		
		llIt = linkedListObj.iterator();
		while(llIt.hasNext())
		{
			Object tmp = llIt.next();
			System.out.println(tmp.toString());
		}
		
		ListIterator llPrev = linkedListObj.listIterator(linkedListObj.size());
		while(llPrev.hasPrevious())
		{
			Object tmp = llPrev.previous();
			System.out.println(tmp.toString());
		}
	}
}
