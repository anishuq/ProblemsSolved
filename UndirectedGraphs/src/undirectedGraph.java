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
	Stack<vertex> sDFS = new Stack<>();//stack for DFS.
	
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
	
	
	public void DFS(vertex v)//its the starting vertex
	{
		v.visited = true;
		displayVertex(v);
		sDFS.push(v);
		
		while( !sDFS.isEmpty() )
		{
			vertex topVertex = sDFS.peek();//get the top vertex (not remove)
			vertex tmpVertex = 	getAdjacentUnvisitedVertex(topVertex);//get the adjacent
												//vertices of top vertex.
			
			if( tmpVertex!= null)
			{
				tmpVertex.visited = true;
				displayVertex(tmpVertex);
				sDFS.push(tmpVertex);
			}
			else
				sDFS.pop();
		}
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

public class undirectedGraph 
{
	List<vertex> vertexList = new ArrayList<>();
	
	public static void main(String[] args) 
	{
		undirectedGraph undireGraphObj = new undirectedGraph();
		
		graphOp graphOBj = new graphOp();
		
		int vertexListSize = 0;	
																   //index
		undireGraphObj.vertexList = graphOBj.addVertex(new vertex(0, 'A', false));//0
		vertexListSize++;
		
		undireGraphObj.vertexList = graphOBj.addVertex(new vertex(1, 'B', false));//1
		vertexListSize++;
		
		undireGraphObj.vertexList = graphOBj.addVertex(new vertex(2, 'C', false));//2
		vertexListSize++;
		
		undireGraphObj.vertexList = graphOBj.addVertex(new vertex(3, 'D', false));//3
		vertexListSize++;
		
		undireGraphObj.vertexList = graphOBj.addVertex(new vertex(4, 'E', false));//4
		vertexListSize++;
		
		graphOBj.initializeMatrix(vertexListSize);
		
     	graphOBj.addEdge(0, 1);
     	graphOBj.addEdge(1, 2);
     	graphOBj.addEdge(0, 3);
     	graphOBj.addEdge(3, 4);
     	
     	//graphOBj.display();
     	graphOBj.DFS(undireGraphObj.vertexList.get(0));
	}

}



/*
public void display()
{   
	for(int i = 0; i < adjacencyMatrix.length; i++)
	{	
		for(int j = i; j < adjacencyMatrix[i].length; j++)
		{
			if(adjacencyMatrix[i][j] == 1)
			{
				System.out.println(vertexList.get(i).label+" is connected to  "+vertexList.get(j).label+"  ");
			}
		}
	//System.out.println();
	}
}
*/



