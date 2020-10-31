import java.util.*;

class vertex
{
	int label;
	boolean isVisited;
	
	vertex(int label)
	{
		this.label = label;
		this.isVisited = false;
	}
}

class graphConnectionOp
{
	ArrayList<vertex> vertexList = new ArrayList<vertex>();
	int[][] adjacencyMatrix; 
	int vertices;
	
	graphConnectionOp(ArrayList<vertex> vertexList, int vertices)
	{
		this.vertices = vertices;
		this.vertexList = vertexList;
		this.adjacencyMatrix = new int[vertices][vertices];
	}
	
	public void addEdge(int row, int col)
	{
		this.adjacencyMatrix[row][col] = 1;
		this.adjacencyMatrix[col][row] = 1;
	}
	
	public void graphgraphConnection()
	{
		ArrayList<vertex> dfsPath = dfs(vertexList.get(0));
		if(dfsPath.size() == vertexList.size())
		{	
			System.out.println("1 1");
		}
		else
		{	
			dfsPath.clear();
			System.out.print("0");
			HashMap<Integer, ArrayList<Integer>> allPaths = new HashMap<>(); 
			//do dfs for each vertex and put it in a HasMap.
			for(int i = 0; i < this.vertices; i++)	
			{	
				dfsPath = dfs(vertexList.get(i));
				//take the labels only.
				ArrayList<Integer> labelList = new ArrayList<Integer>(); 
				for(int j = 0; j < dfsPath.size(); j++)
				{
					labelList.add(dfsPath.get(j).label);
				}
				Collections.sort(labelList);
				
				allPaths.put(i, labelList);
			}	
			
			//look in the map for duplicate paths
			for(int i = 0; i < vertices; i++)
			{
				for(int j = i + 1; j < vertices; j++)
				{
					if( (allPaths.get(i)!=null) && (allPaths.get(j)!= null) )
					{
						if(equalLists(allPaths.get(i), allPaths.get(j)))
						{	
							allPaths.put(j, null);//duplicate paths are made NULL.
						}
					}
				}
			}
			
			int count = 0;
			for(int i = 0; i < vertices; i++)
			{
				if(allPaths.get(i)!=null) count++;
			}
			System.out.print(" "+count);
		}
	}
	
	public boolean equalLists(List<Integer> a, List<Integer> b)
	{     
	    if (a == null && b == null) return true;

	    if ((a == null && b!= null) || (a != null && b== null) || (a.size() != b.size()))
	    {
	        return false;
	    }

	    // Sort and compare the two lists          
	    Collections.sort(a);
	    Collections.sort(b);      
	    return a.equals(b);
	}

	
	
	
	public vertex getAdjVertices(vertex v)
	{
		int row = v.label;
		for(int j = 0; j < vertices; j++)
		{
			if((adjacencyMatrix[row][j] == 1) && (vertexList.get(j).isVisited == false))
				return vertexList.get(j);
		}
		
		return null;
	}
	
	public ArrayList<vertex> dfs(vertex start)
	{
		ArrayList<vertex> path =  new ArrayList<vertex>();
		path.clear();
		
		Stack<vertex> dfsStack = new Stack<vertex>();
		dfsStack.add(start);
		path.add(start);
		//System.out.println("Label: "+(start.label + 1));
		start.isVisited = true;
		
		while(!dfsStack.isEmpty())
		{
			vertex v = dfsStack.peek();
			vertex adjV = getAdjVertices(v);
			if(adjV == null)
			{
				dfsStack.pop();
			}
			else
			{
				dfsStack.add(adjV);
				path.add(adjV);
				//System.out.println("Label: "+(adjV.label + 1));
				adjV.isVisited = true;
			}
		}
		
		//add to path.
		/*
		for(int i = 0; i < vertices; i++)
		{
			if(vertexList.get(i).isVisited == true)
				path.add(vertexList.get(i));
		}
		*/
		//reset the vertices.
		for(int i = 0; i < vertices; i++)
		{
			vertexList.get(i).isVisited = false;
		}
		
		return path;
	}
	
	public ArrayList<vertex> bfs(vertex start)
	{
		ArrayList<vertex> path =  new ArrayList<vertex>();
		
		Queue<vertex> bfsQueue = new LinkedList<>();
		bfsQueue.add(start);
		//System.out.println("Label: "+(start.label + 1));
		start.isVisited = true;
		
		while(!bfsQueue.isEmpty())
		{
			vertex v = bfsQueue.remove();
			vertex adjV = getAdjVertices(v);
			if(adjV != null)
			{
				bfsQueue.add(adjV);
				adjV.isVisited = true;
			}
		}
		
		//add to path.
		for(int i = 0; i < vertices; i++)
		{
			if(vertexList.get(i).isVisited == true)
				path.add(vertexList.get(i));
		}
		
		//reset the vertices.
		for(int i = 0; i < vertices; i++)
		{
			vertexList.get(i).isVisited = false;
		}
		
		return path;
	}
	
}

public class undirectedConnectedGraph 
{
	int[][] adjacencyMatrix;
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		//assign labels to vertices.
		ArrayList<vertex> vertexList = new ArrayList<vertex>();
		for(int i = 0; i < vertices; i++)
		{	
			vertexList.add( new vertex(i));
		}
		
		graphConnectionOp graphConnectionObj = new graphConnectionOp(vertexList, vertices);
		int edges = Integer.parseInt(sc.nextLine());

		int i = 0;
		while(i < edges)
		{
			String tmp = sc.nextLine();
			String[] edgeLine = tmp.split(" "); 
			int row = Integer.parseInt(edgeLine[0]) - 1;
			int col = Integer.parseInt(edgeLine[1]) - 1;
			
			graphConnectionObj.addEdge(row, col);
						
			i++;
		}
		
		graphConnectionObj.graphgraphConnection();
		
		sc.close();
	}

}


