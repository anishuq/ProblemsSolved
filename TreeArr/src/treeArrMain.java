import java.util.*;

class Node
{
	int nData;
	Node leftLink;
	Node rightLink;
	int level;
	
	Node(int param)
	{
		this.nData = param;
	}
}

class buildTreeOp
{
	Node parent = null;
	Node current = null;
	Node root = null;
	Node[] parCurrent = new Node[2];//required in search and delete.
	/*
	 * Node[1] contains the current node and
	 * Node[0] contains current node's parent node.
	 */
	
	public Node buildTree(int param)
	{
		parent = current = root;

		while(true)
		{
			if(root == null)
			{
				root = new Node(param);
				root.level = 0;
				System.out.println("Root item: "+root.nData+"   "+root.level);
				
				return root;
			}
			else
			{
				if(param < current.nData)
				{	
					parent = current;
					current = current.leftLink;
					if(current == null) 
					{
						parent.leftLink = new Node(param);
						parent.leftLink.level = parent.level + 1;
						
						return root;
					}
				}
				else if(param > current.nData)
				{	
					parent = current;
					current = current.rightLink;
					if(current == null) 
					{
						parent.rightLink = new Node(param);
						parent.rightLink.level = parent.level + 1; 
						
						return root;
					}
				}
			}
			
		}
	}
	
	public void inOrder(Node localRoot)
	{
		if(localRoot!=null)
		{
			inOrder(localRoot.leftLink);
			System.out.println(localRoot.nData);
			inOrder(localRoot.rightLink);
		}
	}
	
	public void bfs(Node localRoot)
	{
		Queue<Node> q = new LinkedList<>();
		if(localRoot != null)
		{	
			q.add(localRoot);
		}
		
		while(!q.isEmpty())
		{
			Node current = q.remove();
			System.out.println("Node:  "+current.nData+"  Level: "+current.level);
			
			if(current.leftLink!=null)
				q.add(current.leftLink);
					
			if(current.rightLink!=null)
				q.add(current.rightLink);
		}
	}
	
	public void treeHeightBFS(Node localRoot)
	{
		Queue<Node> heightQueue = new LinkedList<>();
		int nodeHeight = 0;
		
		if(localRoot!=null)
		{
			heightQueue.add(localRoot);
		}
		while(true)
		{
			int size = heightQueue.size();
			System.out.println("Current queue size:"+ size);
			
			while(size!=0)
			{
				Node tmp = heightQueue.remove(); 
				System.out.println("Node:  "+tmp.nData+"  Level: "+tmp.level);
				
				if(tmp.leftLink!=null)
					heightQueue.add(tmp.leftLink);
						
				if(tmp.rightLink!=null)
					heightQueue.add(tmp.rightLink);
				
				size--;
			}
			
			if(heightQueue.isEmpty()) break;
			if(size == 0) nodeHeight++;
		}
		
		System.out.println("Node Height:  "+nodeHeight);
	}

	//calculate left height and right height separately (start)
	public int leftHeight(Node localNode)//using BFS
	{
		Queue<Node> qLeft = new LinkedList<>();
		int leftHeight = 0;
		
		if(localNode!=null)
		{
			qLeft.add(localNode);
		}
		while(true)
		{
			int lSize = qLeft.size();
			
			while(lSize!=0)
			{
				Node lTmp = qLeft.remove();
				System.out.println("Left Node:  "+lTmp.nData);
				
				if(lTmp.leftLink != null)
					qLeft.add(lTmp.leftLink);
				lSize--;
			}
			
			
			if(qLeft.isEmpty()) break;
			if(lSize == 0) leftHeight++;
		}
		
		return leftHeight;
	}
	
	public int rightHeight(Node localNode)//using BFS
	{
		Queue<Node> qRight = new LinkedList<>();
		int rightHeight = 0;
		
		if(localNode!=null)
		{
			qRight.add(localNode);
		}
		while(!qRight.isEmpty())
		{
			int rSize = qRight.size();
			
			while(rSize!=0)
			{
				Node rTmp = qRight.remove();
				System.out.println("Left Node:  "+rTmp.nData);
				
				if(rTmp.rightLink != null)
					qRight.add(rTmp.rightLink);
				
				rSize--;
			}
			
			if(qRight.isEmpty()) break;
			if(rSize == 0) rightHeight++;
		}
		
		return rightHeight;
	}
	//calculate left height and right height separately (end)
	
	public Node[] search(Node root,int item)
	{
		Node current = root;
		Node parent = root; //we need the parent.

		while(current!=null)
		{
			if (item == current.nData) 
			{	
				parCurrent[0] = parent;
				parCurrent[1] = current;
				return parCurrent;
			}	
			else if(item < current.nData)
			{	
				parent = current;
				current = current.leftLink;
			}
			else if(item > current.nData)
			{
				parent = current;
				current = current.rightLink;
			}	
		}
		return null;
	}
	
	public void deleteNode(Node root,int item)
	{
		Node[] foundNode = new Node[2];
		//foundNode[0] holds the parent.
		//foundNode[0] holds the current node, this is the NODE that is going to be 
		//deleted.
		if( (foundNode = search(root, item)) != null) 
		{
			/////////////////////////LEAF///////////////////////////////////////////			
			if((foundNode[1].leftLink == null) && (foundNode[1].rightLink == null))
			{
				//foundNode[0].leftLink.equals(foundNode[1]) does Not work. Why?
				System.out.println("This is a leaf node.");
				if(foundNode[1] == root) //A tree with only ONE node.
					root = null;         //Tree is empty.
				else if(foundNode[0].leftLink == foundNode[1]) //parent's left child is the leaf.
					foundNode[0].leftLink = null;
				
				else if(foundNode[0].rightLink == foundNode[1]) //parent's right child is the leaf.
					foundNode[0].rightLink = null;
					
			}
			/////////////////////////Have LEFT, NO Right//////////////////////////////////
			else if((foundNode[1].leftLink != null) && (foundNode[1].rightLink == null))
			{	
				System.out.println("This node only has LEFT descendants.");
				
				if(root == foundNode[1]) root = root.leftLink;
				
				else if(foundNode[0].leftLink == foundNode[1]) //parent's left child is the node to be deleted.
					foundNode[0].leftLink = foundNode[1].leftLink;
				
				else if(foundNode[0].rightLink == foundNode[1]) //parent's right child is the node to be deleted.
					foundNode[0].rightLink = foundNode[1].leftLink;
				
			}
            /////////////////////////Have RIGHT, NO LEFT//////////////////////////////////
			else if((foundNode[1].leftLink == null) && (foundNode[1].rightLink != null))
			{	
				System.out.println("This node only has RIGHT descendants.");
				
				if(root == foundNode[1]) root = root.rightLink;
				
				else if(foundNode[0].leftLink == foundNode[1]) //parent's left child is the node to be deleted.
					foundNode[0].leftLink = foundNode[1].rightLink;
				
				else if(foundNode[0].rightLink == foundNode[1]) //parent's right child is the node to be deleted.
					foundNode[0].rightLink = foundNode[1].rightLink;
				
			}
			
            /////////////////////////Have both LEFT and RIGHT//////////////////////////////////
			else if((foundNode[1].leftLink != null) && (foundNode[1].rightLink != null))
			{	
				System.out.println("This node has BOTH descendants.");
			    Node[] parentSuccessor = new Node[2];
			    parentSuccessor = findInorderSuccessor(foundNode);
			    
			    //////////////////////////make things clear//////////////////
			    Node delNode = foundNode[1];
			    Node delNodeParent = foundNode[0];
			    
			    Node successor = parentSuccessor[1];
			    Node successorParent = parentSuccessor[0];
			    
			    System.out.println("parent data: "+successorParent.nData);
			    System.out.println("successor data: "+successor.nData);
			    
			    delNode.nData = successor.nData;
			    
			    if(successorParent.leftLink == successor) 
			    {	
			    	//parent's left child is the node to be deleted.
			    	successorParent.leftLink = successor.rightLink;
			    	//the successor cannot have a left child, it can only have a right child.
			    }
				else if(successorParent.rightLink == successor) 
				{
					//parent's right child is the node to be deleted.
					successorParent.rightLink = successor.rightLink;
					//the successor cannot have a left child, it can only have a right child.
				}
			}
		}
		else System.out.println("Item Not found.");
	}
	
	//In case the node has two children, we need to find inorder successor.
	public Node[] findInorderSuccessor(Node[] delNode)
	{
		Node successorParent = delNode[0]; //extremely critical.
		Node current = delNode[1].rightLink;
		Node successor = current;
		
		while(current.leftLink!=null)
		{
			successorParent = successor;
			successor = current;
			current = current.leftLink;
		}
		
		Node[] parentSuccessor = new Node[2];
		parentSuccessor[0] = successorParent;
		parentSuccessor[1] = successor;
		
		return parentSuccessor;
	}
	
	public boolean isLeft(Node[] lr)
	{
		if(lr[0].leftLink == lr[1])
			return true;
		else
			return false;
	}
	
	public boolean isRight(Node[] lr)
	{
		if(lr[0].rightLink == lr[1])
			return true;
		else
			return false;
	}
}

public class treeArrMain 
{
	//Build a basic BINARY SEARCH TREE.
	public static void main(String[] args) 
	{
		Node root = null;
		int[] intList = {45,22,77,11,30,90,15,25,88};
		buildTreeOp buildTreeObj = new buildTreeOp();
		
		for(int i = 0; i < intList.length; i++)
		{
			root = buildTreeObj.buildTree(intList[i]);
		}
		
		buildTreeObj.inOrder(root);
		
		System.out.println("Input for search:");
		Scanner sc = new Scanner(System.in);
		int s = Integer.parseInt(sc.nextLine());
		
		Node[] searchedNode = new Node[2];
		if( (searchedNode = buildTreeObj.search(root,s)) != null) System.out.println("Item found.");
		else System.out.println("Item Not found.");
		
		
		if(searchedNode != null)
		{
			System.out.println("Current: "+searchedNode[1].nData);
			System.out.println("Parent: "+searchedNode[0].nData);
		}
		
		
		System.out.println("Provid number for deletion:");
		int d = Integer.parseInt(sc.nextLine());
		
		buildTreeObj.deleteNode(root, d);
		
		buildTreeObj.inOrder(root);
		
		System.out.println("BFS printout:");
		buildTreeObj.bfs(root);
		
		System.out.println("height of node:");
		buildTreeObj.treeHeightBFS(root);
		
		System.out.println("Print all the left nodes:");
		buildTreeObj.leftHeight(root);
		
		sc.close();
	}

}
