import java.io.*;
import java.util.*;

class fileInputTest
{
	public void fileInputScanner()
	{
		Scanner sc = null;
		FileWriter fout = null;
		FileReader fin = null;
		try
		{
			fout = new FileWriter("input.txt");
			//if file doesn't exist, it creates.
			fout.write("2 5.5 3.6 90 3 done");
			fout.close();
			
			fin = new FileReader("input.txt");
			sc = new Scanner(fin);
		}
		catch(Exception e)
		{
			System.out.println(""+e.toString());
		}
		
		double sum = 0.0;
		int count = 0, n = 0;
		double n_d = 0.0;
		boolean flag = true; 
		
		while(sc.hasNext())
		{
			if(sc.hasNextDouble())
			{
				System.out.println("Input");
				sum = sum + sc.nextDouble();
				count++;
			}
			else if(sc.hasNextLine()) 
			{	
				String t = sc.nextLine().trim();
				if(t.compareTo("done") == 0) System.out.println("VVVVVVVV"); 
				break;
			}
		}
		
		if(flag == true)
		{
			System.out.println("Total: "+sum);
			System.out.println("Average: "+sum/count);
		}
		
		sc.close();
	}
	
	public void fileInputSTringDelimeter()
	{
		Scanner sc = null;
		FileWriter fout = null;
		FileReader fin = null;
		try
		{
			fout = new FileWriter("input2.txt");
			//if file doesn't exist, it creates.
			fout.write("2, 5.5, 3.6, 90, 3, done");
			fout.close();
			
			fin = new FileReader("input2.txt");
			sc = new Scanner(fin);
		}
		catch(Exception e)
		{
			System.out.println(""+e.toString());
		}
		
		double sum = 0.0;
		int count = 0, n = 0;
		double n_d = 0.0;
		boolean flag = true; 
		sc.useDelimiter(", *");
		
		while(sc.hasNext())
		{
			if(sc.hasNextDouble())
			{
				System.out.println("Input");
				sum = sum + sc.nextDouble();
				count++;
			}
			else if(sc.hasNextLine()) 
			{	
				String t = sc.nextLine().trim();
				if(t.compareTo("done") == 0) System.out.println("VVVVVVVV"); 
				break;
			}
		}
		
		if(flag == true)
		{
			System.out.println("Total: "+sum);
			System.out.println("Average: "+sum/count);
		}
		
		sc.close();
	}
	
	public void findPattern()
	{
		Scanner sc = null;
		FileWriter fout = null;
		FileReader fin = null;
		try
		{
			fout = new FileWriter("input3.txt");
			//if file doesn't exist, it creates.
			fout.write("Name: Anisul Huq, Age: 38, Profession: Student @ Concordia");
			fout.close();
			
			fin = new FileReader("input3.txt");
			sc = new Scanner(fin);
		}
		catch(Exception e)
		{
			System.out.println(""+e.toString());
		}
		
		sc.useDelimiter(",");
		sc.findInLine("Profession:");
		
		if(sc.hasNext())
			System.out.println(""+sc.next().trim());
		else
			System.out.println("Not Found!");
	}
	
}

public class InputTesting {

	public static void main(String[] args) 
	{
		//fileInputTest fi = new fileInputTest();
		//fi.fileInputScanner();
		//fi.fileInputSTringDelimeter();
		//fi.findPattern();
		//for keyboard input 
		/*
		Scanner sc = new Scanner(System.in);
		
		double sum = 0.0;
		int count = 0, n = 0;
		double n_d = 0.0;
		boolean flag = true; 
		
		System.out.println("Provide inputs: press \"done\" to exit");
		while(sc.hasNext())
		{
			if(sc.hasNextInt())
			{
				n = sc.nextInt();
				sum = sum + n;
				count++;
			}
			else if(sc.hasNextDouble())
			{
				n_d = sc.nextDouble();
				sum = sum + n_d;
				count++;
			}
			else if(sc.nextLine().equals("done")) break;
			else
			{
				System.out.println("Format Error!");
				flag = false;
				break;
			}
		}
		
		if(flag == true)
		{
			System.out.println("Total:  "+sum);
			System.out.println("Average:  "+sum/count);
		}
		sc.close();
		*/
		
		ContinousInputs ContinousObj = new ContinousInputs();
		ContinousObj.takeInput();
	}

}
