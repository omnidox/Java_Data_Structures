package m4_p1_submission;

import java.util.Arrays;
import java.util.Random;


//Rafael Hidalgo


class MergeSort {

	public static void main(String[] args) {
		
		Random rd = new Random(); // creating Random object
		Integer[] input = new Integer[20];
		System.out.println("Will now make an array of 20 random integers ranging from 0 to 100 \n");
		
		for (int i = 0; i < input.length; i++) {
	         input[i] = rd.nextInt(101); // storing random integers in an array
		}

		System.out.println(Arrays.toString(input));
		
		mergeSort(input, 0, 20 - 1);
		
		System.out.println();
		
		System.out.println("Will now sort the array via merge sort and then print the sorted array \n");
		
		System.out.println(Arrays.toString(input));
	
		
		

	}

	public static <T extends Comparable<? super T>> void mergeSort(T[] a, int first, int last) {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Comparable<?>[a.length]; // Unchecked cast
		mergeSort(a, tempArray, first, last);
	} // end mergeSort

	private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] temp, int first, int last) {

		int mid;
		if (first < last) {
			mid = (first + last) / 2;
			mergeSort(a, temp, first, mid);
			mergeSort(a, temp, mid + 1, last);

			merge2(a, temp, first, mid, last);

		}
	}

	private static <T extends Comparable<? super T>> void merge2(T[] a, T[] tempArray, int first, int mid, int last) {

		int beginHalf1, endHalf1, beginHalf2, endHalf2, mergeLength, i;

		beginHalf1 = first;
		endHalf1 = mid;
		beginHalf2 = mid + 1;
		endHalf2 = last;

		mergeLength = (endHalf2 - beginHalf1 + 1);

		int index = 0; // Next available location in tempArray
		while ((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2)) {
			if (a[beginHalf1].compareTo(a[beginHalf2]) <= 0) {
				tempArray[index] = a[beginHalf1];
				beginHalf1++;
			} else {
				tempArray[index] = a[beginHalf2];
				beginHalf2++;
			}
			index++;
		}

		while ((beginHalf1 <= endHalf1)) {
			tempArray[index] = a[beginHalf1];
			beginHalf1++;
			index++;

		}

		while ((beginHalf2 <= endHalf2)) {

			tempArray[index] = a[beginHalf2];
			beginHalf2++;
			index++;

		}

		for (i = 0; i < mergeLength; i++) {
			a[endHalf2] = tempArray[index - 1];
			endHalf2--;
			index--;
		}

	} // end mergeSort
}