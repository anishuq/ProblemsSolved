import java.util.*;

class Node
{
	int value;
	Node leftLink;
	Node rightLink;
	
	Node(int value)
	{
		this.value = value;
	}
	
	public String toString()
	{
		return ""+this.value;
	}
}




public class treeLabProblem {

	Node root = null;
	Node current = null;
	Node parent = null;
	
	public Node treeConstruction(int n)
	{
		parent = current = root;
		
		if(root == null)
		{	
			root = new Node(n);
			return root;
		}
		else
		{
			while(true)
			{
				if(n < current.value)
				{	
					parent = current;
					current = current.leftLink;
					
					if(current == null) 
					{
						//System.out.println("LEFT");
						parent.leftLink = new Node(n);
						return root;
					}
				}
				if(n > current.value)
				{	
					parent = current; 
					current = current.rightLink;
					
					if(current == null) 
					{
						//System.out.println("RIGHT");
						parent.rightLink = new Node(n);
						return root;
					}
				}
			}
		}
	}
	
	public void preOrder(Node localRoot)
	{
		if(localRoot!=null)
		{
			System.out.print(localRoot.toString()+" ");
			preOrder(localRoot.leftLink);
			preOrder(localRoot.rightLink);
		}
	}
	
	
	
	public static void main(String[] args) 
	{
		treeLabProblem treeLabObj = new treeLabProblem();
		
		Scanner sc = new Scanner(System.in);
		String treeLine = sc.nextLine();
		String[] tNodes = treeLine.split(" ");
		
		for(int i = tNodes.length - 1; i >= 0; i--)
			treeLabObj.root = treeLabObj.treeConstruction( Integer.parseInt(tNodes[i])  );
		
		treeLabObj.preOrder(treeLabObj.root);
		
	}

}
