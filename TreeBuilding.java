import java.util.*;

class treeNode
{
	int keyValue;
	treeNode leftChild;
	treeNode rightChild;
	
	public void displayNode()
	{
		System.out.println("Key Value:  "+keyValue);
	}
}

class treeOperation
{
	treeNode root;
	treeOperation()
	{
		root = null;
	}
	
	public treeNode insertNode(int value)
	{
		treeNode current, parent, newNode;
		
		newNode = new treeNode();
		newNode.keyValue = value;
		
		if(root == null)
			root = newNode;
		else //go left or right.
		{
			current = root;//start from the ROOT.
			while(true)
			{
				parent = current;
				//we need to access the last non-null node.
				
				if(value < current.keyValue) //left child
				{
					current = current.leftChild;
					
					if(current == null)
					{
						parent.leftChild = newNode;
						return root;
					}
				}
				else if (value >= current.keyValue) //right child
				{
					current = current.rightChild;
					
					if(current == null)
					{
						parent.rightChild = newNode;
						return root;
					}
				}
			}
		}
		return root; 
	}
	
	public treeNode find(int key)
	{
		treeNode current = root;// root is initialized when 
								// 
		while(current.keyValue!= key)
		{
			if(key < current.keyValue)
				current = current.leftChild;
			else if(key > current.keyValue)
				current = current.rightChild;
			
			if(current == null)
			{
				System.out.println("Item Not found");
				return null;
			}
		}
		
		return current;
	}
	
	public treeNode minValue(treeNode localRoot)
	{
		treeNode current = localRoot;
		
		while(current.leftChild!=null)
		{
			current = current.leftChild;
		}
		
		return current;
	}
	
	public treeNode maxValue(treeNode localRoot)
	{
		treeNode current = localRoot;
		
		while(current.rightChild!=null)
		{
			current = current.rightChild;
		}
		
		return current;
	}
	
	public void inOrder(treeNode localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			localRoot.displayNode();
			inOrder(localRoot.rightChild);
		}
	}
	
	public void findDelete(int key)
	{
		treeNode current = root;
		treeNode parent = current;
		while(current.keyValue!= key)
		{
			if(key < current.keyValue)
			{
				parent = current;
				current = current.leftChild;
			}
			else if(key > current.keyValue)
			{
				parent = current;
				current = current.rightChild;
			}
			if(current == null)
			{
				System.out.println("Item Not found");
				break;
			}
		}
		
		if(current != null)//means we found it.
		{
			//delete node with NO children.
			if(current.leftChild == null && current.rightChild == null)
			{
				System.out.println("Its a leaf");
				if(current == root)
					parent = current = root = null;//empty tree
				else if(parent.leftChild == current)
					parent.leftChild = null;
				else if(parent.rightChild == current)
					parent.rightChild = null;
			}
			if( (current.leftChild != null && current.rightChild == null) || (current.leftChild == null && current.rightChild != null) )
			{
				System.out.println("With only ONE child");
			}
		}
	}
}


public class TreeBuilding 
{
	public static void main(String[] args) 
	{
		treeNode root = null;
		treeOperation tProcess = new treeOperation();
		int[] inputData = {60,50,55,98,-8,78};
		
		for(int i = 0; i < inputData.length; i++)
			root = tProcess.insertNode(inputData[i]);

		tProcess.inOrder(root);
		
		System.out.println("Input item to find:");
		Scanner inpObj = new Scanner(System.in);
		int key = inpObj.nextInt();
		
		treeNode res = tProcess.find(key);
		if(res!=null)
			res.displayNode();
		
		System.out.println("Min value in BST:");
		tProcess.minValue(root).displayNode();
		System.out.println("Max value in BST:");
		tProcess.maxValue(root).displayNode();
		
		//delete node
		System.out.println("Find item and delete:");
		key = inpObj.nextInt();
		tProcess.findDelete(key);
		
		tProcess.inOrder(root);
	}
}
