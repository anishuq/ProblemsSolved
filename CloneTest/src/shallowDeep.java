class one
{
	int a,b;
}

class two implements Cloneable
{
	int x,y;
	one fObj;
	
	two(int i,int j,int k,int l)
	{
		fObj = new one();
		this.x = i;
		this.y = j;
		
		fObj.a = k;
		fObj.b = l;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		two tmpObj = (two)super.clone();//returns an Object.
		tmpObj.fObj = new one();
		//its a completely new one type object
		//so a and b will have initial value of 0.
		
		//we r going to initialize fObj.
		tmpObj.fObj.a = 44;
		tmpObj.fObj.b = 55;
		
		return tmpObj;
	}
	
	public String toString()
	{
		return "two.x= "+this.x+" two.y= "+this.y+" one.a= "+this.fObj.a+" one.b= "+this.fObj.b;
	}
}

public class shallowDeep {

	public static void main(String[] args) throws CloneNotSupportedException
	{
		// TODO Auto-generated method stub
		
		try
		{
		two twoObj = new two(10,20,30,40);
		System.out.println("Original");
		System.out.println(twoObj.toString());
		
		two twoCloneObj = (two)twoObj.clone();
		System.out.println("Clone");
		System.out.println(twoCloneObj.toString());
		
		twoObj.fObj.a = 199;
		twoObj.fObj.b = 888;
		//as both twoObj and twoCloneObj point to the same fObj, both will
		//change in this SHALLOW copy.
		System.out.println("Change in Original");		
		System.out.println(twoObj.toString());
		
		System.out.println("What happens to clone?");
		System.out.println(twoCloneObj.toString());
		}
		catch(CloneNotSupportedException e) {System.out.println(e.toString());}
		
		
		//cloneArrayList cloneALObj = new cloneArrayList();
		//cloneALObj.arrListCloneTest();
	}

}
