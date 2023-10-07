package ece325.lec.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SongCollectionArrayList {
	private ArrayList<String> songs; // ArrayList to store songs

	/**
	 * Create a SongCollectionArrayList object.
	 * 
	 */
	public SongCollectionArrayList() {
		songs = new ArrayList<>(); // Initialize the ArrayList in the constructor
	}

	/**
	 * Add s to the collection. Only add s if it is not in the collection yet.
	 * Return true if the addition was successful, otherwise return false.
	 * 
	 * @param s the song to be added
	 * @return
	 */
	public boolean add(String s) {
		if (!contains(s)) {
			songs.add(s); // Add the song to the ArrayList if it's not already present
			return true; // Return true indicating successful addition
		}
		return false; // Return false indicating addition was not successful
	}

	/**
	 * Remove s from the collection.
	 * 
	 * @param s the song to be removed
	 */
	public void remove(String s) {
		songs.remove(s); // Remove the specified song from the ArrayList
	}

	/**
	 * Return true if the collection contains s, false otherwise.
	 * 
	 * @param s the song to be searched for
	 * @return
	 */
	public boolean contains(String s) {
		return songs.contains(s); // Check if the song is present in the ArrayList
	}

	/**
	 * If there is a song at position index in the collection, return it. Otherwise
	 * return null.
	 * 
	 * @param index the index of the song to return
	 * @return
	 */
	public String getSong(int index) {
		if (index >= 0 && index < songs.size() && !songs.get(index).equals(null)) {
			return songs.get(index); // Retrieve the song at the specified index from the ArrayList
		}
		return null; // Return null if the index is invalid
	}

	/**
	 * Return the number of songs in the collection.
	 * 
	 * @return
	 */
	public int getNumberOfSongs() {
		return songs.size(); // Return the size of the ArrayList, indicating the number of songs
	}

	/**
	 * Make sure to read the songs.txt file and print the number of unique songs in
	 * it.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialize the SongCollectionArrayList object
		SongCollectionArrayList collection = null;
		// Initialize the BufferedReader for reading the file																	
		BufferedReader br = null;

		try {
			// Open the file for reading
			br = new BufferedReader(new FileReader("songs.txt"));
			String line;

			// Read the total number of lines (songs) from the file
			int totalLines = Integer.parseInt(br.readLine());
			// Create a 'SongCollectionArrayList' object
			collection = new SongCollectionArrayList();

			while ((line = br.readLine()) != null) {
				if (!collection.contains(line)) {
					collection.add(line); // Add unique songs to the collection
				}
			}
		} catch (IOException e) {
			// Handle file reading errors
			System.err.println("Problem while reading file: " + "songs.txt");
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close(); // Close the BufferedReader
				} catch (IOException e) {
					// Handle file closing errors
					System.err.println("Problem closing file: " + "songs.txt");
					e.printStackTrace();
				}
			}
		}

		// Print the total number of unique songs in the songs.txt file
		System.out.println(collection.getNumberOfSongs());
	}
}