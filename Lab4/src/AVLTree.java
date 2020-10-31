import java.util.*;

class Node
{
	int data;
	int level;
	int leftDepth;
	int rightDepth;
	
	Node leftLink;
	Node rightLink;
	
	Node(int data)
	{
		this.data = data;
	}
}

class AVLTreeOp
{
	Node root = null; 
	Node parent = null; 
	Node current = null;
	boolean flag = true;
	String outputStr = "";
	
	public Node createBST(Node root, int n)
	{
		if(root == null)
		{	
			root = new Node(n);
			return root;
		}
		else
		{
			parent = current = root;
			
			while(true)
			{
				if(n <= current.data)
				{
					parent = current;
					current = current.leftLink;
					
					if(current == null)
					{	
						parent.leftLink = new Node(n);
						return root;
					}	
				}
				else if(n > current.data)
				{
					parent = current;
					current = current.rightLink;
					
					if(current == null)
					{	
						parent.rightLink = new Node(n);
						return root;
					}	
				}
			}
		}
	}
	
	public void inOrderTraversal(Node localRoot)
	{
		if(localRoot!= null)
		{
			inOrderTraversal(localRoot.leftLink);
			/*
			nodeHeight(localRoot);
			if(Math.abs(localRoot.leftDepth - localRoot.rightDepth) > 1) 
			{	
				flag = false;
			}
			*/
			localRoot.leftDepth = leftHeight(localRoot);
			localRoot.rightDepth = rightHeight(localRoot);
			
			if(Math.abs(localRoot.leftDepth - localRoot.rightDepth) > 1) 
			{	
				flag = false;
			}
			
			inOrderTraversal(localRoot.rightLink);
		}
	}
	
	public void preOrderTraversal(Node localRoot)
	{
		if(localRoot!= null)
		{
			//System.out.print(localRoot.data+" ");
			outputStr = outputStr + localRoot.data +" ";
			preOrderTraversal(localRoot.leftLink);
			preOrderTraversal(localRoot.rightLink);
		}
		
		
	}
	
	/*	
	public int nodeHeight(Node localNode)
	{
		if(localNode == null)
			return 0;
		else
		{
			localNode.leftDepth = nodeHeight(localNode.leftLink);
			localNode.rightDepth = nodeHeight(localNode.rightLink);
			
			return (Math.max(localNode.leftDepth, localNode.rightDepth)) + 1; 
			//+1 is very important. Otherwise height will NOT increase
		}
	}
	*/
		//calculate left height and right height separately (start)
		public int leftHeight(Node localNode)//using BFS
		{
			Queue<Node> qLeft = new LinkedList<>();
			int leftHeight = 0;
			
			if(localNode!=null)
			{
				qLeft.add(localNode);
			}
			while(!qLeft.isEmpty())
			{
				int lSize = qLeft.size();
				
				while(lSize!=0)
				{
					Node lTmp = qLeft.remove();
					
					if(lTmp.leftLink != null)
						qLeft.add(lTmp.leftLink);
					lSize--;
				}
				
				leftHeight++;
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
					
					if(rTmp.rightLink != null)
						qRight.add(rTmp.rightLink);
					
					rSize--;
				}
				
				rightHeight++;
			}
			
			return rightHeight;
		}
		//calculate left height and right height separately (end)
	
	
}
public class AVLTree {

	public static void main(String[] args) {
		Node root = null;
		
		Scanner sc = new Scanner(System.in);
		String tNode = sc.nextLine();
		tNode = tNode.substring(0, tNode.length() - 2).trim();
		
		String[] tNodeArr = tNode.split(" ");
		
		AVLTreeOp AVLTreeObj = new AVLTreeOp();
		
		for(String s:tNodeArr)
			root = AVLTreeObj.createBST(root, Integer.parseInt(s));
		
		AVLTreeObj.inOrderTraversal(root);
		
		if(AVLTreeObj.flag == false) System.out.print("NOT");
		else 
		{	
			AVLTreeObj.preOrderTraversal(root);
			System.out.print(AVLTreeObj.outputStr.trim());
		}
		
		sc.close();

	}

}
