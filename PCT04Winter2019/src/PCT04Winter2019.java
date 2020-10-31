import java.util.*;


public class PCT04Winter2019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        PCT04Winter2019 palindromeOP =  new PCT04Winter2019();  
		
		String input = "abcda";
		String[] inpArr = input.split("");
		
		ArrayList<String> inpList =  new ArrayList<String>(Arrays.asList(inpArr));
		//this is going to be stretched.
		int initialSize = inpList.size();
		int start = 0;
		int end = inpList.size() - 1;
		int insertions = 0;
		while(start <= end)
		{
			if(palindromeOP.isPalindrome(inpList)) break;
			if(inpList.get(start).compareTo(inpList.get(end)) == 0)
			{
				end--;
			}
			else if(inpList.get(start).compareTo(inpList.get(end)) != 0)
			{
				inpList.add(end + 1, inpList.get(start));
				insertions++;
			}
			
			start++;
		}
		
		System.out.println("minimum insertions "+insertions);
	}
	
	public boolean isPalindrome(ArrayList<String> inpList)
	{
		System.out.println("is palidrome? "+inpList);
		ArrayList<String> forward = new ArrayList<>();
		forward.addAll(inpList);
		
		ArrayList<String> reverse = new ArrayList<>();
		reverse.addAll(inpList);
		Collections.reverse(reverse);
		
		if(forward.equals(reverse))
			return true;
		else
			return false;
	}
}




