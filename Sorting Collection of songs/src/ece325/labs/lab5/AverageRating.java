package ece325.labs.lab5;

public class AverageRating implements Comparable<AverageRating> {
	// not allowed to change anything after this (until the next marker which says you can add code again)
	private float avgRating;
	private int votes;
	
	public AverageRating(float rating, int votes) {
		this.avgRating = rating;
		this.votes = votes;
	}
		
	public float getAvgRating() {
		return avgRating;
	}
	
	public int getVotes() {
		return votes;
	}
	
	public String toString() {
		return "[AverageRating: " + avgRating + ", votes: " + votes + "]";
	}

	// You are allowed to make changes or add code after this line
	
	// Implement compareTo method for sorting based on average rating and votes
    @Override
    public int compareTo(AverageRating other) {
        int ratingComparison = Float.compare(other.getAvgRating(), this.getAvgRating());
        if (ratingComparison == 0) {
            return Integer.compare(other.getVotes(), this.getVotes());
        }
        return ratingComparison;
    }
}