

class genericSortOp
{
	public <T extends Comparable<T> > T[] sorting(T[] arr)
	{
		//simple bubble sort
		for(int out = arr.length - 1; out > 0; out--)
			for(int in = 0; in < out; in++)
			{
				if(arr[in].compareTo(arr[in+1]) > 0)
				{
					T temp;
					temp = arr[in];
					arr[in] = arr[in+1];
					arr[in+1] = temp;
				}
			}
		return arr;
	}
}

public class GenericSortTest 
{
	Integer[] intArr = {33,22,55,44,66};
	Double[] doubArr = {33.33,22.22,55.55,44.44,66.66};
	String[] strArr = {"Tom", "Susan", "Kim"};
	
	public void dummy()
	{
		genericSortOp obj = new genericSortOp();
		Integer[] sortedIntArr = obj.sorting(intArr);
	
		for(Integer i : sortedIntArr)
			System.out.println(i);
		
		Double[] sortedDoubleArr = obj.sorting(doubArr);
		
		for(Double d : sortedDoubleArr)
			System.out.println(d);
		
		String[] sortedStrArr = obj.sorting(strArr);
		
		for(String s : sortedStrArr)
			System.out.println(s);
		
	}
}
