import java.util.*;

class Node
{
	int n;
	int height;
	int leftChildIndex;
	int rightChildIndex;
	int parent;
	
	Node(int n)
	{
		this.n = n;
		parent = -1; //-1 refers to null.
		leftChildIndex = -1;
		rightChildIndex = -1;
	}
}

class treeBuildOp
{
	ArrayList<Node> tree = new ArrayList<Node>();
	
	public void buildTree(int vertices)
	{
		//fill the nodes' n variable.
		for(int i = 0; i < vertices; i++)
		{
			Node tmpNode = new Node(i);
			tree.add(tmpNode);
		}
		//assign child
		int j = 0;//index of array list
		tree.get(0).height = 0;//root's height is zero. 
		while(j < tree.size())
		{
			Node tmpNode = tree.get(j);
			
			if(tmpNode.parent != -1)
				tmpNode.height = tree.get(tmpNode.parent).height + 1;
			
			if( ((2 * j) + 1) < tree.size())
			{
				tmpNode.leftChildIndex = (2 * j) + 1; //left child
				tree.get((2 * j) + 1).parent = j; //assign the left child its parent.
			}
			
			if( ((2 * j) + 2) < tree.size())
			{
				tmpNode.rightChildIndex = (2 * j) + 2; //right child
				tree.get((2 * j) + 2).parent = j;//assign the right child its parent. 
			}
			
			j++;
		}
	}
	
	public Node search(int n)
	{
		Iterator<Node> treeIt = tree.iterator();
		
		while(treeIt.hasNext())
		{
			Node tmp = treeIt.next();
			if(tmp.n == n) return tmp; 
		}
		return null;
	}
	
	public void findLCA(Node fNode, Node sNode)
	{
		ArrayList<Node> path = new ArrayList<Node>(); 
		Node current = fNode;
		
		while(current.parent!=-1)
		{
			path.add(current);			
			current = tree.get(current.parent);
			if(current.parent==-1) path.add(current);//in cases root has to be added to the path.
		}
		
		boolean flag = false;
		current = sNode;
		while(current.parent!=-1)
		{
			//search path (start)
			flag = pathSearch(path, current);
			//search path (end)
			if(flag == true) break;
			
			current = tree.get(current.parent);
			if(current.parent==-1) pathSearch(path, current); //root might need to be searched as well.
		}
	}
	
	public boolean pathSearch(ArrayList path, Node current)
	{
		boolean flag = false;
		Iterator<Node> pathIt = path.iterator();
		while(pathIt.hasNext())
		{
			Node tmp = pathIt.next();
			if(tmp.n == current.n) 
			{
				System.out.println(tmp.n+" "+tmp.height);
				flag = true;
				break;
			}
			
			if(flag == true) break;
		}
		
		return flag;
	}
}

public class PCT_LCAproblem {

	public static void main(String[] args) 
	{
		treeBuildOp treeBuildObj = new treeBuildOp();
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputArr = input.split(" ");
		
		int treeHeight = Integer.parseInt(inputArr[0]);
		int vertices = 0;
		if(treeHeight<=15)
		{	
			for(int i = 0; i <= treeHeight;i++)
				vertices = vertices + (int)Math.pow(2, i);
			
			//System.out.println("Nodes: "+vertices);

			//create the tree
			treeBuildObj.buildTree(vertices);
			
			int f = Integer.parseInt(inputArr[1]);
			int s = Integer.parseInt(inputArr[2]);
			
			Node fNode = treeBuildObj.search(f);
			Node sNode = treeBuildObj.search(s);
			
			if((fNode!=null) && (sNode!= null))
			{
				if(fNode.n == sNode.n)//if the two nodes are same then it is the ancestor.
					System.out.println(fNode.n+" "+fNode.height);
				else
					treeBuildObj.findLCA(fNode, sNode);
			}
		}
	}

}


/*
 * 
 * 
 * inOrder(tree.get(0));
 * public void inOrder(Node root)
	{
		if(tree.get(root.leftChildIndex) )//&& (root.rightChildIndex!=-1))
		{
			inOrder(tree.get(root.leftChildIndex));
			System.out.println(root.n);
			inOrder(tree.get(root.rightChildIndex));
		}
	}
	
	for(Node n:tree)
		{
			System.out.print("  Node value:"+ n.n);
			System.out.print("   Left child index:"+n.leftChildIndex);
			System.out.print("   Right child index:"+n.rightChildIndex);
			System.out.print(" Node's parent: "+n.parent);
			System.out.println(" Node's height: "+n.height);
		}
 * 
 */
