package m4_p1_submission;

import java.util.Arrays;
import java.util.Random;


//Rafael Hidalgo


public class QuickSort {

	private static final int MIN_SIZE = 10;

	public static void main(String[] args) {

		Random rd = new Random(); // creating Random object
		Integer[] input = new Integer[20];
		System.out.println("Will now make an array of 20 random integers ranging from 0 to 100 \n");

		for (int i = 0; i < input.length; i++) {
			input[i] = rd.nextInt(101); // storing random integers in an array
		}

		System.out.println(Arrays.toString(input));

		quickSort(input, 0, 20 - 1);

		System.out.println();

		System.out.println("Will now sort the array via quick sort and print the sorted array \n");

		System.out.println(Arrays.toString(input));
		
		System.out.println();

		Integer[] input2 = new Integer[8];
		System.out.println("Will now make an array of 8 random integers ranging from 0 to 100 "
				+ "to test insertion sort. Insertion sort will occur when the array is " + "smaller than 10 \n");

		for (int i = 0; i < input2.length; i++) {
			input2[i] = rd.nextInt(101); // storing random integers in an array
		}

		System.out.println(Arrays.toString(input2));

		quickSort(input2, 0, 8 - 1);

		System.out.println();

		System.out.println("Will now print the sorted array \n");

		System.out.println(Arrays.toString(input2));

	}

	public static <T extends Comparable<? super T>> int partition(T[] a, int first, int last) {

		int mid, pivotIndex, indexFromLeft, indexFromRight;

		T pivotValue;

		boolean done;

		mid = (first + last) / 2;

		sortFirstMiddleLast(a, first, mid, last);

		swap(a, mid, last - 1);

		pivotIndex = last - 1;

		pivotValue = a[pivotIndex];

		indexFromLeft = first + 1;
		indexFromRight = last - 2;

		done = false;

		while (!done) {
			while (a[indexFromLeft].compareTo(pivotValue) < 0)
				indexFromLeft++;

			while (a[indexFromRight].compareTo(pivotValue) > 0)
				indexFromRight--;

			if (indexFromLeft < indexFromRight) {
				swap(a, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			} else
				done = true;

		}

		swap(a, pivotIndex, indexFromLeft);

		pivotIndex = indexFromLeft;

		return pivotIndex;

	} // end partition

	private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
		if ((a[first].compareTo(a[last]) > 0))
			swap(a, first, last);

		if ((a[first].compareTo(a[mid]) > 0))
			swap(a, first, mid);

		if ((a[mid].compareTo(a[last]) > 0))
			swap(a, mid, last);
	}

	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	} // end swap

	public static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last) {
		if (last - first + 1 < MIN_SIZE) {
			insertionSort(a, first, last);
		} else {
			// Create the partition: Smaller | Pivot | Larger
			int pivotIndex = partition(a, first, last);
			// Sort subarrays Smaller and Larger
			quickSort(a, first, pivotIndex - 1);
			quickSort(a, pivotIndex + 1, last);
		} // end if
	}

	static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last) {
		int unsorted;

		T nextToInsert;

		for (unsorted = first + 1; unsorted <= last; unsorted++) {
			nextToInsert = a[unsorted];

			insertInOrder(nextToInsert, a, first, unsorted - 1);
		}

	}

	static <T extends Comparable<? super T>> void insertInOrder(T anEntry, T[] a, int begin, int end) {
		int index;

		index = end;

		while ((index >= begin) && (anEntry.compareTo(a[index])) < 0) {
			a[index + 1] = a[index];
			index--;
		}

		a[index + 1] = anEntry;

	} // end quickSort

}
