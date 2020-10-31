//Minimum Window Substring
//https://www.youtube.com/watch?v=qzYhjk-nDGU&list=FLf58mI5LbD_dIMk-J6AWgbQ&index=4&t=204s

import java.util.*;

class MWSubOp
{
	String str, pattern;
	Map<String, Integer> windowMap;
	Map<String, Integer> patternMap;
	
	MWSubOp(String str, String pattern)
	{
		this.str = str;
		this.pattern = pattern;
	}
	
	public void slidingWindow()
	{
		int min = Integer.MAX_VALUE;
		
		int winStart = 0;
		int winEnd = 0;
		
		while( winEnd <= this.str.length() )
		{
			String tmpWin = this.str.substring(winStart, winEnd);
			if(!hasAllCharacter(tmpWin, this.pattern)) //window with all characters NOT found.
			{
				winEnd++;
			}
			else  // we found a Window that has all the characters
			{
				System.out.println("found window:  "+tmpWin);
				int winSize = tmpWin.length();
				if(winSize < min)
				{
					min  = winSize;
					System.out.println("min length:   "+min);
				}
				//we look for a smaller window
				winStart++;
			}
		}
	}
	
	public boolean hasAllCharacter(String window, String pattern)
	{
		windowMap =  createMap(window);
		patternMap = createMap(pattern);
		
		int found = 0;
		
		for(String s : patternMap.keySet())
		{
			if(windowMap.containsKey(s))
			{
				int pFreq = patternMap.get(s);
				int wFreq = windowMap.get(s);
				
				if( wFreq >= pFreq ) found++;
			}
		}
		
		if(found == patternMap.size()) return true;
		else return false;
	}
	
	
	
	public Map<String, Integer> createMap(String inpStr)
	{
		String[] inpArr = inpStr.split("");
		ArrayList<String> inpList = new ArrayList<String>(Arrays.asList(inpArr));
		Set<String> uInp = new HashSet<String>();
		uInp.addAll(inpList);
		
		Map<String, Integer> inpMap = new HashMap<String, Integer>();
		Iterator<String> it = uInp.iterator();
		
		while(it.hasNext())
		{
			String key = it.next(); 
			inpMap.put(key, Collections.frequency(inpList, key));
		}
		
		return inpMap;
	}
	
	
	
}

public class MinimumWindowSubstring {

	public static void main(String[] args) 
	{
		//String str = "acbdnracbn";
		//String pattern = "abn";
		//String str = "MKWPLNHNNKLASOPQLRHLI";
		//String pattern = "HILL";
		//String str = "qploresinazxrhqknhoilerthf";
		//String pattern = "lion";
		String str = "1qnkyp098fSkkmnQryS9pkYn0Qd7mksy0fRW0a7Sxzc";
		String pattern = "Sky07";
		
		MWSubOp MWSubObj =  new MWSubOp(str, pattern);
		MWSubObj.slidingWindow();
	}

}


