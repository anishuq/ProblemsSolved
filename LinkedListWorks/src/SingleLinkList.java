import java.util.*;

class Node
{
	int info;
	Node next;
	Node(int i)
	{
		this.info = i;
	}
}


public class SingleLinkList 
{
	Node head = null, tail = null, p = null, q = null;
	
	//Note: Build and insert will require separate methods and logics
	public Node insertNode(Node head, int val)
	{
		Node q = null;
		boolean flag = false;
		
		if(head == null)
			return head;
		else if(head.info > val)//new head insertion
		{
			q = new Node(val);
			q.next = head;
			head = q;
			flag = true;
		}
		else
		{
			p = head;
			while(p.next!=null) // insert in between
			{
				if((p.next.info > val) )
				{
					q = new Node(val);
					q.next = p.next;
					p.next = q;
					flag = true;
					break;
				}
				p = p.next;
			}
			if(flag == false) //added to tail.
			{
				q = new Node(val);
				q.next = null;
				p.next = q;
			}
		}
		return head;
	}
	
	public Node deleteNode(Node head, int val)
	{
		Node q = null;
		boolean flag = false;
		
		if(head.info == val)//delete head.
		{
			head = head.next;
			flag = true;
		}
		else
		{
			p = head;
			while(p.next!=null) // delete in between
			{
				if((p.next.info == val) )
				{
					p.next = p.next.next;
					flag = true;
					break;
				}
				p = p.next;
			}
			
		}
		if(flag == false) System.out.println("Data Not found.");
		return head;
	}
	
	
	
	public void printAll(Node head)
	{
		Node traveseNode = head;
		
		while(traveseNode!=null)
		{
			System.out.println("Data:  "+traveseNode.info);
			traveseNode = traveseNode.next;
		}
	}
	

	
	
	public static void main(String[] args) 
	{
		/*
		Node headNode = null, p=null, q=null;
		int value;
		SingleLinkList lnListBuild = new SingleLinkList();
		int[] inputArr = {10,15,25,56,78,900,1000}; //sorted array.
		
		//build the linked list here. Passing reference to a methods is problematic.
		p = headNode = new Node(inputArr[0]);
		for(int i = 1; i < inputArr.length; i++)
		{	
			 q = new Node(inputArr[i]);
			 p.next = q;
			 p = p.next;
		}
		lnListBuild.printAll(headNode);
		
		Scanner inputData = new Scanner(System.in);
		System.out.println("Value to insert");
		value = inputData.nextInt();
		headNode = lnListBuild.insertNode(headNode, value);
		lnListBuild.printAll(headNode);
		
		System.out.println("Value to Delete");
		value = inputData.nextInt();
		headNode = lnListBuild.deleteNode(headNode, value);
		lnListBuild.printAll(headNode);
		*/
		
		LinkedListLib llObj = new LinkedListLib();
		llObj.execute();
	}
}
