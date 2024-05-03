package ece325.labs.lab5;

import java.util.Objects;

/**
 * This class represents a Song. A Song has a title and an average rating.
 * You are not allowed to change the code that is in between the indications, but you are allowed to add
 * code before and after the indicated lines.
 * 
 * @author Cor-Paul Bezemer
 *
 */
public class Song implements Comparable<Song> {
	// not allowed to change anything after this (until the next marker which says you can add code again)
	private String title;
	private AverageRating rating;
	
	public Song(String title, AverageRating rating) {
		this.title = title;
		this.rating = rating;
	}

	public String getTitle() {
		return this.title;
	}

	public AverageRating getAverageRating() {
		return this.rating;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
	public void setAverageRating(AverageRating rating) {
		this.rating = rating;
	}
	
	public String toString() {
		return "[Song: " + title + ", average rating: " + rating + "]";
	}
	
	// You are allowed to make changes or add code after this line
	
	// Implement compareTo method for sorting based on song title
    @Override
    public int compareTo(Song other) {
        return this.getTitle().compareTo(other.getTitle());
    }

	// Checks if this song is equal to another object. Two songs are
	// considered equal if their titles are equal.
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o; // Type cast an Object to Song
        return Objects.equals(this.getTitle(), song.getTitle());
    }

	// Computes a hash code for this song.
    @Override
    public int hashCode() {
        return Objects.hash();
    }
}