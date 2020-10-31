import java.util.*;

class Person
{
	String name;
	
	Person pNode;
	Person leftChild;
	Person rightChild;
	
	Person(String name)
	{
		this.name = name;
		this.leftChild = null;
		this.rightChild = null;
	}
}

class familyTreeOp 
{
	Person root = null;
	Person current = null;
	Person parent = null;
	String trueFalseResult = "";
	
	public Person createTree(Person p, Person c)
	{
		if(root == null)
		{	
			root = p;
			root.leftChild = c;
			c.pNode = root;
			
			root.pNode = null;// root does not have any parent. 
		}	
		else
		{
			Person parent = BFS(root, p); //locate parent p.
			if(parent!= null)
			{	
				if(parent.leftChild == null)
				{	
					parent.leftChild = c;
					c.pNode = parent; 
				}	
				else
				{
					parent.rightChild = c;
					c.pNode = parent;
				}
			}
		}
		
		return root;
	}
	
	public void searchTree(Person localRoot, String fNode, String func, String sNode)
	{
		//"Sanjay child Indira"
		if(func.compareTo("child") == 0)
		{
			String child = fNode;
			Person parent = searchTree(localRoot, sNode);
			if(parent!= null)
			{
				if( (parent.leftChild!=null) && (parent.leftChild.name.compareTo(child)) == 0)
					trueFalseResult = trueFalseResult +"T ";
				else if( (parent.rightChild!=null) &&  (parent.rightChild.name.compareTo(child) == 0)  )
					trueFalseResult = trueFalseResult +"T ";
				else
					trueFalseResult = trueFalseResult +"F ";
			}
		}
		
		//Sanjay ancestor Varun
		if(func.compareTo("ancestor") == 0)
		{
			//fNode is the ancestor
			Person ancestor = searchTree(localRoot, fNode);
			if(ancestor!=null)
			{
				Person descendant = searchTree(ancestor, sNode);
				if(descendant!=null)
					trueFalseResult = trueFalseResult +"T ";
				else
					trueFalseResult = trueFalseResult +"F ";
			}
		}
		//Varun descendant Indira
		if(func.compareTo("descendant") == 0)
		{
			//sNode is the ancestor. fNode is the descendant 
			Person ancestor = searchTree(localRoot, sNode);
			if(ancestor!=null)
			{
				Person descendant = searchTree(ancestor, fNode);
				if(descendant!=null)
					trueFalseResult = trueFalseResult +"T ";
				else
					trueFalseResult = trueFalseResult +"F ";
			}
		}
		//Priyanka sibling Varun
		if(func.compareTo("sibling") == 0)
		{
			Person fSib = searchTree(localRoot, fNode);
			Person secSib = searchTree(localRoot, sNode);
			
			if((fSib!=null) && (secSib!=null))
			{
				if(fSib.pNode.name.compareTo(secSib.pNode.name) == 0)
					trueFalseResult = trueFalseResult +"T ";
				else
					trueFalseResult = trueFalseResult +"F ";
				
			}
		}
	}
	
	public Person searchTree(Person localRoot, String name)
	{
		Queue<Person> qSearch = new LinkedList<>();
		
		if(localRoot!=null)
		{
			qSearch.add(localRoot);
		}
		
		while(!qSearch.isEmpty())
		{
			Person p = qSearch.remove();
			if(p.name.compareTo(name) == 0)
			{	
				qSearch = null;//reset the queue before return.
				return p;
			}
			if(p.leftChild!=null)
				qSearch.add(p.leftChild);
			
			if(p.rightChild!=null)
				qSearch.add(p.rightChild);
		}
		
		qSearch = null;//reset the queue before return. 
		return null;
	}
	
	
	public Person BFS(Person localRoot, Person findNode)//findNode is a parent node
	{
		Queue<Person> qBFS = new LinkedList<>();
		Person p = null;
		
		if(localRoot!=null)
		{
			qBFS.add(localRoot);
		}
		
		while(!qBFS.isEmpty())
		{
			Person tmpPerson = qBFS.remove();
			if(tmpPerson.name.compareTo(findNode.name) == 0)
			{	
				p = tmpPerson;
			}
				
			if(tmpPerson.leftChild!=null)
				qBFS.add(tmpPerson.leftChild);
			
			if(tmpPerson.rightChild!=null)
				qBFS.add(tmpPerson.rightChild);
		}
		
		qBFS = null; //reset the QUEUE.
		return p;
	}
	
	public void preorderTraversal(Person localRoot)
	{
		if(localRoot!=null)
		{
			System.out.print(localRoot.name+" ");
			preorderTraversal(localRoot.leftChild);
			preorderTraversal(localRoot.rightChild);
		}
	}
	
}

public class familyTree {
	
	public static void main(String[] args) 
		{
		Person root = null;
		familyTreeOp familyTreeObj = new familyTreeOp(); 
		familyTree buildTreeObj = new familyTree();
		
		Scanner sc = new Scanner(System.in);
		int nDataSets = Integer.parseInt(sc.nextLine());
		int i = 0;
		ArrayList<ArrayList<String>> familyData =  new ArrayList<ArrayList<String>>(); 
		while(i<nDataSets)
		{
			String line = sc.nextLine();
			String[] lineArr = line.split(" ");
			
			ArrayList<String> tmpList = new ArrayList<String>();
			tmpList.add(lineArr[0]);
			tmpList.add(lineArr[1]);
			
			familyData.add(tmpList);
			i++;
		}
		
		for(int j = 0; j < familyData.size(); j++)
		{
			Person p = new Person(familyData.get(j).get(0));
			Person c = new Person(familyData.get(j).get(1));
			root = familyTreeObj.createTree(p, c);
		}

		int outputSets = Integer.parseInt(sc.nextLine());
		ArrayList<ArrayList<String>> outputData =  new ArrayList<ArrayList<String>>(); 
		int k = 0;
		while(k < outputSets)
		{
			String outputLine = sc.nextLine();
			String[] lineArr = outputLine.split(" ");
			
			ArrayList<String> oTmpList = new ArrayList<String>();
			for(String s: lineArr)
				oTmpList.add(s);
			
			outputData.add(oTmpList);
			k++;
		}
		
		//output T/F.
		
		for(int l = 0; l < outputData.size(); l++)
		{
			familyTreeObj.searchTree(root, outputData.get(l).get(0), outputData.get(l).get(1), outputData.get(l).get(2) );
		}
		
		System.out.println(familyTreeObj.trueFalseResult.trim());
		
		familyTreeObj.preorderTraversal(root);
		sc.close();
	}

}




























/*
 * public ArrayList<ArrayList<String>> familySort (ArrayList<ArrayList<String>> fData, int nData)
	{
		int size = fData.size();
		ArrayList<ArrayList<String>> sortedData =  new ArrayList<ArrayList<String>>();
		//process root(start)
		String rootName = fData.get(0).get(0);
		for(int i = 0; i < fData.size(); i++)
		{
			if(fData.get(i).get(0).contains(rootName))
			{	
				sortedData.add( fData.get(i) );
			}
		}
		//process root(end)
		
		for(int i = 0; i <  nData; i++) //for sortedData
		{	
			for(int j = 0; j < fData.size(); j++)
			{
				if(sortedData.get(i).get(1).compareTo( fData.get(j).get(0) ) == 0)
				{
					sortedData.add(fData.get(j));
				}
			}
		}
		
		return sortedData;
		//System.out.println(fData);
	}
 */

