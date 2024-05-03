package ece325.lec.assignment3;

// Custom exception class for animals that have already been fed
public class AlreadyFedException extends Exception {
    public AlreadyFedException(String message) {
        super(message);
    }
}