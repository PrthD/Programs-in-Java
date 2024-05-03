package ece325.labs.lab5;

import java.util.Comparator;

public class SongComparator implements Comparator<Song> {
    // Implement compare method for custom sorting based on average rating and votes
    @Override
    public int compare(Song song1, Song song2) {
        int ratingComparison = Float.compare(song2.getAverageRating().getAvgRating(), song1.getAverageRating().getAvgRating());
        if (ratingComparison == 0) {
            return Integer.compare(song2.getAverageRating().getVotes(), song1.getAverageRating().getVotes());
        }
        return ratingComparison;
    }
}