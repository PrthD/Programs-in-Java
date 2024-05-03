package ece325.labs.lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SongLoader {
	/**
	 * Load a SongCollection from a file. Uses one or more Scanners to read the
	 * file, create Song objects and insert them into a SongCollection.
	 * 
	 * 
	 * The input is of the format: Songtitle; Instruments; Rating 
	 * Contribution;Guitar,Guitar,Drums;4.5
	 * 
	 * (see songratings.txt for the full input)
	 * 
	 * @param file
	 * @return the loaded SongCollection
	 */
	public static SongCollection loadSongs(String file) {
		// Initialize a new SongCollection object
		SongCollection collection = new SongCollection();

        BufferedReader reader = null;
        Scanner scanner = null;
		try {
            reader = new BufferedReader(new FileReader(file));
            scanner = new Scanner(reader);
            scanner.useDelimiter("\n"); // Line breaking

            // Read each line from the file and parse it into a Song object
            while (scanner.hasNext()) {
                String line = scanner.next();
                Song song = parseSong(line);
                collection.add(song);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (InvalidSongFormatException e) {
            System.err.println("Invalid song format: " + e.getMessage());
        } finally {
			// Close the Scanner and BufferedReader objects
			try {
				if (reader != null) {
					reader.close();
				}
				if (scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				System.err.println("Error closing resources: " + e.getMessage());
			}
		}
        return collection;
	}

	/**
	 * Parse a Song object from the String and return it. If the String cannot be
	 * parsed into a Song, throw an InvalidSongFormatException.
	 * 
	 * @param songString
	 * @return
	 * @throws InvalidSongFormatException
	 */
	public static Song parseSong(String songString) throws InvalidSongFormatException {
		Scanner scanner = null;
        ArrayList<String> parsedInp = new ArrayList<>();

		try {
			scanner = new Scanner(songString).useDelimiter(";");
			while (scanner.hasNext()) {
            parsedInp.add(scanner.next());
        	}
		}
		finally {
			if (scanner != null) {
				scanner.close();
			}
		}

        // Validate parsed input format
        if (parsedInp.size() != 3) {
            throw new InvalidSongFormatException("Invalid song format: " + songString);
        }

		// Initialize the instance variables for a Song object
        String title = parsedInp.get(0);
        String instruments = parsedInp.get(1);
        String ratingStr = parsedInp.get(2);
		float rating;

		// Check for empty title String
    	if (title.isEmpty()) {
        	throw new InvalidSongFormatException("Invalid song title format: " + songString);
    	}

    	// Check for empty instruments String
    	if (instruments.isEmpty()) {
        	throw new InvalidSongFormatException("Invalid song insruments format: " + songString);
    	}

    	// Try parsing the input ratingStr as a float and check for exceptions
    	try {
			rating = Float.parseFloat(ratingStr);
			// Check for the song rating range
			if (rating < 0 || rating > 10) {
				throw new InvalidSongFormatException("Invalid rating range: " + rating);
			}
		} catch (NumberFormatException e) {
			throw new InvalidSongFormatException("Invalid song rating format: " + songString);
		}

        return new Song(title, parseInstrumentsList(instruments), new AverageRating(rating));
    }

	/**
	 * Uses a scanner to parse the instruments string into an ArrayList of String
	 * objects. You can assume that the string comes in CSV (comma-separated-value)
	 * format, and that it is valid CSV (so no need to do error checking or account
	 * for issues with the data).
	 * 
	 * @param instruments
	 * @return an ArrayList with one String per parsed instrument
	 */
	public static ArrayList<String> parseInstrumentsList(String instruments) {
		Scanner scanner = null;
        ArrayList<String> instrumentList = new ArrayList<>();

		try {
			scanner = new Scanner(instruments).useDelimiter(",");
			while (scanner.hasNext()) {
            instrumentList.add(scanner.next());
			}
		}
		finally {
			if (scanner != null) {
				scanner.close();
			}
		}
        return instrumentList;
	}

	public static void main(String[] args) {
		String file = "songratings.txt";
		System.out.println(SongLoader.loadSongs(file));
	}
}