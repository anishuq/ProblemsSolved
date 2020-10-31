import java.util.*;

class vertex //Node
{
	int index;
	char label;
	boolean visited;
	
	vertex(int index, char label, boolean visited)
	{
		this.index = index;
		this.label = label;
		this.visited = visited;
	}
}

class graphOp
{
	Queue<vertex> qBFS = new LinkedList<>();//Queue for BFS.
	
	List<vertex> vertexList = new ArrayList<>();
	int[][] adjacencyMatrix;
	
	public void initializeMatrix(int size)
	{   
		adjacencyMatrix = new int[size][size];
		//set the adjacency matrix to 0.  
		for(int i = 0; i < adjacencyMatrix.length; i++)
			for(int j = 0; j < adjacencyMatrix[i].length; j++)
				adjacencyMatrix[i][j] = 0;
	}
	
	
	public List<vertex> addVertex(vertex v)
	{
		vertexList.add(v);
		return vertexList; 
	}
	
	public void addEdge(int rVertex, int cVertex)
	{
		//this is an undirected graph.
		adjacencyMatrix[rVertex][cVertex] = 1;
		adjacencyMatrix[cVertex][rVertex] = 1;
	}
	
	public void BFS(vertex v)//its the starting vertex
	{
		vertex tmpVertex = v;
		vertex frontVertex = v;
		//qBFS.add(v);
		displayVertex(v);
		v.visited = true;
		
		do
		{
			if(tmpVertex == null)
				frontVertex = qBFS.poll();
			
			tmpVertex = getAdjacentUnvisitedVertex(frontVertex);
			
			if(tmpVertex!= null)
			{
				qBFS.add(tmpVertex);
				displayVertex(tmpVertex);
				tmpVertex.visited = true;
			}
		}while(!qBFS.isEmpty());
		
	}
	
	public vertex getAdjacentUnvisitedVertex(vertex v)
	{
		int row = v.index;
		for(int j = 0; j < adjacencyMatrix[row].length; j++)
		{	
			if( (adjacencyMatrix[row][j] == 1) && (vertexList.get(j).visited == false ) )  
				return vertexList.get(j);  
		}
		return null;
	}
	
	public void displayVertex(vertex v)//its the starting vertex
	{
		System.out.println("visited:  "+v.label);		
	}
}
public class graphBFS {

	List<vertex> vertexList = new ArrayList<>();
	
	public static void main(String[] args) 
	{
		graphBFS bfsObj = new graphBFS();
		
		graphOp graphOBj = new graphOp();
																   
		bfsObj.vertexList = graphOBj.addVertex(new vertex(0, 'A', false));
		bfsObj.vertexList = graphOBj.addVertex(new vertex(1, 'B', false));
		bfsObj.vertexList = graphOBj.addVertex(new vertex(2, 'C', false));
		bfsObj.vertexList = graphOBj.addVertex(new vertex(3, 'D', false));
		bfsObj.vertexList = graphOBj.addVertex(new vertex(4, 'E', false));
		
		graphOBj.initializeMatrix(bfsObj.vertexList.size());
	
		graphOBj.addEdge(0, 1);
     	graphOBj.addEdge(1, 2);
     	graphOBj.addEdge(0, 3);
     	graphOBj.addEdge(3, 4);
		
     	
     	graphOBj.BFS(bfsObj.vertexList.get(0));
	}

}
