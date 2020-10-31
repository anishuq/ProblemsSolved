import java.util.*;

public class anaGramDetction 
{
	private String f_string;
	private String s_string;
	
	public static void main(String[] args) 
	{
		anaGramDetction anaGramOp = new anaGramDetction();
		Scanner sc = new Scanner(System.in);
		
		anaGramOp.f_string = sc.nextLine();
		anaGramOp.f_string = anaGramOp.f_string.toLowerCase();
		char[] f_string_Arr = anaGramOp.f_string.toCharArray();  
		
		anaGramOp.s_string = sc.nextLine();
		anaGramOp.s_string = anaGramOp.s_string.toLowerCase();
		char[] s_string_Arr = anaGramOp.s_string.toCharArray();
		
		List<Character> f_list = new ArrayList<Character>();
		for(int i = 0; i < f_string_Arr.length; i++)
		{
			if( (f_string_Arr[i]!=' ') && (f_string_Arr[i]!='\'') && (f_string_Arr[i]!=',') && (f_string_Arr[i]!='.') && (f_string_Arr[i]!=';') && (f_string_Arr[i]!='-'))                                                         
				f_list.add(f_string_Arr[i]);
		}
			
		List<Character> s_list = new ArrayList<Character>();
		for(int i = 0; i < s_string_Arr.length; i++)
		{
			if( (s_string_Arr[i]!=' ') && (s_string_Arr[i]!='\'') && (s_string_Arr[i]!=',') && (s_string_Arr[i]!='.') && (s_string_Arr[i]!=';') && (s_string_Arr[i]!='-'))                                                         
				s_list.add(s_string_Arr[i]);
		}
		//System.out.println(f_list);
		//System.out.println(s_list);
		
		if(f_list.size() != s_list.size())
			System.out.print("No");
		else
		{
			Collections.sort(f_list);
			Collections.sort(s_list);
			
			if(f_list.equals(s_list)) System.out.print("Yes"); 
		}
		
		sc.close();
	}

}
