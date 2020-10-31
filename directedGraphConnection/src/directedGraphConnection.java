import java.util.*;

class Node
{
	int label;
	boolean visited;
	
	Node(int label)
	{
		this.label = label;
		this.visited = false;
	}
}

public class directedGraphConnection 
{
	ArrayList<Node> vertexList = new ArrayList<Node>();
	int[][] adjacencyMatrix; 
	int[][] reverseAdjMatrix;
	ArrayList<ArrayList<Integer>> allPaths = new ArrayList<ArrayList<Integer>>();
	
	public Node adjacentNode(Node v, int matrixNo)
	{
		int row = v.label;
		//System.out.println("Here:  "+row);
		for(int j = 0; j < vertexList.size(); j++)
		{
			if(matrixNo == 0)//adjacency Matrix
			{	
				if( (adjacencyMatrix[row][j] == 1) && (vertexList.get(j).visited == false) )
					return vertexList.get(j);
			}	
			else if(matrixNo == 1)//transpose Matrix
			{	
				if( (reverseAdjMatrix[row][j] == 1) && (vertexList.get(j).visited == false) )
				{	
					return vertexList.get(j);
				}
			}
		}
		return null;
	}
	
	public ArrayList<Node> dfs(Node startNode, int matrixNo)
	{
		ArrayList<Node> thisPath = new ArrayList<Node>();
		Stack<Node> sDFS = new Stack<Node>();
		
		sDFS.add(startNode);
		thisPath.add(startNode);
		startNode.visited = true;
		
		while(!sDFS.isEmpty())
		{
			Node v = sDFS.peek();
			
			if(adjacentNode(v, matrixNo)!=null)
			{
				v = adjacentNode(v, matrixNo);
				sDFS.add(v);
				thisPath.add(v);
				v.visited = true;
			}
			else
				sDFS.pop();
		}
		
		return thisPath;
	}
	
	public void vertexListInitialize()
	{
		for(int i = 0; i < vertexList.size(); i++)
			vertexList.get(i).visited = false;
	}
	
	public boolean compareLists(ArrayList<Node> a, ArrayList<Node> b)//both of the same size
	{
		int found = 0;
		
		for(int i = 0; i < a.size(); i++)
		{
			for(int j = 0; j < b.size(); j++)
			{
				if(a.get(i).label == b.get(j).label)
					found++;
			}
		}
		
		if(a.size() == found) return true;
		else return false;
	}
	
	public static void main(String[] args) 
	{
		directedGraphConnection dGraphConnectObj = new directedGraphConnection();  
		
		Scanner sc = new Scanner(System.in);
		int vertexNum = Integer.parseInt(sc.nextLine());
		int edgeNum = Integer.parseInt(sc.nextLine());
		
		dGraphConnectObj.adjacencyMatrix = new int[vertexNum][vertexNum];
		dGraphConnectObj.reverseAdjMatrix = new int[vertexNum][vertexNum];
		
		//create vertex list
		for(int i = 0; i < vertexNum; i++)
		{
			dGraphConnectObj.vertexList.add(new Node(i));
		}
		
		//take input of edges
		for(int i = 0; i < edgeNum; i++)
		{
			ArrayList<Integer> tmpList = new ArrayList<>();
			String line = sc.nextLine();
			String[] lineArr = line.split(" "); 
			
			int start = Integer.parseInt(lineArr[0]);
			int end = Integer.parseInt(lineArr[1]);
			
			dGraphConnectObj.adjacencyMatrix[start][end] = 1;//its a directed graph 		

			dGraphConnectObj.reverseAdjMatrix[end][start] = 1;//for the transpose matrix
		}
		
		//0th Node is starting node.
		//Matrix no is 0 for the adjacency matrix.
		ArrayList<Node> currentPath = dGraphConnectObj.dfs(dGraphConnectObj.vertexList.get(0), 0);
		
		if(currentPath.size() == dGraphConnectObj.vertexList.size())
			System.out.println(dGraphConnectObj.compareLists(currentPath, dGraphConnectObj.vertexList));
			//print true OR false.
		else
			System.out.println("false");
		
		
		dGraphConnectObj.vertexListInitialize();//set visited to false.
		
		currentPath.clear();
		//3rd Node is starting node.
		currentPath = dGraphConnectObj.dfs(dGraphConnectObj.vertexList.get(0), 1);
		//call dfs with transpose matrix.
		
		
		
		if(currentPath.size() == dGraphConnectObj.vertexList.size())
			System.out.println(dGraphConnectObj.compareLists(currentPath, dGraphConnectObj.vertexList));
			//print true OR false.
		else
			System.out.println("false");
		
		
		
		sc.close();
	}

}








/*
 * public void bfs(Node sNode)
	{
		ArrayList<Node> thisPath = new ArrayList<Node>();
		Queue<Node> qBFS = new LinkedList<Node>();
		
		qBFS.add(sNode);
		sNode.visited = true;
		
		while(!qBFS.isEmpty())
		{
			Node n = qBFS.remove();
			thisPath.add(n);
			
			while(true)
			{
				Node v = adjacentNode(n);
				if(v == null) break; //no more unvisited adjacent nodes.
				else
				{
					qBFS.add(v);
					v.visited = true;
				}
			}
		}
		
		for(int i = 0; i < thisPath.size(); i++)
			System.out.print("   "+thisPath.get(i).label);
	}
	
		for(int i = 0; i < dGraphConnectObj.adjacencyMatrix.length; i++)
		{
			for(int j = 0; j < dGraphConnectObj.adjacencyMatrix[i].length; j++)
			{
				System.out.print("  "+dGraphConnectObj.adjacencyMatrix[i][j]);
			}
			System.out.println();
		}

	
	
	for(int i = 0; i < dGraphConnectObj.adjacencyMatrix.length; i++)
		{
			for(int j = 0; j < dGraphConnectObj.adjacencyMatrix[i].length; j++)
			{
				System.out.print("  "+dGraphConnectObj.adjacencyMatrix[i][j]);
			}
			System.out.println();
		}
		
		
	for(int i = 0; i < dGraphConnectObj.reverseAdjMatrix.length; i++)
		{
			for(int j = 0; j < dGraphConnectObj.reverseAdjMatrix[i].length; j++)
			{
				System.out.print("  "+dGraphConnectObj.reverseAdjMatrix[i][j]);
			}
			System.out.println();
		}
			
	for(int i = 0; i < currentPath.size(); i++)
		{
			System.out.println(" f "+currentPath.get(i).label);
		}
	
	for(int i = 0; i < currentPath.size(); i++)
		{
			System.out.println(" s "+currentPath.get(i).label);
		}
	
	
 */











