import java.util.*;

class personNode// implements Comparable
{
	String name;
	int age;
	
	personNode(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String toString()
	{
		return "Name:  "+this.name+" and Age: "+this.age;
	}
	
		
	personNode leftLink;
	personNode rightLink;
}

class treeBuildingOP
{
	personNode root = null;
	personNode parent = null;//to track the current Node's parent
	personNode current = null;// current node that traverses.
	
	/*
	 CompareTo method must return negative number if current object 
	 is less than other object, positive number if current object is 
	 greater than other object and zero if both objects are equal to each other.

	 */
	
	public personNode addTreeNode(personNode nodeObj)
	//personNode type objects are sent as parameters.
	{
		current = root;
		
		while(true)
		{
			if(root == null)
			{
				root = nodeObj;
				return root;
			}
			else
			{
				parent = current;
				if(current.name.compareTo(nodeObj.name) > 0)
				{
					current = current.leftLink;
					if(current == null)
					{	
						parent.leftLink = nodeObj;
						return root;
					}
				}
				else if(current.name.compareTo(nodeObj.name) < 0)
				{
					current = current.rightLink;
					if(current == null)
					{	
						parent.rightLink = nodeObj;
						return root;
					}
				}
			}
		}
	}
	
	/////////////////////////////TRAVERSAL start////////////////////////////////////
	public void inOrderTraversal(personNode localRoot)
	{
		if(localRoot!=null)
		{
			inOrderTraversal(localRoot.leftLink);
			System.out.println(localRoot.toString());
			inOrderTraversal(localRoot.rightLink);
		}
	}
	
	public void preOrderTraversal(personNode localRoot)
	{
		if(localRoot!=null)
		{
			System.out.println(localRoot.toString());
			preOrderTraversal(localRoot.leftLink);
			preOrderTraversal(localRoot.rightLink);
		}
	}
	
	public void postOrderTraversal(personNode localRoot)
	{
		if(localRoot!=null)
		{
			postOrderTraversal(localRoot.leftLink);
			postOrderTraversal(localRoot.rightLink);
			System.out.println(localRoot.toString());
		}
	}
    /////////////////////////////TRAVERSAL end////////////////////////////////////
	
	////////////////////////////NODE delete //////////////////////////////////////
	
	public personNode find(personNode localRoot, String name)
	{//we search by age.
		personNode current = localRoot;
	    while(true)
	    {
	    	if(current == null) return null;
	    	else if(current.name.compareTo(name) == 0) return current;
	    	else if(current.name.compareTo(name) > 0) current = current.leftLink;
	    	else if(current.name.compareTo(name) < 0) current = current.rightLink;
	    }
	}
	

}



public class TreeBuilding 
{
	public static void main(String[] args) 
	{
		personNode root = null;
		treeBuildingOP treeBuildObj = new treeBuildingOP();
		List<personNode> tNodeList = new ArrayList<personNode>();
		List<String> names = new ArrayList<String>();
		names.add("Mashrafe Mortaza");
		names.add("Anisul");
		names.add("Shakib Al Hasan");
		names.add("Tamim Iqbal");
		names.add("Mominul Haque");
		names.add("Mahmudullah Riad");
		names.add("Mushfiqur Rahim");
		names.add("Rubel Hossain");
		names.add("Soumya Sarkar");
		names.add("Sabbir Rahman");
		
		//Player age is the Key for input.
		for(int i = 0; i < names.size(); i++)
		{
			root = treeBuildObj.addTreeNode(new personNode(names.get(i), (int)(Math.random()*100) ) );
		}
		
		System.out.println("INORDER TRAVERSAL");
		treeBuildObj.inOrderTraversal(root);
		
		System.out.println("PREORDER TRAVERSAL");
		treeBuildObj.preOrderTraversal(root);
		
		System.out.println("POSTORDER TRAVERSAL");
		treeBuildObj.postOrderTraversal(root);
		
		//////////////////FIND////////////////////////
		Scanner sc = new Scanner(System.in);
		System.out.println("Give the input name:");
		String name = sc.nextLine();
		
		System.out.println(""+treeBuildObj.find(root, name) );
		
		
		
		//sc.close();
	}
}