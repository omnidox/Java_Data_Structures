package csit_503_M1_submission;


/**
 * Rafael Hidalgo
 */

public class Project1 {
	public static void main(String[] args) {
		System.out.println("Creating an empty bag.");
		BagInterface<String> aBag = new LinkedBag<>();
		testIsEmpty(aBag, true);
		displayBag(aBag);

		String[] contentsOfBag = { "A", "D", "B", "A", "C", "A", "D" };
		testAdd(aBag, contentsOfBag);
		testIsEmpty(aBag, false);

		testGetCurrentSize(aBag, contentsOfBag);

		testRemoveAnyEntry(aBag);

		testGetCurrentSize(aBag, contentsOfBag);

		testRemoveSpecificEntry(aBag, "C");

		displayBag(aBag);

		testRemoveSpecificEntry(aBag, "Z");

		displayBag(aBag);

		testGetFrequencyOf(aBag, "A");

		testGetFrequencyOf(aBag, "Z");

		testContains(aBag, "A");

		testContains(aBag, "Z");

		testClear(aBag);

		testIsEmpty(aBag, true);

	} // end main

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	// private methods

	// Tests the method isEmpty.
	// Precondition: If the bag is empty, the parameter empty should be true;
	// otherwise, it should be false.
	private static void testIsEmpty(BagInterface<String> bag, boolean empty) {
		System.out.print("\nTesting isEmpty with ");
		if (empty)
			System.out.println("an empty bag:");
		else
			System.out.println("a bag that is not empty:");

		System.out.print("isEmpty finds the bag ");
		if (empty && bag.isEmpty())
			System.out.println("empty: OK.");
		else if (empty)
			System.out.println("not empty, but it is: ERROR.");
		else if (!empty && bag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");
	} // end testIsEmpty

	// Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content) {
		System.out.print("Adding the following " + content.length + " strings to the bag: ");
		for (int index = 0; index < content.length; index++) {
			if (aBag.add(content[index]))
				System.out.print(content[index] + " ");
			else
				System.out.print("\nUnable to add " + content[index] + " to the bag.");
		} // end for
		System.out.println();

		displayBag(aBag);
	} // end testAdd

	// Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag) {
		System.out.println("The bag now contains the following string(s)(\"tests toArray\"):");
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++) {
			System.out.print(bagArray[index] + " ");
		} // end for

		System.out.println();

		System.out.println();
	} // end displayBag

	// test the method getCurrentSize()
	private static void testGetCurrentSize(BagInterface<String> aBag, String[] content) {
		System.out.println("\nNow Testing to see if \"abag\" bag size is equal to \"contentsOfBag size\" ");

		if (aBag.getCurrentSize() == content.length)
			System.out.println("Yay, \"abag\" and \"contentsOfBag\" size is the same");
		else
			System.out.println("Boo!, \"abag\" and \"contentsOfBag\" size is different!");

		System.out.println(
				"\"abag\" size is " + aBag.getCurrentSize() + " and \"contentsOfBag\" size is " + content.length);

		System.out.println();

	}

	// test the method remove()
	private static void testRemoveAnyEntry(BagInterface<String> aBag) {
		System.out.println("Will now remove an unspecified entry from abag");
		String removedString = aBag.remove();
		System.out.println("The String " + removedString + " was removed from the bag");

		displayBag(aBag);
	}

	// test the method remove(T anEntry)
	private static void testRemoveSpecificEntry(BagInterface<String> aBag, String rString) {
		System.out.println("Will now remove a specified entry from abag");
		System.out.println("Will now remove \"" + rString + "\" from abag");
		if (aBag.remove(rString))
			System.out.println("\"" + rString + "\" was found in abag and removed");
		else
			System.out.println("\"" + rString + "\" was not found in abag and and thus not removed");

		System.out.println();

	}

	// test the method getFrequencyOf(T anEntry)
	private static void testGetFrequencyOf(BagInterface<String> aBag, String rString) {
		System.out.println("Will now test frequency of a specified entry from abag");
		System.out.println("Will now test how many times \"" + rString + "\" appears in abag");

		int frequency = aBag.getFrequencyOf(rString);

		System.out.println("\"" + rString + "\" appears " + frequency + " times in abag");

		System.out.println();

	}

	// test the method contains(T anEntry)
	private static void testContains(BagInterface<String> aBag, String rString) {
		System.out.println("Will now test if abag contains a specified entry");

		System.out.println("Does aBag contain \"" + rString + "\"?");
		if (aBag.contains(rString))
			System.out.println("\"" + rString + "\" was found in abag");
		else
			System.out.println("\"" + rString + "\" was not found in abag");

		System.out.println();

	}

	private static void testClear(BagInterface<String> aBag) {
		System.out.println("Will now clear aBag of all entries");

		aBag.clear();

	}
} // end Project1
