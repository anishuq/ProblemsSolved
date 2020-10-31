import java.util.*;

class anotherType
{
	String name;
	int age;
	
	anotherType(String s, int i)
	{
		this.name = s;
		this.age = i;
	}
	
	public String toString()
	{
		return "Name: "+this.name+" Age: "+this.age+"\n";
	}
}

class genericStackTest<T>
//it is a class that builds STACK for any type of objects.  
{
	List<T> stackList = new ArrayList<>();
	
	public void push(T param)
	{
		stackList.add(param);
	}
	
	public T pop()
	{
		T obj = stackList.get(stackList.size() - 1);
		stackList.remove(stackList.size() - 1);
		//System.out.println(stackList.size());
		return obj;
	}
	
	public <T> void printAll()
	{
		Iterator it = stackList.iterator();
		
		while(it.hasNext())
		{
			Object ob = it.next();
			System.out.println(ob.toString());
		}
	}
	
	public boolean emptyTest()
	{
		return (stackList.isEmpty());
	}
}


class genericMethodTest
{
	public <T> void printAll(T[] arr)
	{
		for (T t : arr) 
		{
			System.out.println(t.toString());
		}
	}
}

class findMaxOp<T>
{
	List<T> listObj = new ArrayList<>();
	
	public List<T> push(T e)
	{
		if(listObj.add(e))
			return listObj;
		else
			return listObj;
	}
	
	/*
	public T pop()
	{
		if(!listObj.isEmpty())
			return listObj.remove(listObj.size() - 1);
		else return null;
	}
	*/
	
	public void findMax(List<? extends Number> E)
	{
		int i = 0;
		Number max = 0;
		
		while(i < E.size())
		{
			if(E.get(i) instanceof Double)
			{
				if(E.get(i).doubleValue() > max.doubleValue())
					max = E.get(i); 
			}
			
			else if(E.get(i) instanceof Integer)
			{
				if(E.get(i).intValue() > max.intValue())
					max = E.get(i); 
			}
			
			i++;
		}
		if( E.get(0) instanceof Double )
			System.out.println("MAX:  "+max.doubleValue());
		else if( E.get(0) instanceof Integer )
			System.out.println("MAX:  "+max.intValue());
	}
}


public class GenericClassTest {

	public void executeDummy()
	{
		//Build stack for any type of objects.
		/*
		genericStackTest<String> stackObj = new genericStackTest<>();
		stackObj.push("Mashrafe");
		stackObj.push("Liton");
		stackObj.push("Soummo");
		stackObj.push("Mushfiqur");
		stackObj.printAll();
		
		System.out.println("******************POPing****************");
		System.out.println(stackObj.pop().toString());
		System.out.println(stackObj.pop().toString());
		System.out.println(stackObj.pop().toString());
		
		genericStackTest<anotherType> anotherStackObj = new genericStackTest<>();
		anotherStackObj.push(new anotherType("Mashrafe", 36));
		anotherStackObj.push(new anotherType("Liton", 25) );
		anotherStackObj.push(new anotherType("Soummo", 24) );
		anotherStackObj.push(new anotherType("Mushfiqur", 31) );
		anotherStackObj.printAll();
		
		System.out.println("***************POPing********************");
		System.out.println(anotherStackObj.pop().toString());
		System.out.println(anotherStackObj.pop().toString());
		System.out.println(anotherStackObj.pop().toString());
		System.out.println(anotherStackObj.emptyTest());
		
		// genericMethodTest
		Integer[] arrInt = {55,45,-67,98,890};
		anotherType[] arrClass = new anotherType[3];
		arrClass[0] = new anotherType("Sergio Romero", 31);
		arrClass[1] = new anotherType("Agustín Marchesín", 30);
		arrClass[2] = new anotherType("Gerónimo Rulli", 26);
		
		genericMethodTest testObj = new genericMethodTest();
		testObj.printAll(arrInt);
		testObj.printAll(arrClass);
		*/
		findMaxOp<Double> stackObj = new findMaxOp<>();
		stackObj.push(22.56);
		stackObj.push(188.23);
		stackObj.push(70.58);
		List<Double> d = stackObj.push(98.29);
		stackObj.findMax(d);
		
		findMaxOp<Integer> intSort = new findMaxOp<>();
		intSort.push(22);
		intSort.push(188);
		intSort.push(70);
		List<Integer> I = intSort.push(98);
		intSort.findMax(I);
		
	}
}
