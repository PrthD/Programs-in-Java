package ece325.lec.assignment3;

// Custom exception class for animals that did not dance yet
public class DidNotDanceException extends Exception {
    public DidNotDanceException(String message) {
        super(message);
    }
}