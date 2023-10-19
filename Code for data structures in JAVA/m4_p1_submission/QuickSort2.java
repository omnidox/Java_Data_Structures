package m4_p1_submission;

import java.util.*;

public class QuickSort2 {

	private int array[];

	private int length;

	public void sort(int[] inputArr) {

		if (inputArr == null || inputArr.length == 0) {

			return;

		}

		this.array = inputArr;

		length = inputArr.length;

		QuicksortUtil(0, length - 1);

	}

	private void QuicksortUtil(int Low, int High) {

		int i = Low;

		int j = High;

// calculate pivot number

		int pivot = array[Low + (High - Low) / 2];

// Divide into two arrays

		while (i <= j) {

			while (array[i] < pivot) {

				i++;

			}

			while (array[j] > pivot) {

				j--;

			}

			if (i <= j) {

				swap(i, j); // shifting index to next position on both sides

				i++;

				j--;

			}

		}

		if (Low < j)

			QuicksortUtil(Low, j);

		if (i < High)

			QuicksortUtil(i, High);

	}

	private void swap(int i, int j) {

		int temp = array[i];

		array[i] = array[j];

		array[j] = temp;

	}

	public static void main(String a[]) {

		QuickSort2 q = new QuickSort2();

		int n;

		System.out.println("Enter number of elements in the array");

		Scanner s = new Scanner(System.in);

		n = s.nextInt();

		int[] input = new int[n];

		for (int i = 0; i < n; i++)

		{

			input[i] = s.nextInt();

		}

		q.sort(input);

		for (int i = 0; i < n; i++)

		{

			System.out.print(input[i] + " ");

		}

	}

}
