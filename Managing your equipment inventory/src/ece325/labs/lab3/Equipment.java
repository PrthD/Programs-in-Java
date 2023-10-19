package ece325.labs.lab3;

public abstract class Equipment {
    // define type of equipment
	private String type;

    // Constructor to initialize equipment type
    public Equipment(String type) {
        this.type = type;
    }

    // method to return the equipment type
    public String toString() {
        return type;
    }
}