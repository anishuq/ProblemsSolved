
public class Practice_BinarySearch {

	public void binarySearch(int[] inputArr, int key)
	{
		int si = 0;
		int ei = inputArr.length - 1;
		int mid = (int)((si+ei)/2);
		boolean found = false;
		
		int i = 0;
		while(si < ei)
		{
			if(inputArr[mid] == key)
			{
				System.out.println("Found at loc: "+mid);
				found = true;
				break;
			}
			else
			{
				if(key < inputArr[mid])
				{
					ei = mid - 1;
				}
				else if(key > inputArr[mid])
				{
					si = mid + 1;
				}
				mid = (int)((si+ei)/2);
			}
		}
		if(found == false) System.out.println("Item Not found!");
	}
	public static void main(String[] args) 
	{
		Practice_BinarySearch binarySearchObj = new Practice_BinarySearch();
		int[] inputArr = {-10,10,20,100,635,585,4444,9999,100000};
		binarySearchObj.binarySearch(inputArr, 10);
	}

}
