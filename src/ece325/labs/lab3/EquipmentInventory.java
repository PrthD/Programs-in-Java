package ece325.labs.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EquipmentInventory {

	/** The list of all your equipment objects */
	ArrayList<Equipment> inventory;
	/** The number of objects per type of equipment, grouped by the String description of a type */
	HashMap<String, Integer> inventoryCount;

	/** 
	 * Create an EquipmentInventory object by initializing the inventory and inventoryCount objects.
	 */
	public EquipmentInventory() {
		inventory = new ArrayList<>();
        inventoryCount = new HashMap<>();
	}

	/**
	 * Add e to the inventory, and if the add is successful, increase the number of that equipment type in your inventoryCount.
	 * Make sure that you cannot accidentally add the same object twice.
	 * @param e The equipment object to add
	 */
	public void add(Equipment e) {
		// Check if the equipment already exists in the inventory
		if (!inventory.contains(e)) {
			// Add equipment to the inventory list
            inventory.add(e);
			// Update the inventory count
            increaseInventoryCount(e);
        }
	}

	/**
	 * Remove e from the inventory and if successful, decrease the number of that equipment type in your inventoryCount.
	 * @param e The equipment object to remove
	 */
	public void remove(Equipment e) {
		// Check if the equipment exists in the inventory
		if (inventory.contains(e)) {
			// Remove equipment from the inventory list
            inventory.remove(e);
			// Update the inventory count
            decreaseInventoryCount(e);
        }
	}

	/**
	 * Increase the inventoryCount for the type of equipment of e by 1.
	 * If it does not exist in the inventoryCount yet, add the type to the inventoryCount.
	 * Note: this method should be private, but to allow running unit tests on it (and make our lives easier when marking),
	 * we made this method protected. The method should never be called outside of the class. 	 
	 * @param e The type of equipment for which we want to increase the inventoryCount
	 */
	protected void increaseInventoryCount(Equipment e) {
		// Get the type of equipment
		String key = e.toString();
		// Increment the count for the equipment type in the inventoryCount map by 1
        inventoryCount.put(key, inventoryCount.getOrDefault(key, 0) + 1);
	}

	/**
	 * Decrease the inventoryCount for the type of equipment of e by 1.
	 * If the inventoryCount for this type is now 0, remove the type from the inventoryCount.
	 * If the inventoryCount does not contain this type of equipment, do nothing.
	 * Note: this method should be private, but to allow running unit tests on it (and make our lives easier when marking),
	 * we made this method protected. The method should never be called outside of the class. 	 
	 * @param e The type of equipment for which we want to decrease the inventoryCount
	 */
	protected void decreaseInventoryCount(Equipment e) {
		String equipmentType = e.toString();
		// Get the current count for the equipment type
		int count = inventoryCount.getOrDefault(equipmentType, 0);
		if (count > 1) {
			// If count is more than 1, decrement the count
			inventoryCount.put(equipmentType, count - 1);
		} else {
			if (count == 1) {
				// If count is 1, remove the equipment type from the inventoryCount map
				inventoryCount.remove(equipmentType);
			}
		}
	}

	/** 
	 * Return the number of times this type of equipment occurs in the inventory.
	 * If it doesn't occur in the inventory, return -1 (to indicate that something went wrong somewhere).
	 * @param e
	 * @return
	 */
	public Integer getInventoryCount(Equipment e) {
		// Get the count for the equipment type from the inventoryCount map
        return inventoryCount.getOrDefault(e.toString(), -1);
	}
	
	/**
	 * Return the String representation of the EquipmentInventory.
	 * It should look similarly to the following:
	 * [EquipmentInventory: Guitar: 3, Stool: 3, Chair: 1, Keyboard: 2]
	 * (after adding 3 guitars, 3 stools, 1 chair and 2 keyboards).
	 * The order in which the types are printed does not matter.
	 * @return the string representation of the EquipmentInventory
	 */
	public String toString() {
		// Initialize the result string with the starting portion
		String result = "[EquipmentInventory: ";
		// Iterate over inventoryCount map and append equipment type and count to the result string
		for (Map.Entry<String, Integer> entry : inventoryCount.entrySet()) {
			// Concatenate equipment type, count, and a comma with the result string
			result += entry.getKey() + ": " + entry.getValue() + ", ";
		}
		// If the result string ends with a comma and space, remove them
		if (result.endsWith(", ")) {
			result = result.substring(0, result.length() - 2);
		}
		// Concatenate the closing bracket with the result string
		result += "]";
		// Return the final result string
		return result;
	}

	public static void main(String[] args) {
		// Create a new instance of EquipmentInventory
        EquipmentInventory equipInv = new EquipmentInventory();

        // Add equipment to the inventory so that it looks like
		// [EquipmentInventory: Guitar: 3, Stool: 3, Chair: 1, Keyboard: 2]
		Guitar G1 = new Guitar();
		equipInv.add(G1);
		Guitar G2 = new Guitar();
        equipInv.add(G2);
		Guitar G3 = new Guitar();
        equipInv.add(G3);
		Stool S1 = new Stool();
        equipInv.add(S1);
		Stool S2 = new Stool();
        equipInv.add(S2);
		Stool S3 = new Stool();
        equipInv.add(S3);
		Chair C1 = new Chair();
        equipInv.add(C1);
		Keyboard K1 = new Keyboard();
        equipInv.add(K1);
		Keyboard K2 = new Keyboard();
        equipInv.add(K2);

		// Print the initial inventory
        System.out.println(equipInv);
        
        // Remove a Keyboard and a Stool from the inventory
        equipInv.remove(S1);
		equipInv.remove(K1);

        // Print the updated inventory
        System.out.println(equipInv);
	}
}