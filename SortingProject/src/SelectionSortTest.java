import java.util.*;

class SelectionSortOp
{
	public int findSmallest(List<Integer> dummyList)
	{
		int smallest = dummyList.get(0);
		int smallest_index = 0;
		
		for(int j = 0; j < dummyList.size(); j++)
		{
			if(dummyList.get(j) < smallest)
			{
				smallest = dummyList.get(j);
				smallest_index = j;
			}
		}
		dummyList.remove(smallest_index);
		return smallest;
	}
	
	public void SelectionSort(int[] Arr)
	{
		List<Integer> unsortedList = new ArrayList<>();
		int i; 
		for(i = 0; i < Arr.length; i++)
			unsortedList.add(new Integer(Arr[i]));
		
		List<Integer> sortedList = new ArrayList<>();  
		
		for(i = 0; i < Arr.length; i++)
		{
			sortedList.add(findSmallest(unsortedList));
		}
		
		for(i = 0; i < sortedList.size(); i++)//Display
			System.out.println(sortedList.get(i));
	}

}

public class SelectionSortTest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] inputArr = {25,20,85,65,78,71,67,60,101,-456};
		//SelectionSortOp s_sort = new SelectionSortOp();
		//s_sort.SelectionSort(inputArr);
		
		BubbleSortTest b_op = new BubbleSortTest();
		int[] outputArr = b_op.bubbleSortOp(inputArr);
		
		for(int i = 0; i < outputArr.length; i++)
		{
			System.out.println(outputArr[i]);
		}
		String[] inputStrArr = {"a","b","x","d","y","f","g","h","i"};
		String[] outputStrArr = b_op.bubbleSortOpString(inputStrArr);
		
		for(String s: outputStrArr)
			System.out.println(s);
		
	}

}
