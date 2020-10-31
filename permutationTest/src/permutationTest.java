import java.util.ArrayList;
import java.util.List;

class permutationOp {

	// Iterative function to generate all permutations of a String in Java
	// using Collections
	public static void permutations(String s)
	{
		// create an empty ArrayList to store (partial) permutations
		List<String> partial = new ArrayList<>();

		// initialize the list with the first character of the string
		partial.add(String.valueOf(s.charAt(0)));
		
		// do for every character of the specified string
		for (int i = 1; i < s.length(); i++)
		{//1
			System.out.println("inside 1: partial:  "+partial);
			// consider previously constructed partial permutation one by one
			// (iterate backwards to avoid ConcurrentModificationException)
			for (int j = partial.size() - 1; j >= 0 ; j--)
			{//2
				// remove current partial permutation from the ArrayList
				String str = partial.remove(j);
				System.out.println("inside 2: j="+j+"   str:  "+str);
				// Insert next character of the specified string in all
				// possible positions of current partial permutation. Then
				// insert each of these newly constructed string in the list

				for (int k = 0; k <= str.length(); k++)
				{//3
					// Advice: use StringBuilder for concatenation
					System.out.println("inside 3:k=  "+k+" partial before add:  "+partial);
					String tmp = str.substring(0, k) + s.charAt(i) + str.substring(k);
					System.out.println("inside 3: tmp  "+tmp);
					partial.add(tmp);
					System.out.println("inside 3:k=  "+k+" partial AFTER add:  "+partial);
				}//3
			}//2
			System.out.println("**************************************");
			if(i == 2)break;
		}

		System.out.println(partial);
	}

	// Iterative program to generate all permutations of a String in Java

}
public class permutationTest 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		permutationOp permutationObj = new permutationOp();
		String s = "ABC";
		
		permutationObj.permutations(s);
	}

}

//str.substring(k) means start from k to the end.

