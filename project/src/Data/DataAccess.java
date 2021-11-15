package Data;

import java.util.ArrayList;
import java.util.HashMap;


public class DataAccess {
	
	public DataAccess() {
	}
	public HashMap<Integer,ArrayList<Actor>> actorsHM(){
		Actor acts=new Actor();
		acts.fillActorsHashMap();
		return acts.getActors();
	}
	public HashMap<Integer,Country> countriesHM(){
		Country cntrs=new Country();
		cntrs.fillCountriesHashMap();
		return cntrs.getCountries();
	}
	public HashMap<Integer,ArrayList<Director>> directorsHM(){
		Director dir=new Director();
		dir.fillDirectrosHashMap();
		return dir.getDirectors();
	}
	public HashMap<Integer,ArrayList<Genre>> genresHM(){
		Genre gen=new Genre();
		gen.fillGenreHashMap();
		return gen.getGenres();
	}
	public HashMap<Integer,ArrayList<Location>> locationsHM(){
		Location loc=new Location();
		loc.fillLocationsHashMap();
		return loc.getLocations();
	}
	public HashMap<Integer,Movie> moviesHM(){
		Movie mov=new Movie();
		mov.fillMovieHashMap();
		return mov.getMovie();
	}
	public HashMap<Integer,ArrayList<Rating>> ratingsHM(){
		Rating rat=new Rating();
		rat.fillRatingHashMap();
		return rat.getRatings();
	}
	public HashMap<Integer,ArrayList<Tag>> tagsHM(){
		Tag tagt=new Tag();
		tagt.fillTagResultsHashMap();
		return tagt.getTags();
	}
}
