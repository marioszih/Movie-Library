package Data;

import java.util.ArrayList;
import java.util.HashMap;
import DatabaseLoading.DatabaseFactory;

public class Movie {

	private String id;
	private String title;
	private String imdbId;
	private String spanishTitle;
	private String imdbPictureUrl;
	private String year;
	private String rtId;
	private String rtAllCriticsRating;
	private String rtAllCriticsNumReviews;
	private String rtAllCriticsNumFresh;
	private String rtAllCriticsNumRotten;
	private String rtAllCriticsScore;
	private String rtTopCriticsRating;
	private String rtTopCriticsNumReviews;
	private String rtTopCriticsNumFresh;
	private String rtTopCriticsNumRotten;
	private String rtTopCriticsScore;
	private String rtAudienceRating;
	private String rtAudienceNumRatings;
	private String rtAudienceScore;
	private String rtPictureUrl;
	private HashMap<Integer,Movie> movies;
	private ArrayList<String[]> moviesList;
	
	public Movie() {
	}

	public Movie(String id,String title,String imdbId,String spanishTitle,String imdbPictureUrl,
			String year,String rtId,String rtAllCriticsRating,String rtAllCriticsNumReviews,
			String rtAllCriticsNumFresh,String rtAllCriticsNumRotten,String rtAllCriticsScore,
			String rtTopCriticsRating,String rtTopCriticsNumReviews,String rtTopCriticsNumFresh,
			String rtTopCriticsNumRotten,String rtTopCriticsScore,String rtAudienceRating,
			String rtAudienceNumRatings,String rtAudienceScore,String rtPictureUrl) {
		this.id=id;
		this.title=title;
		this.imdbId=imdbId;
		this.spanishTitle=spanishTitle;
		this.imdbPictureUrl=imdbPictureUrl;
		this.year=year;
		this.rtId=rtId;
		this.rtAllCriticsRating=rtAllCriticsRating;
		this.rtAllCriticsNumReviews=rtAllCriticsNumReviews;
		this.rtAllCriticsNumFresh=rtAllCriticsNumFresh;
		this.rtAllCriticsNumRotten=rtAllCriticsNumRotten;
		this.rtAllCriticsScore=rtAllCriticsScore;
		this.rtTopCriticsRating=rtTopCriticsRating;
		this.rtTopCriticsNumReviews=rtTopCriticsNumReviews;
		this.rtTopCriticsNumFresh=rtTopCriticsNumFresh;
		this.rtTopCriticsNumRotten=rtTopCriticsNumRotten;
		this.rtTopCriticsScore=rtTopCriticsScore;
		this.rtAudienceRating=rtAudienceRating;
		this.rtAudienceNumRatings=rtAudienceNumRatings;
		this.rtAudienceScore=rtAudienceScore;
		this.rtPictureUrl=rtPictureUrl;
	}
	
	public void fillMovieHashMap() {
		movies=new HashMap<Integer,Movie>();
		DatabaseFactory m=new DatabaseFactory();
		moviesList=m.allTheMovies();
		for(String[] x:moviesList){
			Movie y=new Movie(x[0],x[1],x[2],x[3],x[4],x[5],x[6],x[7],x[8],x[9],x[10],
					x[11],x[12],x[13],x[14],x[15],x[16],x[17],x[18],x[19],x[20]);
			movies.put(Integer.parseInt(x[0]),y);
		}
	}
	public HashMap<Integer,Movie> getMovie(){
		return movies;
	}
	public String getMovieTitle() {
		return title;
	}
	
	public String getMovieYear() {
		return year;
	}
	
	public int getMovieId() {
		return Integer.parseInt(id);
	}
	
	public String toString() {
		return title+ " "+" ("+spanishTitle+") "+"\r\n"+"Year: "+year+"\r\n"+"\r\n"+ "-IMDB Info:"+"\r\n"+
	"ID: "+imdbId+"\r\n"+"Picture URL: "+imdbPictureUrl+"\r\n"+"\r\n"+"-Rotten Tomatos Info:"+"\r\n"+"ID: "+rtId+
		"\r\n"+"Picture URL:"+rtPictureUrl+"\r\n"+"All Critics Rating: "+rtAllCriticsRating+
	", All Reviews Number: "+rtAllCriticsNumReviews+"  Fresh: "+rtAllCriticsNumFresh+
	"  Rotten: "+rtAllCriticsNumRotten+", Critics Score: "+rtAllCriticsScore+"\r\n"+
	"Top Critics Rating: "+rtTopCriticsRating+", Top Reviews Number:"+rtTopCriticsNumReviews+
	"  Fresh: "+rtTopCriticsNumFresh+"  Rotten: "+rtTopCriticsNumRotten+
	", Score: "+rtTopCriticsScore+"\r\n"+"Audience Rating: "+rtAudienceRating+
	", Audience Reviews Number :"+rtAudienceNumRatings+", Score:"+rtAudienceScore;
	}
}
