package ece325.labs.lab4;

public class AverageRating {
	private float avgRating; // Average rating of the song
	private float count; // Number of ratings received
	
	// Initialize the first rating
	public AverageRating(float rating) {
		avgRating = rating;
        count = 1;
	}
	
	/**
	 * Recomputes the average rating taking the new rating r into account.
	 * @param rating 
	 */
	public void addRating(float r) {
		// Calculate the new average and increase the count for ratings received
		avgRating = (avgRating * count + r) / (count + 1);
        count++;
	}
	
	// Getter method to retrieve average rating
	public float getAvgRating() {
		return avgRating;
	}
	
	// Provide a string representation of AverageRating object
	public String toString() {
		return "[AverageRating: " + avgRating + "]";
	}
}