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
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	// will read the information on the csv file and separate it all into individual
	// lines
	public List<String> readData(String csvFile) {

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String[] temp = null;
		List<String> data = new ArrayList<String>();


		try {

			br = new BufferedReader(new FileReader(csvFile));
			// two while loops to skip the first line of the category titles
			while ((line = br.readLine()) != null) {
				while ((line = br.readLine()) != null) {
					// use comma as separator
					temp= line.split(cvsSplitBy);
					//printing for test
					for (int i = 0; i < temp.length; i++) {
						data.add(temp[i]);
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
}
