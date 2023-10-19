package CSIT_503_module_1;


/**
 * Rafael Hidalgo
 */

public class LinkedBag<T> implements BagInterface<T> {

	private Node firstNode; // Reference to first node
	private int numberOfEntries;

	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	@Override
	public boolean add(T newEntry) {
		// Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode; // Make new node reference rest of chain
		// (firstNode is null if chain is empty)
		firstNode = newNode; // New node is at beginning of chain
		numberOfEntries++;
		return true;
	} // end add

	@Override
	public T remove() {
		T result = null;
		if (firstNode != null) {
			result = firstNode.data;
			firstNode = firstNode.next; // Remove first node from chain
			numberOfEntries--;
		} // end if
		return result;
	} // end remove

	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);
		if (nodeN != null) {
			nodeN.data = firstNode.data; // Replace located entry with entry
			// in first node
			firstNode = firstNode.next; // Remove first node
			numberOfEntries--;
			result = true;
		} // end if
		return result;
	} // end remove

	@Override
	public void clear() {
		while (!isEmpty())
			remove();
	}

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry The entry to be counted.
	 * @return The number of times anEntry appears in the bag.
	 */
	@Override
	public int getFrequencyOf(T anEntry) {
		{
			int frequency = 0;
			int loopCounter = 0;
			Node currentNode = firstNode;
			while ((loopCounter < numberOfEntries) && (currentNode != null)) {
				if (anEntry.equals(currentNode.data))
					frequency++;
				loopCounter++;
				currentNode = currentNode.next;
			} // end while
			return frequency;
		} // end getFrequencyOf
	}

	@Override
	public boolean contains(T anEntry) {
		return getReferenceTo(anEntry) != null;
	}// end contains

	@Override
	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		} // end while
		return result;
	} // end toArray

	private class Node {
		private T data; // Entry in bag
		private Node next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor
	} // end Node

	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while
		return currentNode;
	} // end getReferenceTo

}
