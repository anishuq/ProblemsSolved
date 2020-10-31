import java.util.*;

public class LineIntersection {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String lines = sc.nextLine();
		String[] vh = lines.split(" ");
		int vLines = Integer.parseInt(vh[0]);
		int hLines = Integer.parseInt(vh[1]);
		
		String[] vLineStrings = new String[vLines]; 
		int i = 0;
		while(i < vLines)
		{
			vLineStrings[i] = sc.nextLine(); 
			i++;
		}
		
		String[] hLineStrings = new String[hLines]; 
		int j = 0;
		while(j < hLines)
		{
			hLineStrings[j] = sc.nextLine();
			j++;
		}
		
		int intersections = 0;
		for(int k = 0; k < vLineStrings.length; k++)
		{	
			String[] vCoor = vLineStrings[k].split(" ");
			int v_X = Integer.parseInt(vCoor[0]);
			int v_Y1 = Integer.parseInt(vCoor[1]);
			int v_Y2 = Integer.parseInt(vCoor[2]);
			
			for(int l = 0; l < hLineStrings.length; l++)
			{	
				String[] hCoor = hLineStrings[l].split(" ");
				int h_Y = Integer.parseInt(hCoor[0]);
				int h_X1 = Integer.parseInt(hCoor[1]);
				int h_X2 = Integer.parseInt(hCoor[2]);
				
				if((v_X >= h_X1) && (v_X <= h_X2))
				{	
					if((h_Y >= v_Y1) && (h_Y <= v_Y2)) intersections++;
				}
			}
		}
		
		System.out.println("Intersections:  "+intersections);
		
		sc.close();
	}

}
