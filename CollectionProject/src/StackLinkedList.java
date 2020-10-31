

class Node
{
	int info;
	Node next; //automatically null.
	Node(int i)
	{
		this.info = i;
	}
	
	public void displayNodeItem()
	{
		System.out.println("Data:  "+info);
	}
}

class linkedListOP
{
	Node head,tail;
	//For STACK, insert and deletion at the same end.
	linkedListOP()
	{
		head = null;
		tail = null;
	}
	public boolean isEmpty()
	{
		if(head == null) return true;
		else return false;
	}
	
	public void insertFirst(int item) //push operation 
	{
		Node temp;
		temp = new Node(item);
		
		if(isEmpty()) tail = temp; 
		
		temp.next = head;
		head = temp;
	}
	
	public void insertLast(int item) 
	{
		Node temp;
		temp = new Node(item);
		
		tail.next = temp;//always
		tail=tail.next;
	}
	
	public Node deleteFirst() //pop operation
	{
		Node temp;
		temp = head;
		head = head.next;
		
		return temp;
	}
	
	public void displayStack() //display operation
	{
		Node temp;
		temp = head;
		if(!isEmpty())
		{
			while(temp!=null)
			{	
				temp.displayNodeItem();
				temp = temp.next;
			}
		}
		else System.out.println("Stack is EMPTY!");
	}
	
}

public class StackLinkedList 
{
	
	public void runCode()
	{
		linkedListOP sList = new linkedListOP();
		sList.displayStack();
		
		sList.insertFirst(60);//Tail
		sList.insertFirst(80);
		sList.insertFirst(-42);
		sList.insertFirst(1235);
		sList.insertFirst(9875); //Head 
		//Last In First Out
		
		sList.displayStack();
		
		System.out.println("******************************");
		
		sList.insertLast(-70); //added to the tail
		sList.insertLast(-456);
		sList.insertLast(985);
		
		System.out.println("******************************");
		
		sList.displayStack();
		
		System.out.println("Elememnt deleted (poped): "+sList.deleteFirst().info);
		System.out.println("Elememnt deleted (poped): "+sList.deleteFirst().info);
		System.out.println("Elememnt deleted (poped): "+sList.deleteFirst().info);
		
		sList.displayStack();
		
		
		
	}
}
