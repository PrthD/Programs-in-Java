package ece325.labs.lab4;

import java.util.ArrayList;
import java.util.Collections;

public class Song {
	private String title; // Title of the song
	private ArrayList<String> instruments; // List of instruments used to play the song
	private AverageRating averageRating; // Object to store average rating for the song
	
	// Initialize Song object with title, instruments, and average rating
	public Song(String title, ArrayList<String> instruments, AverageRating rating) {
		this.title = title;
        this.instruments = instruments;
        averageRating = rating;
	}
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o; // Type cast an Object to Song
		// Sort the instruments ArrayLists to compare the instruments used in the songs
		Collections.sort(instruments);
        Collections.sort(song.getInstruments());

        if (title == null || !title.equals(song.getTitle())) return false;
        return instruments.equals(song.getInstruments());
	}
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 */
	public boolean equals(Song s) {
		if (this == s) return true;
        if (s == null) return false;

		// Sort the instruments ArrayLists to compare the instruments used in the songs
		Collections.sort(instruments);
        Collections.sort(s.getInstruments());

        if (title == null || !title.equals(s.getTitle())) return false;
        return instruments.equals(s.getInstruments());
	}
	
	// Method to retrieve a copy of the instruments list
	public ArrayList<String> getInstruments(){
		return new ArrayList<>(instruments);
	}
	
	// Method to add a new rating to the song's average rating
	public void addRating(float rating) {
		averageRating.addRating(rating);
	}
	
	// Method to retrieve the song's average rating
	public AverageRating getRating() {
		return averageRating;
	}
	
	// Getter method for retrieving the song's title
	public String getTitle() {
		return title;
	}
	
	// Provide a string representation of Song object
	public String toString() {
		return "[Song: " + title + ", instruments: " + instruments + ", avg. rating: " + averageRating + "]"; 
	}
}