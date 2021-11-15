package Data;

import java.util.ArrayList;
import java.util.HashMap;

import DatabaseLoading.DatabaseFactory;

public class Rating {
	private HashMap<Integer,ArrayList<Rating>> ratings;
	private ArrayList<String[]> ratingsList;
	private String userId;
	private String movieId;
	private String rating;
	private String dateDay;
	private String dateMonth;
	private String dateYear;
	private String dateHour;
	private String dateMinute;
	private String dateSecond;
	
	public Rating() {
	}

	public Rating(String userId,String movieId,String rating,String dateDay,String dateMonth,
			String dateYear,String dateHour,String dateMinute,String dateSecond){
		this.userId=userId;
		this.movieId=movieId;
		this.rating=rating;
		this.dateDay=dateDay;
		this.dateMonth=dateMonth;
		this.dateYear=dateYear;
		this.dateHour=dateHour;
		this.dateMinute=dateMinute;
		this.dateSecond=dateSecond;
	}
	
	public void fillRatingHashMap() {
		ratings=new HashMap<Integer,ArrayList<Rating>>();
		DatabaseFactory r=new DatabaseFactory();
		ratingsList=r.allTheUserRatedMovies();
		for(String[] x:ratingsList) {
			Rating y=new Rating(x[0],x[1],x[2],x[3],x[4],x[5],x[6],x[7],x[8]);
			if (ratings.containsKey(Integer.parseInt(x[1]))){
				ratings.get(Integer.parseInt(x[1])).add(y);
				ratings.put(Integer.parseInt(x[1]),ratings.get(Integer.parseInt(x[1])));
				
					}
			else {
				ArrayList<Rating> z= new ArrayList<Rating>();
				z.add(y);
				ratings.put(Integer.parseInt(x[1]),z);
			}
		}		
	}
	
	public HashMap<Integer,ArrayList<Rating>> getRatings(){
		return ratings;
	}
	public int getMovieId() {
		return Integer.parseInt(movieId);
	}
	public String getRating() {
		return rating;
	}
}
