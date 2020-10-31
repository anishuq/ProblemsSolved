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

public class graphConnectivity 
{
	int vertexNum;
	ArrayList<ArrayList<String>> inputLines = new ArrayList<ArrayList<String>>();
	ArrayList<Node> vertexList;
	int[][] adjacencyMatrix;
	Stack<Node> dfsStack = new Stack<Node>();//for dfs 
	
	public Node getAdjUnvisitedVertex(Node v)
	{
		int row = v.label;
		for(int j = 0; j < vertexList.size(); j++)
		{
			if((adjacencyMatrix[row][j] == 1) && (vertexList.get(j).visited == false))
				    return vertexList.get(j);
		}

		return null;//if NOT found.
	}
	
	public ArrayList<Node> dfs(Node startNode)
	{
		ArrayList<Node> pathTaken = new ArrayList<>();
		startNode.visited = true;//we start from node 1.
		pathTaken.add(startNode);
		//System.out.println("Node label:  "+startNode.label);
		dfsStack.push(startNode);
		
		while(!dfsStack.isEmpty())
		{
			Node v = getAdjUnvisitedVertex( dfsStack.peek() );
			if(v!=null)
			{
				dfsStack.push(v);
				pathTaken.add(v);
				//System.out.println(v.label);
				v.visited = true;
			}
			else
			{
				dfsStack.pop();
			}
		}
		
		return pathTaken;
	}
	
	public boolean compareLists(List<Node> a, List<Node> b)
	{
		int found = 0;
		for(int i = 0; i < a.size(); i++)
		{
			for(int j = 0; j < b.size(); j++)
			{
				if(a.get(i).label == b.get(j).label)
				{	
					found++;
					break;
				}
			}
		}
		
		if(found == a.size()) return true;
		else return false;
	}
	
	public void initializeVisited(List<Node> verList)
	{
		for(int i = 0; i < verList.size(); i++)
		{
			verList.get(i).visited = false;
		}
	}
	
	
	public int connectedComponents(ArrayList<ArrayList<Node>> allPaths)
	{
		int uniqueComp = 1;
		int noMatch = 0;
		for(int i = 1; i < allPaths.size(); i++)
		{
			//debugDisplay(allPaths.get(i));
			for(int j = 0; j < i; j++)
			{
				//debugDisplay(allPaths.get(j));
				if(!compareLists(allPaths.get(i), allPaths.get(j))) 
						noMatch++;
			}
			
			if(noMatch == (i - 1) ) uniqueComp++; 
			
			noMatch = 0;
	
		}
		return uniqueComp;
	}
	
	public static void main(String[] args) 
	{
		graphConnectivity graphConnectObj = new graphConnectivity();
		Scanner sc = new Scanner(System.in);
		graphConnectObj.vertexNum = Integer.parseInt(sc.nextLine());
		int edgeNum = Integer.parseInt(sc.nextLine());
		graphConnectObj.adjacencyMatrix = new int[graphConnectObj.vertexNum][graphConnectObj.vertexNum];
		
		
		for(int i = 0; i<edgeNum; i++)
		{
			String tmpLine = sc.nextLine();
			String[] lineArr = tmpLine.split(" ");
			
			ArrayList<String> tmpString = new ArrayList<String>();
			tmpString.add(lineArr[0]);
			tmpString.add(lineArr[1]);

			graphConnectObj.inputLines.add(tmpString);
		}

		//vertex initialization
		graphConnectObj.vertexList = new ArrayList<Node>(); 
		for(int i = 0; i < graphConnectObj.vertexNum; i++)
			graphConnectObj.vertexList.add(new Node(i));
		
		for(int i = 0; i < graphConnectObj.inputLines.size(); i++)
		{
			int start = Integer.parseInt(graphConnectObj.inputLines.get(i).get(0));
			int end = Integer.parseInt(graphConnectObj.inputLines.get(i).get(1));
			
			graphConnectObj.adjacencyMatrix[start - 1][end - 1] = 1;
			graphConnectObj.adjacencyMatrix[end - 1][start -1] = 1; //its an undirected graph.
		}   //its a 0,1 matrix.
			//added the edges.
		
		ArrayList<Node> thisPath = graphConnectObj.dfs(graphConnectObj.vertexList.get(1));
		
		//for comparing two ArrayLists
		if( graphConnectObj.compareLists(graphConnectObj.vertexList, thisPath) )
			System.out.print("1");
		else
			System.out.print("0"); //Not Connected
		
		
		//connected components. Run DFS for each vertex. //////////////////////
		ArrayList<ArrayList<Node>> allPath = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i < graphConnectObj.vertexList.size(); i++)
		{
			//initialize "visited" to false.
			graphConnectObj.initializeVisited(graphConnectObj.vertexList);
			thisPath = graphConnectObj.dfs(graphConnectObj.vertexList.get(i));
			allPath.add(thisPath);
		}
		
		int connectedComp = graphConnectObj.connectedComponents(allPath);
		System.out.print(" "+connectedComp);
		
		sc.close();
	}

}
/*
1 2
2 3
3 4
2 4
1 3
2 8
5 7
6 7
5 6 
*/


/*
Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<Integer, ArrayList<Integer>>();

for(int i = 0; i < adjacencyMatrix.length; i++ )
{
	ArrayList<Integer> tmpRowData = new ArrayList<Integer>();
	for(int j = 0; j < adjacencyMatrix[i].length; j++ )
	{
		if(adjacencyMatrix[i][j] != 0)
		{
			tmpRowData.add(j);
			adjacencyList.put(i, tmpRowData);
		}
	}
}
System.out.println(adjacencyList);

		//for(int j = 0; j < thisPath.size(); j++)
			//	System.out.print(thisPath.get(j).label);
			 * 
			 * 
			 * 
			 * 
			 * int uniqueComp = 1;
		int noMatch = 0;
		for(int i = 1; i < allPaths.size(); i++)
		{
			debugDisplay(allPaths.get(i));
			for(int j = 0; j < i; j++)
			{
				debugDisplay(allPaths.get(j));
				if(!compareLists(allPaths.get(i), allPaths.get(j))) 
						noMatch++;
				
			}
			
			if(noMatch == (i - 1) ) uniqueComp++; 
			
			noMatch = 0;
	
		}
		System.out.println("Comp:  "+uniqueComp);


for(int i = 0; i < allPaths.size(); i++ )
		{
			for(int j = 0; j < allPaths.get(i).size(); j++ )
			{
				System.out.print(allPaths.get(i).get(j).label);
			}
			
			System.out.println();
		}


	public void debugDisplay(ArrayList<Node> d)
	{
		for(int i = 0; i < d.size(); i++)
		{
			System.out.print("  "+d.get(i).label);
		}
		System.out.println();
	}
	

*
*
*/










