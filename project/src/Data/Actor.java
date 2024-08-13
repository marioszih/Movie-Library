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
		System.out.println("ESKERE");
		DatabaseFactory a=new DatabaseFactory();
		actorsList=a.allTheActors();
		for(String[] actor:actorsList){
			Actor y=new Actor(actor[0],actor[1],actor[2],actor[3]);
			if(actors.containsKey(Integer.parseInt(actor[0]))){
				actors.get(Integer.parseInt(actor[0])).add(y);
				actors.put(Integer.parseInt(actor[0]),actors.get(Integer.parseInt(actor[0])));
			}
			else {
				ArrayList<Actor> z= new ArrayList<Actor>();
				z.add(y);
				actors.put(Integer.parseInt(actor[0]),z);
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