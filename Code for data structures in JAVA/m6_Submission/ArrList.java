package m6_Submission;
import java.util.ArrayList;
import java.util.List;


//Rafael Hidalgo


public class ArrList<T> implements ListInterface<T> {

	private List<T> list; // Last element is the top entry in stack
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	private int numberOfEntries;

	public ArrList() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public ArrList(int initialCapacity) {
		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else // Is initialCapacity too big?
			checkCapacity(initialCapacity);
		list = new ArrayList<>(initialCapacity); // Size doubles as needed
		numberOfEntries = 0;
		initialized = true;
	} // end constructor

	@Override
	public void add(T newEntry) {
		checkInitialization();

		list.add(numberOfEntries, newEntry);
		numberOfEntries++;

	}

	@Override
	public void add(int newPosition, T newEntry) {
		checkInitialization();

		newPosition--;

		if ((newPosition >= 0) && (newPosition <= numberOfEntries)) {

			list.add(newPosition, newEntry);
			numberOfEntries++;
		} else
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");

	}

	@Override
	public T remove(int givenPosition) {
		checkInitialization();

		givenPosition--;
		if ((givenPosition >= 0) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			T result = list.remove(givenPosition); // Get entry to be removed

			numberOfEntries--;
			return result; // Return reference to removed entry
		} else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	}

	@Override
	public void clear() {
		list.clear();

	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		checkInitialization();

		givenPosition--;

		if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
			assert !isEmpty();
			T originalEntry = list.set(givenPosition, newEntry);
			return originalEntry;
		} else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}

	@Override
	public T getEntry(int givenPosition) {
		checkInitialization();

		givenPosition--;
		if ((givenPosition >= 0) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return list.get(givenPosition);
		} else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	}

	@Override
	public T[] toArray() {

		checkInitialization();

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list.get(index);
		} // end for

		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		checkInitialization();
		boolean found;
		found = list.contains(anEntry);
		return found;
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a bag whose " + "capacity exeeds allowed " + "maximum of " + MAX_CAPACITY);
	} // end checkCapacity

	private void checkInitialization() {
		if (!initialized)
			throw new SecurityException("ArrayBag object is not initialized " + "properly.");
	} // end checkInitialization
}
