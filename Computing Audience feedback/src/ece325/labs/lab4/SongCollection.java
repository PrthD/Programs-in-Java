package ece325.labs.lab4;

import java.util.ArrayList;

public class SongCollection {
	private ArrayList<Song> songs; // ArrayList to store Song objects

	// Initialize the SongCollection
	public SongCollection() {
		songs = new ArrayList<>();
	}

	/**
	 * Add the song if it is not in the list yet, otherwise update the average
	 * rating of the song.
	 * 
	 * @param s
	 */
	public void add(Song s) {
		for (Song song : songs) {
			// If song is already in the List, update its rating
            if (song.equals(s)) {
                song.addRating(s.getRating().getAvgRating());
                return;
            }
		}
		// Else, add the song to the collection
        songs.add(s);
	}

	// Method to remove a song from the collection
	public void remove(Song s) {
		if (songs.contains(s)) {
			songs.remove(s);
		}
	}

	// Method to check if a song is in the collection
	public boolean contains(Song s) {
		for (Song song : songs) {
			if (s.equals(song)) {
				return true;
			}
		}
		return false;
	}

	// Method to retrieve a song by index
	public Song getSong(int index) {
		return songs.get(index);
	}

	// Method to get the number of songs in the collection
	public int getNumberOfSongs() {
		return songs.size();
	}

	// Method to retrieve a copy of the ArrayList containing songs
	public ArrayList<Song> getSongs() {
		return new ArrayList<>(songs);
	}

	// Provide a string representation of SongCollection object
	public String toString() {
		String toRet = "[SongCollection: ";
		for (Song s : songs)
			toRet += "\n\t" + s + "; ";
		return toRet + "\n]";
	}
}