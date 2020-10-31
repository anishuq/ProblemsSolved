import java.util.*;

class Movies implements Comparable<Movies>
{
	String name;
	Integer year;
	Double rating;
	
	Movies(String name, Integer year, Double rating)
	{
		this.name = name;
		this.year = year;
		this.rating = rating;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Integer getYear()
	{
		return this.year;
	}
	
	public Double getRating()
	{
		return this.rating;
	}
	
	/*
	public int compareTo(Movies m)
	{
		
		//if(this.year >= m.year) return 1; //positive
		//else if (this.year == m.year) return 0;
		//else if (this.year < m.year) return -1; //negative
		
		//the same as above
		return this.year - m.year;
	}
	*/
	public int compareTo(Movies m)
	{
		return this.name.compareTo(m.name);
	}
}
public class PracticeCompareObjects {

	public static void main(String[] args) 
	{
		ArrayList<Movies> listMovies = new ArrayList<Movies>();
		listMovies.add(new Movies("Star Wars: Episode VII - The Force Awakens", 2015, 8.7) );
		listMovies.add(new Movies("Avatar", 2009, 7.8) );
		listMovies.add(new Movies("Black Panther", 2018, 7.1) );
		listMovies.add(new Movies("Avengers: Infinity War", 2018, 9.1) );
		listMovies.add(new Movies("Titanic", 1997, 6.7) );
		
		Collections.sort(listMovies);
		
		for(Movies m : listMovies)
			System.out.println(" Name: "+m.name+"  Year: "+m.year+"  Rating "+m.rating);
		
		System.out.println("==============================================================");
		
		Collections.reverse(listMovies);
		
		for(Movies m : listMovies)
			System.out.println(" Name: "+m.name+"  Year: "+m.year+"  Rating "+m.rating);

	}

}
