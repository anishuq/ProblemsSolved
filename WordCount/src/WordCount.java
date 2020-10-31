import java.util.*;

public class WordCount {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		input = input.toLowerCase();
		String[] inpArr = input.split(" ");
		ArrayList<String> inpArrList = new ArrayList<String>(Arrays.asList(inpArr));  
		Set<String> uniqueNames = new HashSet<String>();
		uniqueNames.addAll(inpArrList);
		
		System.out.println(""+uniqueNames.size());
		
		sc.close();
	}

}
