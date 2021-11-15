package DatabaseLoading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseLocations implements DataLoader {
	
	private ArrayList<String[]> fileList;
	private String readerpath;//="C:\Users\eleni\eclipse-workspace\Film Library\data files";
	private  Scanner inputReader;
	private ArrayList<String> matrix;
	
	public DatabaseLocations(String readerpath) {
		this.readerpath=readerpath;
	}
	
	public boolean loadData() {
		Scanner inputReader= null;
		try{
			inputReader = new Scanner(new FileInputStream(readerpath));
		}
		catch (FileNotFoundException e){
			System.out.println("The"+readerpath +"File Was Not Found");
			return false;
		}
		this.inputReader = inputReader;
		return true;
	}
	
	public void readFile() {
		fileList=new ArrayList<String[]>();
		while(inputReader.hasNextLine()) {
			String[] line=new String[5];
			String p = inputReader.nextLine();
			String[] m=p.split("\t");
			for(int i=0; i<m.length; i++) {
				line[i]=m[i];
			}
			fileList.add(line);
		}
		fileList.remove(0);
	}
	
	public ArrayList<String[]> getLocationsArrayList(){
		return fileList;
	}
	
	public void closeReader(){
		inputReader.close();
	}
}