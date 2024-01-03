package edu.miracosta.cs112.mpaulding.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The <code>Model</code> class represents the business logic (data and calculations) of the application.
 * In the San Diego Burritos app, it either loads burrito from a CSV file (first load) or a binary file (all
 * subsequent loads).  It is also responsible for saving data to a binary file.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class Model {

	private static final String CSV_FILE = "SDBurritos.csv";
	public static final String BINARY_FILE = "SDBurritos.dat";

	/**
	 * Determines whether the binary file exists and has data (size/length > 0).
	 * @return True if the binary file exists and has data, false otherwise.
	 */
	public static boolean binaryFileHasData()
	{
		// TODO: Create a File reference to the binary file
		// TODO: Return whether the binary file exists and has data
		return false;
	}

	/**
	 * Populates the list of all burritos from the binary file. This will be called everytime the application loads,
	 * other than the very first time, since it needs initial data from CSV.
	 * @return The list of all burritos populated from the binary file
	 */
	public static ObservableList<Burrito> populateListFromBinaryFile()
	{
		ObservableList<Burrito> allBurritos = FXCollections.observableArrayList();
		// TODO: Create a File reference to the binary file
		// TODO: Check to see if the binary file exists
		// TODO: Instantiate an ObjectInputStream reference to the binary file for reading
		// TODO: Create a temp array of Burrito objects to read from the binary file
		// TODO: Initialize the temp array from the binary file reader.
		// TODO: Add the temp array to the collection of all burritos (list)
		// TODO: Close the binary file reader.

		return allBurritos;
	}

	/**
	 * Saves the list of all burritos to the binary file. This will be called each time the application stops,
	 * which occurs when the user exits/closes the app.  Note this method is called in the View, by the controller,
	 * during the stop() method.
	 * @return True if the data were saved to the binary file successfully, false otherwise.
	 */
	public static boolean writeDataToBinaryFile(ObservableList<Burrito> allBurritosList)
	{
		// TODO: Create a File reference to the binary file
		// TODO: Instantiate an ObjectOutputStream reference to the binary file for writing
		// TODO: Create a temp array of Burrito objects to read from the binary file (length should match list size)
		// TODO: Loop through the temp array and initialize each element to the corresponding element in the list
		// TODO: Write the temp array object to the binary file writer
		// TODO: Close the binary file writer and return true.
		// TODO: If an exception occurs, print its message and return false.
		return false;
	}

	/**
	 * Populates the initial list of all burritos from the CSV file. This will only be called once when the
	 * application loads for the first time.  All other loads will populate from the binary file.
	 * @return The list of all burritos populated from the CSV file.
	 */
	public static ObservableList<Burrito> populateListFromCSV() {
		ObservableList<Burrito> allBurritos = FXCollections.observableArrayList();
		String[] data=null;
		String location, name, neighborhood, notes, line = null;
		double price, rating;
		try {
			Scanner fileScanner = new Scanner(new File(CSV_FILE));

			// First read is for headings (skipped):
			fileScanner.nextLine();
			while (fileScanner.hasNextLine()) {
				line = fileScanner.nextLine();
				data = line.split(",");
				location = data[0].trim();
				name = data[1].trim();
				neighborhood = data[2].trim();
				price = (data[8].isEmpty()) ? 0.0 : Double.parseDouble(data[8]);
				rating = (data[24].isEmpty()) ? 0.0 : Double.parseDouble(data[24]);
				notes =(data.length <= 27 || data[27].isEmpty()) ? "N/A" : data[27].trim();
				allBurritos.add(new Burrito(location, name, neighborhood, price, rating, notes));
			}
			fileScanner.close();

		}  catch (FileNotFoundException e) {
			System.err.println("Error opening " + CSV_FILE + ": " + e.getMessage());
		}

		return allBurritos;
	}

}
