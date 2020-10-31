

class LNode
{
	int info;
	LNode next; //automatically null.
	LNode(int i)
	{
		this.info = i;
	}
	
	public void displayNodeItem()
	{
		System.out.println("Data:  "+info);
	}
}

class QlinkedListOP
{
	LNode head,tail;
	//For Queue, INSERT (PUSH) in tail (last element) 
	//Delete (POP) from head
	QlinkedListOP()
	{
		head = null;
		tail = null;
	}
	public boolean isEmpty()
	{
		if(head == null) return true;
		else return false;
	}
	
	public void insertTail(int item) //push operation 
	{
		LNode temp;
		temp = new LNode(item);
		
		if(isEmpty()) head = tail = temp; 
		
		tail.next = temp;
		tail = tail.next;
	}
	
		
	public LNode deleteHead() //pop operation
	{
		LNode temp;
		temp = head;
		head = head.next;
		
		return temp;
	}
	
	public void displayQueue() //display operation
	{
		LNode temp;
		temp = head;
		if(!isEmpty())
		{
			while(temp!=null)
			{	
				temp.displayNodeItem();
				temp = temp.next;
			}
		}
		else System.out.println("Queue is EMPTY!");
	}
	
}


public class QueueLinkedList 
{
	public void runCode()
	{
		QlinkedListOP ql = new QlinkedListOP();
		ql.displayQueue();
		
		ql.insertTail(60);//Head
		ql.insertTail(80);
		ql.insertTail(-42);
		ql.insertTail(1235);
		ql.insertTail(9875); //Tail 
		//First In First Out
		
		ql.displayQueue();
		
		System.out.println("******************************");
		
		
		System.out.println("Elememnt deleted (poped): "+ql.deleteHead().info);
		System.out.println("Elememnt deleted (poped): "+ql.deleteHead().info);
		System.out.println("Elememnt deleted (poped): "+ql.deleteHead().info);
		
		System.out.println("******************************");
		
		ql.displayQueue();
	}
}
