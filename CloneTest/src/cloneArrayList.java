import java.util.*;

class person
{
	String name;
	int age;
	
	person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String toString()
	{
		return "Name: "+this.name+" Age: "+this.age;
	}
}


class cloneArrayListOp
{
	/*
	ArrayList<String> listObj = new ArrayList<>();
	public void push(String[] param) throws CloneNotSupportedException
	{
		for(String s : param)
			listObj.add(s);
	
		System.out.println(listObj);
		
		ArrayList<String> listCloneObj = (ArrayList<String>)listObj.clone();
		System.out.println(listCloneObj);
		
		if(listObj.contains("Kant"))
			listObj.remove("Kant");
		
		System.out.println(listObj);
		System.out.println("**************************************************");
		System.out.println(listCloneObj);
		
	}
	*/
	ArrayList<person> listObj = new ArrayList<>();
	ArrayList<person> listCloneObj;
	
	public void push(String[] param) throws CloneNotSupportedException
	{
		for(String s : param)
			listObj.add( new person( s, (int)(Math.random()*100) ) );
	}
	
	public void printClone()
	{
		System.out.println("Original");
		display(listObj);
		listCloneObj = (ArrayList<person>)listObj.clone();
		
		System.out.println("Cloned");
		display(listCloneObj);
		//now we change the original.
		//remove an element.
		System.out.println("*****************************");
		Iterator<person> it = listObj.iterator();
		int i = 0;
		while(it.hasNext())
		{
			person tmp = it.next();
			if(tmp.name.equalsIgnoreCase("Descartes"))
			{	
				listObj.remove(i);
				break;
			}
			i++;
		}
		System.out.println("Changed listObj");	
		display(listObj);
		System.out.println("Print the clone");
		display(listCloneObj);
	}
	
	public void display(ArrayList<person> param)
	{
		Iterator<person> it; 
		it = param.iterator();
		while(it.hasNext())
		{
			person tmp = it.next();
			System.out.println(tmp.toString());
		}
	}
}

public class cloneArrayList 
{
	
	public void arrListCloneTest() throws CloneNotSupportedException
	{
		String[] philosophers = {"Plato", "Aristotle", "Kant", "Hume", "Descartes", "Socrates", "Wittgenstein", "Locke"};
		
		cloneArrayListOp cloneObj = new cloneArrayListOp();
		cloneObj.push(philosophers);
		cloneObj.printClone();
	}
}
