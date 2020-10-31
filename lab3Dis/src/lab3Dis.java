import java.util.*;
/*
 * Finding distance between between two nodes
 * by LCA. 
 */
class Node
{
	int nData;
	
	Node pNode;
	Node leftLink;
	Node rightLink;
	
	Node(int nData)
	{
		this.nData = nData;
	}
}

class treeOperation
{
	Node root = null;
	Node current = null;
	Node parent = null;
	int searchValue;
	Node searchedNode = null;
	
	public Node buildTree(Node r, int param)
	{
		root = parent = current = r;
		
		if(root == null)
		{
			root = new Node(param);
			root.pNode = null; // root does NOT have a parent. 
			return root;
		}
		else
		{
			while(true)
			{
				if(param <= current.nData)
				{
					parent = current;
					current = current.leftLink;
					
					if(current == null)
					{
						parent.leftLink = new Node(param);
						parent.leftLink.pNode = parent;
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
						parent.rightLink.pNode = parent;
						
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
			if(localRoot.nData == this.searchValue) 
				searchedNode = localRoot; 
			inOrder(localRoot.rightLink);
		}
	}
	
	public void LCA(Node root, Node fNode, Node sNode)
	{
		int fDistance = 0;
		int sDistance = 0;
		ArrayList<Node> fNodePath = new ArrayList<Node>();
		
		while(fNode!=null)//go to root
		{
			fNodePath.add(fNode);
			fNode = fNode.pNode;
		}
		
		Node lca = null;
		int fIndex = 0;
		boolean found = false;
		while(sNode!=null)//might go to root
		{
			if(fNodePath.get(fIndex).equals(sNode))
			{
				lca = sNode;
				found = true;
				break;
			}
			
			sNode = sNode.pNode;
			fIndex++;
			fDistance++;
			sDistance++;
		}
		
		if(found == true) 
			System.out.println("LCA:   "+lca.nData+" Node distance: "+(fDistance + sDistance));
	}
}


public class lab3Dis {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Node fNode = null;
		Node sNode = null;
		
		treeOperation treeOpObj = new treeOperation();
		int[] treeDList = {45, 22, 77, 11, 30, 90, 15, 25, 88};
		
		Node mainRoot = null;
		for(int i : treeDList)
			mainRoot = treeOpObj.buildTree(mainRoot, i);
		
		System.out.println("First Node:");
		treeOpObj.searchValue = Integer.parseInt(sc.nextLine());
		treeOpObj.inOrder(mainRoot);//used to search	
		if(treeOpObj.searchedNode!=null)
		{	
			System.out.println("the Node is found   "+treeOpObj.searchedNode.nData);
			fNode = treeOpObj.searchedNode;
			treeOpObj.searchedNode=null;
		}
		else
			System.out.println("Node does Not exist");
		
		System.out.println("Second Node:");
		treeOpObj.searchValue = Integer.parseInt(sc.nextLine());
		treeOpObj.inOrder(mainRoot);//used to search	
		if(treeOpObj.searchedNode!=null)
		{	
			System.out.println("the Node is found   "+treeOpObj.searchedNode.nData);
			sNode = treeOpObj.searchedNode;
			treeOpObj.searchedNode=null;
		}
		else
			System.out.println("Node does Not exist");
		
		
		treeOpObj.LCA(mainRoot, fNode, sNode);
		
		sc.close();
	}

}
