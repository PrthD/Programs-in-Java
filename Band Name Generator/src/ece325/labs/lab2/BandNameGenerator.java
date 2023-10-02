package ece325.labs.lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BandNameGenerator {
	String[] adjectives;
	String[] nouns;

	boolean adjectivesLoaded = false;
	boolean nounsLoaded = false;

	String adjectivesFile;
	String nounsFile;

	public BandNameGenerator(String adjectivesFile, String nounsFile) {
		this.adjectivesFile = adjectivesFile;
		this.nounsFile = nounsFile;
	}

	/**
	 * Load the adjectives file and initialize that part of the generator.
	 */
	public void loadAdjectives() {
		adjectives = getAdjectives(); // Load adjectives from the file.
		adjectivesLoaded = true; // Mark adjectives as loaded.
	}

	/**
	 * Load the nouns file and initialize that part of the generator.
	 */
	public void loadNouns() {
		nouns = getNouns(); // Load nouns from the file.
		nounsLoaded = true; // Mark nouns as loaded.
	}

	/**
	 * Return a string that capitalizes only the first letter of s. So for example,
	 * cat becomes Cat.
	 * 
	 * @param s
	 * @return
	 */
	public String capitalizeFirst(String s) {
		// Capitalize the first letter of a word.
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	/**
	 * Generate a name for your band consisting of two adjectives and one noun. Make
	 * sure to return "UNINITIALIZED" if the band name generator is not initialized
	 * correctly yet.
	 * 
	 * @return the generated name or "UNINITIALIZED"
	 */
	public String generateName() {
		String BandName; // Initialize variable that'll contain the generated band name.

		if (adjectivesLoaded && nounsLoaded) {
			// Get the total number of adjectives and nouns from their respective string
			// lists.
			int numAdj = adjectives.length;
			int numNoun = nouns.length;

			// Get random indices (for lists) for choosing the two adjectives and one noun.
			int randAdj1 = (int) (Math.random() * numAdj);
			int randAdj2 = (int) (Math.random() * numAdj);
			int randNoun = (int) (Math.random() * numNoun);

			BandName = capitalizeFirst(adjectives[randAdj1]) + " " + capitalizeFirst(adjectives[randAdj2]) + " "
					+ capitalizeFirst(nouns[randNoun]); // Generate the band name.
		} else {
			BandName = "UNINITIALIZED"; // Return "UNINITIALIZED" if not initialized correctly.
		}
		return BandName;
	}

	/**
	 * This method loads a text file into a String array. It assumes the number of
	 * lines in the file is on the first line of the file itself.
	 * 
	 * Note: you are not allowed to make changes to this method. You can use this
	 * method for loading text files in the other lab and course assignments as
	 * well.
	 * 
	 * @param file
	 * @return
	 */
	private String[] loadTxt(String file) {
		String[] data = new String[0];
		BufferedReader in = null;

		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			int totalLines = Integer.parseInt(in.readLine());
			data = new String[totalLines];
			while ((line = in.readLine()) != null) {
				data[i] = line;
				i++;
			}
		} catch (Exception e) {
			System.err.println("Problem while reading file: " + file);
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.err.println("Problem closing file: " + file);
					e.printStackTrace();
				}
			}
		}
		return data;
	}

	/**
	 * Returns the list of adjectives.
	 * 
	 * @return
	 */
	public String[] getAdjectives() {
		return loadTxt(adjectivesFile); // Get the list of adjectives from the text file.
	}

	/**
	 * Returns the list of nouns.
	 * 
	 * @return
	 */
	public String[] getNouns() {
		return loadTxt(nounsFile); // Get the list of nouns from the text file.
	}

	public static void main(String[] args) {
		// create a BandNameGenerator instance with file paths and initialize it.
		BandNameGenerator newBandName = new BandNameGenerator("adjectives.txt", "nouns.txt");

		// generate and print 20 names for your band
		newBandName.loadAdjectives(); // Load adjectives.
		newBandName.loadNouns(); // Load nouns.

		for (int i = 1; i <= 20; i++) {
			String Name = newBandName.generateName();
			System.out.println(Name);
		}
	}
}