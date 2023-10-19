//Rafael Hidalgo

import java.util.Arrays;
import java.util.Random;

public class RadixSort {

	public static void main(String[] args) {

		Random rd = new Random(); // creating Random object
		int[] input = new int[20];
		System.out.println("Will now make an array of 20 random integers ranging from 0 to 100 \n");
		
		for (int i = 0; i < input.length; i++) {
	         input[i] = rd.nextInt(101); // storing random integers in an array
		}

		System.out.println(Arrays.toString(input));
		
		radixSort(input, 0, 20 - 1, 4);
		
		System.out.println();
		
		System.out.println("Will now sort the array via Radix sort and then print the sorted array \n");
		
		System.out.println(Arrays.toString(input));

	}

	public static void radixSort(int[] a, int first, int last, int maxDigits) {

		int i;
		int j;
		int index;
		int digit;

		@SuppressWarnings("unchecked")
		QueueInterface<Integer>[] buckets = new LinkedQueue[10];
		
		for (digit = 0; digit < 10; digit++)
			buckets[digit] = new LinkedQueue<Integer>();

		for (i = 0; i < maxDigits; i++) {

			for (j = 0; j < 10; j++) {
				buckets[j].clear();
			}

			for (index = first; index <= last; index++) {

				String strA = "" + a[index];
				

				if (strA.length() > i)
				{
		
				digit = strA.charAt(strA.length()-(i+1)) - '0';

		
				buckets[digit].enqueue(a[index]);
				}
				else
				{
					buckets[0].enqueue(a[index]);
				}
				

			}

			digit = 0;

			for (index = first; index <= last; index++) {
				
				
				
				while (buckets[digit].isEmpty())
					
				{
					
					digit++;
					
				}
				a[index] = buckets[digit].dequeue();
			}

		}
	}
}
