import java.util.*;

public class HashPCTArray {

	int listLength;
	int[] hashTable;
	
	public static void main(String[] args) 
	{
		HashPCTArray HashPCTArrayObj = new HashPCTArray();
		
		Scanner sc = new Scanner(System.in);
		HashPCTArrayObj.listLength = Integer.parseInt(sc.nextLine());
		
		HashPCTArrayObj.hashTable = new int[HashPCTArrayObj.listLength];//initially empty 
		for(int k = 0; k < HashPCTArrayObj.hashTable.length; k++)
			HashPCTArrayObj.hashTable[k] = -10;//means empty
		
		String input = sc.nextLine();
		String[] inputArr = input.split(" ");
		
		int index = 0;
		while(index < inputArr.length -1)
		{
			int i = Integer.parseInt(inputArr[index]);//i is the value to be added.
			int j = i % HashPCTArrayObj.listLength; //j is the index of hashTable 
			if(HashPCTArrayObj.hashTable[j] == -10)
				HashPCTArrayObj.hashTable[j] = i;
			else//collision
			{
				
			}
			index++;
		}
		
		sc.close();
	}
	
	public void collisionHandle(int i)//i is the number to be inserted.
	{
		
	}

}
