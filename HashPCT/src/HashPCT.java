import java.util.*;

class element
{
	int index; //0 to length - 1;
	int value;
	
	element next, prev;
	
	element(int index, int value, element prev, element next)
	{
		this.index = index;
		this.value = value;
		this.prev = prev;
		this.next = next;
	}
}

class hashFunctionOP
{
	element listStart = null;
	element end = null;
	element current = null;
	element parent = null;
	
	public element buildList(element start, int index, int value)
	{
		if(value != -1)
		{	
			if(start == null)
			{
				start = new element(index, value, null, null);
				listStart = start; 
				return listStart;
			}
			else
			{
				parent = start;
				current = parent;
				while(current!=null)
				{
					parent = current;
					current = current.next;
				}
				//create element and assign links
				end = new element(index, value, null, null);
				parent.next = end;
				end.prev = parent;
			}
		}
		else
		{
			end.next = start;
			start.prev = end;
		}

		return listStart;
	}
}

public class HashPCT 
{
	public static void main(String[] args) 
	{
		element start = null;
		element end = null;
		
		hashFunctionOP hashFunctionObj = new hashFunctionOP();
		
		Scanner sc = new Scanner(System.in);
		int listLength = Integer.parseInt(sc.nextLine());
		String input = sc.nextLine();
		String[] inputArr = input.split(" ");
		
		int index = 0;
		while(index < inputArr.length)
		{
			int value = Integer.parseInt(inputArr[index]);
			
			if(start == null)
				start = hashFunctionObj.buildList(start, index, value);
			
			else
				end = hashFunctionObj.buildList(start, index, value);
			
			index++;
		}
		
		sc.close();
	}

}

/*
 * element c = start;
		do
		{
			System.out.println("Index: "+c.index+"  val:  "+c.value);
			//System.out.println("loop current:  "+current.value);
			c = c.next;
			
		}while(c!=start);
 */

