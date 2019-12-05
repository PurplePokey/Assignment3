/*
 *File name: CSVReader2.java
 * 
 *Programmer: Raph Rusak
 *Date: Dec 5, 2019
 */

/**
 * <insert class description here>
 *@author Raph Rusak
 *
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader2
{
	//will read the information on the csv file and separate it all into individual lines
	 public String[] readData(String csvFile) {

	        
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        String[] data=null;

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            //two while loops to skip the first line of the category titles
	            while ((line = br.readLine()) != null) {
	            	 while ((line = br.readLine()) != null) {
	                // use comma as separator
	                 data = line.split(cvsSplitBy);
	                for(int i=0; i<data.length; i++) {
	                System.out.println(data[i]);
	                }

	            }
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return data;

	    }

	 public static void main(String[] args) {
		 //tested with both the Terms file and Relationships file
		 //String csvFile = "C:\\Users\\Raph\\eclipse-workspace\\IT226Project3\\src\\Terms.csv";
		 //String csvFile= "C:\\Users\\Raph\\eclipse-workspace\\IT226Project3\\src\\relationships.csv";
		 String csvFile= "C:\\Users\\Raph\\eclipse-workspace\\IT226Project3\\src\\relationships2.csv";
		 CSVReader2 reader= new CSVReader2();
		 reader.readData(csvFile);

}
}