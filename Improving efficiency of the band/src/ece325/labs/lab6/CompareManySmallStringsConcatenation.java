package ece325.labs.lab6;

import java.io.FileWriter;
import java.io.IOException;

public class CompareManySmallStringsConcatenation {
	/**
	 * Creates numberOfStrings String objects and performs operationsPerString concatenation
	 * operations on every string. Note that you can create one string first, then perform all
	 * the operations on that string, then create the second string, etc.
	 * @param numberOfStrings
	 * @param concatOperationsPerString
	 */
	private static void concatString(int numberOfStrings, int concatOperationsPerString) {
		for (int i = 0; i < numberOfStrings; i++) {
            String result = "";
            for (int j = 0; j < concatOperationsPerString; j++) {
                result += "test";
            }
        }
	}

	/**
	 * Creates numberOfStrings StringBuilder objects and performs operationsPerString concatenation
	 * operations on every StringBuilder. Note that you can create one StringBuilder first, then 
	 * perform all the operations on that StringBuilder, then convert the StringBuilder to a String, 
	 * then create the second StringBuilder, etc.
	 * @param numberOfStrings
	 * @param concatOperationsPerString
	 */
	private static void concatStringBuilder(int numberOfStrings, int concatOperationsPerString) {
		for (int i = 0; i < numberOfStrings; i++) {
            StringBuilder strBuilder = new StringBuilder();
            for (int j = 0; j < concatOperationsPerString; j++) {
                strBuilder.append("test");
            }
        }
	}

	/**
	 * Performs the performance test on the concatString method, displays the runtime result, and returns it.
	 * @param numStrings The number of Strings to concatenate.
	 * @param concatOpsPerString The number of concatenation operations per String.
	 * @param measurement MillisPerformanceMeasurement class instance.
	 * @return The runtime result of concatString method.
	 */
	public static long ConcatStringPerformanceTest(int numStrings, int concatOpsPerString, MillisPerformanceMeasurement measurement) {
		measurement.start();
		concatString(numStrings, concatOpsPerString);
		measurement.end();

		long runtime = measurement.getResult();
		System.out.println("Approach 1 (String): " + runtime + " ms");

		measurement.reset();
		return runtime;
	}

	/**
	 * Performs the performance test on the concatStringBuilder method, displays the runtime result, and returns it.
	 * @param numStrings The number of Strings to concatenate.
	 * @param concatOpsPerString The number of concatenation operations per String.
	 * @param measurement MillisPerformanceMeasurement class instance.
	 * @return The runtime result of concatStringBuilder method.
	 */
	public static long ConcatStringBuilderPerformanceTest(int numStrings, int concatOpsPerString, MillisPerformanceMeasurement measurement) {
		measurement.start();
		concatStringBuilder(numStrings, concatOpsPerString);
		measurement.end();

		long runtime = measurement.getResult();
		System.out.println("Approach 2 (StringBuilder): " + runtime + " ms");

		measurement.reset();
		return runtime;
	}

	public static void main(String[] args) throws IOException {
		int[] numberOfStrings = {1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000};
		int[] numberOfOperations = {0, 1, 2, 3, 4};

		// Instantiate a FileWriter to record the test results into a .csv file
		FileWriter csvRecorder = new FileWriter("CompareManySmallStringsConcatenation.csv");
		MillisPerformanceMeasurement measurement = new MillisPerformanceMeasurement();

		for (int numStrings : numberOfStrings) {
			csvRecorder.append(Integer.toString(numStrings));
			for (int operations : numberOfOperations) {
				System.out.println("# of Strings: " + numStrings + "; # of Operations: " + operations);

				// Performance for Approach 1 (String)
				long StringPerformance = ConcatStringPerformanceTest(numStrings, operations, measurement);
				csvRecorder.append(",");
				csvRecorder.append(Long.toString(StringPerformance));

				// Performance for Approach 2 (StringBuilder)
				long StringBuilderPerformance = ConcatStringBuilderPerformanceTest(numStrings, operations, measurement);
				csvRecorder.append(",");
				csvRecorder.append(Long.toString(StringBuilderPerformance));

				System.out.println();
			}
			csvRecorder.append("\n");
		}
		csvRecorder.flush();
		csvRecorder.close();
	}
}