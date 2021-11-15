package Data;

import java.util.ArrayList;
import java.util.HashMap;

import DatabaseLoading.DatabaseTags;
import DatabaseLoading.DatabaseFactory;

public class Tag {

	private HashMap<Integer,String> tagValue;
	private ArrayList<String[]> tagsList;
	private HashMap<Integer,ArrayList<Tag>> tagResults;
	private ArrayList<String[]> tagResultsList;
	private String userId;
	private String movieId;
	private String tagId;
	private String dateDay;
	private String dateMonth;
	private String dateYear;
	private String dateHour;
	private String dateMinute;
	private String dateSecond;

	public Tag() {
	}

	public Tag(String userId,String movieId,String tagId,String dateDay,String dateMonth,
			String dateYear,String dateHour,String dateMinute,String dateSecond){
		this.userId=userId;
		this.movieId=movieId;
		this.tagId=tagId;
		this.dateDay=dateDay;
		this.dateMonth=dateMonth;
		this.dateYear=dateYear;
		this.dateHour=dateHour;
		this.dateMinute=dateMinute;
		this.dateSecond=dateSecond;
	}
	
	public void fillTagValueHashMap() {
		tagValue=new HashMap<Integer,String>();
		DatabaseFactory t= new DatabaseFactory();
		tagsList=t.allTheTags();
		for(String[] x:tagsList) {
			tagValue.put(Integer.parseInt(x[0]),x[1]);	
		}
	}
	public void fillTagResultsHashMap() {
		tagResults=new HashMap<Integer,ArrayList<Tag>>();
		DatabaseFactory tr=new DatabaseFactory();
		tagResultsList=tr.allTheUserTaggedMovies();
		for(String[] x:tagResultsList) {
			Tag y=new Tag(x[0],x[1],tagValue.get(Integer.parseInt(x[2])),x[3],x[4],x[5],x[6],x[7],x[8]);
			if (tagResults.containsKey(Integer.parseInt(x[2]))){
				tagResults.get(Integer.parseInt(x[2])).add(y);
				tagResults.put(Integer.parseInt(x[2]),tagResults.get(Integer.parseInt(x[2])));
			}
			else {
				ArrayList<Tag> z= new ArrayList<Tag>();
				z.add(y);
				tagResults.put(Integer.parseInt(x[0]),z);
			}
		}
	}
	
	public HashMap<Integer,ArrayList<Tag>> getTags (){
		return tagResults;
	}
	
	public String toString() {
		return tagId;
	}
}
