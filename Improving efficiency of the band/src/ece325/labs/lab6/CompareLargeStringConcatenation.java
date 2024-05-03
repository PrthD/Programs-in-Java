package ece325.labs.lab6;

import java.io.IOException;
import java.io.FileWriter;

public class CompareLargeStringConcatenation {
	/**
	 * Creates a String object, performs concatOperations operations on it and returns the resulting String.
	 * @param concatOperations The number of concatenation operations to perform on the String.
	 * @return The resulting String.
	 */
	private static String concatString(int concatOperations) {
		String result = "";
		for (int i = 0; i < concatOperations; i++)
			result += "test";

		return result;
	}
	
	/**
	 * Creates a StringBuilder object, performs concatOperations operations on it, converts the StringBuilder to a String and returns the 
	 * resulting String.
	 * @param concatOperations The number of concatenation operations to perform on the StringBuilder.
	 * @return The resulting String.
	 */
	private static String concatStringBuilder(int concatOperations) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < concatOperations; i++)
			strBuilder.append("test");

		return strBuilder.toString();
	}

	/**
     * Performs the performance test on the concatString method, displays the runtime result, and returns it.
     * @param numStrings The number of Strings to concatenate.
     * @param measurement MillisPerformanceMeasurement class instance.
     * @return The runtime result of concatString method.
     */
    public static long ConcatStringPerformanceTest(int numStrings, MillisPerformanceMeasurement measurement) {
        measurement.start();
        String testString = concatString(numStrings);
        measurement.end();

        long runtime = measurement.getResult();
        System.out.println("Approach 1 (String): " + runtime + " ms");

        measurement.reset();
        return runtime;
    }

    /**
     * Performs the performance test on the concatStringBuilder method, displays the runtime result, and returns it.
     * @param numStrings The number of Strings to concatenate.
     * @param measurement MillisPerformanceMeasurement class instance.
     * @return The runtime result of concatStringBuilder method.
     */
    public static long ConcatStringBuilderPerformanceTest(int numStrings, MillisPerformanceMeasurement measurement) {
        measurement.start();
        String testStringBuilder = concatStringBuilder(numStrings);
        measurement.end();

        long runtime = measurement.getResult();
        System.out.println("Approach 2 (StringBuilder): " + runtime + " ms");

        measurement.reset();
        return runtime;
    }

	public static void main(String[] args) throws IOException {
		// Instantiate a FileWriter to record the test results into a .csv file
		FileWriter csvRecorder = new FileWriter("CompareLargeStringConcatenation.csv");
        MillisPerformanceMeasurement measurement = new MillisPerformanceMeasurement();

        for (int numStrings = 10; numStrings <= 100000; numStrings *= 10) {
            csvRecorder.append(Integer.toString(numStrings));
            csvRecorder.append(",");

            System.out.println("# of concatenation operations: " + numStrings);

			// Performance for Approach 1 (String)
            long StringPerformance = ConcatStringPerformanceTest(numStrings, measurement);
            csvRecorder.append(Long.toString(StringPerformance));
            csvRecorder.append(",");

			// Performance for Approach 2 (StringBuilder)
            long StringBuilderPerformance = ConcatStringBuilderPerformanceTest(numStrings, measurement);
            csvRecorder.append(Long.toString(StringBuilderPerformance));
            csvRecorder.append("\n");

            System.out.println();
        }
        csvRecorder.flush();
        csvRecorder.close();
    }
}