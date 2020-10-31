import java.util.*;
//Sort an array according to the order defined by another array
//https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/

class element implements Comparable<element>
{
	int value;
	boolean visited;
	
	element(int value)
	{
		this.value = value;
		this.visited = false;
	}
	
	public int compareTo(element e)
	{
		if(this.value > e.value) return 1;
		else if (this.value < e.value) return -1;
		else return 0;
	}
}

public class ArraySorting 
{
	public static void main(String[] args) 
	{
		int[] A1= {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}; // array to be sorted.
	    int[] A2 = {2, 1, 8, 3};//sets the sorting order
	    
	    ArrayList<element> inpList = new ArrayList<element>();
	    for(int i = 0; i < A1.length; i++)
	    {	
	    	inpList.add(new element( A1[i] ));
	    }
	    
	    Collections.sort(inpList);
	    ArrayList<Integer> outputList = new ArrayList<>();
	    
	    for(int i = 0; i < A2.length; i++)
	    {
	    	for(int j = 0; j < inpList.size(); j++)
	    	{
	    		if(inpList.get(j).value == A2[i])
	    		{
	    			outputList.add(inpList.get(j).value);
	    			inpList.get(j).visited = true;
	    		}
	    	}
	    }
	    
	    Iterator<element> it = inpList.iterator();
	    while(it.hasNext())
	    {
	    	element e = it.next();
	    	if(e.visited == false) outputList.add(e.value);
	    }
	    
	    Iterator<Integer> itOut = outputList.iterator();
	    while(itOut.hasNext())
	    {
	    	System.out.print(itOut.next()+"   ");
	    }
	}
}
