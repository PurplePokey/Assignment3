import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

/**
 * <insert class description here>
 * 
 * @author 
 *
 */
public class CSVReader {

	/**
	 * @param args
	 */
	public String[] readData(String filename) throws IOException {

		// reads the date and message from a file and puts it into an ArrayList
		FileReader fileReader = new FileReader(filename);

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> data = new ArrayList<String>();
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			data.add(line);
		}

		bufferedReader.close();

		String[] bioData = new String[data.size()];
		// takes each string from the array and divides it into specific
		// components
		if (!data.get(0).equals("")) {
			for (int i = 0; i < data.size(); i++) {
				

			}
		}
		return bioData;
	}

}
