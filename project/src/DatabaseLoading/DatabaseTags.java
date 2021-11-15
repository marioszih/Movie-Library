package DatabaseLoading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseTags implements TagsDataLoader {
	
	private ArrayList<String[]> fileList;
	private String readerpath;//="C:\Users\eleni\eclipse-workspace\Film Library\data files";
	private  Scanner inputReader;
	
	public DatabaseTags(String readerpath) {
		this.readerpath=readerpath;
	}

	public boolean loadTagsData() {
		Scanner inputReader= null;
		try{
			inputReader = new Scanner(new FileInputStream(readerpath));
		}
		catch (FileNotFoundException e){
			System.out.println("The "+readerpath +" File Was Not Found");
			return false;
		}
		this.inputReader = inputReader;
		return true;
	}
	
	public void readFile() {
		fileList=new ArrayList<String[]>();
		while(inputReader.hasNextLine()) {
			String[] line=new String[2];
			String p=inputReader.nextLine();
			String[] m=p.split("\t");
			for(int i=0;i<2;i++) {
				line[i]=m[i];
			}
			fileList.add(line);
		}
		fileList.remove(0);
	}
	
	public ArrayList<String[]> getTagsArrayList(){
		return fileList;
	}
	
	public void closeReader(){
		inputReader.close();
	}
}