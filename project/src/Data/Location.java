package Data;

import java.util.ArrayList;
import java.util.HashMap;

import DatabaseLoading.DatabaseFactory;

public class Location {

	private HashMap<Integer, ArrayList<Location>> locations;
	private ArrayList<String[]> locationsList;
	private String movieId;
	private String location1;
	private String location2;
	private String location3;
	private String location4;
	
	public Location() {
	}
	
	public Location(String movieId,String location1,String location2,String location3,String location4) {
		this.movieId=movieId;
		this.location1=location1;
		this.location2=location2;
		this.location3=location3;
		this.location4=location4;
	}
	
	public void fillLocationsHashMap() {
		locations=new HashMap<Integer,ArrayList<Location>>();
		DatabaseFactory l=new DatabaseFactory();
		locationsList=l.allTheLocations();
		for(String[] x:locationsList){
			Location y=new Location(x[0],x[1],x[2],x[3],x[4]);
			if(locations.containsKey(Integer.parseInt(x[0]))){
					locations.get(Integer.parseInt(x[0])).add(y);
					locations.put(Integer.parseInt(x[0]),locations.get(Integer.parseInt(x[0])));
			}
			else {
				ArrayList<Location> z= new ArrayList<Location>();
				z.add(y);
				locations.put(Integer.parseInt(x[0]),z);
			}		
		}
	}
	
	public HashMap<Integer,ArrayList<Location>> getLocations (){
		return locations;
	}
	
	public String toString() {
		return location1+" "+location2+" "+location3+" "+location4;
	}
}