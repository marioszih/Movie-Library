package Data;

import java.util.ArrayList;
import java.util.HashMap;

import DatabaseLoading.DatabaseFactory;

public class Country {

	private HashMap<Integer, Country> countries;
	private ArrayList<String[]> countriesList;
	private String countryName;
	private String movieId;
	
	public Country() {
	}
	
	public Country(String movieId,String countryName){
		this.movieId=movieId;
		this.countryName=countryName;
	}
	
	public void fillCountriesHashMap() {
		countries=new HashMap<Integer,Country>();
		DatabaseFactory c=new DatabaseFactory();
		countriesList=c.allTheCountries();
		for (String[] x: countriesList) {
			Country y=new Country(x[0],x[1]);
			countries.put(Integer.parseInt(x[0]),y);
		}
	}
	public HashMap<Integer,Country> getCountries (){
		return countries;
	}
	
	public String getCountryName() {
		return countryName;
	}

	public int getMovieId() {
		return Integer.parseInt(movieId);
	}
	
	public String toString() {
		return countryName;
	}
}