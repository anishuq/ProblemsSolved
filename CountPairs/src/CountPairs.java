import java.util.*;

//https://www.geeksforgeeks.org/count-of-pairs-x-y-in-an-array-such-that-x-y/
//count pairs of (x,y) in an array such that x < y.
/*
 * For an element x. In order to find the count of valid pairs of the 
 * form (x, y1), (x, y2), …, (x, yn), we need to count the elements which 
 * are greater than x. For the smallest element, there will be n – 1 elements
 * greater than it. Similarly, the second smallest element can form n – 2 pairs 
 * and so on. Therefore, the desired count of valid pairs 
 * will be (n – 1) + (n – 2) + …. + 1 = n * (n – 1) / 2 
 * where n is the length of the array.
 */


public class CountPairs {

	public static void main(String[] args) 
	{
	
	}

}
