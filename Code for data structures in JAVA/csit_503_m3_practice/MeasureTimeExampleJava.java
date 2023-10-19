package csit_503_m3_practice;

/**
 * Simple Java Program to measure elapsed execution time in Java This Java
 * Program shows two ways for measuring time in Java, by using System.nanoTime()
 * which was added in Java 5 and StopWatch which is a utility class from Spring
 * Framework.
 */
public class MeasureTimeExampleJava {

	public static void main(String args[]) {

		// measuring elapsed time using System.nanoTime
		long startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			Object obj = new Object();
		}
		long elapsedTime = System.nanoTime() - startTime;

		System.out.println("Total execution time to create 1000K objects in Java in millis: " + elapsedTime / 1000000);

	}

}
