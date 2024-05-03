package ece325.lec.assignment3;

import java.util.ArrayList;

public class ZooAnimalHandler implements DanceTherapist, AnimalHandler {
	private ArrayList<ZooAnimal> animals;

	public ZooAnimalHandler(ArrayList<ZooAnimal> animals) {
		this.animals = animals;
	}

	// Select a random animal from the list
	public ZooAnimal selectRandomAnimal() {
		// Generate a random index for the ArrayList animals
		int random = (int) (Math.random()*animals.size());
		return animals.get(random);
	}

	// Feed a random animal
	public void feedRandomAnimal() throws Exception {
		ZooAnimal animal = selectRandomAnimal();
		feed(animal);
	}

	// Feed a specified animal, throw exceptions if necessary
    public void feed(ZooAnimal animal) throws Exception {
		// If animal is already fed, throw exception
		if (animal.isFed()) {
            throw new AlreadyFedException(animal.getName() + " already ate and may get a belly ache!");
        } else if (!animal.hasDanced()) {
			// If animal has not danced yet, throw exception
			throw new DidNotDanceException(animal.getName() + " did not dance yet!");
		}
		// Else, feed the animal
        animal.feed();
    }

	// Invite a random animal to dance
    public void inviteRandomAnimalToDance() throws Exception {
        ZooAnimal animal = selectRandomAnimal();
        inviteAnimalToDance(animal);
    }

	// Invite a specific animal to dance, throw exception if necessary
    public void inviteAnimalToDance(ZooAnimal animal) throws Exception {
		// If animal is already fed and is invited to dance, throw exception
		if (animal.isFed()) {
			throw new AlreadyFedException(animal.getName() + " already ate and is about to vomit!");
		}
		animal.inviteToDance();
    }
}