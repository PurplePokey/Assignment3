import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		String userInput="";
		String fileNameRead = "";
		String fileNameWrite = "";
		String rela = "";
		String strTemp = "";
		String cuiTemp = "";
		String medicalTerm = "";
		List<String> dataTemp=null;
		List<String> dataComplete=new ArrayList<String>();
		List<String> terms = new ArrayList<String>();
		
		FileWriter csvWrite=null;
		
		Scanner scan = new Scanner(System.in);
		CSVReader reader = new CSVReader();
		
		//read data into terms
		terms=reader.readData("terms.csv");
		
		while(!userInput.equalsIgnoreCase("e")) {
			displayMenu();
			userInput=scan.nextLine();

			//MENU OPTION A - ADDING DATA
			if (userInput.equalsIgnoreCase("a")) {
				
				//get filename for reading part i - COMPLETE
				System.out.println("Enter the file name: ");
				fileNameRead=scan.nextLine();
				
				//read file into dataComplete part ii
				//ERROR HANDLING FOR INVALID FILENAME NEEDED
				dataTemp = reader.readData(fileNameRead);
				for(int i = 0; i<dataTemp.size();i++) {
						dataComplete.add(dataTemp.get(i));
					
				}
				
				//Print number of rows read part iii
				//NEED TO CHECK IF FILE HAS BEEN PROCESSED YET
				System.out.println(dataTemp.size() + " rows read.");
				
			}
			
			//MENU OPTION R - SAVE DATA FOR A RELATIONSHIP 
			else if (userInput.equalsIgnoreCase("r")) {
				
				//get relationship type part i - COMPLETE
				System.out.println("Enter the relationship type: ");
				rela=scan.nextLine();
				
				//get file name for export part ii - COMPLETE
				System.out.println("Enter the file name: ");
				fileNameWrite=scan.nextLine();
				
				//find all data for the relationship type and write output file part iii
				//create output file
				try {
					csvWrite = new FileWriter(fileNameWrite);
					//Create columns
					//appends STR 
					csvWrite.append("STR");
					csvWrite.append(",");
					//appends RELATIONSHIP
					csvWrite.append("Relationship");
					csvWrite.append(",");
					//appends STR2
					csvWrite.append("STR2");
					csvWrite.append("\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//find relationship types and write to output file - COMPLETE - CHECK BUG
				// BUG??? -> overwrites file every time option is selected instead of appending
				for(int i =0; i<dataComplete.size();i++) {
					if(rela.equals(dataComplete.get(i))) {
						
						try {
							//find STR for CUI
							cuiTemp=dataComplete.get(i-1);
							for(int t = 0; t<terms.size(); t++) {
								if(cuiTemp.equals(terms.get(t))) {
									strTemp=terms.get(t+1);
								}
							}
							//appends STR 
							csvWrite.append(strTemp);
							csvWrite.append(",");
							//appends RELATIONSHIP
							csvWrite.append(dataComplete.get(i));
							csvWrite.append(",");
							//appends STR2
							csvWrite.append(dataComplete.get(i+2));
							csvWrite.append("\n");
						} catch (IOException e) {
							e.printStackTrace();
						}	
					}
				}
				
			}
			
			//MENU OPTION T - SAVE DATA FOR MEDICAL TERMS
			else if (userInput.equalsIgnoreCase("t")) {
				
				//get medical term part i - COMPLETE
				System.out.println("Enter the medical term: ");
				medicalTerm=scan.nextLine();
				
				//get file name for export part ii - COMPLETE
				System.out.println("Enter the file name: ");
				fileNameWrite=scan.nextLine();
				
				//find all data for the relationship type and write output file part iii
				//create output file
				try {
					csvWrite = new FileWriter(fileNameWrite);
					//Create columns
					//appends STR 
					csvWrite.append("STR");
					csvWrite.append(",");
					//appends RELATIONSHIP
					csvWrite.append("Relationship");
					csvWrite.append(",");
					//appends STR2
					csvWrite.append("STR2");
					csvWrite.append("\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//find medical term and write to output file
				// BUG??? -> overwrites file every time option is selected instead of appending
				for(int i =0; i<dataComplete.size();i++) {
					if(medicalTerm.equals(dataComplete.get(i))) {
						try {
							//appends STR 
							csvWrite.append(dataComplete.get(i-1));
							csvWrite.append(",");
							//appends RELATIONSHIP
							csvWrite.append(dataComplete.get(i));
							csvWrite.append(",");
							//appends STR2
							csvWrite.append(dataComplete.get(i+1));
							csvWrite.append("\n");
						} catch (IOException e) {
							e.printStackTrace();
						}	
					}
				}
			}
			
			
			//EXIT PROGRAM - COMPLETE
			else if(userInput.equalsIgnoreCase("e")) {

				System.out.println("Quitting application.");
				
			}
			
			
			//INVALID MENU SELECTION
			else {
				
				System.out.println("Invalid choice, try again.\n");
				
			}
			

			
		}
		try {
			csvWrite.flush();
			csvWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void displayMenu() {
		System.out.println("Add data - 'a' or 'A' ");
		System.out.println("Save data for a relationship - 'r' or 'R' ");
		System.out.println("Save data for a medical term - 't' or 'T' ");
		System.out.println("Exit program - 'e' or 'E' ");
	}

}
