import java.util.*;
class Node<T>
{
	T data;
	Node next;
	
	Node(T param)
	{
		this.data = param;
	}
}

class ListBuilder
{
	Node head = null;
	Node tail = null;
	Node start = null;
	
	int[] fInput;
	float[] sInput;
	
	ListBuilder(int[] param)
	{
		this.fInput = param;
		
		for(int i = 0; i < fInput.length; i++)
			this.head = buildList(fInput[i]);
		
		displayList(this.head);
	}
	
	ListBuilder(float[] param)
	{
		this.sInput = param;
		
		for(int i = 0; i < sInput.length; i++)
			this.head = buildList(sInput[i]);
		
		displayList(this.head);
	}
	
	public Node buildList(int n)
	{
		Node temp;
		if(start == null) 
		{
			start = tail = new Node(n);
			start.next = null;
		}
		else
		{
			tail.next = new Node(n);
			tail = tail.next;
			tail.next = null;
		}
		return start;
	}
	
	public Node buildList(float n)
	{
		Node temp;
		if(start == null) 
		{
			start = tail = new Node(n);
			start.next = null;
		}
		else
		{
			tail.next = new Node(n);
			tail = tail.next;
			tail.next = null;
		}
		return start;
	}
	
	public void displayList(Node n)
	{
		while(n.next!= null)
		{	
			System.out.println(n.data);
			n = n.next;
		}
	}
}

public class GenericNodes 
{
	public void executeCode()
	{
		int[] testData = {15,10,20,105,789,-90};
		ListBuilder t = new ListBuilder(testData);
		
		float[] tData = {15.45f,10.20f,20.23f,105.89f,789.98f,-90.88f};
		ListBuilder s = new ListBuilder(tData); 
	}
}
