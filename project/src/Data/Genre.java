package Data;

import java.util.ArrayList;
import java.util.HashMap;

import DatabaseLoading.DatabaseFactory;

public class Genre {

	private HashMap<Integer,ArrayList<Genre>> genres;
	private String genre;
	private String movieId;
	private ArrayList<String[]> genresList;
	
	public Genre() {
	}
	
	public Genre(String movieId,String genre){
		this.genre=genre;
		this.movieId=movieId;
	}
	
	public void fillGenreHashMap() {
		genres=new HashMap<Integer,ArrayList<Genre>>();
		DatabaseFactory g=new DatabaseFactory();
		genresList=g.allTheGenres();
		for (String[]x:genresList) {
			Genre y=new Genre(x[0],x[1]);
			if(genres.containsKey(Integer.parseInt(x[0]))){
				genres.get(Integer.parseInt(x[0])).add(y);
				genres.put(Integer.parseInt(x[0]),genres.get(Integer.parseInt(x[0])));
			}
			else {
				ArrayList<Genre> z= new ArrayList<Genre>();
				z.add(y);
				genres.put(Integer.parseInt(x[0]),z);
			}
		}
	}
	public HashMap<Integer,ArrayList<Genre>> getGenres (){
		return genres;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getMovieId() {
		return Integer.parseInt(movieId);
	}
	
	public String toString() {
		return genre;
	}
}
