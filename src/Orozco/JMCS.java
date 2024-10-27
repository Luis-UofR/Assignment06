package Orozco;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class JMCS {

	// Data members
	private File inputFile;
	private ArrayList<String> catalog;

	// Constructor
	public JMCS(File inputFile) {
		this.inputFile = inputFile;
		catalog = new ArrayList<>();
	}

	public void buildCatalog() {

		// Create scanner to read the file
		Scanner fileInputScan = null;

		// Opens the scanner to the input file and searches for catalog elements
		try {
			fileInputScan = new Scanner(inputFile);
			search(fileInputScan);
		} catch (FileNotFoundException e) {
			System.out.println("Error - This file could not be found.");
		} finally {
			if (fileInputScan != null) {
				fileInputScan.close();
			}
		}
	}

	// look at the curly brackets
	private void search(Scanner fileInputScan) {

		catalog = new ArrayList<String>();
		Stack<String> stack = new Stack<>();
		String codeLine = "";
		String possibleMCS = ""; // Possible method, class, or structure

		while (fileInputScan.hasNextLine()) {

			// Task 1: Grab a single line of code and trim whitespace from front
			codeLine = fileInputScan.nextLine();
			codeLine = codeLine.trim();

			// Task 2: check if the codeline is the start of an MCS
			if (codeLine.length() > 0) {
				if (!codeLine.equals("{") && !codeLine.equals("}")) {
					possibleMCS = codeLine;
				} else if (codeLine.equals("{")) {
					stack.push(possibleMCS);
				} else {
					catalog.add(0, stack.pop());
				}
			}
		}
	}

	public String toString() {
		String MCSString = "";
		for (int i = 0; i < catalog.size(); i++) {
			MCSString += catalog.get(i) + "\n";
		}
		return MCSString;
	}
}
