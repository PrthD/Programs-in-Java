package ece325.labs.lab6;

public interface PerformanceMeasurement {
	/**
	 * First resets the performance measurement, and then starts it.
	 */
	public void start();

	/**
	 * Ends the performance measurement.
	 */
	public void end();
	
	/**
	 * Resets the performance measurement. Make sure that the start and end are set to 0.
	 */
	public void reset();
	
	/**
	 * Returns the result of the measurement.
	 * @return the result of the measurement.
	 */
	public long getResult();
}