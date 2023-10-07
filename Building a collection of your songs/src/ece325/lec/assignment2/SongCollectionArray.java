package ece325.lec.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class SongCollectionArray {
	private String[] songs;
	private int size;
    private int capacity;
	
	/**
	 * Create a SongCollectionArray object with capacity i (= the number of songs it can hold).
	 * @param i the number of songs the collection can hold
	 */
	public SongCollectionArray(int i) {
		this.capacity = i;
		this.songs = new String[capacity]; // Initialize the array for storing songs
		this.size = 0; // Initialize the current number of stored songs to 0
	}
	
	
	/**
	 * Add s to the collection. Only add s if it is not in the collection yet. 
	 * Return true if the addition was successful, otherwise return false.
	 * 
	 * @param s the song to be added
	 * @return
	 */
	public boolean add(String s) {
		if (!contains(s) && size < capacity) {
            songs[size] = s; // Add the song to the collection
            size++; // Increment the size of the collection
            return true;
        }
        return false;
    }
	
	/**
	 * Remove s from the collection. Make sure that all the empty spots of the array 
	 * are at the end. So if you remove a song from the 'middle' of the array, you need to
	 * make sure that the empty spot is filled up somehow.
	 * @param s the song to be removed
	 */
	public void remove(String s) {
		for (int i = 0; i < size; i++) {
            if (songs[i] != null && songs[i].equals(s)) {
                songs[i] = null; // Set the found song spot to null
                // Shift the subsequent songs to fill the empty spot
                for (int j = i; j < size - 1; j++) {
                    songs[j] = songs[j + 1];
                }
				songs[size - 1] = null; // Set the last spot to null
                size--; // Decrement the size of the collection
                break; // Exit the loop after removing the song
            }
        }
	}
	
	/**
	 * Return true if the collection contains s, false otherwise.
	 * @param s the song to be searched for
	 * @return
	 */
	public boolean contains(String s) {
		for (int i = 0; i < size; i++) {
            if (songs[i] != null && songs[i].equals(s)) {
                return true; // Return true if the song is found in the collection
            }
        }
        return false; // Return false if the song is not found in the collection
	}
	
	/**
	 * If there is a song at position index in the collection, return it. Otherwise return null.
	 * @param index the index of the song to return
	 * @return
	 */
	public String getSong(int index) {
		if (index >= 0 && index < size && !songs[index].equals(null)) {
			// Return the song if the index is valid and the spot is not empty
            return songs[index];
        }
        return null; // Return null if the index is invalid or the spot is empty
	}
	
	/**
	 * Return the number of songs in the collection.
	 * @return
	 */
	public int getNumberOfSongs() {
		return size; // Return the current size of the collection
	}
	
	/**
	 * Make sure to read the songs.txt file and print the number of unique songs in it.
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialize the SongCollectionArray object
		SongCollectionArray collection = null;
		// Initialize the BufferedReader for reading the file
		BufferedReader br = null;
		
		try {
			// Open the file for reading
			br = new BufferedReader(new FileReader("songs.txt"));
			String line;
			
			// Read the total number of lines (songs) from the file
			int totalLines = Integer.parseInt(br.readLine());
			// Create a 'SongCollectionArray' object array with the specified capacity
			collection = new SongCollectionArray(totalLines);
			
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