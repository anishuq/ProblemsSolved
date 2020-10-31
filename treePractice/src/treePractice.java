import java.util.*;

class Node
{
	int value;

	Node parentLink;
	Node leftLink;
	Node rightLink;
	Node(int value)
	{
		this.value = value;
		this.leftLink = null;
		this.rightLink = null;
		this.parentLink = null;
	}
}

class treeBuildOp
{
	Node parent, current, root, foundNode, successor;
	boolean found = false;
	
	treeBuildOp()
	{
		foundNode = parent = current = root = null;
	}
	
	public Node buildTree(int value)
	{
		if(root == null)
		{
			root = new Node(value);
			return root;
		}
		else
		{
			parent = current = root;
			while(true)
			{
				if(value < current.value)
				{
					parent = current;
					current = current.leftLink;
					if(current == null)
					{
						Node tmp = new Node(value);
						parent.leftLink = tmp;
						tmp.parentLink = parent;
						return root;
					}
				}
				else if(value > current.value)
				{
					parent = current;
					current = current.rightLink;
					if(current == null)
					{
						Node tmp = new Node(value);
						parent.rightLink = tmp;
						tmp.parentLink = parent;
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
			System.out.println(localRoot.value);
			inOrder(localRoot.rightLink);			
		}
	}
	
	public void bfs(Node localRoot)
	{
		Queue<Node> qBFS = new LinkedList<Node>();
		qBFS.add(localRoot);
		
		while(!qBFS.isEmpty())
		{
			Node disNode = qBFS.remove();
			System.out.println(disNode.value);
			
			if(disNode.leftLink!=null)
				qBFS.add(disNode.leftLink);
			
			if(disNode.rightLink!=null)
				qBFS.add(disNode.rightLink);
		}
	}
	public void depthBFS(Node localRoot)
	{
		Queue<Node> qBFS = new LinkedList<Node>();
		qBFS.add(localRoot);
		int count = 0;
		while(true)
		{
			int size = qBFS.size();
			while(size!=0)
			{	
				Node disNode = qBFS.remove();
				System.out.println(disNode.value);
				
				if(disNode.leftLink!=null)
					qBFS.add(disNode.leftLink);
				
				if(disNode.rightLink!=null)
					qBFS.add(disNode.rightLink);
			
				size--;
			}
			
			if(qBFS.isEmpty()) break;
			if(size == 0) count++;
		}
		//count = count - 1;
		System.out.println("Total depth:  "+ count);
	}
	
	public void leftDepthBFS(Node localRoot)
	{
		Queue<Node> lQBFS = new LinkedList<Node>();
		lQBFS.add(localRoot);
		int lCount = 0;
		while(true)
		{
			int lSize = lQBFS.size();
			while(lSize!=0)
			{	
				Node disNode = lQBFS.remove();
				System.out.println(disNode.value);
				
				if(disNode.leftLink!=null)
					lQBFS.add(disNode.leftLink);
				
				lSize--;
			}
			
			if(lQBFS.isEmpty()) break;
			if(lSize == 0) lCount++;
		}
		
		System.out.println("Total depth:  "+ lCount);
	}
	
	
	
	public void findNode(Node localRoot, int key)
	{
		if(localRoot!=null)
		{
			findNode(localRoot.leftLink, key);
			if(localRoot.value == key) 
			{
				foundNode = localRoot; 
				found = true;
			}
			findNode(localRoot.rightLink, key);			
		}
	}
	
	public Node delNode(Node delN)
	{
		//the node is leaf (start)
		if((delN.leftLink == null) && (delN.rightLink == null))
		{
			root = delLeaf(delN);
		}//the node is leaf (end)
		else if((delN.leftLink == null) && (delN.rightLink != null))
		{//no left, but has right
			root = delRight(delN);
		}
		else if((delN.leftLink != null) && (delN.rightLink == null))
		{//HAS left, but NO right
			root = delLeft(delN);
		}
		else if((delN.leftLink != null) && (delN.rightLink != null))
		{//It has both Nodes.
			Node successorNode = delN.rightLink;
			while(successorNode.leftLink!=null)
			{
				successorNode = successorNode.leftLink;
			}
			//get the successor value and assign
			int value = successorNode.value;
			delN.value = value;
			//delete successor.
			if((successorNode.leftLink == null) && (successorNode.rightLink == null))
			{
				root = delLeaf(successorNode);
			}
			else if((successorNode.leftLink == null) && (successorNode.rightLink != null))
			{//no left, but has right
				root = delRight(successorNode);
			}
		}
		
		return root;
	}
	public Node delLeaf(Node delN)
	{
		Node parent = delN.parentLink;
		if(parent!=null)
		{
			if(parent.leftLink == delN)
			{
				parent.leftLink = null;
			}
			else if(parent.rightLink == delN)
			{
				parent.rightLink = null;
			}
		}
		else
		{//root is modified
			root = null;
		}
		return root;
	}
	
	//has one child
	public Node delRight(Node delN)//no left, but has right
	{
		Node parent = delN.parentLink;
		if(parent!=null)
		{	
			if(parent.leftLink == delN)
			{
				parent.leftLink = delN.rightLink;
			}
			else if(parent.rightLink == delN)
			{
				parent.rightLink = delN.rightLink;
			}
		}
		else//its root
		{
			root = root.rightLink;
		}
		return root;
	}
	
	public Node delLeft(Node delN)////Has left, but NO right
	{
		Node parent = delN.parentLink;
		if(parent!=null)
		{
			if(parent.leftLink == delN)
			{
				parent.leftLink = delN.leftLink;
			}
			else if(parent.rightLink == delN)
			{
				parent.rightLink = delN.leftLink;
			}
		}
		else
		{//its root
			root = root.leftLink;
		}
		return root;
	}
}


public class treePractice 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		Node root = null;
		String input = "63 47 71 67 22 53 11 33 17 50 60 57 49 51";
		//String input = "63 47 22 11 9 8 7";
		//String input = "63 71 75 82 90 99 107";
		//String input = "63";
		String[] inputArr = input.split(" "); 
		
		treeBuildOp treeBuildObj  = new treeBuildOp();
		for(int i = 0; i < inputArr.length; i++)
		{
			root = treeBuildObj.buildTree(Integer.parseInt( inputArr[i] ));
		}
		treeBuildObj.inOrder(root);
		System.out.println("*******************************");
		treeBuildObj.bfs(root);
		System.out.println("*******************************");
		treeBuildObj.depthBFS(root);
		
		System.out.println("Calculate left depth: ");
		int key = Integer.parseInt(sc.nextLine());
		treeBuildObj.findNode(root, key);
		if((treeBuildObj.foundNode!= null) && (treeBuildObj.found == true))
		{
			treeBuildObj.leftDepthBFS(treeBuildObj.foundNode);

			treeBuildObj.foundNode = null;
			treeBuildObj.found = false;
		}
		else
		{
			System.out.println("Not found!");
		}
		
		System.out.println("Node to find: ");
		
		key = Integer.parseInt(sc.nextLine());
		treeBuildObj.findNode(root, key);
		if((treeBuildObj.foundNode!= null) && (treeBuildObj.found == true))
		{
			System.out.println(treeBuildObj.foundNode.value);
			treeBuildObj.depthBFS(treeBuildObj.foundNode);
			System.out.println("After Deletion: ");
			Node r = treeBuildObj.delNode(treeBuildObj.foundNode);
			treeBuildObj.inOrder(r);
			
			treeBuildObj.foundNode = null;
			treeBuildObj.found = false;
		}
		else
		{
			System.out.println("Not found!");
		}
	
		
		
		sc.close();
	}
}
