
public class primalityTest {
	/*
	 Given an input number n, check whether any prime 
	 integer m from 2 to SQRT(n) evenly divides n (the division leaves no remainder). 
	 If n is divisible by any m then n is composite, otherwise it is prime.
	*/
	public static void main(String[] args) 
	{
		long input = 65537;
		int sqrtInput = (int)Math.floor( Math.sqrt(input) );
		
		boolean isPrime = true;
		for(int i = 2 ; i <= sqrtInput; i++)
		{
			if((input % i) == 0)
			{
				System.out.println(i);
				isPrime = false;
				break;
			}
		}
		
		System.out.println(isPrime);
		
		primalityTest primalityTestObj = new primalityTest();
		primalityTestObj.isPrimeNumber(input, sqrtInput);
	}

	//Another method.
	public void isPrimeNumber(long n, int sq)
	{
		if(n <= 1) System.out.println("Not Prime");
		else if(((n % 2) == 0)  || ((n % 3) == 0)) System.out.println("Not Prime");
		else
		{
			//Look at the DOC document in the src file of this project.
			for(int i = 5; i <= sq; i = i + 6)
			{
				if ( (( n % i ) == 0) || (( n % (i+2) ) == 0))
				{	
					System.out.println("Not Prime");
					break;
				}	
			}
		}
	}
	
}
