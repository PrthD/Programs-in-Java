package ece325.lec.assignment3;

public class ZooAnimal {
	/**
	 * True iff the animal was fed already.
	 */
	private boolean isFed;
	
	/**
	 * True iff the animal has danced already.
	 */
	private boolean hasDanced;
	
	/**
	 * The name of the animal.
	 */
	private String name;
	
	public ZooAnimal(String name) {
		// Initialize the instance variables
		this.name = name;
		isFed = false;
		hasDanced = false;
	}
			
	/**
	 * Returns true iff the animal was fed already during the concert.
	 * @return true if the animal was fed
	 */
	public boolean isFed() {
		return isFed;
	}

	/**
	 * Feed the animal.
	 */
	public void feed() {
		// Feed the animal
        isFed = true;
	}
	
	/**
	 * Invite an animal to dance. There's a 50% chance they actually start to dance when they are invited.
	 */	
	public void inviteToDance() {
		// Generate a random boolean value. The animal starts dancing if hasDanced = true, else doesn't
        hasDanced = (Math.random()) < 0.5;
	}
	
	/** 
	 * Return true iff the animal has already danced.
	 * @return true if the animal has danced
	 */
	public boolean hasDanced() {
		return hasDanced;
	}
	
	/** 
	 * Return the name of the animal.
	 * @return the name of the animal
	 */
	public String getName() {
		return name;
	}
}