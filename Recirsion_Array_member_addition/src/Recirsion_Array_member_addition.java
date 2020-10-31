/**
 * 
 * @author anis_huq
 * @desription add the members of an integer array using recursion. 
 */


public class Recirsion_Array_member_addition {

	public static void main(String[] args) 
	{
		Recirsion_Array_member_addition recObj = new Recirsion_Array_member_addition(); 
		
		int[] input = {2,4,6,8};
		System.out.println(recObj.addMembers(input));		
	}

	public int addMembers(int[] inp)
	{
		if(inp.length == 1)
			return inp[0];
		else 
		{
			int[] tmp = new int[inp.length - 1];
			int j = 0;
			for(int i = 1; i < inp.length; i++)
			{
				tmp[j] = inp[i];
				j++;
			}
			
			return inp[0] + addMembers(tmp);
		}
	}
}
