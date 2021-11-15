package Data;

import java.util.ArrayList;
import java.util.HashMap;

import DatabaseLoading.DatabaseFactory;

public class Director {

	private HashMap<Integer,ArrayList<Director>> directors;
	private ArrayList<String[]> directorsList;
	private String movieId;
	private String directorId;
	private String directorName;
	
	public Director() {
	}
	
	public Director(String movieId,String directorId,String directorName) {
		this.movieId=movieId;
		this.directorId=directorId;
		this.directorName=directorName;
	}
	public void fillDirectrosHashMap() {
		directors=new HashMap<Integer,ArrayList<Director>>();
		DatabaseFactory d=new DatabaseFactory();
		directorsList=d.allTheDirectors();
		for (String[]x:directorsList) {
			Director y=new Director(x[0],x[1],x[2]);
			if(directors.containsKey(Integer.parseInt(x[0]))){
				directors.get(Integer.parseInt(x[0])).add(y);
				directors.put(Integer.parseInt(x[0]),directors.get(Integer.parseInt(x[0])));
			}
			else {
				ArrayList<Director> z= new ArrayList<Director>();
				z.add(y);
				directors.put(Integer.parseInt(x[0]),z);
			}
		}
	}
	public HashMap<Integer,ArrayList<Director>> getDirectors (){
		return directors;
	}
	public String getDirectorName() {
		return directorName;
	}
	
	public String toString() {
		return directorName;
	}
	
	public int getMovieId() {
		return Integer.parseInt(movieId);
	}
}