package DatabaseLoading;
import java.util.ArrayList;

public class DatabaseFactory {
		public DatabaseFactory(){
		}
		public ArrayList<String[]> allTheActors(){
			DatabaseActor actors = new DatabaseActor("..\\Film Library\\src\\DatabaseLoading\\movie_actors.dat");
			if(actors.loadData()){
				actors.readFile();
				actors.closeReader();
			}
			else {
				System.exit(0);
			}
			return actors.getActorArrayList();
		}
		
		public ArrayList<String[]> allTheCountries(){
			DatabaseCountries countries = new DatabaseCountries("..\\Film Library\\src\\DatabaseLoading\\movie_countries.dat");
			if(countries.loadData()){
				countries.readFile();
				countries.closeReader();
			}
			else {
				System.exit(0);
			}
			return countries.getCountriesArrayList();
		}
		
		public ArrayList<String[]> allTheDirectors(){
			DatabaseDirectors directors = new DatabaseDirectors("..\\Film Library\\src\\DatabaseLoading\\movie_directors.dat");
			if(directors.loadData()){
				directors.readFile();
				directors.closeReader();
			}
			else {
				System.exit(0);
			}
			return directors.getDirectorsArrayList();
		}
		
		public ArrayList<String[]> allTheGenres(){
			DatabaseGenres genres = new DatabaseGenres("..\\Film Library\\src\\DatabaseLoading\\movie_genres.dat");
			if(genres.loadData()){
				genres.readFile();
				genres.closeReader();
			}
			else {
				System.exit(0);
			}
			return genres.getGenresArrayList();
		}
		
		public ArrayList<String[]> allTheLocations(){
			DatabaseLocations locations = new DatabaseLocations("..\\Film Library\\src\\DatabaseLoading\\movie_locations.dat");
			if(locations.loadData()){
				locations.readFile();
				locations.closeReader();
			}
			else {
				System.exit(0);
			}
			return locations.getLocationsArrayList();
		}
		
		public ArrayList<String[]> allTheMovies(){
			DatabaseMovie movie = new DatabaseMovie("..\\Film Library\\src\\DatabaseLoading\\movies.dat");
			if(movie.loadData()){
				movie.readFile();
				movie.closeReader();
			}
			else {
				System.exit(0);
			}
			return movie.getMovieArrayList();
		}
		
		public ArrayList<String[]> allTheTags(){
			DatabaseTags tags = new DatabaseTags("..\\Film Library\\src\\DatabaseLoading\\tags.dat");
			if(tags.loadTagsData()){
				tags.readFile();
				tags.closeReader();
			}
			else {
				System.exit(0);
			}
			return tags.getTagsArrayList();
		}
		
		public ArrayList<String[]> allTheUserRatedMovies(){
			DatabaseUserRatedMovies urmovies = new DatabaseUserRatedMovies("..\\Film Library\\src\\DatabaseLoading\\user_ratedmovies.dat");
			if(urmovies.loadRatingsData()){
				urmovies.readFile();
				urmovies.closeReader();
			}
			else {
				System.exit(0);
			}
			return urmovies.getUserRatedMoviesArrayList();
		}
		
		public ArrayList<String[]> allTheUserTaggedMovies(){
			DatabaseUserTaggedMovies utmovies = new DatabaseUserTaggedMovies("..\\Film Library\\src\\DatabaseLoading\\user_taggedmovies.dat");
			if(utmovies.loadTagsData()){
				utmovies.readFile();
				utmovies.closeReader();
			}
			else {
				System.exit(0);
			}
			return utmovies.getUserTaggedMoviesArrayList();
		}
	}