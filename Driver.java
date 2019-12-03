import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		String userInput="";
		String fileName = "";
		String rela = "";
		
		Scanner scan = new Scanner(System.in);
		CSVReader reader = new CSVReader();
		
		
		while(!userInput.equalsIgnoreCase("e")) {
			displayMenu();
			userInput=scan.next();
			
			if (userInput.equalsIgnoreCase("a")) {
				
			}
			else if (userInput.equalsIgnoreCase("r")) {
				
			}
			else if (userInput.equalsIgnoreCase("t")) {
				
			}
			else if(userInput.equalsIgnoreCase("e")) {
				System.out.println("Quitting application.");
			}
			else {
				System.out.println("Invalid choice, try again.\n");
			}
			
			
		}
		
	}
	
	public static void displayMenu() {
		System.out.println("Add data - 'a' or 'A' ");
		System.out.println("Save data for a relationship - 'r' or 'R' ");
		System.out.println("Save data for a medical term - 't' or 'T' ");
		System.out.println("Exit program - 'e' or 'E' ");
	}

}
