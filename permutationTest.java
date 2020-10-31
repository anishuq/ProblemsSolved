import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class permutationTest {

	public static void main(String[] args) {
		String in = "4 3 2 2 1 1";
		int specifiedTotaol = 4;
//		String in = "1 2 3";
		String[] inpA = in.split(" ");
	    List<String> input = new ArrayList<String>();
	    for (String s:inpA)
			input.add(s);
	 
	    Set<String> parmHash = getPermutation(input);
	    List<Integer> totInt =	total(parmHash);
	    int freq = Collections.frequency(totInt, specifiedTotaol);
//	for (int x: totInt)
//		System.out.println(x);	
	
	
	System.out.println("The frequency of is: " + freq);
	}
  
	static Set<String> getPermutation(List<String> input){
	       Set<String> listPermA = new HashSet<String>();
	  
			while(!input.isEmpty()){			
		    for(int i=0; i<input.size(); i++){
			    List<String> listPermtemp = getP(input, i);
			    listPermA.addAll(listPermtemp);
			    }
		      input.remove(0);
			}
		return 	listPermA;
	}

	
	static List<String> getP(List<String> list, int n){
		List<String> listPerm = new ArrayList<String>();
		String li;
		
	    	for(int j= n; j<list.size(); j++){
	    	li = "";
	    	  for(int k = 0; k<n; k++){	
	    	li += list.get(k)+" ";
	    	}
	    	li = li+ list.get(j);
	    	listPerm.add(li);
	    	}
	       return listPerm;

	}

	
	
	static List<Integer> total(Set<String> permParam){
		List<Integer> sumList = new ArrayList<Integer>();
		
		for(String s: permParam){
			String[] tempList = s.split(" ");
			int total = 0; 
			for (String sa:tempList){
				total += Integer.parseInt(sa);
			}
			sumList.add(total);
		}
		
	return sumList;	
	}
	
	}
