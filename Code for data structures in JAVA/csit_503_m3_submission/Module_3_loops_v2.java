package csit_503_m3_submission;

import java.time.Duration;
import java.time.Instant;

//Rafael Hidalgo

public class Module_3_loops_v2 {

	public static void main(String[] args) {

		long TimeA;

		long TimeB;

		System.out.println(
				"Will now insert n values starting at 11000 to both loops A and B, and then decreasing in value\n"
						+ "by one until loop B becomes faster than Loop A, or until n becomes 0, and loop A remains\n"
						+ "faster than loop B.\n");

		for (int var = 11000; var >= 0; var--) {

			System.out.println("Curently assigning " + var + " to \"n\" \n");

			TimeA = loop_A(var);
			TimeB = loop_B(var);

			if (TimeA > TimeB) {
				System.out.println("Loop B was faster than loop A when n equaled " + var + " \n");
				System.out.println("Loop A execution time was " + TimeA + " milliseconds \n");
				System.out.println("Loop B execution time was " + TimeB + " milliseconds \n");
				break;
			} else if (var == 0) {
				System.out.println("Loop B is not faster than loop A when n is between 11000 and 0");
			}

		}

	}

	public static long loop_A(int n) {
		int j;
		int sum = 0;
		int finalSum;
		long elapsedTime;

		Instant startTime = Instant.now();
		// Loop A
		for (int i = 1; i <= n; i++) {
			for (j = 1; j <= 10000; j++) {
				sum = sum + j;
			}

		}
		;

		Instant finishTime = Instant.now();

		elapsedTime = Duration.between(startTime, finishTime).toMillis();

		finalSum = sum; // although final sum is not used, this is necessary for java to properly run
						// the for loop.

		return elapsedTime;
	}

	public static long loop_B(int n) {
		int j;
		int sum = 0;
		long elapsedTime;
		int finalSum;

		Instant startTime = Instant.now();
		// Loop B
		for (int i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				sum = sum + j;
			}

		}
		;
		Instant finishTime = Instant.now();

		elapsedTime = Duration.between(startTime, finishTime).toMillis();

		finalSum = sum; // although final sum is not used, this is necessary for java to properly run
						// the for loop.

		return elapsedTime;
	}

}
