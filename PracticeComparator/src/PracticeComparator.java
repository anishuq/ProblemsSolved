import java.util.*;

class Music
{
	String artist;
	String album;
	Integer copiesSold;
	
	Music(String artist, String album, Integer copiesSold)
	{
		this.artist = artist;
		this.album = album;
		this.copiesSold = copiesSold;
	}
	
	public String getArtist()
	{
		return this.artist;
	}
	public String getAlbum()
	{
		return this.album;
	}
	public Integer getSales()
	{
		return this.copiesSold;
	}
}

class albumComparator implements Comparator<Music>
{
	public int compare(Music m1, Music m2)
	{
		return m1.album.compareTo(m2.album);
	}
}

class salesComparator implements Comparator<Music>
{
	public int compare(Music m1, Music m2)
	{
		if(m1.copiesSold > m2.copiesSold) return 1;
		else if (m1.copiesSold < m2.copiesSold) return -1;
		return 0;
	}
}


public class PracticeComparator 
{
	public static void main(String[] args) 
	{
		ArrayList<Music> listMusic = new ArrayList<Music>();
		listMusic.add(new Music("Eagles", "Their Greatest Hits 1971 - 1975", 3800000) );
		listMusic.add(new Music("Michael Jackson", "Thriller", 3300000) );
		listMusic.add(new Music("Eagles", "Hotel California", 2600000) );
		listMusic.add(new Music("Billy Joel", "Greatest Hits Volume I and II", 2300000 ) );
		listMusic.add(new Music("Led Zeppelin", "Led Zeppelin IV", 2300000) );
		listMusic.add(new Music("Pink Floyd", "The Wall", 2200000) );
		listMusic.add(new Music("AC/DC", "Back in Black", 2100000 ) );
		listMusic.add(new Music("Hootie and the Blowfish", "Cracked Rear View", 200000) );
		
		
		Collections.sort(listMusic, new albumComparator());
		for(Music m : listMusic)
			System.out.println(" Artist: "+m.artist+"  Album: "+m.album+"  Sales: "+m.copiesSold);
		
		System.out.println("==============================================================");
		
		Collections.sort(listMusic, new salesComparator());
		for(Music m : listMusic)
			System.out.println(" Artist: "+m.artist+"  Album: "+m.album+"  Sales: "+m.copiesSold);
	}

}
