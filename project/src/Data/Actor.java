package Data;

import java.util.ArrayList;
import java.util.HashMap;

import DatabaseLoading.DatabaseFactory;

public class Actor {
	
	private HashMap<Integer,ArrayList<Actor>> actors;
	private ArrayList<String[]> actorsList;
	private String movieId;
	private String actorId;
	private String actorName;
	private String ranking;
	
	public Actor(){
	}
	
	public Actor(String movieId,String actorId,String actorName,String ranking) {
		this.movieId=movieId;
		this.actorId=actorId;
		this.actorName=actorName;
		this.ranking=ranking;
	}
	
	public void fillActorsHashMap() {
		actors=new HashMap<Integer,ArrayList<Actor>>();
		DatabaseFactory a=new DatabaseFactory();
		actorsList=a.allTheActors();
		for(String[] x:actorsList){
			Actor y=new Actor(x[0],x[1],x[2],x[3]);
			if(actors.containsKey(Integer.parseInt(x[0]))){
				actors.get(Integer.parseInt(x[0])).add(y);
				actors.put(Integer.parseInt(x[0]),actors.get(Integer.parseInt(x[0])));
			}
			else {
				ArrayList<Actor> z= new ArrayList<Actor>();
				z.add(y);
				actors.put(Integer.parseInt(x[0]),z);
			}
		}
	}
	
	public HashMap<Integer,ArrayList<Actor>> getActors (){
		return actors;
	}
	public String getActorName() {
		return actorName;
	}
	
	public int getMovieId() {
		return Integer.parseInt(movieId);
	}
	
	public String toString() {
		return actorName+" ranking: "+ranking;
	}
}